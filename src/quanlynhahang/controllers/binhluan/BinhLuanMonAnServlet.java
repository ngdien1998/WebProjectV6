package quanlynhahang.controllers.binhluan;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.BinhLuanService;
import quanlynhahang.models.businessmodels.MonAnService;
import quanlynhahang.models.datamodels.BinhLuan;
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

@WebServlet(name = "BinhLuanMonAnServlet", urlPatterns = {"/admin/binh-luan-mon-an-hien-tai"})
public class BinhLuanMonAnServlet extends HttpServlet implements ActionPermissionID {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (!AuthorizePermission.islogined(request)) {
                response.sendError(404);
                return;
            }

//            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
//                response.sendError(401);
//                return;
//            }

            String idMonAn = request.getParameter("idMonAn");
            if (idMonAn == null || idMonAn.trim().isEmpty()) {
                response.setStatus(400);
                return;
            }

            BinhLuanService binhLuanService = new BinhLuanService(DbAccess.getValue(request));
            ArrayList<BinhLuan> binhLuans = binhLuanService.getBinhLuanMonAn(Integer.parseInt(idMonAn));
            request.setAttribute("binhLuans", binhLuans);

            MonAnService monAnService = new MonAnService(DbAccess.getValue(request));
            request.setAttribute("monAn", monAnService.get(idMonAn));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-binh-luan-mon-an.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public int getPermissionId() {
        return 0;
    }
}
