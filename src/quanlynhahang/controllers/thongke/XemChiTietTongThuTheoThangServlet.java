package quanlynhahang.controllers.thongke;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.ThongKeService;
import quanlynhahang.models.datamodels.ThongKeTongThu;
import quanlynhahang.models.datamodels.ThongKeTongThuChiTiet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "XemChiTietTongThuTheoThangServlet", urlPatterns = {"/admin/chi-tiet-tong-thu-theo-thang"})
public class XemChiTietTongThuTheoThangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String thang = request.getParameter("thang");
        ThongKeService thongKeService = new ThongKeService(DbAccess.getValue(request));

        try {
            ArrayList<ThongKeTongThu> thongKeTongThus = thongKeService.thongKeTongThuTungNgayTrongThang();
            request.setAttribute("thongKeTongThu", thongKeTongThus);

            ArrayList<ThongKeTongThu> thongKeTongThusThangNay = thongKeService.thongKeTongThuTungNgayTrongThangNay();
            request.setAttribute("thongKeTongThuThangnay", thongKeTongThusThangNay);

            ArrayList<ThongKeTongThu> thongKeTongThus1 = thongKeService.thongKeTongThuTungThang();
            request.setAttribute("thongKeTongThuTungThang", thongKeTongThus1);

            ArrayList<ThongKeTongThuChiTiet> thongKeTongThuChiTiets = thongKeService.thongKeTongThuChiTietTungThang(Integer.parseInt(thang));
            request.setAttribute("thongKeTongThuChiTietTungThang", thongKeTongThuChiTiets);

            request.setAttribute("thang", thang);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-thong-ke-tong-thu.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
