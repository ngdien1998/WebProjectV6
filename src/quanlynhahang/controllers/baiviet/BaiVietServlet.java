package quanlynhahang.controllers.baiviet;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.BaiVietService;
import quanlynhahang.models.datamodels.BaiViet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "BaiVietServlet", urlPatterns = { "/admin/bai-viet" })
public class BaiVietServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BaiVietService baiVietService = new BaiVietService(DbAccess.getValue(request));
            ArrayList<BaiViet> baiViets = baiVietService.getData();
            request.setAttribute("baiViets", baiViets);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-bai-viet.jsp");
        dispatcher.forward(request, response);
    }
}
