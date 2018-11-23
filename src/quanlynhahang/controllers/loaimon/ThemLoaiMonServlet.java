package quanlynhahang.controllers.loaimon;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.LoaiMonService;
import quanlynhahang.models.datamodels.LoaiMon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ThemLoaiMonServlet", urlPatterns = {"/admin/them-loai-mon"})
public class ThemLoaiMonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            LoaiMon loaiMon = new LoaiMon();
            loaiMon.setTenLoaiMon(request.getParameter("txtTenLoaiMon"));
            loaiMon.setMoTa(request.getParameter("txtMoTa"));
            LoaiMonService loaiMonService = new LoaiMonService(DbAccess.getValue(request));
            loaiMonService.add(loaiMon);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/admin/loai-mon");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-them-loai-mon.jsp");
        dispatcher.forward(request, response);
    }
}
