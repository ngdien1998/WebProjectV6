package quanlynhahang.controllers.monan;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "ThemMonAnServlet", urlPatterns = {"/admin/them-mon-an"})
public class ThemMonAnServlet extends HttpServlet implements ActionPermissionID {
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            if (!AuthorizePermission.islogined(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }
            MonAn monAn = new MonAn();
            monAn.setTenMonAn(request.getParameter("txtTenMonAn"));
            monAn.setDonViTinh(request.getParameter("txtDonViTinh"));
            monAn.setMoTa(request.getParameter("txtMoTa"));
            monAn.setMoTaChiTiet(request.getParameter("txtMoTaChiTiet"));
            monAn.setGia(Integer.parseInt(request.getParameter("txtGia")));
            monAn.setKhuyenMai(Integer.parseInt(request.getParameter("txtKhuyenMai")));
            java.sql.Date ngayThem = null;
            if (request.getParameter("dteNgayThem") != null) {
                Date temp = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dteNgayThem"));
                ngayThem = new java.sql.Date(temp.getTime());
            }
            monAn.setNgayThem(ngayThem);
            monAn.setIdLoaiMon(Integer.parseInt(request.getParameter("cmbLoaiMon")));

            // Hình

            Part filePart = request.getPart("filecover");

            String photo = "";
            String path = "C:\\Users\\Windows 10\\Desktop\\WebProjectV6\\web\\assests\\images\\monan";
            String path1 = "C:\\Users\\Windows 10\\Desktop\\WebProjectV6\\out\\artifacts\\WebProjectV6_war_exploded\\assests\\images\\monan";
            File file = new File(path);
            File file1 = new File(path1);
            file.mkdir();
            file1.mkdir();
            String fileName = getFileName(filePart);

            OutputStream out = null;
            OutputStream out0 = null;

            InputStream filecontent = null;

            PrintWriter writer = response.getWriter();
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            out0 = new FileOutputStream(new File(path1 + File.separator
                    + fileName));

            filecontent = filePart.getInputStream();


            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
                out0.write(bytes, 0, read);

                photo = "../assests/images/monan/" + fileName;
            }


            // =========================================================
            monAn.setHinhMonAn(photo);


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
            if (!AuthorizePermission.islogined(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }
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

    @Override
    public int getPermissionId() {
        return AuthorizePermission.THEM_MON_AN;
    }
}
