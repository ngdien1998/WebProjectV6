package quanlynhahang.controllers.trangnguoidung.giohang;

import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.models.viewmodels.GioHang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ThemVaoGioHangServlet", urlPatterns = { "/them-vao-gio-hang" })
public class ThemVaoGioHangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");

            if (!AuthorizePermission.islogined(request)) {
                response.getWriter().println("Bạn hãy <a href='/dang-nhap'>đăng nhập</a> hoặc <a href='/dang-ky'>đăng ký tài khoản</a> để có thể đặt món");
                return;
            }

            String idMonAn = request.getParameter("txtIdMon");
            String soLuong = request.getParameter("txtSoLuong");

            if (idMonAn == null || soLuong == null) {
                response.sendError(400);
                return;
            }

            GioHang gioHang = new GioHang(request.getSession());
            gioHang.themMonAnVaoGioHang(Integer.parseInt(idMonAn), Integer.parseInt(soLuong));

            response.getWriter().println("Đã thêm " + soLuong + " món ăn này vào. Vào <a href='/gio-hang'>Giỏ hàng</a> để xem chi tiết");
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().equals("404")) {
                response.sendError(404);
                return;
            }
            response.sendError(500);
        }
    }
}