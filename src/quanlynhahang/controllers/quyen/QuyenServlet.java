package quanlynhahang.controllers.quyen;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.QuyenService;
import quanlynhahang.models.datamodels.Quyen;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "QuyenServlet" ,  urlPatterns = {"/admin/quyen"})
public class QuyenServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            QuyenService quyenService=new QuyenService(DbAccess.getValue(request));
            ArrayList<Quyen> quyens = quyenService.getData();
            request.setAttribute("quyens", quyens);
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/admin-quyen.jsp");
            dispatcher.forward(request,response);
        }catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
