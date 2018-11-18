package quanlynhahang.controllers.binhluan;

import quanlynhahang.models.businessmodels.BinhLuanService;
import quanlynhahang.models.datamodels.BinhLuan;

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
public class BinhLuanBaiVietServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idDanhMucLienQuan = request.getParameter("id");
            if (idDanhMucLienQuan == null || idDanhMucLienQuan.trim().isEmpty()) {
                response.setStatus(400);
                return;
            }
            BinhLuanService service = new BinhLuanService();
            ArrayList<BinhLuan> binhLuans = service.getData("binhluan", Integer.parseInt(idDanhMucLienQuan));
            request.setAttribute("binhLuans", binhLuans);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-binh-luan-bai-viet.jsp");
        dispatcher.forward(request, response);
    }
}
