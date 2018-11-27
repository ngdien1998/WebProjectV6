package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.NghiepVu;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NghiepVuService extends ConnectDatabase implements Businesses<NghiepVu> {
    public NghiepVuService(UserDbConnect user) {
        super(user);
    }

    @Override
    public ArrayList<NghiepVu> getData() throws SQLException, ClassNotFoundException {
        openConnection();
        ArrayList<NghiepVu> nghiepVus = new ArrayList<>();
        String sql = "SELECT * FROM LayNghiepVu";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            NghiepVu nghiepVu = new NghiepVu();
            nghiepVu.setIdNghiepVu(res.getInt(1));
            nghiepVu.setTenNghiepVu(res.getString(2));
            nghiepVu.setMoTa(res.getString(3));

            nghiepVus.add(nghiepVu);
        }

        closeConnection();
        return nghiepVus;
    }

    @Override
    public int add(NghiepVu nghiepVu) throws SQLException, ClassNotFoundException {
        if (nghiepVu == null)
            return 0;

        openConnection();
        String sql = "EXEC ThemNghiepVu ?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, nghiepVu.getTenNghiepVu());
        statement.setString(2, nghiepVu.getMoTa());
        int rowAffected = statement.executeUpdate();

        closeConnection();
        return rowAffected;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC XoaNghiepVu ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, (int) keys[0]);
        int rowAffected = statement.executeUpdate();

        closeConnection();
        return rowAffected;
    }

    @Override
    public int modify(NghiepVu nghiepVu) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC SuaNghiepVu ?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, nghiepVu.getIdNghiepVu());
        statement.setString(2, nghiepVu.getTenNghiepVu());
        statement.setString(3, nghiepVu.getMoTa());
        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public NghiepVu get(Object... keys) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "SELECT * FROM LayMotNghiepVu(?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, (int) keys[0]);

        NghiepVu nghiepVu = null;
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            nghiepVu = new NghiepVu();
            nghiepVu.setIdNghiepVu(res.getInt(1));
            nghiepVu.setTenNghiepVu(res.getString(2));
            nghiepVu.setMoTa(res.getString(3));
        }
        closeConnection();
        return nghiepVu;
    }
}
