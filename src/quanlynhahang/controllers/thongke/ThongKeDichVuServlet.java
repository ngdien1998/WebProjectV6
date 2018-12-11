package quanlynhahang.controllers.thongke;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.ThongKeService;
import quanlynhahang.models.datamodels.ThongKeBinhLuanBieuDo;
import quanlynhahang.models.datamodels.ThongKeDatBanBieuDo;
import quanlynhahang.models.datamodels.ThongKeDatBanChiTiet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ThongKeDichVuServlet", urlPatterns = {"/admin/thong-ke-dich-vu"})
public class ThongKeDichVuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        ThongKeService thongKeService = new ThongKeService(DbAccess.getValue(request));
        try {
            ArrayList<ThongKeDatBanChiTiet> thongKeDatBans = thongKeService.thongKeDatBanChiTiet();
            request.setAttribute("thongKeDatBan", thongKeDatBans);

            ArrayList<ThongKeDatBanBieuDo> thongKeDatBansBieuDo = thongKeService.thongKeDatBanBieuDo();
            request.setAttribute("thongKeDatBanBieuDo", thongKeDatBansBieuDo);

            ArrayList<ThongKeBinhLuanBieuDo> thongKeBinhLuanBieuDos = thongKeService.thongKeBinhLuanBieuDo();
            request.setAttribute("thongKeBinhLuanBieuDo", thongKeBinhLuanBieuDos);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-thong-ke-dich-vu.jsp");
        dispatcher.forward(request,response);
    }
}
