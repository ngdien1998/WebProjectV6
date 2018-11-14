package quanlynhahang.controllers.loaibaiviet;

import quanlynhahang.models.businessmodels.LoaiBaiVietService;
import quanlynhahang.models.datamodels.LoaiBaiViet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "XoaLoaiBaiVietServlet" , urlPatterns = "/admin/xoa-loai-bai-viet")
public class XoaLoaiBaiVietServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            LoaiBaiViet loaiBaiViet=new LoaiBaiViet();
            loaiBaiViet.setIdLoaiBaiViet(Integer.parseInt(request.getParameter("txtIdLoai")));
            String id = request.getParameter("txtIdLoai");
            if (id == null || id.trim().equals("")) {
                response.setStatus(400);
                return;
            }

            LoaiBaiVietService service = new LoaiBaiVietService();
            service.delete(Integer.parseInt(id));

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String id=request.getParameter("id");
            if(id==null || id.trim().equals("")){
                response.setStatus(400);
                return;
            }
            LoaiBaiVietService service=new LoaiBaiVietService();
            LoaiBaiViet loaiBaiViet=service.get(Integer.parseInt(id));
            if(loaiBaiViet==null ){
                response.setStatus(404);
                return;
            }
            request.setAttribute("loaiBaiViet1",loaiBaiViet);
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/admin-xoa-loai-bai-viet.jsp");
        dispatcher.forward(request,response);
    }
}
