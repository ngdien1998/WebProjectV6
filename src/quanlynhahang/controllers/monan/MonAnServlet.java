package quanlynhahang.controllers.monan;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnService;
import quanlynhahang.models.datamodels.MonAn;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "MonAnServlet", urlPatterns = {"/admin/mon-an"})
public class MonAnServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            MonAnService service = new MonAnService(DbAccess.getValue(request));
            ArrayList<MonAn> monAns = service.getData();

            request.setAttribute("soLuong", monAns.size());
            request.setAttribute("monAns", monAns);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-mon-an.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
