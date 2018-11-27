package quanlynhahang.controllers.nguoidung;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.NguoiDungService;
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

import static com.ckfinder.connector.ServletContextFactory.getServletContext;

@WebServlet(name = "NguoiDung", urlPatterns = { "/admin/nguoi-dung" })
public class NguoiDungServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            NguoiDungService service = new NguoiDungService(DbAccess.getValue(request));
            ArrayList<NguoiDung> nguoiDungs = service.getData();

            request.setAttribute("nguoiDungs", nguoiDungs);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-nguoi-dung.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}