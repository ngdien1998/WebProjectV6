package quanlynhahang.controllers.monan;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnService;
import quanlynhahang.models.businessmodels.ThucDonMonAnService;
import quanlynhahang.models.businessmodels.ThucDonService;
import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.datamodels.ThucDon;
import quanlynhahang.models.viewmodels.UserDbConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ThemMonAnVaoThucDonServlet", urlPatterns = {"/admin/them-mon-an-vao-thuc-don"})
public class ThemMonAnVaoThucDonServlet extends HttpServlet implements ActionPermissionID {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idThucDon = request.getParameter("txtIdThucDon");
        String[] selectedMonAn = request.getParameterValues("cmbMonAn");
        ThucDonMonAnService thucDonMonAnService = new ThucDonMonAnService(DbAccess.getValue(request));
        for (int i = 0; i < selectedMonAn.length; i++) {
            try {
                thucDonMonAnService.addThucDonMonAn(selectedMonAn[i], idThucDon);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("/admin/thuc-don");
    }

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
            UserDbConnect admin = DbAccess.getValue(request);

            ThucDonService thucDonService = new ThucDonService(DbAccess.getValue(request));
            ThucDon thucDon = null;
            thucDon = thucDonService.get(idThucDon);

            //Lấy món ăn trong ThucDonMonAn
            MonAnService monAnService = new MonAnService(admin);
            ArrayList<MonAn> listMonAn = null;

            if (!AuthorizePermission.islogined(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }
            listMonAn = monAnService.getData();

            request.setAttribute("thucDon", thucDon);
            request.setAttribute("listMonAn", listMonAn);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-them-mon-an-vao-thuc-don.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.THEM_MON_AN_VAO_THUC_DON;
    }
}
