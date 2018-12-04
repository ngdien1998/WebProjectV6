package quanlynhahang.controllers.trangnguoidung.datmonnhom;

import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnNhomService;
import quanlynhahang.models.businessmodels.MonAnService;
import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.viewmodels.HoaDonNhom;
import quanlynhahang.models.viewmodels.UserDbConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DatMonNhomServlet", urlPatterns = { "/dat-mon-nhom" })
public class DatMonNhomServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDbConnect value = DbAccess.getValue(request);
            String idDatMon = request.getParameter("id");
            request.setAttribute("isInGroup", idDatMon != null);
            if (idDatMon != null) {
                MonAnNhomService service = new MonAnNhomService(value);
                HoaDonNhom hoaDon = service.layHoaDon(Integer.parseInt(idDatMon));
                request.setAttribute("hoaDon", hoaDon);
            }
            MonAnService monAnService = new MonAnService(value);
            request.setAttribute("monAns", monAnService.getData());
            request.setAttribute("monAnNhanhs", monAnService.layMonAnTheoThucDon(9));
            request.setAttribute("doUongs", monAnService.layMonAnTheoThucDon(10));

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dat-mon-nhom.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }
    }
}