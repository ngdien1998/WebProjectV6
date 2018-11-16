package quanlynhahang.models.datamodels;

public class Quyen {
    private int idQuyen;
    private String tenQuyen;
    private String moTa;
    private int idNghiepVu;

    public Quyen() {
    }

    public Quyen(int idQuyen, String tenQuyen, String moTa, int idNghiepVu) {
        this.idQuyen = idQuyen;
        this.tenQuyen = tenQuyen;
        this.moTa = moTa;
        this.idNghiepVu = idNghiepVu;
    }

    public int getIdQuyen() {
        return idQuyen;
    }

    public void setIdQuyen(int idQuyen) {
        this.idQuyen = idQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getIdNghiepVu() {
        return idNghiepVu;
    }

    public void setIdNghiepVu(int idNghiepVu) {
        this.idNghiepVu = idNghiepVu;
    }
}