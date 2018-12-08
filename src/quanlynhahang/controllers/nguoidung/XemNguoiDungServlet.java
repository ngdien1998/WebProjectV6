package quanlynhahang.controllers.nguoidung;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.NguoiDungService;
import quanlynhahang.models.datamodels.NguoiDung;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "XemNguoiDungServlet", urlPatterns = { "/admin/xem-nguoi-dung" })
public class XemNguoiDungServlet extends HttpServlet implements ActionPermissionID {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (!AuthorizePermission.islogined(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }

            String email = request.getParameter("email");
            if (email == null) {
                response.sendError(400);
                return;
            }
            NguoiDungService service = new NguoiDungService(DbAccess.getValue(request));
            NguoiDung nguoiDung = service.get(email);
            if (nguoiDung == null) {
                response.sendError(404);
                return;
            }
            request.setAttribute("nguoiDung", nguoiDung);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xem-nguoi-dung.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.XEM_NGUOI_DUNG;
    }
}
