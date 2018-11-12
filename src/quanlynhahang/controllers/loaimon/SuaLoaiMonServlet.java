package quanlynhahang.controllers.loaimon;

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

@WebServlet(name = "SuaLoaiMonServlet", urlPatterns = {"/admin/sua-loai-mon"})
public class SuaLoaiMonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");

            String idLoaiMon = request.getParameter("txtIdLoaiMon");
            String tenLoaiMon = request.getParameter("txtTenLoaiMon");
            String moTa = request.getParameter("txtMoTa");
            if (idLoaiMon == null) {
                response.setStatus(400);
                return;
            }

            LoaiMon loaiMon = new LoaiMon();
            loaiMon.setIdLoaiMon(Integer.parseInt(idLoaiMon));
            loaiMon.setTenLoaiMon(tenLoaiMon);
            loaiMon.setMoTa(moTa);

            LoaiMonService loaiMonService = new LoaiMonService();
            loaiMonService.modify(loaiMon);
            response.sendRedirect("/admin/loai-mon");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idLoaiMon = request.getParameter("idLoaiMon");
            if (idLoaiMon == null) {
                response.setStatus(400);
                return;
            }

            LoaiMonService loaiMonService = new LoaiMonService();
            LoaiMon loaiMon = null;
            loaiMon = loaiMonService.get(idLoaiMon);
            if (loaiMon == null) {
                response.setStatus(404);
                return;
            }
            request.setAttribute("loaiMon", loaiMon);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-sua-loai-mon.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
