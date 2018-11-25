package quanlynhahang.controllers.dashboard;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.viewmodels.UserDbConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DashboardServlet", urlPatterns = { "/admin" })
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDbConnect userDbConnect = DbAccess.getValue(request);
        if (userDbConnect == null || !userDbConnect.isAdmin()) {
            response.sendError(404);
            return;
        }
        if (userDbConnect.getHostName() == null || userDbConnect.getPort() == null) {
            response.sendRedirect("/admin/ket-noi-database");
            return;
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-dashboard.jsp");
        dispatcher.forward(request, response);
    }
}