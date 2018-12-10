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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.SQLException;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "SuaThucDonServlet", urlPatterns = {"/admin/sua-thuc-don"})
public class SuaThucDonServlet extends HttpServlet implements ActionPermissionID {
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
        try(PrintWriter out1 = response.getWriter())  {
            if (!AuthorizePermission.islogined(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }
            ThucDon thucDon = new ThucDon();
            thucDon.setIdThucDon(Integer.parseInt(request.getParameter("txtIdThucDon")));
            thucDon.setTenThucDon(request.getParameter("txtTenThucDon"));
            thucDon.setMoTa(request.getParameter("txtMoTa"));
            thucDon.setGia(Integer.parseInt(request.getParameter("txtGia")));
            thucDon.setPhanTramKhuyenMai(Integer.parseInt(request.getParameter("txtPhanTramKhuyenMai")));
            thucDon.setThu(Integer.parseInt(request.getParameter("cmbThu")));

            //            // Hình

            Part filePart = request.getPart("filecover");

            String photo = "";
            if(filePart.getSize() == 0){
                photo = null;
            }
            else {
                String path = "F:\\WebProjectV6\\web\\assests\\images\\thucdon";
                String path1 = "F:\\WebProjectV6\\out\\artifacts\\WebProjectV6_war_exploded\\assests\\images\\thucdon";
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
            }

//            // =========================================================

            thucDon.setHinhThucDon(photo);

            ThucDonService thucDonService = new ThucDonService(DbAccess.getValue(request));
            thucDonService.modify(thucDon);

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
            String idThucDon = request.getParameter("idThucDon");
            if (idThucDon == null || idThucDon.trim().equals("")) {
                response.setStatus(400);
                return;
            }
            ThucDonService thucDonService = new ThucDonService(DbAccess.getValue(request));
            ThucDon thucDon = thucDonService.get(Integer.parseInt(idThucDon));
            if (thucDon == null) {
                response.setStatus(404);
                return;
            }

            request.setAttribute("thucDon", thucDon);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-sua-thuc-don.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.SUA_THUC_DON;
    }
}
