package quanlynhahang.controllers.monan;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnService;

import quanlynhahang.models.datamodels.LoaiMon;
import quanlynhahang.models.datamodels.MonAn;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "SuaMonAnServlet", urlPatterns = {"/admin/sua-mon-an"})
public class SuaMonAnServlet extends HttpServlet implements ActionPermissionID {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (!AuthorizePermission.islogin(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");

            MonAn monAn = new MonAn();
            monAn.setIdMonAn(Integer.parseInt(request.getParameter("txtIdMonAn")));
            monAn.setTenMonAn(request.getParameter("txtTenMonAn"));
            monAn.setDonViTinh(request.getParameter("txtDonViTinh"));
            monAn.setMoTa(request.getParameter("txtMoTa"));
            monAn.setGia(Integer.parseInt(request.getParameter("txtGia")));
            monAn.setKhuyenMai(Integer.parseInt(request.getParameter("txtKhuyenMai")));
            java.sql.Date ngayThem = null;
            if (request.getParameter("dteNgayThem") != null) {
                Date temp = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dteNgayThem"));
                ngayThem = new java.sql.Date(temp.getTime());
            }
            monAn.setNgayThem(ngayThem);
            monAn.setIdLoaiMon(Integer.parseInt(request.getParameter("cmbIdLoaiMon")));
//            monAn.setIdThucDon(Integer.parseInt(request.getParameter("cmdIdThucDon")));

            MonAnService monAnService = new MonAnService(DbAccess.getValue(request));
            monAnService.modify(monAn);
            response.sendRedirect("/admin/mon-an");
        } catch (SQLException | ClassNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (!AuthorizePermission.islogin(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }
            String idMonAn = request.getParameter("idMonAn");
            if (idMonAn == null) {
                response.setStatus(400);
                return;
            }

            MonAnService monAnService = new MonAnService(DbAccess.getValue(request));

//            ArrayList<ThucDon> listThucDon = null;
            ArrayList<LoaiMon> listLoaiMon = null;
            MonAn monAn = null;
            monAn = monAnService.get(idMonAn);
            if (monAn == null) {
                response.setStatus(404);
                return;
            }

//            listThucDon = monAnService.layToanBoThucDon();
            listLoaiMon = monAnService.layToanBoLoaiMon();

//            request.setAttribute("listThucDon", listThucDon);
            request.setAttribute("listLoaiMon", listLoaiMon);
            request.setAttribute("monAn", monAn);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-sua-mon-an.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.SUA_MON_AN;
    }
}
