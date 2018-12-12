package quanlynhahang.controllers.lienhe;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.LienHeService;
import quanlynhahang.models.datamodels.LienHe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "LienHeServlet" , urlPatterns = {"/admin/lien-he"})
public class LienHeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            LienHeService service=new LienHeService(DbAccess.getValue(request));
            ArrayList<LienHe> lienHes=service.getData();
            request.setAttribute("lienHes",lienHes);
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/admin-lien-he.jsp");
            dispatcher.forward(request,response);
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
