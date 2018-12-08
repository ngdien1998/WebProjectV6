package quanlynhahang.controllers.trangnguoidung.giohang;

import com.google.gson.JsonObject;
import quanlynhahang.models.viewmodels.GioHang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CapNhatGioHangServlet", urlPatterns = { "/cap-nhat-gio-hang" })
public class CapNhatGioHangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            int idMonAn = Integer.parseInt(request.getParameter("txtIdMon"));
            int soLuong = Integer.parseInt(request.getParameter("txtSoLuong"));

            GioHang gioHang = new GioHang(request.getSession());
            gioHang.capNhatGioHang(idMonAn, soLuong);

            JsonObject jsonResult = new JsonObject();
            jsonResult.addProperty("giaMoi", gioHang.layMonAn(idMonAn).tinhTien());
            jsonResult.addProperty("tongTien", gioHang.tinhTongTien());
            response.getWriter().print(jsonResult.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
