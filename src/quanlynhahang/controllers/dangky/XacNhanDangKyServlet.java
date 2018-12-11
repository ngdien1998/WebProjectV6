package quanlynhahang.controllers.dangky;

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

@WebServlet(name = "XacNhanDangKyServlet", urlPatterns = { "/xac-nhan-dang-ky" })
public class XacNhanDangKyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String code = request.getParameter("txtCode");
            if (code == null || code.trim().isEmpty()) {
                response.sendError(400);
                return;
            }
            HttpSession session = request.getSession();
            Object obj = session.getAttribute(Consts.SAVED_CODE);
            if (obj == null) {
                response.sendRedirect("/dang-ky");
                return;
            }
            String savedCode = (String) obj;
            if (savedCode.equals(code)) {
                NguoiDungService service = new NguoiDungService(DbAccess.getValue(request));
                NguoiDung user = service.get((String) session.getAttribute(Consts.EMAIL));
                UserDbConnect admin = new UserDbConnect();
                admin.setAdmin(user.isQuanTriVien());
                session.setAttribute(Consts.WEBSITE_LOGIN, user);
                session.setAttribute(Consts.USER_DB_CONNECT, admin);
                session.removeAttribute(Consts.SAVED_CODE);
                response.sendRedirect("/trang-chu");
                return;
            }
            request.setAttribute(Consts.MESSAGE, "Mã xác nhận không chính xác, vui lòng kiểm tra lại email!");
            doGet(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/xac-nhan-dang-ky.jsp");
        dispatcher.forward(request, response);
    }
}
