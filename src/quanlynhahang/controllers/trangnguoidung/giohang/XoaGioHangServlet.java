package quanlynhahang.controllers.trangnguoidung.giohang;

import quanlynhahang.models.viewmodels.GioHang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "XoaGioHangServlet", urlPatterns = { "/xoa-gio-hang" })
public class XoaGioHangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");

            GioHang gioHang = new GioHang(request.getSession());
            gioHang.xoaGioHang();

            response.sendRedirect("/gio-hang");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
