package quanlynhahang.controllers.thucdon;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.ThucDonService;
import quanlynhahang.models.datamodels.ThucDon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "ThemThucDonServlet", urlPatterns = {"/admin/them-thuc-don"})
public class ThemThucDonServlet extends HttpServlet implements ActionPermissionID {
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
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out1 = response.getWriter())  {
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
            ThucDon thucDon = new ThucDon();
            thucDon.setTenThucDon(request.getParameter("txtTenThucDon"));
            String moTa = request.getParameter("txtMoTa");
            thucDon.setMoTa(moTa);
            thucDon.setGia(Integer.parseInt(request.getParameter("txtGia")));
            thucDon.setPhanTramKhuyenMai(Integer.parseInt(request.getParameter("txtPhanTramKhuyenMai")));
            thucDon.setThu(Integer.parseInt(request.getParameter("cmbThu")));

//            // Hình

            Part filePart = request.getPart("filecover");

            String photo = "";
            String path = "F:\\BK11_12\\WebProjectV6\\web\\assests\\images\\thucdon";
            String path1 = "F:\\BK11_12\\WebProjectV6\\out\\artifacts\\WebProjectV6_war_exploded\\assests\\images\\thucdon";
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

                photo = "../assests/images/thucdon/" + fileName;
            }

//            // =========================================================

            thucDon.setHinhThucDon(photo);

            ThucDonService thucDonService = new ThucDonService(DbAccess.getValue(request));
            thucDonService.add(thucDon);
            response.sendRedirect("/admin/thuc-don");
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-them-thuc-don.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.THEM_THUC_DON;
    }
}
