package quanlynhahang.controllers.thongke;

import com.google.gson.JsonObject;
import quanlynhahang.common.DbAccess;
import quanlynhahang.common.ExcelExport;
import quanlynhahang.models.businessmodels.ThongKeService;
import quanlynhahang.models.datamodels.DatBan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ExcelReportDatbanServlet", urlPatterns = {"/admin/excel-report/dat-ban"})
public class ExcelReportDatbanServlet extends HttpServlet {
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
            ArrayList<DatBan> datBans = service.reportDatBanToExcel(Integer.parseInt(thang));
            JsonObject result = new JsonObject();
            if (datBans.size() <= 0) {
                result.addProperty("res", "null");
            } else {
                String fileName = "thong-ke-dat-ban-thang-" + thang;
                ExcelExport report = new ExcelExport();
                fileName = report.thongKeDatBanTheoThang(datBans, fileName, "Thống kê đặt bàn tháng " + thang);
                result.addProperty("res", fileName);
            }
            response.getWriter().print(result);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
