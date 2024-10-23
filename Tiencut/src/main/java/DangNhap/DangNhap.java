package DangNhap;

public class DangNhap {
    private String tenDangNhap;
    private String matKhau;
    private boolean quyen;

    public DangNhap() {
    }

    public DangNhap(String tenDangNhap, String matKhau, boolean quyen) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.quyen = quyen;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isQuyen() {
        return quyen;
    }

    public void setQuyen(boolean quyen) {
        this.quyen = quyen;
    }
}