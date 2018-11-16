package quanlynhahang.models.datamodels;

public class ThucDon {
    private int idThucDon;
    private String tenThucDon;
    private String moTa;
    private int gia;
    private int phanTramKhuyenMai;
    private int thu;

    public ThucDon() {
    }

    public ThucDon(int idThucDon, String tenThucDon, String moTa, int gia, int phanTramKhuyenMai, int thu) {
        this.idThucDon = idThucDon;
        this.tenThucDon = tenThucDon;
        this.moTa = moTa;
        this.gia = gia;
        this.phanTramKhuyenMai = phanTramKhuyenMai;
        this.thu = thu;
    }

    public int getIdThucDon() {
        return idThucDon;
    }

    public void setIdThucDon(int idThucDon) {
        this.idThucDon = idThucDon;
    }

    public String getTenThucDon() {
        return tenThucDon;
    }

    public void setTenThucDon(String tenThucDon) {
        this.tenThucDon = tenThucDon;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }


    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }


    public int getPhanTramKhuyenMai() {
        return phanTramKhuyenMai;
    }

    public void setPhanTramKhuyenMai(int phanTramKhuyenMai) {
        this.phanTramKhuyenMai = phanTramKhuyenMai;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }
}
