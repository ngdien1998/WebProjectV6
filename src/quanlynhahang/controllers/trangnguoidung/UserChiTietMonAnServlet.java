package quanlynhahang.controllers.trangnguoidung;

import quanlynhahang.common.Consts;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.BinhLuanService;
import quanlynhahang.models.businessmodels.NguoiDungService;
import quanlynhahang.models.businessmodels.UserChiTietMonAnService;
import quanlynhahang.models.businessmodels.UserTrangChuService;
import quanlynhahang.models.datamodels.BinhLuan;
import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.datamodels.NguoiDung;

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

@WebServlet(name = "UserChiTietMonAnServlet", urlPatterns = {"/chi-tiet-mon-an"})
public class UserChiTietMonAnServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idMonAn = request.getParameter("idMonAn");
        UserChiTietMonAnService userChiTietMonAnService = new UserChiTietMonAnService(DbAccess.getValue(request));
        UserTrangChuService userTrangChuService = new UserTrangChuService(DbAccess.getValue(request));
        try {
            MonAn monAn = userChiTietMonAnService.get(idMonAn);
            request.setAttribute("monAn", monAn);

            BinhLuanService binhLuanService = new BinhLuanService(DbAccess.getValue(request));
            ArrayList<BinhLuan> binhLuans = binhLuanService.getBinhLuanMonAn(Integer.parseInt(idMonAn));
            request.setAttribute("binhLuans", binhLuans);

            ArrayList<MonAn> listMonAn = userTrangChuService.getBonMonAnMoiNhat();
            request.setAttribute("listMonAn", listMonAn);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/chi-tiet-mon-an.jsp");
        dispatcher.forward(request, response);
    }
}
