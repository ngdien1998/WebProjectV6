package quanlynhahang.controllers.loaibaiviet;

import quanlynhahang.common.ActionPermissionID;
import quanlynhahang.common.AuthorizePermission;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.LoaiBaiVietService;
import quanlynhahang.models.datamodels.LoaiBaiViet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "XoaLoaiBaiVietServlet" , urlPatterns = "/admin/xoa-loai-bai-viet")
public class XoaLoaiBaiVietServlet extends HttpServlet implements ActionPermissionID {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
//            if (!AuthorizePermission.checkLogined(request)) {
//                response.sendError(404);
//                return;
//            }
//
//            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
//                response.sendError(401);
//                return;
//            }

            String idLoaiBaiViet = request.getParameter("txtIdLoai");
            if (idLoaiBaiViet == null || idLoaiBaiViet.trim().equals("")) {
                response.setStatus(400);
                return;
            }

            LoaiBaiVietService service = new LoaiBaiVietService(DbAccess.getValue(request));
            service.delete(Integer.parseInt(idLoaiBaiViet));
            response.sendRedirect("/admin/loai-bai-viet");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            if (!AuthorizePermission.checkLogined(request)) {
//                response.sendError(404);
//                return;
//            }
//
//            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
//                response.sendError(401);
//                return;
//            }
            String idLoaiBaiViet = request.getParameter("idLoaiBaiViet");
            if (idLoaiBaiViet == null || idLoaiBaiViet.trim().equals("")) {
                response.setStatus(400);
                return;
            }
            LoaiBaiVietService service = new LoaiBaiVietService(DbAccess.getValue(request));
            LoaiBaiViet loaiBaiViet = service.get(Integer.parseInt(idLoaiBaiViet));
            if (loaiBaiViet == null) {
                response.setStatus(404);
                return;
            }

            request.setAttribute("loaiBaiViet", loaiBaiViet);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xoa-loai-bai-viet.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.XOA_LOAI_BAI_VIET;
    }
}
