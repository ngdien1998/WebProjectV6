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

@WebServlet(name = "XoaNghiepVuServlet" , urlPatterns = {"/admin/xoa-nghiep-vu"})
public class XoaNghiepVuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try{
            String id=request.getParameter("txtIdNghiepVu");
            if(id==null || id.trim().equals(""))
            {
                response.setStatus(400);
                return;
            }
            NghiepVuService service=new NghiepVuService(DbAccess.getValue(request));
            service.delete(Integer.parseInt(id));

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String id=request.getParameter("idNghiepVu");
            if(id==null || id.trim().equals(""))
            {
                response.setStatus(400);
                return;
            }
            NghiepVuService service=new NghiepVuService(DbAccess.getValue(request));
            NghiepVu nghiepVu =service.get(Integer.parseInt(id));
            if(nghiepVu==null)
            {
                response.setStatus(404);
                return;
            }
            request.setAttribute("nghiepVu",nghiepVu);

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();

        }
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/admin-xoa-nghiep-vu.jsp");
        dispatcher.forward(request,response);
    }
}
