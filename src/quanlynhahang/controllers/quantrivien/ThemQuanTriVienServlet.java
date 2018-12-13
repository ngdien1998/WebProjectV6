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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ThemQuanTriVienServlet", urlPatterns = {"/admin/them-quan-tri-vien"})
public class ThemQuanTriVienServlet extends HttpServlet implements ActionPermissionID {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            if (!AuthorizePermission.islogined(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }

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
            qtv.setDienThoai(request.getParameter("txtDienThoai"));
            qtv.setDiaChi(request.getParameter("txtDiaChi"));
            qtv.setChoPhep(request.getParameter("chkChoPhep") != null);
            qtv.setQuanTriVien(true);
            qtv.setKichHoat(request.getParameter("chkKichHoat") != null);

            QuanTriVienService service = new QuanTriVienService(DbAccess.getValue(request));
            service.add(qtv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/admin/quan-tri-vien");
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

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-them-quan-tri-vien.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.THEM_QUAN_TRI_VIEN;
    }
}