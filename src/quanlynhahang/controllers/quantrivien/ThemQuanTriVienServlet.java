package quanlynhahang.controllers.quantrivien;

import quanlynhahang.models.businessmodels.QuanTriVienService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ThemQuanTriVienServlet", urlPatterns = { "/admin/them-quan-tri-vien" })
public class ThemQuanTriVienServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");

            NguoiDung qtv = new NguoiDung();
            qtv.setEmail(request.getParameter("txtEmail"));
            qtv.setHoDem(request.getParameter("txtHoDem"));
            qtv.setTen(request.getParameter("txtTen"));
            qtv.setMatKhau(request.getParameter("txtMatKhau"));
            qtv.setNu(request.getParameter("radNu") != null);
            java.sql.Date ngaySinh = null;
            if (request.getParameter("dteNgaySinh") != null) {
                Date temp = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dteNgaySinh"));
                ngaySinh = new java.sql.Date(temp.getTime());
            }
            qtv.setNgaySinh(ngaySinh);
            qtv.setAvatar(request.getParameter("txtAvatar"));
            qtv.setDienThoai(request.getParameter("txtDienThoai"));
            qtv.setDiaChi(request.getParameter("txtDiaChi"));
            qtv.setChoPhep(request.getParameter("chkChoPhep") != null);
            qtv.setQuanTriVien(request.getParameter("chkLaQtv") != null);
            qtv.setKichHoat(request.getParameter("chkKichHoat") != null);

            QuanTriVienService service = new QuanTriVienService();
            service.add(qtv);
        } catch (ParseException | SQLException | ClassNotFoundException e) {
            HttpSession error = request.getSession();
            error.setAttribute("error", e.toString());
            e.printStackTrace();
        }
        response.sendRedirect("/admin/quan-tri-vien");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-them-quan-tri-vien.jsp");
        dispatcher.forward(request, response);
    }
}
