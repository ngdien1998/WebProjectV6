package quanlynhahang.models.viewmodels;

public class MonAnVM {
    private int idMonAn;
    private String tenMonAn;
    private int gia;
    private int soLuong;

    public MonAnVM() {
    }

    public MonAnVM(int idMonAn, String tenMonAn, int gia) {
        this.idMonAn = idMonAn;
        this.tenMonAn = tenMonAn;
        this.gia = gia;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int tinhTien() {
        return gia * soLuong;
    }
}
