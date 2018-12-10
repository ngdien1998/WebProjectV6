package quanlynhahang.controllers.loaibaiviet;

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
import java.util.ArrayList;

@WebServlet(name = "LoaiBaiVietServlet", urlPatterns = { "/admin/loai-bai-viet" })
public class LoaiBaiVietServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            LoaiBaiVietService service = new LoaiBaiVietService(DbAccess.getValue(request));
            ArrayList<LoaiBaiViet> loaiBaiViets = service.getData();
            request.setAttribute("loaiBaiViets", loaiBaiViets);
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/admin-loai-bai-viet.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}