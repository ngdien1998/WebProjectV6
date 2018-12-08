package quanlynhahang.controllers.monan;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.LoaiMonService;
import quanlynhahang.models.businessmodels.MonAnService;
import quanlynhahang.models.businessmodels.ThucDonMonAnService;
import quanlynhahang.models.datamodels.LoaiMon;
import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.viewmodels.UserDbConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "XemMonAnServlet", urlPatterns = {"/admin/xem-mon-an"})
public class XemMonAnServlet extends HttpServlet implements ActionPermissionID {
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
            String idMonAn = request.getParameter("idMonAn");
            if (idMonAn == null) {
                response.setStatus(400);
                return;
            }
            UserDbConnect admin = DbAccess.getValue(request);
            MonAnService monAnService = new MonAnService(admin);
            MonAn monAn = null;
            monAn = monAnService.get(idMonAn);

            if (monAn == null) {
                response.setStatus(404);
                return;
            }

            // Check trên thực đơn, tên loại món theo ID ở đây sau đó gửi lại
            int idLoaiMon = monAn.getIdLoaiMon();
            LoaiMonService loaiMonService = new LoaiMonService(admin);
            LoaiMon loaiMon = null;
            loaiMon = loaiMonService.get(idLoaiMon);
            ThucDonMonAnService thucDonMonAnService = new ThucDonMonAnService(admin);


            request.setAttribute("monAn", monAn);
            request.setAttribute("loaiMon", loaiMon);
//            request.setAttribute("thucDon", thucDon);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xem-mon-an.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.XEM_MON_AN;
    }
}
