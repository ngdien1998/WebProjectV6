package quanlynhahang.controllers.dangnhap;

import quanlynhahang.common.Consts;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.NguoiDungService;
import quanlynhahang.models.datamodels.NguoiDung;
import quanlynhahang.models.viewmodels.UserDbConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DangNhapServlet", urlPatterns = {"/dang-nhap"})
public class DangNhapServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("txtEmail");
            String matKhau = request.getParameter("txtMatKhau");
            NguoiDungService service = new NguoiDungService(DbAccess.getValue(request));
            NguoiDung loginUser = service.dangNhap(email, matKhau);
            if (loginUser != null) {
                UserDbConnect userDbConnect = new UserDbConnect();
                userDbConnect.setUsername(loginUser.getEmail());
                userDbConnect.setPassword(loginUser.getMatKhau());
                userDbConnect.setAdmin(loginUser.isQuanTriVien());

                HttpSession session = request.getSession();
                session.setAttribute(Consts.WEBSITE_LOGIN, loginUser);
                session.setAttribute(Consts.USER_DB_CONNECT, userDbConnect);

                response.sendRedirect("/trang-chu");
                return;
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dang-nhap.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dang-nhap.jsp");
        dispatcher.forward(request, response);
    }
}
