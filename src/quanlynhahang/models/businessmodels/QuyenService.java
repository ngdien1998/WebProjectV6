package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.Quyen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuyenService extends ConnectDatabase implements Businesses<Quyen> {
    @Override
    public ArrayList<Quyen> getData() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int add(Quyen quyen) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int modify(Quyen quyen) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public Quyen get(Object... keys) throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<quanlynhahang.models.viewmodels.Quyen> getQuyenViewModel(String email, int idNghiepVu) throws SQLException, ClassNotFoundException {
        openConnection();
        ArrayList<quanlynhahang.models.viewmodels.Quyen> quyens = new ArrayList<>();
        String sql = "EXEC LayPhanQuyen ?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, email);
        statement.setInt(2, idNghiepVu);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            quanlynhahang.models.viewmodels.Quyen quyen = new quanlynhahang.models.viewmodels.Quyen();
            quyen.setIdQuyen(res.getInt(1));
            quyen.setTenQuyen(res.getString(2));
            quyen.setMoTa(res.getString(3));
            quyen.setDuocCap(res.getBoolean(4));

            quyens.add(quyen);
        }
        closeConnection();
        return quyens;
    }
}
