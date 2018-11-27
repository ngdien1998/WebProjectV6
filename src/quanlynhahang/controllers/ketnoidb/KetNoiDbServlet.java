package quanlynhahang.controllers.ketnoidb;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.ConnectDbService;
import quanlynhahang.models.viewmodels.UserDbConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "KetNoiDbServlet", urlPatterns = { "/admin/ket-noi-database" })
public class KetNoiDbServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String server, port;
            if (request.getParameter("chkServer") == null) {
                server = request.getParameter("txtServer");
                port = request.getParameter("txtPort");
            } else {
                server = "192.168.1.16";
                port = "1433";
            }
            UserDbConnect admin = DbAccess.getValue(request);
            if (admin == null || !admin.isAdmin()) {
                response.sendError(400);
                return;
            }
            admin.setHostName(server);
            admin.setPort(port);

            ConnectDbService login = new ConnectDbService(admin);
            if (login.tryConnectToServer()) {
                response.sendRedirect("/admin");
                return;
            }
            request.setAttribute("server", server);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-dang-nhap-db.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDbConnect admin = DbAccess.getValue(request);
        if (admin == null || !admin.isAdmin()) {
            response.sendError(404);
            return;
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-dang-nhap-db.jsp");
        dispatcher.forward(request, response);
    }
}
