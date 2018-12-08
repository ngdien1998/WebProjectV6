package quanlynhahang.controllers.quantrivien;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.QuanTriVienService;
import quanlynhahang.models.datamodels.NguoiDung;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "XemQuanTriVienServlet", urlPatterns = { "/admin/xem-quan-tri-vien" })
public class XemQuanTriVienServlet extends HttpServlet implements ActionPermissionID {
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
                response.setStatus(400);
                return;
            }
            QuanTriVienService service = new QuanTriVienService(DbAccess.getValue(request));
            NguoiDung qtv = service.get(email);
            if (qtv == null) {
                response.setStatus(404);
                return;
            }
            request.setAttribute("qtv", qtv);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xem-quan-tri-vien.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.XEM_QUAN_TRI_VIEN;
    }
}