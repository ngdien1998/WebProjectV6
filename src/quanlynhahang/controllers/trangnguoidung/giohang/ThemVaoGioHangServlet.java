package quanlynhahang.controllers.trangnguoidung.giohang;

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

            int idMonAn = Integer.parseInt(request.getParameter("txtIdMon"));
            int soLuong = Integer.parseInt(request.getParameter("txtSoLuong"));

            GioHang gioHang = new GioHang(request.getSession());
            gioHang.themMonAnVaoGioHang(idMonAn, soLuong);

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