package HoaDonModel;

import java.util.Date;

public class HoaDon {
    private long maHoaDon;
    private long maKH;
    private Date ngayMua;
    private boolean daMua;

    public HoaDon() {
    }

    public HoaDon(long maHoaDon, long maKH, Date ngayMua, boolean daMua) {
        this.maHoaDon = maHoaDon;
        this.maKH = maKH;
        this.ngayMua = ngayMua;
        this.daMua = daMua;
    }

    public long getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(long maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public long getMaKH() {
        return maKH;
    }

    public void setMaKH(long maKH) {
        this.maKH = maKH;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public boolean isDaMua() {
        return daMua;
    }

    public void setDaMua(boolean daMua) {
        this.daMua = daMua;
    }
}