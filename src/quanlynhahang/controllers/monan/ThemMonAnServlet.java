package quanlynhahang.controllers.monan;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.LoaiMonService;
import quanlynhahang.models.businessmodels.MonAnService;
import quanlynhahang.models.businessmodels.ThucDonMonAnService;
import quanlynhahang.models.datamodels.LoaiMon;
import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.datamodels.ThucDon;
import quanlynhahang.models.datamodels.ThucDonMonAn;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ThemMonAnServlet", urlPatterns = {"/admin/them-mon-an"})
public class ThemMonAnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            MonAn monAn = new MonAn();
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
            monAn.setIdLoaiMon(Integer.parseInt(request.getParameter("cmbLoaiMon")));

            MonAnService monAnService = new MonAnService(DbAccess.getValue(request));
            monAnService.add(monAn);

        } catch (ParseException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/admin/mon-an");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MonAnService monAnService = new MonAnService(DbAccess.getValue(request));

        ArrayList<ThucDon> listThucDon = null;
        ArrayList<LoaiMon> listLoaiMon = null;
        try {
            listThucDon = monAnService.layToanBoThucDon();
            listLoaiMon = monAnService.layToanBoLoaiMon();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("listThucDon", listThucDon);
        request.setAttribute("listLoaiMon", listLoaiMon);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-them-mon-an.jsp");
        dispatcher.forward(request, response);
    }
}
