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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@WebServlet(name = "SuaBaiVietServlet", urlPatterns = { "/admin/sua-bai-viet" })
public class SuaBaiVietServlet extends HttpServlet implements ActionPermissionID {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            if (!AuthorizePermission.islogined(request)) {
                response.sendError(404);
                return;
            }

            if (!AuthorizePermission.checkPermissionAllowed(request, getPermissionId())) {
                response.sendError(401);
                return;
            }

            BaiViet baiViet = new BaiViet();
            baiViet.setIdBaiViet(Integer.parseInt(request.getParameter("txtIdBaiViet")));
            baiViet.setTenBaiViet(request.getParameter("txtTenBaiViet"));
            baiViet.setMoTa(request.getParameter("txtMoTa"));
            baiViet.setNoiDung(request.getParameter("txtNoiDung"));
            baiViet.setHinh(request.getParameter("txtHinhBaiViet"));
            baiViet.setEmail(AuthorizePermission.getCurrentLoginUser(request).getEmail());
            baiViet.setIdLoaiBaiViet(Integer.parseInt(request.getParameter("cmbLoaiBaiViet")));

            BaiVietService service = new BaiVietService(DbAccess.getValue(request));
            service.modify(baiViet);
        } catch (Exception e) {
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
            request.setAttribute("baiViet", baiViet);

            QuanTriVienService qtvService = new QuanTriVienService(admin);
            NguoiDung nguoiViet = qtvService.get(baiViet.getEmail());
            request.setAttribute("tacGia", nguoiViet);
            ArrayList<NguoiDung> nguoiViets = qtvService.getData();
            request.setAttribute("nguoiViets", nguoiViets);

            LoaiBaiVietService lbvSevice = new LoaiBaiVietService(admin);
            LoaiBaiViet loaiBaiViet = lbvSevice.get(baiViet.getIdBaiViet());
            request.setAttribute("loaiBai", loaiBaiViet);
            ArrayList<LoaiBaiViet> loaiBaiViets = lbvSevice.getData();
            request.setAttribute("loaiBaiViets", loaiBaiViets);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-sua-bai-viet.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public int getPermissionId() {
        return AuthorizePermission.SUA_BAI_VIET;
    }
}
