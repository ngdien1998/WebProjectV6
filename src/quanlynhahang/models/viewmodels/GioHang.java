package quanlynhahang.models.viewmodels;

import quanlynhahang.common.Consts;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.MonAnService;
import quanlynhahang.models.datamodels.MonAn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class GioHang {
    private HttpSession session;

    public GioHang(HttpSession session) {
        this.session = session;
    }

    public void themMonAnVaoGioHang(int idMonAn, int soLuong) throws Exception {
        ArrayList<MonAnVM> monAns = layDanhSachMonAnTrongGioHang();
        if (monAns == null) {
            MonAnService service = new MonAnService((UserDbConnect) session.getAttribute(Consts.USER_DB_CONNECT));
            MonAn monAn = service.get(idMonAn);
            if (monAn == null) {
                throw new Exception("404");
            }

            MonAnVM monAnVM = new MonAnVM();
            monAnVM.setIdMonAn(monAn.getIdMonAn());
            monAnVM.setTenMonAn(monAn.getTenMonAn());
            monAnVM.setGia(monAn.getGia());
            monAnVM.setSoLuong(soLuong);

            ArrayList<MonAnVM> monAnsMoi = new ArrayList<>();
            monAnsMoi.add(monAnVM);
            session.setAttribute(Consts.GIO_HANG, monAnsMoi);
        } else {
            int existedIndex = -1;
            for (int i = 0; i < monAns.size(); i++) {
                if (monAns.get(i).getIdMonAn() == idMonAn) {
                    existedIndex = i;
                    break;
                }
            }

            if (existedIndex >= 0) {
                MonAnVM monAnVM = monAns.get(existedIndex);
                monAnVM.setSoLuong(monAnVM.getSoLuong() + soLuong);
            } else {
                MonAnService service = new MonAnService((UserDbConnect) session.getAttribute(Consts.USER_DB_CONNECT));
                MonAn monAn = service.get(idMonAn);
                if (monAn == null) {
                    throw new Exception("404");
                }

                MonAnVM monAnVM = new MonAnVM();
                monAnVM.setIdMonAn(monAn.getIdMonAn());
                monAnVM.setTenMonAn(monAn.getTenMonAn());
                monAnVM.setGia(monAn.getGia());
                monAnVM.setSoLuong(soLuong);

                monAns.add(monAnVM);
            }
        }
    }

    private ArrayList<MonAnVM> layDanhSachMonAnTrongGioHang() {
        Object objGioHang = session.getAttribute(Consts.GIO_HANG);
        if (objGioHang == null) {
            return null;
        }
        return (ArrayList<MonAnVM>) objGioHang;
    }

    public void capNhatGioHang(int idMonAn, int soLuong) {
        ArrayList<MonAnVM> monAnVMs = layDanhSachMonAnTrongGioHang();
        if (monAnVMs == null) {
            return;
        }
        for (MonAnVM monAnItem : monAnVMs) {
            if (monAnItem.getIdMonAn() == idMonAn) {
                monAnItem.setSoLuong(soLuong);
                return;
            }
        }
    }

    public void xoaGioHang() {
        if (session.getAttribute(Consts.GIO_HANG) != null) {
            session.removeAttribute(Consts.GIO_HANG);
        }
    }

    public void xoaMonAnTrongGioHang(int idMonAn) {
        ArrayList<MonAnVM> monAnVMs = layDanhSachMonAnTrongGioHang();
        if (monAnVMs == null) {
            return;
        }
        for (int i = 0; i < monAnVMs.size(); i++) {
            if (monAnVMs.get(i).getIdMonAn() == idMonAn) {
                monAnVMs.remove(i);
                return;
            }
        }
    }

    public boolean laGioHangRong() {
        ArrayList<MonAnVM> obj = layDanhSachMonAnTrongGioHang();
        return obj == null || obj.size() <= 0;
    }

    public MonAnVM layMonAn(int idMonAn) {
        ArrayList<MonAnVM> monAnVMS = layDanhSachMonAnTrongGioHang();
        if (monAnVMS != null)
        for (MonAnVM monAnVM : monAnVMS) {
            if (monAnVM.getIdMonAn() == idMonAn) {
                return monAnVM;
            }
        }
        return null;
    }

    public int tinhTongTien() {
        int tongTien = 0;
        ArrayList<MonAnVM> monAnVMS = layDanhSachMonAnTrongGioHang();
        if (monAnVMS != null)
            for (MonAnVM monAnVM : monAnVMS) {
                tongTien += monAnVM.tinhTien();
            }
        return tongTien;
    }
}
