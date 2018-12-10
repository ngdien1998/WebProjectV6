package quanlynhahang.controllers.monan;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnService;

import quanlynhahang.models.datamodels.LoaiMon;
import quanlynhahang.models.datamodels.MonAn;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "SuaMonAnServlet", urlPatterns = {"/admin/sua-mon-an"})
public class SuaMonAnServlet extends HttpServlet implements ActionPermissionID {
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

            MonAn monAn = new MonAn();
            monAn.setIdMonAn(Integer.parseInt(request.getParameter("txtIdMonAn")));
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
            monAn.setIdLoaiMon(Integer.parseInt(request.getParameter("cmbIdLoaiMon")));
            //            // Hình

            Part filePart = request.getPart("filecover");
            String photo = "";

            if(filePart.getSize() == 0){
                photo = null;
            }
            else {
                String path = "F:\\WebProjectV6\\web\\assests\\images\\monan";
                String path1 = "F:\\WebProjectV6\\out\\artifacts\\WebProjectV6_war_exploded\\assests\\images\\monan";
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
            }

//            // =========================================================

            monAn.setHinhMonAn(photo);

            MonAnService monAnService = new MonAnService(DbAccess.getValue(request));
            monAnService.modify(monAn);
            response.sendRedirect("/admin/mon-an");
        } catch (SQLException | ClassNotFoundException | ParseException e) {
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
