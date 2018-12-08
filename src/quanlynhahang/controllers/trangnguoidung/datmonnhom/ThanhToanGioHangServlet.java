package quanlynhahang.controllers.trangnguoidung.datmonnhom;

import com.google.gson.JsonObject;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnNhomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ThanhToanGioHangServlet", urlPatterns = { "/thanh-toan-gio-hang-nhom" })
public class ThanhToanGioHangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            String idHoaDon = request.getParameter("idHoaDon");
            if (idHoaDon == null || idHoaDon.trim().isEmpty()) {
                response.sendError(400);
                return;
            }
            MonAnNhomService service = new MonAnNhomService(DbAccess.getValue(request));
            String res = service.hoanThanhDonHang(Integer.parseInt(idHoaDon));

            String[] temp = res.split("-");
            JsonObject json = new JsonObject();
            json.addProperty("soLuong", temp[0]);
            json.addProperty("tongTien", temp[1]);

            response.getWriter().print(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print(e.toString());
        }
    }
}