package quanlynhahang.controllers.trangnguoidung;

import javafx.util.converter.DateTimeStringConverter;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.DatBanService;
import quanlynhahang.models.datamodels.DatBan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "UserDatBanServlet", urlPatterns = {"/dat-ban"})
public class UserDatBanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            DatBan datBan=new DatBan();
            datBan.setEmail(request.getParameter("txtEmail"));
            datBan.setThoiGian(request.getParameter("txtTime"));
            java.sql.Date ngay = null;
            if (request.getParameter("txtDate") != null) {
                Date temp = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("txtDate"));
                ngay = new java.sql.Date(temp.getTime());
            }
            datBan.setNgay(ngay);
            datBan.setSoLuong(Integer.parseInt(request.getParameter("txtSoNguoi")));
            datBan.setGhiChu(request.getParameter("txtGhiChu"));
            datBan.setHoTen(request.getParameter("txtHoTen"));
            datBan.setSoDT(request.getParameter("txtSDT"));
            //datBan.setThoiGian(thoiGian);

            DatBanService datBanService= new DatBanService(DbAccess.getValue(request));
            datBanService.add(datBan) ;
            response.sendRedirect("/admin/dat-ban");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dat-ban.jsp");
        dispatcher.forward(request, response);
    }
}
