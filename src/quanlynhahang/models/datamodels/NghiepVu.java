package quanlynhahang.models.datamodels;

public class NghiepVu {
    private int idNghiepVu;
    private String tenNghiepVu;
    private String moTa;

    public NghiepVu() {
    }

    public NghiepVu(int idNghiepVu, String tenNghiepVu, String moTa) {
        this.idNghiepVu = idNghiepVu;
        this.tenNghiepVu = tenNghiepVu;
        this.moTa = moTa;
    }

    public int getIdNghiepVu() {
        return idNghiepVu;
    }

    public void setIdNghiepVu(int idNghiepVu) {
        this.idNghiepVu = idNghiepVu;
    }

    public String getTenNghiepVu() {
        return tenNghiepVu;
    }

    public void setTenNghiepVu(String tenNghiepVu) {
        this.tenNghiepVu = tenNghiepVu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}