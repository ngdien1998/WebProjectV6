package quanlynhahang.controllers.trangnguoidung;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.ThucDonService;
import quanlynhahang.models.businessmodels.UserThucDonService;
import quanlynhahang.models.datamodels.MonAn;
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

@WebServlet(name = "UserThucDonServlet", urlPatterns = {"/thuc-don"})
public class UserThucDonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            UserThucDonService thucDonUserService = new UserThucDonService(DbAccess.getValue(request));
            ArrayList<ThucDon> thucDons = thucDonUserService.getBonThucDonHot();
            request.setAttribute("thucDons", thucDons);

            ThucDonService thucDonService = new ThucDonService(DbAccess.getValue(request));

            //Thực đơn sáng
            ThucDon thucDon0 = thucDonService.get(3);
            request.setAttribute("infoThucDonSang", thucDon0);
            ArrayList<MonAn> monAns0 = thucDonUserService.layBonMonAnCuaThucDonSang();
            request.setAttribute("bonMonAnThucDonSang", monAns0);

            // THực đơn trưa
            ThucDon thucDon = thucDonService.get(4);
            request.setAttribute("infoThucDonTrua", thucDon);
            ArrayList<MonAn> monAns = thucDonUserService.layBonMonAnCuaThucDonTrua();
            request.setAttribute("bonMonAnThucDonTrua", monAns);


            // Thực đơn tối
            ThucDon thucDon1 = thucDonService.get(6);
            request.setAttribute("infoThucDonToi", thucDon1);
            ArrayList<MonAn> monAns1 = thucDonUserService.layBonMonAnCuaThucDonToi();
            request.setAttribute("bonMonAnThucDonToi", monAns1);

            ArrayList<ThucDon> tatCaThucDons = thucDonUserService.getTatCaThucDon();
            request.setAttribute("tatCaThucDons", tatCaThucDons);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/thuc-don.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
