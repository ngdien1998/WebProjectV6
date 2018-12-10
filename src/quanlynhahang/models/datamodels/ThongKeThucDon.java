package quanlynhahang.models.datamodels;

public class ThongKeThucDon {
    private String tenThucDon;
    private int soLanSuDung;

    public ThongKeThucDon() {
    }

    public ThongKeThucDon(String tenThucDon, int soLanSuDung) {
        this.tenThucDon = tenThucDon;
        this.soLanSuDung = soLanSuDung;
    }

    public String getTenThucDon() {
        return tenThucDon;
    }

    public void setTenThucDon(String tenThucDon) {
        this.tenThucDon = tenThucDon;
    }

    public int getSoLanSuDung() {
        return soLanSuDung;
    }

    public void setSoLanSuDung(int soLanSuDung) {
        this.soLanSuDung = soLanSuDung;
    }
}
