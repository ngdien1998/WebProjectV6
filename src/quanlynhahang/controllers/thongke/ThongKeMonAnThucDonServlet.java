package quanlynhahang.controllers.thongke;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.ThongKeService;
import quanlynhahang.models.datamodels.ThongKeMonAn;
import quanlynhahang.models.datamodels.ThongKeThucDon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ThongKeMonAnThucDonServlet", urlPatterns = {"/admin/mon-an-thuc-don"})
public class ThongKeMonAnThucDonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        ThongKeService thongKeService = new ThongKeService(DbAccess.getValue(request));
        try {
            ArrayList<ThongKeMonAn> thongKeMonAns = thongKeService.top10MonAnBanChay();
            request.setAttribute("thongKeMonAns", thongKeMonAns);

            ArrayList<ThongKeThucDon> thongKeThucDons = thongKeService.thongKeSuDungThucDon();
            request.setAttribute("thongKeThucDon", thongKeThucDons);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-thong-ke-mon-an-thuc-don.jsp");
        dispatcher.forward(request, response);

    }
}
