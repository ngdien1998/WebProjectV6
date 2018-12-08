package quanlynhahang.controllers.trangnguoidung.datmonnhom;

import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnNhomService;
import quanlynhahang.models.viewmodels.HoaDonNhom;
import quanlynhahang.models.viewmodels.MonAnNhom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CapNhatGioHangNhomServlet", urlPatterns = {"/cap-nhap-trang-thai-gio-hang"})
public class CapNhatGioHangNhomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            String idGioHang = request.getParameter("idGioHang");
            if (idGioHang == null) {
                response.sendError(400);
                return;
            }
            MonAnNhomService service = new MonAnNhomService(DbAccess.getValue(request));
            HoaDonNhom hoaDon = service.layHoaDon(Integer.parseInt(idGioHang));

            double cong = 0;
            StringBuilder html = new StringBuilder();
            html.append("<h4>Tình trạng giỏ hàng</h4>");
            if (hoaDon.getMonAnNhoms().size() > 0) {
                html.append("<div class='gio-hang'>");
                for (MonAnNhom monAn : hoaDon.getMonAnNhoms()) {
                    html.append("<div class='item-gio-hang'>\n");
                    if (monAn.getEmailNguoiDat().equals(AuthorizePermission.getCurrentLoginUser(request).getEmail())) {
                        html.append("<small><b>Bạn</b> đã đặt</small>\n");
                        html.append("<div class='alert alert-warning' data-id='").append(monAn.getIdMonAn()).append("'>\n");
                        html.append("<span class='btn-xoa' onclick='xoaMon(").append(hoaDon.getIdHoaDonNhom()).append(", ").append(monAn.getIdMonAn()).append(", \"").append(monAn.getEmailNguoiDat()).append("\");'>x</span>\n");
                        html.append("<span class='btn-cong' onclick='themMon(").append(hoaDon.getIdHoaDonNhom()).append(", ").append(monAn.getIdMonAn()).append(", \"").append(monAn.getEmailNguoiDat()).append("\");'>+</span>\n");
                        html.append("<span id='so-luong-").append(monAn.getIdMonAn()).append("'>").append(monAn.getSoLuong()).append("</span>\n");
                        html.append("<span class='btn-tru' onclick='botMon(").append(hoaDon.getIdHoaDonNhom()).append(", ").append(monAn.getIdMonAn()).append(", \"").append(monAn.getEmailNguoiDat()).append("\");'>-</span>\n");
                        html.append("<span class='ten-mon-an' style='font-weight: bold;'>").append(monAn.getTenMonAn()).append("</span>\n");
                        html.append("<span class='gia' style='color: #939b9d; font-size: small;'>").append(monAn.getGia()).append("đ</span>\n");
                    } else {
                        html.append("<small><b>").append(monAn.getTenNguoiDat()).append("</b> đã đặt</small>\n");
                        html.append("<div class='alert alert-success' data-id='").append(monAn.getIdMonAn()).append("'>\n");
                        html.append("<span class='btn-xoa' onclick='xoaMon(").append(hoaDon.getIdHoaDonNhom()).append(", ").append(monAn.getIdMonAn()).append(", \"").append(monAn.getEmailNguoiDat()).append("\");'>x</span>\n");
                        html.append("<span class='btn-cong' onclick='themMon(").append(hoaDon.getIdHoaDonNhom()).append(", ").append(monAn.getIdMonAn()).append(", \"").append(monAn.getEmailNguoiDat()).append("\");'>+</span>\n");
                        html.append("<span id='so-luong-").append(monAn.getIdMonAn()).append("'>").append(monAn.getSoLuong()).append("</span>\n");
                        html.append("<span class='btn-tru' onclick='botMon(").append(hoaDon.getIdHoaDonNhom()).append(", ").append(monAn.getIdMonAn()).append(", \"").append(monAn.getEmailNguoiDat()).append("\");'>-</span>\n");
                        html.append("<span class='ten-mon-an' style='font-weight: bold;'>").append(monAn.getTenMonAn()).append("</span>\n");
                        html.append("<span class='gia' style='color: #939b9d; font-size: small;'>").append(monAn.getGia()).append("đ</span>\n");
                    }
                    html.append("</div>\n");
                    html.append("</div>");
                    cong += monAn.tinhTienMon();
                }
                html.append("</div>");
                html.append("<div class='thong-tin-thanh-toan'>\n");
                html.append("<table class='table tbl-thanh-toan'>\n");
                html.append("<tr>\n");
                html.append("<td>Cộng</td>\n");
                html.append("<td class='text-right'>\n");
                html.append("<div class='badge badge-outline-warning' id='cong'>").append(cong).append(" đồng</div>\n");
                html.append("</td>\n");
                html.append("</tr>\n");
                html.append("<tr>\n");
                html.append("<td>Phí vận chuyển</td>\n");
                html.append("<td class='text-right'>\n");
                html.append("<div class='badge badge-outline-success'>7 000 đồng</div>\n");
                html.append("</td>\n");
                html.append("</tr>\n");
                html.append("<tr>\n");
                html.append("<td>Tổng cộng</td>\n");
                html.append("<td class='text-right'>\n");
                html.append("<div class='badge badge-outline-info' id='tong-cong'>").append(cong + 7000).append(" đồng</div>\n");
                html.append("</td>\n");
                html.append("</tr>\n");
                html.append("</table>\n");
                if (AuthorizePermission.getCurrentLoginUser(request).getEmail().equals(hoaDon.getEmailNguoiTao())) {
                    html.append("<input id='btn-thanh-toan' type='button' onclick='thanhToanGioHang(").append(hoaDon.getIdHoaDonNhom()).append(")' class='btn btn-primary btn-rounded' style='margin-top: 16px; width: 100%;' value='Thanh toán'>\n");
                }
            } else {
                html.append("<div class='alert-warning alert'>Giỏ hàng chưa có món ăn nào. Hãy chia sẻ link để mọi người cùng đặt món</div>");
            }
            html.append("</div>");

            response.getWriter().print(html.toString());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}