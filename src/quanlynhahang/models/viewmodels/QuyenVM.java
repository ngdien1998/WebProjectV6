package quanlynhahang.models.viewmodels;

public class QuyenVM {
    private int idQuyen;
    private String tenQuyen;
    private String moTa;
    private boolean duocCap;

    public QuyenVM() {
    }

    public QuyenVM(int idQuyen, String tenQuyen, String moTa, boolean duocCap) {
        this.idQuyen = idQuyen;
        this.tenQuyen = tenQuyen;
        this.moTa = moTa;
        this.duocCap = duocCap;
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

    public boolean isDuocCap() {
        return duocCap;
    }

    public void setDuocCap(boolean duocCap) {
        this.duocCap = duocCap;
    }
}
