package quanlynhahang.controllers.baiviet;

import quanlynhahang.models.businessmodels.BaiVietService;
import quanlynhahang.models.businessmodels.LoaiBaiVietService;
import quanlynhahang.models.businessmodels.QuanTriVienService;
import quanlynhahang.models.datamodels.BaiViet;
import quanlynhahang.models.datamodels.LoaiBaiViet;
import quanlynhahang.models.datamodels.NguoiDung;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "XemBaiVietServlet", urlPatterns = { "/admin/xem-bai-viet" })
public class XemBaiVietServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            if (id == null || id.trim().isEmpty()) {
                response.setStatus(400);
                return;
            }
            BaiVietService service = new BaiVietService();
            BaiViet baiViet = service.get(Integer.parseInt(id));
            if (baiViet == null) {
                response.setStatus(404);
                return;
            }
            QuanTriVienService qtvService = new QuanTriVienService();
            NguoiDung nguoiViet = qtvService.get(baiViet.getEmail());
            request.setAttribute("nguoiViet", nguoiViet);
            LoaiBaiVietService lbvSevice = new LoaiBaiVietService();
            LoaiBaiViet loaiBaiViet = lbvSevice.get(baiViet.getIdBaiViet());
            request.setAttribute("loaiBaiViet", loaiBaiViet);
            request.setAttribute("baiViet", baiViet);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-xem-bai-viet.jsp");
        dispatcher.forward(request, response);
    }
}
