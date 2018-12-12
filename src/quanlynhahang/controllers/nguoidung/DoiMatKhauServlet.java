package quanlynhahang.controllers.nguoidung;

import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.Consts;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.NguoiDungService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DoiMatKhauServlet", urlPatterns = { "/doi-mat-khau" })
public class DoiMatKhauServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String oldPass = request.getParameter("txtMatKhau");
            String newPass = request.getParameter("txtMatKhauMoi");

            NguoiDungService service = new NguoiDungService(DbAccess.getValue(request));
            boolean res = service.doiMatKhau(AuthorizePermission.getCurrentLoginUser(request).getEmail(), oldPass, newPass);
            if (res) {
                response.sendRedirect("/sua-thong-tin-ca-nhan");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!AuthorizePermission.islogined(request)) {
            HttpSession session = request.getSession();
            session.setAttribute(Consts.PREVIOUS_PAGE, "/doi-mat-khau");
            response.sendRedirect("/dang-nhap");
            return;
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/doi-mat-khau.jsp");
        dispatcher.forward(request, response);
    }
}