package quanlynhahang.controllers.trangnguoidung;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.UserTrangChuService;
import quanlynhahang.models.datamodels.BaiViet;
import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.datamodels.ThucDon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "TrangChuServlet", urlPatterns = { "/trang-chu" })
public class TrangChuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            UserTrangChuService trangChuService = new UserTrangChuService(DbAccess.getValue(request));
            ArrayList<MonAn> monAns = trangChuService.getBonMonAnMoiNhat();
            ArrayList<ThucDon> thucDons = trangChuService.getBonThucDonMoiNhat();
            ArrayList<BaiViet> baiViets = trangChuService.getBonBaiVietMoiNhat();

            request.setAttribute("monAns", monAns);
            request.setAttribute("thucDons", thucDons);
            request.setAttribute("baiViets", baiViets);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.toString());
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/trang-chu.jsp");
        dispatcher.forward(request, response);
    }
}
