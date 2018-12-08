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

@WebServlet(name = "XoaQuanTriVienServlet", urlPatterns = { "/admin/xoa-quan-tri-vien" })
public class XoaQuanTriVienServlet extends HttpServlet implements ActionPermissionID {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            if (!AuthorizePermission.islogined(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }

            String email = request.getParameter("txtEmail");
            if (email == null || email.trim().equals("")) {
                response.sendError(400);
                return;
            }
            QuanTriVienService service = new QuanTriVienService(DbAccess.getValue(request));
            service.delete(email);
            response.sendRedirect("/admin/quan-tri-vien");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }

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
            if (email == null || email.trim().equals("")) {
                response.sendError(400);
                return;
            }
            QuanTriVienService service = new QuanTriVienService(DbAccess.getValue(request));
            NguoiDung qtv = service.get(email);
            if (qtv == null) {
                response.sendError(404);
                return;
            }
            request.setAttribute("qtv", qtv);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xoa-quan-tri-vien.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.XOA_QUAN_TRI_VIEN;
    }
}