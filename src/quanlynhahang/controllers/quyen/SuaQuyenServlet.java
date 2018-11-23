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

@WebServlet(name = "SuaQuyenServlet" , urlPatterns = {"/admin/sua-quyen"})
public class SuaQuyenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            Quyen quyen = new Quyen();
            quyen.setIdQuyen(Integer.parseInt(request.getParameter("txtIdQuyen")));
            quyen.setTenQuyen(request.getParameter("txtTenQuyen"));
            quyen.setMoTa(request.getParameter("txtMoTa"));
            quyen.setIdNghiepVu(Integer.parseInt(request.getParameter("txtIdNghiepVu")));
            QuyenService service=new QuyenService(DbAccess.getValue(request));
            service.modify(quyen);
            response.sendRedirect("/admin/sua-quyen");
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();

        }

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

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();

        }

        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/admin-sua-quyen.jsp");
        dispatcher.forward(request,response);
    }
}
