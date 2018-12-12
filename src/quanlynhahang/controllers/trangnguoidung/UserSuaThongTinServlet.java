package quanlynhahang.controllers.trangnguoidung;

import quanlynhahang.common.Consts;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.NguoiDungService;
import quanlynhahang.models.datamodels.NguoiDung;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "UserSuaThongTinServlet", urlPatterns = {"/sua-thong-tin-ca-nhan"})
public class UserSuaThongTinServlet extends HttpServlet {
    private String getFileName(final Part part) {

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
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.setEmail(request.getParameter("txtEmail"));
            nguoiDung.setHoDem(request.getParameter("txtHoDem"));
            nguoiDung.setTen(request.getParameter("txtTen"));
            int gioiTinh = Integer.parseInt(request.getParameter("slGioiTinh"));
            boolean setNu;
            setNu = gioiTinh != 0;
            nguoiDung.setNu(setNu);
            if (request.getParameter("dteNgaySinh") != null) {
                Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dteNgaySinh"));
                nguoiDung.setNgaySinh(new java.sql.Date(ngaySinh.getTime()));
            }
            nguoiDung.setDienThoai(request.getParameter("txtDienThoai"));
            nguoiDung.setDiaChi(request.getParameter("txtDiaChi"));

            // Hình
            Part filePart = request.getPart("filecover");

            String photo = "";
            String path = "E:\\JSP Servlet\\WebProjectV6\\web\\assests\\images\\nguoidung";
            String path1 = "E:\\JSP Servlet\\WebProjectV6\\out\\artifacts\\WebProjectV6_war_exploded\\assests\\images\\nguoidung";
            File file = new File(path);
            File file1 = new File(path1);
            file.mkdir();
            file1.mkdir();
            String fileName = getFileName(filePart);

            OutputStream out;
            OutputStream out0;

            InputStream filecontent;

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

                photo = "../assests/images/nguoidung/" + fileName;
            }
            nguoiDung.setAvatar(photo);

            NguoiDungService service = new NguoiDungService(DbAccess.getValue(request));
            service.suaThongTinCaNhan(nguoiDung);

        } catch (ParseException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/trang-chu");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = ((NguoiDung) session.getAttribute(Consts.WEBSITE_LOGIN)).getEmail();
        NguoiDungService nguoiDungService = new NguoiDungService(DbAccess.getValue(request));
        try {
            NguoiDung nguoiDung = nguoiDungService.get(email);
            request.setAttribute("nguoiDung", nguoiDung);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/sua-thong-tin-ca-nhan.jsp");
        dispatcher.forward(request,response);
    }
}
