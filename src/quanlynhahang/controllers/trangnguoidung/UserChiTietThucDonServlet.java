package quanlynhahang.controllers.trangnguoidung;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.ThucDonService;
import quanlynhahang.models.businessmodels.UserChiTietMonAnService;
import quanlynhahang.models.businessmodels.UserChiTietThucDonService;
import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.datamodels.ThucDon;
import quanlynhahang.models.viewmodels.UserDbConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "UserChiTietThucDonServlet", urlPatterns = {"/chi-tiet-thuc-don"})
public class UserChiTietThucDonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String idThucDon = request.getParameter("idThucDon");
        UserChiTietThucDonService userChiTietThucDonService = new UserChiTietThucDonService(DbAccess.getValue(request));

        try {
            ThucDonService thucDonService = new ThucDonService(DbAccess.getValue(request));
            ThucDon thucDon = thucDonService.get(idThucDon);
            request.setAttribute("thucDon", thucDon);

            // Tất cả món ăn của thưc đơn
            ArrayList<MonAn> monAns = userChiTietThucDonService.getAllMonAnCuaThucDon(Integer.parseInt(idThucDon));
            request.setAttribute("monAns", monAns);

            request.setAttribute("soLuong", monAns.size());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/chi-tiet-thuc-don.jsp");
        dispatcher.forward(request, response);
    }
}
