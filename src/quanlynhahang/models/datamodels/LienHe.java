package quanlynhahang.models.datamodels;
import java.sql.Array;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class LienHe {
    private  int idLienHe;
    private String email;
    private String hoTen;
    private String soDT;
    private String noiDung;
    private Date thoiGian;
    private boolean trangThaiSeen;

    public LienHe(){

    }

    public LienHe(int idLienHe, String email, String hoTen, String soDT, String noiDung, Date thoiGian, boolean trangThaiSeen) {
        this.idLienHe = idLienHe;
        this.email = email;
        this.hoTen = hoTen;
        this.soDT = soDT;
        this.noiDung = noiDung;
        this.thoiGian = thoiGian;
        this.trangThaiSeen = trangThaiSeen;
    }

    public int getIdLienHe() {
        return idLienHe;
    }

    public void setIdLienHe(int idLienHe) {
        this.idLienHe = idLienHe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public boolean isTrangThaiSeen() {
        return trangThaiSeen;
    }

    public void setTrangThaiSeen(boolean trangThaiSeen) {
        this.trangThaiSeen = trangThaiSeen;
    }
}

