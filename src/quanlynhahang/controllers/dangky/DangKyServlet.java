package quanlynhahang.controllers.dangky;

import quanlynhahang.common.Consts;
import quanlynhahang.common.DbAccess;
import quanlynhahang.common.Mailer;
import quanlynhahang.models.businessmodels.UserDangKyService;
import quanlynhahang.models.datamodels.NguoiDung;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "DangKyServlet", urlPatterns = {"/dang-ky"})
public class DangKyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("txtEmail");
            String matKhau = request.getParameter("txtMatKhau");
            UserDangKyService service = new UserDangKyService(DbAccess.getValue(request));
            int checkExisted = service.checkExist(email);
            if (checkExisted == 0) {
                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.setEmail(email);
                nguoiDung.setMatKhau(matKhau);
                nguoiDung.setQuanTriVien(false);
                nguoiDung.setKichHoat(true);
                nguoiDung.setChoPhep(true);

                service.add(nguoiDung);

                HttpSession session = request.getSession();
                session.setAttribute(Consts.EMAIL, email);

                Random rd = new Random();
                String code = String.valueOf(rd.nextInt(9999 - 1000 + 1) + 1000);
                session.setAttribute(Consts.SAVED_CODE, code);
                String subject = "Mã xác nhận đăng ký tài khoản mới";
                Thread sendingEmail = new Thread(() -> Mailer.sendEmail(email, subject, code));
                sendingEmail.start();
                response.sendRedirect("/xac-nhan-dang-ky");
                return;
            }
            request.setAttribute(Consts.MESSAGE, "Email đã được sử dụng, hảy sử dụng email khác");
            doGet(request, response);
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
