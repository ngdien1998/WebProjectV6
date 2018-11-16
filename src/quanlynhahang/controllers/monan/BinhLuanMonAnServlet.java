package quanlynhahang.controllers.monan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BinhLuanMonAnServlet", urlPatterns = {"/admin/binh-luan-mon-an"})
public class BinhLuanMonAnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý
        String idMonAn = request.getParameter("idMonAn");
        //BinhLuanService binhLuanService = new BinhLuanService();

        //Lấy các thông tin bình luận của món ăn theo IDMonAn là IDDanhMucLienQuan và Loai là monan trong Bảng Bình Luận

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-binh-luan-mon-an.jsp");
        dispatcher.forward(request, response);
    }
}
