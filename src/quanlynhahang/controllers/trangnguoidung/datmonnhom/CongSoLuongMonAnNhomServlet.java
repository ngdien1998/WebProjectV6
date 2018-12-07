package quanlynhahang.controllers.trangnguoidung.datmonnhom;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnNhomService;
import quanlynhahang.models.viewmodels.MonAnNhom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CongSoLuongMonAnNhomServlet", urlPatterns = { "/cong-them-mon-an-nhom" })
public class CongSoLuongMonAnNhomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idHoaDon = request.getParameter("idHoaDon");
            String idMonAn = request.getParameter("idMonAn");
            String emailNguoiDat = request.getParameter("emailNguoiDat");
            String soLuong = request.getParameter("soLuong");

            if (idMonAn == null || idHoaDon == null || emailNguoiDat == null || soLuong == null || Integer.parseInt(soLuong) <= 0) {
                response.sendError(400);
                return;
            }

            MonAnNhomService service = new MonAnNhomService(DbAccess.getValue(request));
            int rowsAffected = service.congSoLuongMonAn(Integer.parseInt(idHoaDon), Integer.parseInt(idMonAn), emailNguoiDat);
            if (rowsAffected <= 0) {
                response.sendError(304); // 304: NOT MODIFIED
                return;
            }
            double cong = 0;
            for (MonAnNhom monAnNhom : service.layHoaDon(Integer.parseInt(idHoaDon)).getMonAnNhoms()) {
                cong += monAnNhom.tinhTienMon();
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}