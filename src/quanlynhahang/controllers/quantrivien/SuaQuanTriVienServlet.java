package quanlynhahang.controllers.quantrivien;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SuaQuanTriVienServlet", urlPatterns = {"/admin/sua-quan-tri-vien"})
public class SuaQuanTriVienServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");

            NguoiDung qtv = new NguoiDung();
            qtv.setEmail(request.getParameter("txtEmail"));
            qtv.setHoDem(request.getParameter("txtHoDem"));
            qtv.setTen(request.getParameter("txtTen"));
            qtv.setMatKhau(request.getParameter("txtMatKhau"));
            qtv.setNu(request.getParameter("radGioiTinh").equals("nu"));
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
            qtv.setQuanTriVien(true);
            qtv.setKichHoat(request.getParameter("chkKichHoat") != null);

            QuanTriVienService service = new QuanTriVienService(DbAccess.getValue(request));
            service.modify(qtv);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
        response.sendRedirect("/admin/quan-tri-vien");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            if (email == null) {
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
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-sua-quan-tri-vien.jsp");
        dispatcher.forward(request, response);
    }
}
