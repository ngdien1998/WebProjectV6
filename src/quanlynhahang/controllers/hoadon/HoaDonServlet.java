package quanlynhahang.controllers.hoadon;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.HoaDonService;
import quanlynhahang.models.datamodels.HoaDon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "HoaDonServlet" ,urlPatterns = {"/admin/hoa-don"})
public class HoaDonServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HoaDonService hoaDonService=new HoaDonService(DbAccess.getValue(request));
        ArrayList<HoaDon> hoaDons=hoaDonService.getData();
        request.setAttribute("hoaDons",hoaDons);
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/admin-quan-ly-hoa-don.jsp");
        dispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
