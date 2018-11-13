package quanlynhahang.controllers.quantrivien;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "PhanQuyenServlet", urlPatterns = { "/admin/phan-quyen" })
public class PhanQuyenServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            if (email == null || email.trim().equals("")) {
                response.setStatus(400);
                return;
            }
            QuanTriVienService quanTriVienService = new QuanTriVienService();
            NguoiDung qtv = quanTriVienService.get(email);
            if (qtv == null) {
                response.setStatus(404);
                return;
            }
            if (!qtv.isQuanTriVien()) {
                response.setStatus(400);
                return;
            }

            NghiepVuService nghiepVuService = new NghiepVuService();
            ArrayList<NghiepVu> nghiepVus = nghiepVuService.getData();
            request.setAttribute("nghiepVus", nghiepVus);
            request.setAttribute("qtv", qtv);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-phan-quyen.jsp");
        dispatcher.forward(request, response);
    }
}
