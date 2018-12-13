package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.NguoiDung;
import quanlynhahang.models.viewmodels.UserDbConnect;

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
public class QuanTriVienService extends ConnectDatabase implements Businesses<NguoiDung> {
    public QuanTriVienService(UserDbConnect user) {
        super(user);
    }

    @Override
    public ArrayList<NguoiDung> getData() throws SQLException, ClassNotFoundException {
        ArrayList<NguoiDung> nguoiDungs = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM LayQuanTriVien";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);

        ResultSet res = statement.executeQuery();
        while (res.next()) {
            NguoiDung qtv = new NguoiDung();
            qtv.setEmail(res.getString(1));
            qtv.setHoDem(res.getString(2));
            qtv.setTen(res.getString(3));
            qtv.setMatKhau(res.getString(4));
            qtv.setNgaySinh(res.getDate(5));
            qtv.setNu(res.getBoolean(6));
            qtv.setAvatar(res.getString(7));
            qtv.setDienThoai(res.getString(8));
            qtv.setDiaChi(res.getString(9));
            qtv.setQuanTriVien(res.getBoolean(10));
            qtv.setKichHoat(res.getBoolean(11));
            qtv.setChoPhep(res.getBoolean(12));

            nguoiDungs.add(qtv);
        }

        closeConnection();
        return nguoiDungs;
    }

    @Override
    public int add(NguoiDung model) throws SQLException, ClassNotFoundException {
        if (model == null) {
            return 0;
        }
        openConnection();

        String sql = "EXEC ThemNguoiDung ?,?,?,?,?,?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, model.getEmail());
        statement.setString(2, model.getHoDem());
        statement.setString(3, model.getTen());
        statement.setString(4, model.getMatKhau());
        statement.setDate(5, model.getNgaySinh());
        statement.setBoolean(6, model.isNu());
        statement.setString(7, "../assests/images/profile.jpg");
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
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        if (keys.length <= 0) {
            return 0;
        }
        openConnection();

        String sql = "EXEC XoaNguoiDung ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, (String) keys[0]);
        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
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

        String sql = "SELECT * FROM LayMotQuanTriVien(?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, (String) keys[0]);

        ResultSet res = statement.executeQuery();
        NguoiDung qtv = null;
        if (res.next()) {
            qtv = new NguoiDung();
            qtv.setEmail(res.getString(1));
            qtv.setHoDem(res.getString(2));
            qtv.setTen(res.getString(3));
            qtv.setMatKhau(res.getString(4));
            qtv.setNgaySinh(res.getDate(5));
            qtv.setNu(res.getBoolean(6));
            qtv.setAvatar(res.getString(7));
            qtv.setDienThoai(res.getString(8));
            qtv.setDiaChi(res.getString(9));
            qtv.setQuanTriVien(res.getBoolean(10));
            qtv.setKichHoat(res.getBoolean(11));
            qtv.setChoPhep(res.getBoolean(12));
        }

        closeConnection();
        return qtv;
    }
}