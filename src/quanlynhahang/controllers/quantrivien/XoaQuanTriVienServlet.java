package quanlynhahang.controllers.quantrivien;

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

@WebServlet(name = "XoaQuanTriVienServlet", urlPatterns = { "/admin/xoa-quan-tri-vien" })
public class XoaQuanTriVienServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String email = request.getParameter("txtEmail");
            if (email == null || email.trim().equals("")) {
                response.setStatus(400);
                return;
            }
            QuanTriVienService service = new QuanTriVienService();
            service.delete(email);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/admin/quan-tri-vien");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            if (email == null || email.trim().equals("")) {
                response.setStatus(400);
                return;
            }
            QuanTriVienService service = new QuanTriVienService();
            NguoiDung qtv = service.get(email);
            if (qtv == null) {
                response.setStatus(404);
                return;
            }
            request.setAttribute("qtv", qtv);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xoa-quan-tri-vien.jsp");
        dispatcher.forward(request, response);
    }
}
