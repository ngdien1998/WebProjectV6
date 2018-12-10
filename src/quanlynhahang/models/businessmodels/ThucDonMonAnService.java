package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.datamodels.ThucDon;
import quanlynhahang.models.datamodels.ThucDonMonAn;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThucDonMonAnService extends ConnectDatabase implements Businesses<ThucDonMonAn> {
    public ThucDonMonAnService(UserDbConnect user) {
        super(user);
    }

    public ArrayList<MonAn> getMonAns(int idThucDon) throws SQLException, ClassNotFoundException {
        MonAnService monAnService = new MonAnService(getDbAccessValue());
        ArrayList<Integer> listIDMonAn = monAnService.getIDMonAn(idThucDon);
        if (listIDMonAn == null) {
            return null;
        }

        ArrayList<MonAn> listMonAn = new ArrayList<>();
        for (int i = 0; i < listIDMonAn.size(); i++) {
            MonAn monAn = null;
            monAn = monAnService.get(listIDMonAn.get(i));

            listMonAn.add(monAn);
        }

        return listMonAn;
    }

    public int addThucDonMonAn(String idMonAn, String idThucDon) throws SQLException, ClassNotFoundException {

        openConnection();
        String sql = "EXEC ThemThucDonMonAn ?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, idMonAn);
        statement.setString(2, idThucDon);

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    public int xoaThucDonMonAn(String idMonAn, String idThucDon) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC XoaMonAnKhoiThucDon ?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, idMonAn);
        statement.setString(2, idThucDon);

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    public ArrayList<ThucDon> getThucDon(String idMonAn) throws SQLException, ClassNotFoundException {
//        String sql = "EXEC LayIDThucDonCuaMonAn ?";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setEscapeProcessing(true);
//        statement.setQueryTimeout(90);
//        statement.setInt(1, Integer.parseInt(idMonAn));
//
//        ResultSet res = statement.executeQuery();
//        ArrayList<Integer> listIDThucDon = new ArrayList<>();
//
//        while (res.next()){
//            int ID;
//            ID = res.getInt(1);
//            listIDThucDon.add(ID);
//        }
//
//        ArrayList<ThucDon> listThucDon = new ArrayList<>();
//        for(int i =0;i<listIDThucDon.size() ;i++){
//            thucDonMonAnService.get(listIDThucDon.get(i));
//
//        }
//        closeConnection();
//        return listIDMonAn;
        return null;
    }

    @Override
    public ArrayList<ThucDonMonAn> getData() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int add(ThucDonMonAn thucDonMonAn) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int modify(ThucDonMonAn thucDonMonAn) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public ThucDonMonAn get(Object... keys) throws SQLException, ClassNotFoundException {
        return null;
    }
}
