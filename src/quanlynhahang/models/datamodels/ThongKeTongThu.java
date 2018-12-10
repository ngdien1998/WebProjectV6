package quanlynhahang.models.datamodels;

import java.sql.Date;

public class ThongKeTongThu {
    private  int tongTien;
    private int thoiGian;

    public ThongKeTongThu() {
    }

    public ThongKeTongThu(int tongTien,int  thoiGian) {
        this.tongTien = tongTien;
        this.thoiGian = thoiGian;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int  getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int  thoiGian) {
        this.thoiGian = thoiGian;
    }
}
