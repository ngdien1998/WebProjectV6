package quanlynhahang.controllers.quantrivien;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.NghiepVuService;
import quanlynhahang.models.businessmodels.QuanTriVienService;
import quanlynhahang.models.datamodels.NghiepVu;
import quanlynhahang.models.datamodels.NguoiDung;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "PhanQuyenServlet", urlPatterns = { "/admin/phan-quyen" })
public class PhanQuyenServlet extends HttpServlet implements ActionPermissionID {
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
            QuanTriVienService quanTriVienService = new QuanTriVienService(DbAccess.getValue(request));
            NguoiDung qtv = quanTriVienService.get(email);
            if (qtv == null) {
                response.sendError(404);
                return;
            }
            if (!qtv.isQuanTriVien()) {
                response.sendError(400);
                return;
            }

            NghiepVuService nghiepVuService = new NghiepVuService(DbAccess.getValue(request));
            ArrayList<NghiepVu> nghiepVus = nghiepVuService.getData();
            request.setAttribute("nghiepVus", nghiepVus);
            request.setAttribute("qtv", qtv);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-phan-quyen.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendError(500);
        }

    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.PHAN_QUYEN;
    }
}
