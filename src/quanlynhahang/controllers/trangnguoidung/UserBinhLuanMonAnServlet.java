package quanlynhahang.controllers.trangnguoidung;

import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.Consts;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.UserBinhLuanService;
import quanlynhahang.models.datamodels.NguoiDung;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserBinhLuanMonAnServlet", urlPatterns = {"/binh-luan-nguoi-dung"})
public class UserBinhLuanMonAnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        if (!AuthorizePermission.islogined(request)) {
            response.sendRedirect("/dang-nhap");
            return;
        }
        try {
            String idMonAn = request.getParameter("txtIdMonAn");
            String noiDung = request.getParameter("comment");
            HttpSession session = request.getSession();
            NguoiDung nguoiDung = (NguoiDung) session.getAttribute(Consts.WEBSITE_LOGIN);
            String email = nguoiDung.getEmail();

            UserBinhLuanService userBinhLuanService = new UserBinhLuanService(DbAccess.getValue(request));

            userBinhLuanService.addBinhLuanMonAn(idMonAn, noiDung, email);

            response.sendRedirect("/chi-tiet-mon-an?idMonAn="+idMonAn+"");
        } catch (SQLException | ClassNotFoundException  e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
