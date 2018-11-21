package quanlynhahang.models.datamodels;

public class NghiepVu {
    private int idNghiepVu;
    private String tenNghiepVu;

    public NghiepVu() {
    }

    public NghiepVu(int idNghiepVu, String tenNghiepVu) {
        this.idNghiepVu = idNghiepVu;
        this.tenNghiepVu = tenNghiepVu;
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

    /*public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }*/
}