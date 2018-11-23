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

@WebServlet(name = "ThemQuyenServlet" , urlPatterns = {"/admin/them-quyen"})
public class ThemQuyenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            Quyen quyen= new Quyen();
            quyen.setTenQuyen(request.getParameter("txtTenQuyen"));
            quyen.setMoTa(request.getParameter("txtMoTa"));
            quyen.setIdNghiepVu(Integer.parseInt(request.getParameter("txtIDNghiepVu")));

            QuyenService service = new QuyenService(DbAccess.getValue(request));
            service.add(quyen);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/admin/quyen");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/admin-them-quyen.jsp");
        dispatcher.forward(request,response);
    }
}
