package quanlynhahang.common;

import quanlynhahang.models.datamodels.NguoiDung;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class DbAccess {
    public static Boolean getValue(HttpServletRequest request) {
        Boolean isAdmin = null;
        HttpSession session = request.getSession();
        NguoiDung loginSesstion = (NguoiDung) session.getAttribute(Consts.LOGIN_SESSION);
        if (loginSesstion != null) {
            isAdmin = loginSesstion.isQuanTriVien();
        }
        return isAdmin;
    }
}
