package quanlynhahang.controllers.trangnguoidung;

import quanlynhahang.common.Consts;
import quanlynhahang.models.datamodels.MonAn;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GioHangServlet", urlPatterns = { "/gio-hang" })
public class GioHangServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Object objSession = session.getAttribute(Consts.GIO_HANG);
            String idMonAn = request.getParameter("txtIdMon");
            if (objSession != null) {
                ArrayList<MonAn> monAns = (ArrayList<MonAn>) objSession;
            } else {
                ArrayList<MonAn> monAns = new ArrayList<>();
                session.setAttribute(Consts.GIO_HANG, monAns);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/gio-hang.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
