package quanlynhahang.controllers.trangnguoidung.datmonnhom;

import com.google.gson.JsonObject;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnNhomService;
import quanlynhahang.models.datamodels.NguoiDung;
import quanlynhahang.models.viewmodels.HoaDonNhom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "TaoHoaDonNhomServlet", urlPatterns = { "/tao-hoa-don-nhom" })
public class TaoHoaDonNhomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            NguoiDung currentUser = AuthorizePermission.getCurrentLoginUser(request);

            HoaDonNhom hoaDonNhom = new HoaDonNhom();
            hoaDonNhom.setEmailNguoiTao(currentUser.getEmail());
            hoaDonNhom.setTenNguoiTao(currentUser.getTen());
            hoaDonNhom.setThoiGianTao(new java.sql.Date(new Date().getTime()));

            MonAnNhomService service = new MonAnNhomService(DbAccess.getValue(request));
            hoaDonNhom = service.taoHoaDon(hoaDonNhom);

            JsonObject jsonHoaDon = new JsonObject();
            jsonHoaDon.addProperty("tenNguoiTao", hoaDonNhom.getTenNguoiTao());
            jsonHoaDon.addProperty("idHoaDon", hoaDonNhom.getIdHoaDonNhom());
            response.getWriter().print(jsonHoaDon.toString());
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print(e.toString());
        }
    }
}
