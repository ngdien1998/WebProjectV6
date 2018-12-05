package quanlynhahang.controllers.trangnguoidung.datmonnhom;

import com.google.gson.JsonObject;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnNhomService;
import quanlynhahang.models.viewmodels.MonAnNhom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "XoaMonAnNhomServlet", urlPatterns = { "/xoa-mon-an-nhom" })
public class XoaMonAnNhomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            String idHoaDon = request.getParameter("idHoaDon");
            String idMonAn = request.getParameter("idMonAn");
            String emailNguoiDat = request.getParameter("emailNguoiDat");

            if (idMonAn == null || idHoaDon == null || emailNguoiDat == null) {
                response.sendError(400);
                return;
            }

            MonAnNhomService service = new MonAnNhomService(DbAccess.getValue(request));
            int rowsAffected = service.xoaMonAnTronHoaDon(Integer.parseInt(idHoaDon), Integer.parseInt(idMonAn), emailNguoiDat);
            if (rowsAffected <= 0) {
                response.sendError(304); // NOT MODIFIED
                return;
            }
            double cong = 0;
            for (MonAnNhom monAnNhom : service.layHoaDon(Integer.parseInt(idHoaDon)).getMonAnNhoms()) {
                cong += monAnNhom.tinhTienMon();
            }
            JsonObject object = new JsonObject();
            object.addProperty("cong", cong);
            object.addProperty("tongCong", cong + 7000);
            response.getWriter().print(object.toString());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.toString());
        }
    }
}
