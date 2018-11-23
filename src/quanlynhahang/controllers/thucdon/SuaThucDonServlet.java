package quanlynhahang.controllers.thucdon;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.ThucDonService;
import quanlynhahang.models.datamodels.ThucDon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SuaThucDonServlet", urlPatterns = {"/admin/sua-thuc-don"})
public class SuaThucDonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            ThucDon thucDon = new ThucDon();
            thucDon.setIdThucDon(Integer.parseInt(request.getParameter("txtIdThucDon")));
            thucDon.setTenThucDon(request.getParameter("txtTenThucDon"));
            thucDon.setMoTa(request.getParameter("txtMoTa"));
            thucDon.setGia(Integer.parseInt(request.getParameter("txtGia")));
            thucDon.setPhanTramKhuyenMai(Integer.parseInt(request.getParameter("txtPhanTramKhuyenMai")));
            thucDon.setThu(Integer.parseInt(request.getParameter("cmbThu")));

            ThucDonService thucDonService = new ThucDonService(DbAccess.getValue(request));
            thucDonService.modify(thucDon);

            response.sendRedirect("/admin/thuc-don");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idThucDon = request.getParameter("idThucDon");
            if (idThucDon == null || idThucDon.trim().equals("")) {
                response.setStatus(400);
                return;
            }
            ThucDonService thucDonService = new ThucDonService(DbAccess.getValue(request));
            ThucDon thucDon = thucDonService.get(Integer.parseInt(idThucDon));
            if (thucDon == null) {
                response.setStatus(404);
                return;
            }

            request.setAttribute("thucDon", thucDon);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-sua-thuc-don.jsp");
        dispatcher.forward(request, response);
    }
}
