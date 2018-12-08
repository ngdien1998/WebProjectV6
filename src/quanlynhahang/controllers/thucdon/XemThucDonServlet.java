package quanlynhahang.controllers.thucdon;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.ThucDonService;
import quanlynhahang.models.datamodels.ThucDon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "XemThucDonServlet", urlPatterns = {"/admin/xem-thuc-don"})
public class XemThucDonServlet extends HttpServlet implements ActionPermissionID {
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
            if (idThucDon == null) {
                response.setStatus(400);
                return;
            }

            ThucDonService thucDonService = new ThucDonService(DbAccess.getValue(request));
            ThucDon thucDon = null;
            thucDon = thucDonService.get(idThucDon);
            if (thucDon == null) {
                response.setStatus(404);
                return;
            }
            request.setAttribute("thucDon", thucDon);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xem-thuc-don.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.XEM_THUC_DON;
    }
}
