package quanlynhahang.controllers.quantrivien;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.QuanTriVienService;
import quanlynhahang.models.datamodels.NguoiDung;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "QuanTriVienServlet", urlPatterns = { "/admin/quan-tri-vien" })
public class QuanTriVienServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QuanTriVienService service = new QuanTriVienService(DbAccess.getValue(request));
            ArrayList<NguoiDung> qtvs = service.getData();
            request.setAttribute("qtvs", qtvs);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-quan-tri-vien.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(500, e.toString());
        }
    }
}