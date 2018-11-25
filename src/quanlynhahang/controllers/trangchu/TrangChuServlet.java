package quanlynhahang.controllers.trangchu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TrangChuServlet", urlPatterns = { "/trang-chu" })
public class TrangChuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.sendError(500);
//        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/trang-chu.jsp");
        dispatcher.forward(request, response);
    }
}
