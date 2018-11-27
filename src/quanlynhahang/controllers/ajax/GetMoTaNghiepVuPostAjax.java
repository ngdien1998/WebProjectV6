package quanlynhahang.controllers.ajax;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.NghiepVuService;
import quanlynhahang.models.datamodels.NghiepVu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetMoTaNghiepVuPostAjax", urlPatterns = { "/admin/ajax-get-mo-ta-nghiep-vu" })
public class GetMoTaNghiepVuPostAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String id = request.getParameter("idNghiepVu");
            if (id == null || id.trim().isEmpty())  {
                response.setStatus(400);
                return;
            }
            int idNghiepVu = Integer.parseInt(id);
            NghiepVuService service = new NghiepVuService(DbAccess.getValue(request));
            NghiepVu nghiepVu = service.get(idNghiepVu);
            if (nghiepVu == null) {
                response.setStatus(404);
                return;
            }
            response.getWriter().print(nghiepVu.getMoTa());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}