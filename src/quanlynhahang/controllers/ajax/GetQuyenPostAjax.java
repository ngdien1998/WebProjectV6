package quanlynhahang.controllers.ajax;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.QuyenService;
import quanlynhahang.models.viewmodels.QuyenVM;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet(name = "GetQuyenPostAjax", urlPatterns = { "/admin/ajax-get-quyen" })
public class GetQuyenPostAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String idNghiepVu = request.getParameter("idNghiepVu");
            String email = request.getParameter("email");
            if (idNghiepVu == null || email == null || idNghiepVu.isEmpty() || email.isEmpty()) {
                response.setStatus(400);
                return;
            }
            QuyenService service = new QuyenService(DbAccess.getValue(request));
            ArrayList<QuyenVM> quyens = service.getQuyenViewModel(email, Integer.parseInt(idNghiepVu));
            StringBuilder sb = new StringBuilder();
            sb.append("<ul>\n");
            for (QuyenVM quyen : quyens) {
                sb.append("<li>\n");
                sb.append("<div class='form-group'>\n");
                sb.append("<div class='form-check form-check-flat'>\n");
                sb.append("<label class='form-check-label'>\n");
                sb.append("<input type='checkbox' class='form-check-input quyen' value='" + quyen.getIdQuyen() + "' ");
                if (quyen.isDuocCap()) {
                    sb.append("checked");
                }
                sb.append(">\n");
                sb.append(quyen.getTenQuyen() + "\n");
                sb.append("<i class='input-helper'></i>\n");
                sb.append("</label>\n");
                sb.append("</div>\n");
                sb.append("</div>\n");
                sb.append("</li>\n");
            }
            sb.append("</ul>\n");

            response.getWriter().print(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}