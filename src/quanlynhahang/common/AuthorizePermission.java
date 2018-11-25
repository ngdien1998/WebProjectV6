package quanlynhahang.common;

import quanlynhahang.models.businessmodels.CheckPhanQuyenService;
import quanlynhahang.models.datamodels.NguoiDung;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public final class AuthorizePermission {
    public static final int PHAN_QUYEN = 7;

    public static boolean checkPermissionAllowed(HttpServletRequest request, int permissionId) throws SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute(Consts.WEBSITE_LOGIN);
        if (obj != null) {
            NguoiDung loginedUser = (NguoiDung) obj;
            CheckPhanQuyenService service = new CheckPhanQuyenService(DbAccess.getValue(request));
            return service.checkPhanQuyen(loginedUser.getEmail(), permissionId);
        }
        return false;
    }

    public static boolean checkLogined(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute(Consts.WEBSITE_LOGIN) != null;
    }
}
