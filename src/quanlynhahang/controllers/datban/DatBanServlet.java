package quanlynhahang.controllers.datban;

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
            DatBanService service = new DatBanService();
            ArrayList<DatBan> datBans = service.getData();

            request.setAttribute("datBans", datBans);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-dat-ban.jsp");
        dispatcher.forward(request, response);
    }
}
