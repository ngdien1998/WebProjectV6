package quanlynhahang.controllers.dangxuat;

import quanlynhahang.common.Consts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DangXuatServlet", urlPatterns = {"/dang-xuat"})
public class DangXuatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute(Consts.USER_DB_CONNECT);
        session.removeAttribute(Consts.WEBSITE_LOGIN);

        response.sendRedirect("/trang-chu");
    }
}

