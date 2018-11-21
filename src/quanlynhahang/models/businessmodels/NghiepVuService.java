package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.NghiepVu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NghiepVuService extends ConnectDatabase implements Businesses<NghiepVu> {
    public NghiepVuService(Boolean isAdmin) {
        super(isAdmin);
    }

    @Override
    public ArrayList<NghiepVu> getData() throws SQLException, ClassNotFoundException {
        openConnection();
        ArrayList<NghiepVu> nghiepVus = new ArrayList<>();
        String sql = "EXEC LayNghiepVu";
        Statement st = connection.createStatement();
        ResultSet res = st.executeQuery(sql);
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
        return 0;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int modify(NghiepVu nghiepVu) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public NghiepVu get(Object... keys) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC LayMotNghiepVu ?";
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
