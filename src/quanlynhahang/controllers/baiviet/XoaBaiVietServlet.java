package quanlynhahang.controllers.baiviet;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.BaiVietService;
import quanlynhahang.models.businessmodels.LoaiBaiVietService;
import quanlynhahang.models.businessmodels.QuanTriVienService;
import quanlynhahang.models.datamodels.BaiViet;
import quanlynhahang.models.datamodels.LoaiBaiViet;
import quanlynhahang.models.datamodels.NguoiDung;
import quanlynhahang.models.viewmodels.UserDbConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "XoaBaiVietServlet", urlPatterns = { "/admin/xoa-bai-viet" })
public class XoaBaiVietServlet extends HttpServlet implements ActionPermissionID {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (!AuthorizePermission.islogined(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }
            String idBaiViet = request.getParameter("txtIdBaiViet");
            if (idBaiViet == null || idBaiViet.trim().isEmpty()) {
                response.setStatus(400);
                return;
            }
            BaiVietService service = new BaiVietService(DbAccess.getValue(request));
            service.delete(Integer.parseInt(idBaiViet));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/admin/bai-viet");
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
            UserDbConnect admin = DbAccess.getValue(request);
            String id = request.getParameter("id");
            if (id == null || id.trim().isEmpty()) {
                response.setStatus(400);
                return;
            }
            BaiVietService service = new BaiVietService(admin);
            BaiViet baiViet = service.get(Integer.parseInt(id));
            if (baiViet == null) {
                response.setStatus(404);
                return;
            }
            QuanTriVienService qtvService = new QuanTriVienService(admin);
            NguoiDung nguoiViet = qtvService.get(baiViet.getEmail());
            request.setAttribute("nguoiViet", nguoiViet);
            LoaiBaiVietService lbvSevice = new LoaiBaiVietService(admin);
            LoaiBaiViet loaiBaiViet = lbvSevice.get(baiViet.getIdBaiViet());
            request.setAttribute("loaiBaiViet", loaiBaiViet);
            request.setAttribute("baiViet", baiViet);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xoa-bai-viet.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.XOA_BAI_VIET;
    }
}