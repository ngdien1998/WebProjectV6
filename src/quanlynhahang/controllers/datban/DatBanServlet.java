package quanlynhahang.controllers.datban;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.DatBanService;
import quanlynhahang.models.datamodels.DatBan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "DatBanServlet" , urlPatterns = { "/admin/dat-ban" })
public class DatBanServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            DatBanService service = new DatBanService(DbAccess.getValue(request));
            ArrayList<DatBan> datBans = service.getData();

            request.setAttribute("datBans", datBans);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-dat-ban.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
