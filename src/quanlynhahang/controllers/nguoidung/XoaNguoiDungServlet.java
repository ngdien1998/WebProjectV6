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

@WebServlet(name = "XoaNguoiDungServlet", urlPatterns = { "/admin/xoa-nguoi-dung" })
public class XoaNguoiDungServlet extends HttpServlet implements ActionPermissionID {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            NguoiDungService service = new NguoiDungService(DbAccess.getValue(request));
            service.delete(email);
            response.sendRedirect("/admin/nguoi-dung");
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
            NguoiDungService service = new NguoiDungService(DbAccess.getValue(request));
            NguoiDung nguoiDung = service.get(email);
            if (nguoiDung == null) {
                response.sendError(404);
                return;
            }
            request.setAttribute("nguoiDung", nguoiDung);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xoa-nguoi-dung.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.XOA_NGUOI_DUNG;
    }
}
