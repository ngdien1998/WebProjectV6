package quanlynhahang.controllers.dangky;

import quanlynhahang.common.Consts;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.NguoiDungService;
import quanlynhahang.models.businessmodels.UserDangKyService;
import quanlynhahang.models.datamodels.NguoiDung;
import quanlynhahang.models.viewmodels.UserDbConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DangKyServlet", urlPatterns = {"/dang-ky"})
public class DangKyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("txtEmail");
            String matKhau = request.getParameter("txtMatKhau");
            UserDangKyService service = new UserDangKyService(DbAccess.getValue(request));
            int checkExisted = service.checkExist(email);
            if(checkExisted == 0){
                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.setEmail(email);
                nguoiDung.setMatKhau(matKhau);
                nguoiDung.setQuanTriVien(false);
                nguoiDung.setKichHoat(true);
                nguoiDung.setChoPhep(true);

                // Chưa xong
                service.add(nguoiDung);
//
//                HttpSession session = request.getSession();
//                session.setAttribute("nguoiDungHienTai", nguoiDung);
                response.sendRedirect("/trang-chu");
            }
            else {
                response.sendError(404);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dang-ky.jsp");
        dispatcher.forward(request, response);
    }
}
