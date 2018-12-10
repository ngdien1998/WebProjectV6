package quanlynhahang.controllers.ajax;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.NguoiDungService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "KiemTraEmailPostAjax", urlPatterns = { "/kiem-tra-email" })
public class KiemTraEmailPostAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String email = request.getParameter("email");
            NguoiDungService service = new NguoiDungService(DbAccess.getValue(request));
            response.getWriter().print(service.checkEmailExisted(email));
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
