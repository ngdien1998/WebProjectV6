package quanlynhahang.controllers.monan;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.ThucDonMonAnService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "XoaMonAnKhoiThucDonServlet", urlPatterns = {"/admin/xoa-mon-an-khoi-thuc-don"})
public class XoaMonAnKhoiThucDonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idThucDon = request.getParameter("idThucDon");
        String idMonAn = request.getParameter("idMonAn");

        ThucDonMonAnService thucDonMonAnService = new ThucDonMonAnService(DbAccess.getValue(request));
        try {
            thucDonMonAnService.xoaThucDonMonAn(idMonAn, idThucDon);
            response.sendRedirect("/admin/thuc-don");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
