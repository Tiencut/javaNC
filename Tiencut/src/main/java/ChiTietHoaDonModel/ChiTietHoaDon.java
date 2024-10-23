package ChiTietHoaDonModel;

public class ChiTietHoaDon {
    private long maChiTietHD;
    private String maSach;
    private int soLuongMua;
    private long maHoaDon;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(long maChiTietHD, String maSach, int soLuongMua, long maHoaDon) {
        this.maChiTietHD = maChiTietHD;
        this.maSach = maSach;
        this.soLuongMua = soLuongMua;
        this.maHoaDon = maHoaDon;
    }

    public long getMaChiTietHD() {
        return maChiTietHD;
    }

    public void setMaChiTietHD(long maChiTietHD) {
        this.maChiTietHD = maChiTietHD;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public long getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(long maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
}