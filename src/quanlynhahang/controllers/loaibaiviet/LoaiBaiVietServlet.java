package quanlynhahang.controllers.loaibaiviet;

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
import java.util.ArrayList;

@WebServlet(name = "LoaiBaiVietServlet", urlPatterns = { "/admin/loai-bai-viet" })
public class LoaiBaiVietServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            LoaiBaiVietService service = new LoaiBaiVietService();
            ArrayList<LoaiBaiViet> loaiBaiViets = service.getData();

            request.setAttribute("loaiBaiViets", loaiBaiViets);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-loai-bai-viet.jsp");
        dispatcher.forward(request, response);
    }
}