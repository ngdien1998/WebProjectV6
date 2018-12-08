package quanlynhahang.controllers.trangnguoidung;

import quanlynhahang.models.businessmodels.LienHeService;
import quanlynhahang.models.datamodels.LienHe;
import quanlynhahang.common.DbAccess;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserLienHeServlet", urlPatterns = {"/lien-he"})
public class UserLienHeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            LienHe lienHe=new LienHe();
            lienHe.setEmail(request.getParameter("email"));
            lienHe.setHoTen(request.getParameter("name"));
            lienHe.setSoDT(request.getParameter("phone"));
            lienHe.setNoiDung(request.getParameter("message"));
            lienHe.setTrangThaiSeen(false);
            LienHeService lienHeService= new LienHeService(DbAccess.getValue(request));
            lienHeService.add(lienHe) ;
            RequestDispatcher dispatcher = request.getRequestDispatcher("/lien-he.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/lien-he.jsp");
        dispatcher.forward(request, response);
    }
}
