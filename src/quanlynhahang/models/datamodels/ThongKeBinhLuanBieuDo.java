package quanlynhahang.models.datamodels;

public class ThongKeBinhLuanBieuDo {
    private int soLuong;
    private int ngay;

    public ThongKeBinhLuanBieuDo() {
    }

    public ThongKeBinhLuanBieuDo(int soLuong, int ngay) {
        this.soLuong = soLuong;
        this.ngay = ngay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }
}
