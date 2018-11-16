package quanlynhahang.controllers.thucdon;

import quanlynhahang.models.businessmodels.ThucDonMonAnService;
import quanlynhahang.models.datamodels.MonAn;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "XemChiTietThucDonServlet", urlPatterns = {"/admin/thuc-don-mon-an"})
public class XemChiTietThucDonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idThucDon = request.getParameter("idThucDon");
            if (idThucDon == null) {
                response.setStatus(400);
                return;
            }
            ThucDonMonAnService thucDonMonAnService = new ThucDonMonAnService();

            ArrayList<MonAn> monAns = thucDonMonAnService.getMonAns(Integer.parseInt(idThucDon));

            request.setAttribute("monAns", monAns);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-chi-tiet-thuc-don.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
