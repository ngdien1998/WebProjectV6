package quanlynhahang.controllers.trangnguoidung;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.BaiVietService;
import quanlynhahang.models.businessmodels.LoaiBaiVietService;
import quanlynhahang.models.datamodels.BaiViet;
import quanlynhahang.models.datamodels.LoaiBaiViet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TinTucServlet", urlPatterns = { "/tin-tuc" })
public class TinTucServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String loaiBaiViet = request.getParameter("loaiBaiViet");
            BaiVietService service = new BaiVietService(DbAccess.getValue(request));
            LoaiBaiVietService service1 = new LoaiBaiVietService(DbAccess.getValue(request));
            ArrayList<LoaiBaiViet> loaiBaiViets = service1.getData();
            ArrayList<BaiViet> baiViets;
            if (loaiBaiViet == null) {
                 baiViets = service.getData();
            } else {
                baiViets = service.layBaiVietTheoDanhMuc(Integer.parseInt(loaiBaiViet));
            }

            if (baiViets.size() > 0) {
                request.setAttribute("baiViet1", baiViets.get(0));
            }
            if (baiViets.size() > 1) {
                request.setAttribute("baiViet2", baiViets.get(1));
            }
            if (baiViets.size() > 2) {
                request.setAttribute("baiViet3", baiViets.get(2));
            }

            ArrayList<BaiViet> temp = new ArrayList<>();
            for (int i = 3; i < baiViets.size(); i++) {
                temp.add(baiViets.get(i));
            }
            request.setAttribute("baiViets", temp);
            request.setAttribute("loaiBaiViets", loaiBaiViets);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/tin-tuc.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, e.toString());
        }
    }
}