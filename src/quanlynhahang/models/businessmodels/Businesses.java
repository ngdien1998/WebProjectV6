package quanlynhahang.models.businessmodels;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Businesses<TDataModel> {
    ArrayList<TDataModel> getData() throws SQLException, ClassNotFoundException;
    int add(TDataModel model) throws SQLException, ClassNotFoundException;
    int delete(Object... keys) throws SQLException, ClassNotFoundException;
    int modify(TDataModel model) throws SQLException, ClassNotFoundException;
    TDataModel get(Object... keys) throws SQLException, ClassNotFoundException;
}