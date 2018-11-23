package quanlynhahang.controllers.loaimon;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.LoaiBaiVietService;
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

@WebServlet(name = "XoaLoaiMonServlet", urlPatterns = {"/admin/xoa-loai-mon"})
public class XoaLoaiMonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String id = request.getParameter("txtIdLoaiMon");
            if (id == null || id.trim().equals("")) {
                response.setStatus(400);
                return;
            }

            LoaiMonService service = new LoaiMonService(DbAccess.getValue(request));
            service.delete(Integer.parseInt(id));

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

            LoaiMonService loaiMonService = new LoaiMonService(DbAccess.getValue(request));
            LoaiMon loaiMon = null;
            loaiMon = loaiMonService.get(idLoaiMon);
            if (loaiMon == null) {
                response.setStatus(404);
                return;
            }
            request.setAttribute("loaiMon", loaiMon);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xoa-loai-mon.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
