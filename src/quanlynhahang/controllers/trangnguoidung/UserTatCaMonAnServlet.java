package quanlynhahang.controllers.trangnguoidung;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.UserTatCaMonAnService;
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

@WebServlet(name = "UserTatCaMonAnServlet", urlPatterns = {"/tat-ca-mon-an"})
public class UserTatCaMonAnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserTatCaMonAnService userTatCaMonAnService = new UserTatCaMonAnService(DbAccess.getValue(request));
        try {
            ArrayList<MonAn> monAns = userTatCaMonAnService.getData();

            ArrayList<MonAn> baMonAnMoiNhat = userTatCaMonAnService.LayBaMonAnMoiNhat();

            request.setAttribute("monAns", monAns);
            request.setAttribute("soLuong", monAns.size());
            request.setAttribute("baMonAnMoiNhat", baMonAnMoiNhat);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/tat-ca-mon-an.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
