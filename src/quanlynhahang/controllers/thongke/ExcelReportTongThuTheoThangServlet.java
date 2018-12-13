package quanlynhahang.controllers.thongke;

import com.google.gson.JsonObject;
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
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            String thang = request.getParameter("thang");
            if (thang == null || thang.trim().isEmpty()) {
                response.sendError(400);
                return;
            }

            ThongKeService service = new ThongKeService(DbAccess.getValue(request));
            ArrayList<HoaDonReport> hoaDonReports = service.reportHoaDonToExcel(Integer.parseInt(thang));
            JsonObject result = new JsonObject();
            if (hoaDonReports.size() <= 0) {
                result.addProperty("res", "null");
            } else {
                ExcelExport report = new ExcelExport();
                String fileName = report.thongKeDoanhThuThang(hoaDonReports, "hoa-don-thang-" + thang, "Hóa đơn tháng " + thang);
                result.addProperty("res", fileName);
            }
            response.getWriter().print(result);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.toString());
        }
    }
}