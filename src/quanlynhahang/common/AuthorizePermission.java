package quanlynhahang.common;

import quanlynhahang.models.businessmodels.CheckPhanQuyenService;
import quanlynhahang.models.datamodels.NguoiDung;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public final class AuthorizePermission {
    public static final int XOA_NGUOI_DUNG = 2;
    public static final int THEM_QUAN_TRI_VIEN = 4;
    public static final int XOA_QUAN_TRI_VIEN = 5;
    public static final int PHAN_QUYEN = 7;
    public static final int XEM_QUAN_TRI_VIEN = 8;
    public static final int XEM_NGUOI_DUNG = 9;
    public static final int THEM_MON_AN = 10;
    public static final int XEM_MON_AN = 11;
    public static final int XOA_MON_AN = 12;
    public static final int SUA_MON_AN = 13;
    public static final int XOA_BINH_LUAN_MON_AN = 14;
    public static final int XEM_LOAI_MON = 15;
    public static final int THEM_LOAI_MON = 16;
    public static final int XOA_LOAI_MON = 17;
    public static final int SUA_LOAI_MON = 18;
    public static final int THEM_THUC_DON = 19;
    public static final int XEM_THUC_DON = 20;
    public static final int XOA_THUC_DON = 21;
    public static final int SUA_THUC_DON = 22;
    public static final int THEM_MON_AN_VAO_THUC_DON = 23;
    public static final int THEM_BAI_VIET = 25;
    public static final int SUA_BAI_VIET = 26;
    public static final int XOA_BAI_VIET = 27;
    public static final int XEM_BAI_VIET = 28;
    public static final int XEM_DAT_BAN = 29;
    public static final int XOA_DAT_BAN = 30;
    public static final int XEM_HOA_DON = 31;
    public static final int THEM_HOA_DON = 32;
    public static final int XEM_CHI_TIET_THUC_DON = 33;
    public static final int XOA_BINH_LUAN_BAI_VIET = 34;
    public static final int SUA_LOAI_BAI_VIET = 35;
    public static final int THEM_LOAI_BAI_VIET = 36;
    public static final int XOA_LOAI_BAI_VIET = 37;
    public static final int DAT_BAN=38;

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

    public static boolean islogined(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute(Consts.WEBSITE_LOGIN) != null;
    }

    public static NguoiDung getCurrentLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (NguoiDung) session.getAttribute(Consts.WEBSITE_LOGIN);
    }
}
