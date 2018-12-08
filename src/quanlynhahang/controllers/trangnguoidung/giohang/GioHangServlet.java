package quanlynhahang.controllers.trangnguoidung.giohang;

import quanlynhahang.models.viewmodels.GioHang;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GioHangServlet", urlPatterns = {"/gio-hang"})
public class GioHangServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            GioHang gioHang = new GioHang(request.getSession());
            request.setAttribute("tongTien", gioHang.tinhTongTien());
            request.setAttribute("gioHangRong", gioHang.laGioHangRong());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gio-hang.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
