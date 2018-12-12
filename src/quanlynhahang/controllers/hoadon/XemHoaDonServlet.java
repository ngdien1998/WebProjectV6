package quanlynhahang.controllers.hoadon;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.HoaDonService;
import quanlynhahang.models.datamodels.HoaDon;
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

@WebServlet(name = "XemHoaDonServlet" , urlPatterns = {"/admin/xem-hoa-don"})
public class XemHoaDonServlet extends HttpServlet implements ActionPermissionID {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
//            if (!AuthorizePermission.islogined(request)) {
//                response.sendError(404);
//                return;
//            }
//
//            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
//                response.sendError(401);
//                return;
//            }
            String idHoaDon = request.getParameter("idHoaDon");
            if (idHoaDon == null) {
                response.setStatus(400);
                return;
            }

            HoaDonService hoaDonService = new HoaDonService(DbAccess.getValue(request));
            ArrayList<HoaDon> hoaDons=hoaDonService.getHoaDon(idHoaDon);
            if (hoaDons == null) {
                response.setStatus(404);
                return;
            }
            request.setAttribute("hoaDons", hoaDons);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xem-hoa-don.jsp");
            dispatcher.forward(request, response);

        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.XEM_HOA_DON;
    }
}
