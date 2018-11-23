package quanlynhahang.controllers.thucdon;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.LoaiMonService;
import quanlynhahang.models.businessmodels.ThucDonService;
import quanlynhahang.models.datamodels.LoaiMon;
import quanlynhahang.models.datamodels.ThucDon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ThucDonServlet", urlPatterns = {"/admin/thuc-don"})
public class ThucDonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");

            ThucDonService thucDonService = new ThucDonService(DbAccess.getValue(request));
            ArrayList<ThucDon> thucDons = thucDonService.getData();
            request.setAttribute("thucDons", thucDons);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-thuc-don.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
