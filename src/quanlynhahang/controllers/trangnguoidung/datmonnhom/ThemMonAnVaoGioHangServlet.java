package quanlynhahang.controllers.trangnguoidung.datmonnhom;

import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.Consts;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnNhomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ThemMonAnVaoGioHangServlet", urlPatterns = { "/them-mon-an-vao-gio-hang" })
public class ThemMonAnVaoGioHangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            String idMonAn = request.getParameter("idMonAn");
            String idGioHang = request.getParameter("idGioHang");
            if (idMonAn == null || idGioHang == null) {
                response.sendError(400);
                return;
            }

            if (!AuthorizePermission.islogined(request)) {
                HttpSession session = request.getSession();
                session.setAttribute(Consts.PREVIOUS_PAGE, "/dat-mon-nhom?id=" + idGioHang);
                response.getWriter().print("redirect");
                return;
            }

            MonAnNhomService service = new MonAnNhomService(DbAccess.getValue(request));
            service.themMonAn(Integer.parseInt(idMonAn), Integer.parseInt(idGioHang), AuthorizePermission.getCurrentLoginUser(request).getEmail());

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
