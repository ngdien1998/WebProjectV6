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

@WebServlet(name = "XoaQuyenServlet" , urlPatterns = {"/admin/xoa-quyen"})
public class XoaQuyenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try{
            String id=request.getParameter("txtIdQuyen");
            if(id==null || id.trim().equals(""))
            {
                response.setStatus(400);
                return;
            }
            QuyenService service=new QuyenService(DbAccess.getValue(request));
            service.delete(Integer.parseInt(id));
        }catch (SQLException | ClassNotFoundException e){

            e.printStackTrace();
        }
        response.sendRedirect("/admin/quyen");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String idquyen=request.getParameter("idQuyen");
            if(idquyen == null) {
                response.setStatus(400);
                return;
            }
            QuyenService quyenService= new QuyenService(DbAccess.getValue(request));
            Quyen quyen=null;
            quyen=quyenService.get(idquyen);
            if(quyen==null){
                response.setStatus(404);
                return;
            }
            request.setAttribute("quyen",quyen);
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/admin-xoa-quyen.jsp");
            dispatcher.forward(request,response);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
