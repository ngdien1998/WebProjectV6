package quanlynhahang.models.datamodels;

public class LoaiBaiViet {
    private int idLoaiBaiViet;
    private String tenLoaiBaiViet;
    private String moTa;

    public LoaiBaiViet() {
    }

    public LoaiBaiViet(int idLoaiBaiViet, String tenLoaiBaiViet, String moTa) {
        this.idLoaiBaiViet = idLoaiBaiViet;
        this.tenLoaiBaiViet = tenLoaiBaiViet;
        this.moTa = moTa;
    }

    public int getIdLoaiBaiViet() {
        return idLoaiBaiViet;
    }

    public void setIdLoaiBaiViet(int idLoaiBaiViet) {
        this.idLoaiBaiViet = idLoaiBaiViet;
    }

    public String getTenLoaiBaiViet() {
        return tenLoaiBaiViet;
    }

    public void setTenLoaiBaiViet(String tenLoaiBaiViet) {
        this.tenLoaiBaiViet = tenLoaiBaiViet;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
