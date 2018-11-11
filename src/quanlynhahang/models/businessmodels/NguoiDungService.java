package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.NguoiDung;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * args[0] Email
 * args[1] HoDem
 * args[2] Ten
 * args[3] MatKhau
 * args[4] NgaySinh
 * args[5] Nu
 * args[6] Avatar
 * args[7] DienThoai
 * args[8] DiaChi
 * args[9] LaQTV
 * args[10] KichHoat
 * args[11] ChoPhep
 */
public class NguoiDungService extends ConnectDatabase implements Businesses<NguoiDung> {

    @Override
    public ArrayList<NguoiDung> getData() throws SQLException, ClassNotFoundException {
        ArrayList<NguoiDung> nguoiDungs = new ArrayList<>();
        openConnection();

        String sql = "EXEC LayNguoiDung";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);

        ResultSet res = statement.executeQuery();
        while (res.next()) {
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.setEmail(res.getString(1));
            nguoiDung.setHoDem(res.getString(2));
            nguoiDung.setTen(res.getString(3));
            nguoiDung.setMatKhau(res.getString(4));
            nguoiDung.setNgaySinh(res.getDate(5));
            nguoiDung.setNu(res.getBoolean(6));
            nguoiDung.setAvatar(res.getString(7));
            nguoiDung.setDienThoai(res.getString(8));
            nguoiDung.setDiaChi(res.getString(9));
            nguoiDung.setQuanTriVien(res.getBoolean(10));
            nguoiDung.setKichHoat(res.getBoolean(11));
            nguoiDung.setChoPhep(res.getBoolean(12));

            nguoiDungs.add(nguoiDung);
        }

        closeConnection();
        return nguoiDungs;
    }

    @Override
    public int add(NguoiDung model) {
        return 0;
    }

    @Override
    public int delete(NguoiDung model) {
        return 0;
    }

    @Override
    public int modify(NguoiDung model) throws SQLException, ClassNotFoundException {
        if (model == null) {
            return 0;
        }
        openConnection();

        String sql = "EXEC SuaNguoiDung ?,?,?,?,?,?,?,?,?,?,?,?";
        PreparedStatement  statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, model.getEmail());
        statement.setString(2, model.getHoDem());
        statement.setString(3, model.getTen());
        statement.setString(4, model.getMatKhau());
        statement.setDate(5, model.getNgaySinh());
        statement.setBoolean(6, model.isNu());
        statement.setString(7, model.getAvatar());
        statement.setString(8, model.getDienThoai());
        statement.setString(9, model.getDiaChi());
        statement.setBoolean(10, model.isQuanTriVien());
        statement.setBoolean(11, model.isKichHoat());
        statement.setBoolean(12, model.isChoPhep());

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public NguoiDung get(Object... keys) throws SQLException, ClassNotFoundException {
        if (keys.length <= 0) {
            return null;
        }
        openConnection();

        String sql = "EXEC LayMotNguoiDung ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, keys[0].toString());

        ResultSet res = statement.executeQuery();
        NguoiDung nguoiDung = null;
        if (res.next()) {
            nguoiDung = new NguoiDung();
            nguoiDung.setEmail(res.getString(1));
            nguoiDung.setHoDem(res.getString(2));
            nguoiDung.setTen(res.getString(3));
            nguoiDung.setMatKhau(res.getString(4));
            nguoiDung.setNgaySinh(res.getDate(5));
            nguoiDung.setNu(res.getBoolean(6));
            nguoiDung.setAvatar(res.getString(7));
            nguoiDung.setDienThoai(res.getString(8));
            nguoiDung.setDiaChi(res.getString(9));
            nguoiDung.setQuanTriVien(res.getBoolean(10));
            nguoiDung.setKichHoat(res.getBoolean(11));
            nguoiDung.setChoPhep(res.getBoolean(12));
        }

        closeConnection();
        return nguoiDung;
    }
}