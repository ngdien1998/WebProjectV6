package quanlynhahang.common;

import quanlynhahang.models.viewmodels.UserDbConnect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class DbAccess {
    public static UserDbConnect getValue(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object adminLogied = session.getAttribute(Consts.USER_DB_CONNECT);
        if (adminLogied != null) {
            return (UserDbConnect) adminLogied;
        }
        return null;
    }
}
