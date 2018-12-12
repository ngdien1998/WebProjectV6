package quanlynhahang.controllers.ajax;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnService;
import quanlynhahang.models.datamodels.MonAn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FilterMonAnAjax", urlPatterns = {"/admin/ajax-filter-mon-an"})
public class FilterMonAnAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String typeFilter = request.getParameter("typeFilter");
            if (typeFilter == null || typeFilter.trim().isEmpty())  {
                response.setStatus(400);
                return;
            }

            MonAnService monAnService = new MonAnService(DbAccess.getValue(request));

            ArrayList<MonAn> monAns = null;
            if(typeFilter.equals("tat-ca")){
                monAns = monAnService.getData();
            }

            if(typeFilter.equals("moi-nhat")){
                monAns = monAnService.getMonAnMoiNhat();
            }

            if(typeFilter.equals("khuyen-mai")){
                monAns = monAnService.getMonAnTheoKhuyenMai();
            }


            StringBuilder sb = new StringBuilder();
            sb.append(" <div class=\"row\">\n");
            for (MonAn monAn: monAns) {
                sb.append("<div class=\"food-item col-md-4 col-sm-6 col-12 mb-5 contentPage\">\n");
                sb.append("<a href=\"/chi-tiet-mon-an?idMonAn=").append(monAn.getIdMonAn()).append("\">\n");
                sb.append("<div class=\"food-img\">\n");
                sb.append(" <img src=\"").append(monAn.getHinhMonAn()).append("\" height=\"170px\"/>\n");
                sb.append("</div>\n");
                sb.append(" <div class=\"row\">");
                sb.append(" <p class=\"col-8 food-name\" style=\"line-height: 30px\">").append(monAn.getTenMonAn()).append("</p>\n");
                sb.append(" <p class=\"col-4 price\">").append(monAn.getGia()).append("đ</p>\n");
                sb.append(" </div>\n");
                if(monAn.getKhuyenMai() == 0){
                    sb.append("<p class=\"price old-price\" style=\"position: absolute; right: 17px;top: 208px;\"></p>\n");
                }
                else {
                    int gia = Math.round(monAn.getGia() + (monAn.getKhuyenMai() * monAn.getGia())/100);

                    sb.append("<p class=\"price old-price\" style=\"position: absolute; right: 17px;top: 208px;\">").append(gia).append("đ</p>\n");
                }
                sb.append("</a>\n");
                sb.append("</div>");
            }
            sb.append("</div>\n");

            response.getWriter().print(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
