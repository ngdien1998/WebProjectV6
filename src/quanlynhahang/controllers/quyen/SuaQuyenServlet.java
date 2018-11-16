package quanlynhahang.controllers.quyen;

import quanlynhahang.models.datamodels.Quyen;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SuaQuyenServlet" , urlPatterns = {"/admin/sua-quyen"})
public class SuaQuyenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Quyen quyen=new Quyen();
        quyen.setIdQuyen(Integer.parseInt(request.getParameter("IDQuyen")));
        quyen.setTenQuyen(request.getParameter("TenQuyen"));
        quyen.setMoTa(request.getParameter("MoTa"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
