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

@WebServlet(name = "LayMonAnTheoGiaServlet", urlPatterns = {"/loc-mon-an-theo-gia"})
public class LayMonAnTheoGiaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gia_min = request.getParameter("gia-min");
        String gia_max = request.getParameter("gia-max");
        UserTatCaMonAnService userTatCaMonAnService = new UserTatCaMonAnService(DbAccess.getValue(request));
        try {
            ArrayList<MonAn> monAnTheoGia = userTatCaMonAnService.LayMonAnTheoGia(gia_min, gia_max);
            request.setAttribute("monAns", monAnTheoGia);
            request.setAttribute("soLuong", monAnTheoGia.size());

            ArrayList<MonAn> baMonAnMoiNhat = userTatCaMonAnService.LayBaMonAnMoiNhat();
            request.setAttribute("baMonAnMoiNhat", baMonAnMoiNhat);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/tat-ca-mon-an.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
