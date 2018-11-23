package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.Quyen;
import quanlynhahang.models.viewmodels.QuyenVM;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuyenService extends ConnectDatabase implements Businesses<Quyen> {
    public QuyenService(UserDbConnect user) {
        super(user);
    }

    @Override
    public ArrayList<Quyen> getData() throws SQLException, ClassNotFoundException {
        openConnection();
        ArrayList<Quyen> quyens = new ArrayList<>();
        String sql = "EXEC LayQuyen";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);

        ResultSet res = statement.executeQuery();
        while (res.next()) {
            Quyen quyen = new Quyen();
            quyen.setIdQuyen(res.getInt("IDQuyen"));
            quyen.setTenQuyen(res.getString("TenQuyen"));
            quyen.setMoTa(res.getString("MoTa"));
            quyen.setIdNghiepVu(res.getInt("IDNghiepVu"));
            quyens.add(quyen);
        }
        closeConnection();
        return quyens;
    }

    @Override
    public int add(Quyen quyen) throws SQLException, ClassNotFoundException {
        if(quyen==null)
            return 0;
        openConnection();
        String sql="EXEC ThemQuyen ?,?,?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1,quyen.getTenQuyen());
        statement.setString(2,quyen.getMoTa());
        statement.setInt(3,quyen.getIdNghiepVu());

        int rowAffected=statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql="EXEC XoaQuyen ?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1,(int)keys[0]);
        int rowAffected=statement.executeUpdate();
        closeConnection();
        return  rowAffected;
    }

    @Override
    public int modify(Quyen quyen) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public Quyen get(Object... keys) throws SQLException, ClassNotFoundException {
        if(keys.length <=0)
            return null;

        openConnection();
        String sql ="EXEC Lay1Quyen ?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1,keys[0].toString());
        ResultSet res=statement.executeQuery();
        Quyen quyen=null;
        if(res.next())
        {
            quyen=new Quyen();
            quyen.setIdQuyen(res.getInt(1));
            quyen.setTenQuyen(res.getString(2));
            quyen.setMoTa(res.getString(3));
            quyen.setIdNghiepVu(res.getInt(4));
        }
        closeConnection();
        return quyen;
    }

    public ArrayList<QuyenVM> getQuyenViewModel(String email, int idNghiepVu) throws SQLException, ClassNotFoundException {
        openConnection();
        ArrayList<QuyenVM> quyens = new ArrayList<>();
        String sql = "EXEC LayPhanQuyen ?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, email);
        statement.setInt(2, idNghiepVu);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            QuyenVM quyen = new QuyenVM();
            quyen.setIdQuyen(res.getInt(1));
            quyen.setTenQuyen(res.getString(2));
            quyen.setMoTa(res.getString(3));
            quyen.setDuocCap(res.getBoolean(4));

            quyens.add(quyen);
        }
        closeConnection();
        return quyens;
    }

    public boolean phanQuyen(int idQuyen, String email, String action) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC PhanQuyenQuanTri ?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, idQuyen);
        statement.setString(2, email);
        statement.setString(3, action);
        int rowsAffected = statement.executeUpdate();
        closeConnection();
        return rowsAffected > 0;
    }
}
