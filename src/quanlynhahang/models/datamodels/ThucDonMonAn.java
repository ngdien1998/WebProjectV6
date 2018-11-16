package quanlynhahang.models.datamodels;

public class ThucDonMonAn {
    private int IDMonAn;
    private int IDThucDon;

    public ThucDonMonAn() {
    }

    public ThucDonMonAn(int IDMonAn, int IDThucDon) {
        this.IDMonAn = IDMonAn;
        this.IDThucDon = IDThucDon;
    }

    public int getIDMonAn() {
        return IDMonAn;
    }

    public void setIDMonAn(int IDMonAn) {
        this.IDMonAn = IDMonAn;
    }

    public int getIDThucDon() {
        return IDThucDon;
    }

    public void setIDThucDon(int IDThucDon) {
        this.IDThucDon = IDThucDon;
    }
}
