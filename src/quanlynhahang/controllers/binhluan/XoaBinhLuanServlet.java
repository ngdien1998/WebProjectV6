package quanlynhahang.controllers.binhluan;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.BinhLuanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "XoaBinhLuanServlet", urlPatterns = { "/xoa-binh-luan" })
public class XoaBinhLuanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idBinhLuan = request.getParameter("idBinhLuan");
            if (idBinhLuan == null || idBinhLuan.trim().isEmpty()) {
                response.sendError(400);
                return;
            }
            BinhLuanService service = new BinhLuanService(DbAccess.getValue(request));
            service.delete(Integer.parseInt(idBinhLuan));
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.toString());
        }
    }
}