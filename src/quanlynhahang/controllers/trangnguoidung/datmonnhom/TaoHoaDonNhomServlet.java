package quanlynhahang.controllers.trangnguoidung.datmonnhom;

import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.Consts;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnNhomService;
import quanlynhahang.models.datamodels.NguoiDung;
import quanlynhahang.models.viewmodels.HoaDonNhom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(name = "TaoHoaDonNhomServlet", urlPatterns = { "/tao-hoa-don-nhom" })
public class TaoHoaDonNhomServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            if (!AuthorizePermission.islogined(request)) {
                HttpSession session = request.getSession();
                session.setAttribute(Consts.PREVIOUS_PAGE, "/tao-hoa-don-nhom");
                response.sendRedirect("/dang-nhap");
                return;
            }

            NguoiDung currentUser = AuthorizePermission.getCurrentLoginUser(request);

            HoaDonNhom hoaDonNhom = new HoaDonNhom();
            hoaDonNhom.setEmailNguoiTao(currentUser.getEmail());
            hoaDonNhom.setTenNguoiTao(currentUser.getTen());
            hoaDonNhom.setThoiGianTao(Calendar.getInstance().getTime());

            MonAnNhomService service = new MonAnNhomService(DbAccess.getValue(request));
            hoaDonNhom = service.taoHoaDon(hoaDonNhom);

            response.sendRedirect("/dat-mon-nhom?id=" + hoaDonNhom.getIdHoaDonNhom());
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print(e.toString());
        }
    }
}
