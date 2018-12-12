package quanlynhahang.models.businessmodels;
import quanlynhahang.models.datamodels.LienHe;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class LienHeService extends ConnectDatabase implements Businesses<LienHe> {
    public LienHeService(UserDbConnect user) {
        super(user);
    }

    @Override
    public ArrayList<LienHe> getData() throws SQLException, ClassNotFoundException {
        ArrayList<LienHe> lienHes=new ArrayList<>();
        openConnection();
        String sql="select *from LayLienHe";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res=statement.executeQuery();
        while (res.next()){
            LienHe lienHe=new LienHe();
            lienHe.setIdLienHe(res.getInt(1));
            lienHe.setEmail(res.getString(2));
            lienHe.setHoTen(res.getString(3));
            lienHe.setSoDT(res.getString(4));
            lienHe.setNoiDung(res.getString(5));
            lienHe.setThoiGian(res.getDate(6));
            lienHe.setTrangThaiSeen(res.getBoolean(7));
            lienHes.add(lienHe);

        }
        closeConnection();
        return lienHes;
    }

    @Override
    public int add(LienHe lienHe) throws SQLException, ClassNotFoundException {
        if(lienHe==null)
            return 0;
        openConnection();

        String sql="exec  ThemLienHe ?,?,?,?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1,lienHe.getEmail());
        statement.setString(2,lienHe.getHoTen());
        statement.setString(3,lienHe.getSoDT());
        statement.setString(4,lienHe.getNoiDung());
        //statement.setDate(5,lienHe.getThoiGian());
        //statement.setBoolean(6,lienHe.isTrangThaiSeen());
        int rowAffected=statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql="Exec XoaLienHe ?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1,keys[0].toString());

        int rowAffected=statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int modify(LienHe lienHe) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public LienHe get(Object... keys) throws SQLException, ClassNotFoundException {
        openConnection();

        String sql="select * LayMotLienHe (?)";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1,keys[0].toString());
        LienHe lienHe=null;
        ResultSet res=statement.executeQuery();
        if(res.next()){
            lienHe.setEmail(res.getString(1));
            lienHe.setHoTen(res.getString(2));
            lienHe.setSoDT(res.getString(3));
            lienHe.setNoiDung(res.getString(4));
            lienHe.setThoiGian(res.getDate(5));
            lienHe.setTrangThaiSeen(res.getBoolean(6));
        }
        closeConnection();
        return lienHe;
    }
}
