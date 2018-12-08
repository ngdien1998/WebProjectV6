package quanlynhahang.controllers.binhluan;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.BaiVietService;
import quanlynhahang.models.businessmodels.BinhLuanService;
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

@WebServlet(name = "BinhLuanBaiVietServlet", urlPatterns = { "/admin/binh-luan-bai-viet" })
public class BinhLuanBaiVietServlet extends HttpServlet implements ActionPermissionID {
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
            UserDbConnect admin = DbAccess.getValue(request);

            String idBaiViet = request.getParameter("idBaiViet");
            if (idBaiViet == null || idBaiViet.trim().isEmpty()) {
                response.setStatus(400);
                return;
            }
            BinhLuanService service = new BinhLuanService(admin);
            ArrayList<BinhLuan> binhLuans = service.getData("baiviet", Integer.parseInt(idBaiViet));
            request.setAttribute("binhLuans", binhLuans);
            BaiVietService baiVietService = new BaiVietService(admin);
            request.setAttribute("tenBaiViet", baiVietService.get(Integer.parseInt(idBaiViet)).getTenBaiViet());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-binh-luan-bai-viet.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.XOA_BINH_LUAN_BAI_VIET;
    }
}