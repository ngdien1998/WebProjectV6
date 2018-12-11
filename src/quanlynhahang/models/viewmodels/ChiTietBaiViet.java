package quanlynhahang.models.viewmodels;

public class ChiTietBaiViet {
    private int idBaiViet;
    private String tenBaiViet;
    private String thoiGianViet;
    private String nguoiViet;
    private String moTa;
    private String noiDung;
    private int idLoaiBaiViet;
    private String loaiBaiViet;

    public ChiTietBaiViet() {
    }

    public ChiTietBaiViet(int idBaiViet, String tenBaiViet, String thoiGianViet, String nguoiViet, String moTa, String noiDung, int idLoaiBaiViet, String loaiBaiViet) {
        this.idBaiViet = idBaiViet;
        this.tenBaiViet = tenBaiViet;
        this.thoiGianViet = thoiGianViet;
        this.nguoiViet = nguoiViet;
        this.moTa = moTa;
        this.noiDung = noiDung;
        this.idLoaiBaiViet = idLoaiBaiViet;
        this.loaiBaiViet = loaiBaiViet;
    }

    public int getIdBaiViet() {
        return idBaiViet;
    }

    public void setIdBaiViet(int idBaiViet) {
        this.idBaiViet = idBaiViet;
    }

    public String getTenBaiViet() {
        return tenBaiViet;
    }

    public void setTenBaiViet(String tenBaiViet) {
        this.tenBaiViet = tenBaiViet;
    }

    public String getThoiGianViet() {
        return thoiGianViet;
    }

    public void setThoiGianViet(String thoiGianViet) {
        this.thoiGianViet = thoiGianViet;
    }

    public String getNguoiViet() {
        return nguoiViet;
    }

    public void setNguoiViet(String nguoiViet) {
        this.nguoiViet = nguoiViet;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getIdLoaiBaiViet() {
        return idLoaiBaiViet;
    }

    public void setIdLoaiBaiViet(int idLoaiBaiViet) {
        this.idLoaiBaiViet = idLoaiBaiViet;
    }


    public String getLoaiBaiViet() {
        return loaiBaiViet;
    }

    public void setLoaiBaiViet(String loaiBaiViet) {
        this.loaiBaiViet = loaiBaiViet;
    }
}