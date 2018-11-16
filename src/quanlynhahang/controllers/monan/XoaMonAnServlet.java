package quanlynhahang.controllers.monan;

import quanlynhahang.models.businessmodels.LoaiMonService;
import quanlynhahang.models.businessmodels.MonAnService;
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

@WebServlet(name = "XoaMonAnServlet", urlPatterns = {"/admin/xoa-mon-an"})
public class XoaMonAnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String id = request.getParameter("txtIdMonAn");
            if (id == null || id.trim().equals("")) {
                response.setStatus(400);
                return;
            }

            MonAnService monAnService = new MonAnService();

            monAnService.delete(Integer.parseInt(id));
            //Check xem có xóa được ko
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/admin/mon-an");
    }

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

            // Check tên thực đơn, tên loại món theo ID ở đây sau đó gửi lại
            int idLoaiMon = monAn.getIdLoaiMon();
//            int idThucDon = monAn.getIdThucDon();
            LoaiMonService loaiMonService = new LoaiMonService();
            LoaiMon loaiMon = null;
            loaiMon = loaiMonService.get(idLoaiMon);
            ThucDonService thucDonService = new ThucDonService();
            ThucDon thucDon = null;
//            thucDon = thucDonService.get(idThucDon);

            request.setAttribute("monAn", monAn);
            request.setAttribute("loaiMon", loaiMon);
//            request.setAttribute("thucDon", thucDon);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xoa-mon-an.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
