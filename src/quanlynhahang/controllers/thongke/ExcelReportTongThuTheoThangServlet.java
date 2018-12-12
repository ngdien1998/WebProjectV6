package quanlynhahang.controllers.thongke;

import quanlynhahang.common.DbAccess;
import quanlynhahang.common.ExcelExport;
import quanlynhahang.models.businessmodels.ThongKeService;
import quanlynhahang.models.viewmodels.HoaDonReport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ExcelReportTongThuTheoThangServlet", urlPatterns = { "/admin/excel-report/doanh-thu-theo-thang" })
public class ExcelReportTongThuTheoThangServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");

            String thang = request.getParameter("thang");
            if (thang == null || thang.trim().isEmpty()) {
                response.sendError(400);
                return;
            }

            ThongKeService service = new ThongKeService(DbAccess.getValue(request));
            ArrayList<HoaDonReport> hoaDonReports = service.reportHoaDonExcel(Integer.parseInt(thang));

            ExcelExport.thongKeDoanhThuThang(hoaDonReports, "hoa-don-thang-" + thang);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.toString());
        }
    }
}