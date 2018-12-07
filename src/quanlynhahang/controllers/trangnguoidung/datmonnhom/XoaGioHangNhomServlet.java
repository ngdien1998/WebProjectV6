package quanlynhahang.controllers.trangnguoidung.datmonnhom;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnNhomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "XoaGioHangNhomServlet", urlPatterns = { "/xoa-gio-hang-nhom" })
public class XoaGioHangNhomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idGioHang = request.getParameter("idGioHang");
            if (idGioHang == null) {
                response.sendError(400);
                return;
            }
            MonAnNhomService service = new MonAnNhomService(DbAccess.getValue(request));
            service.xoaHoaDon(Integer.parseInt(idGioHang));

            response.sendRedirect("/dat-mon-nhom");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
