package quanlynhahang.controllers.loaimon;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
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

@WebServlet(name = "SuaLoaiMonServlet", urlPatterns = {"/admin/sua-loai-mon"})
public class SuaLoaiMonServlet extends HttpServlet implements ActionPermissionID{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (!AuthorizePermission.islogined(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }
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

            LoaiMonService loaiMonService = new LoaiMonService(DbAccess.getValue(request));
            loaiMonService.modify(loaiMon);
            response.sendRedirect("/admin/loai-mon");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (!AuthorizePermission.islogined(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }

            String idLoaiMon = request.getParameter("idLoaiMon");
            if (idLoaiMon == null || idLoaiMon.trim().equals("")) {
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

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-sua-loai-mon.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.SUA_LOAI_MON;
    }
}
