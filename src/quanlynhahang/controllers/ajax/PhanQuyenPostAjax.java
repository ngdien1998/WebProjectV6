package quanlynhahang.controllers.ajax;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.QuyenService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PhanQuyenPostAjax", urlPatterns = { "/admin/ajax-cap-nhap-phan-quyen" })
public class PhanQuyenPostAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean isset = false;
        try {
            String idQuyen = request.getParameter("idQuyen");
            String email = request.getParameter("email");
            String action = request.getParameter("action");
            if (idQuyen == null || email == null || action == null || idQuyen.trim().isEmpty() || email.trim().isEmpty() || action.trim().isEmpty()) {
                response.setStatus(400);
                return;
            }
            QuyenService service = new QuyenService(DbAccess.getValue(request));
            isset = service.phanQuyen(Integer.parseInt(idQuyen), email, action);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print(e.toString());
        }
        response.getWriter().print(isset);
    }
}
