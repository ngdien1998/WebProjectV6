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
import java.util.ArrayList;

@WebServlet(name = "LoaiMonServlet", urlPatterns = {"/admin/loai-mon"})
public class LoaiMonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");

            LoaiMonService loaiMonService = new LoaiMonService(DbAccess.getValue(request));
            ArrayList<LoaiMon> loaiMons = loaiMonService.getData();
            request.setAttribute("loaiMons", loaiMons);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-loai-mon.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
