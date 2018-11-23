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
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "NghiepVuServlet", urlPatterns = { "/admin/nghiep-vu" })
public class NghiepVuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            NghiepVuService nghiepVuService=new NghiepVuService(DbAccess.getValue(request));
            ArrayList<NghiepVu> nghiepVus=nghiepVuService.getData();
            request.setAttribute("nghiepVus",nghiepVus);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin-nghiep-vu.jsp");
        dispatcher.forward(request,response);
    }
}
