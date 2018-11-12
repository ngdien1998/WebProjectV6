package quanlynhahang.controllers.loaibaiviet;

import quanlynhahang.models.businessmodels.LoaiBaiVietService;
import quanlynhahang.models.datamodels.LoaiBaiViet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SuaLoaiBaiVietServlet", urlPatterns = { "/admin/sua-loai-bai-viet" })
public class SuaLoaiBaiVietServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            LoaiBaiViet loaiBaiViet = new LoaiBaiViet();
            loaiBaiViet.setIdLoaiBaiViet(Integer.parseInt(request.getParameter("txtIdLoai")));
            loaiBaiViet.setTenLoaiBaiViet(request.getParameter("txtTenLoai"));
            loaiBaiViet.setMoTa(request.getParameter("txtMoTa"));

            LoaiBaiVietService service = new LoaiBaiVietService();
            service.modify(loaiBaiViet);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            if (id == null || id.trim().equals("")) {
                response.setStatus(400);
                return;
            }
            LoaiBaiVietService service = new LoaiBaiVietService();
            LoaiBaiViet loaiBaiViet = service.get(Integer.parseInt(id));
            if (loaiBaiViet == null) {
                response.setStatus(404);
                return;
            }

            request.setAttribute("loaiBaiViet", loaiBaiViet);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-sua-loai-bai-viet.jsp");
        dispatcher.forward(request, response);
    }
}
