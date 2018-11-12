package quanlynhahang.models.datamodels;

public class LoaiMon {
    private int idLoaiMon;
    private String tenLoaiMon;
    private String moTa;

    public LoaiMon() {
    }

    public LoaiMon(int idLoaiMon, String tenLoaiMon, String moTa) {
        this.idLoaiMon = idLoaiMon;
        this.tenLoaiMon = tenLoaiMon;
        this.moTa = moTa;
    }

    public int getIdLoaiMon() {
        return idLoaiMon;
    }

    public void setIdLoaiMon(int idLoaiMon) {
        this.idLoaiMon = idLoaiMon;
    }

    public String getTenLoaiMon() {
        return tenLoaiMon;
    }

    public void setTenLoaiMon(String tenLoaiMon) {
        this.tenLoaiMon = tenLoaiMon;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
