package quanlynhahang.controllers.binhluan;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.BinhLuanService;
import quanlynhahang.models.businessmodels.MonAnService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "XoaBinhLuanMonAnServlet", urlPatterns = {"/admin/xoa-binh-luan-mon-an"})
public class XoaBinhLuanMonAnServlet extends HttpServlet implements ActionPermissionID {
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
            if (idMonAn == null) {
                response.setStatus(400);
                return;
            }

            String idBinhLuan = request.getParameter("idBinhLuan");
            if (idBinhLuan == null || idBinhLuan.trim().isEmpty()) {
                response.setStatus(400);
                return;
            }

            BinhLuanService binhLuanService = new BinhLuanService(DbAccess.getValue(request));

            binhLuanService.deleteBinhLuanMonAn(Integer.parseInt(idMonAn), Integer.parseInt(idBinhLuan));

            response.sendRedirect("/admin/mon-an");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getPermissionId() {
        return 0;
    }
}
