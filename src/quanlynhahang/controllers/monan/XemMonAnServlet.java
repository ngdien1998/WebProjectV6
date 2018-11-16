package quanlynhahang.controllers.monan;

import quanlynhahang.models.businessmodels.LoaiMonService;
import quanlynhahang.models.businessmodels.MonAnService;
import quanlynhahang.models.businessmodels.ThucDonMonAnService;
import quanlynhahang.models.businessmodels.ThucDonService;
import quanlynhahang.models.datamodels.LoaiMon;
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

@WebServlet(name = "XemMonAnServlet", urlPatterns = {"/admin/xem-mon-an"})
public class XemMonAnServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idMonAn = request.getParameter("idMonAn");
            if (idMonAn == null) {
                response.setStatus(400);
                return;
            }
            MonAnService monAnService = new MonAnService();
            MonAn monAn = null;
            monAn = monAnService.get(idMonAn);

            if (monAn == null) {
                response.setStatus(404);
                return;
            }

            // Check trên thực đơn, tên loại món theo ID ở đây sau đó gửi lại
            int idLoaiMon = monAn.getIdLoaiMon();
            LoaiMonService loaiMonService = new LoaiMonService();
            LoaiMon loaiMon = null;
            loaiMon = loaiMonService.get(idLoaiMon);
            ThucDonMonAnService thucDonMonAnService = new ThucDonMonAnService();


            request.setAttribute("monAn", monAn);
            request.setAttribute("loaiMon",loaiMon);
//            request.setAttribute("thucDon", thucDon);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xem-mon-an.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
