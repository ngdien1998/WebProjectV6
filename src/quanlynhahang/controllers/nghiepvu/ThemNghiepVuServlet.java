package quanlynhahang.controllers.nghiepvu;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.NghiepVuService;
import quanlynhahang.models.datamodels.NghiepVu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "ThemNghiepVuServlet" , urlPatterns = {"/admin/them-nghiep-vu"})
public class ThemNghiepVuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try{
            NghiepVu nghiepVu=new NghiepVu();
            nghiepVu.setTenNghiepVu(request.getParameter("txtTenNghiepVu"));
            NghiepVuService service= new NghiepVuService(DbAccess.getValue(request));
            service.add(nghiepVu);

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();

        }
        response.sendRedirect("/admin/nghiep-vu");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/admin-them-nghiep-vu.jsp");
        dispatcher.forward(request,response);
    }
}
