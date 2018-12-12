package quanlynhahang.controllers.trangnguoidung;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.BaiVietService;
import quanlynhahang.models.businessmodels.BinhLuanService;
import quanlynhahang.models.datamodels.BaiViet;
import quanlynhahang.models.datamodels.BinhLuan;
import quanlynhahang.models.viewmodels.ChiTietBaiViet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ChiTietBanTinServlet", urlPatterns = { "/chi-tiet-bai-viet" })
public class ChiTietBanTinServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String idBaiViet = request.getParameter("idBaiViet");
            if (idBaiViet == null || idBaiViet.trim().isEmpty()) {
                response.sendError(400);
                return;
            }
            BaiVietService service = new BaiVietService(DbAccess.getValue(request));
            ChiTietBaiViet baiViet = service.layChiTietBaiViet(Integer.parseInt(idBaiViet));
            if (baiViet == null) {
                response.sendError(404);
                return;
            }
            ArrayList<BaiViet> baiViets = service.layBaiVietTheoDanhMuc(baiViet.getIdLoaiBaiViet());

            request.setAttribute("baiViets", baiViets);
            request.setAttribute("baiViet", baiViet);

            BinhLuanService binhLuanService = new BinhLuanService(DbAccess.getValue(request));
            ArrayList<BinhLuan> binhLuans = binhLuanService.getBinhLuanBaiViet(Integer.parseInt(idBaiViet));
            request.setAttribute("binhLuans", binhLuans);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/chi-tiet-bai-viet.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.toString());
        }
    }
}
