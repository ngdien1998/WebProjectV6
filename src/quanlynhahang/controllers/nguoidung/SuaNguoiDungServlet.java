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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SuaNguoiDungServlet", urlPatterns = {"/admin/sua-nguoi-dung"})
public class SuaNguoiDungServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");

            String email = request.getParameter("email");
            if (email == null) {
                response.setStatus(400);
                return;
            }
            NguoiDungService service = new NguoiDungService(DbAccess.getValue(request));
            NguoiDung nguoiDung = service.get(email);
            if (nguoiDung == null) {
                response.setStatus(404);
                return;
            }
            request.setAttribute("nguoiDung", nguoiDung);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-sua-nguoi-dung.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");

            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.setEmail(request.getParameter("txtEmail"));
            nguoiDung.setHoDem(request.getParameter("txtHoDem"));
            nguoiDung.setTen(request.getParameter("txtTen"));
            nguoiDung.setMatKhau(request.getParameter("txtMatKhau"));
            nguoiDung.setNu(request.getParameter("radNu") != null);
            if (request.getParameter("dteNgaySinh") != null) {
                Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dteNgaySinh"));
                nguoiDung.setNgaySinh(new java.sql.Date(ngaySinh.getTime()));
            }
            nguoiDung.setAvatar(request.getParameter("txtAvatar"));
            nguoiDung.setDienThoai(request.getParameter("txtDienThoai"));
            nguoiDung.setDiaChi(request.getParameter("txtDiaChi"));
            nguoiDung.setChoPhep(request.getParameter("chkChoPhep") != null);
            nguoiDung.setQuanTriVien(false);
            nguoiDung.setKichHoat(request.getParameter("chkKichHoat") != null);

            NguoiDungService service = new NguoiDungService(DbAccess.getValue(request));
            service.modify(nguoiDung);
        } catch (ParseException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/admin/nguoi-dung");
    }
}
