package DangNhapMODEL;

public class DangNhap {
	String TenDangNhap;
	String MatKhau;
	boolean Quyen;
	
	public DangNhap() {
	}
	
	public DangNhap(String tenDangNhap, String matKhau, boolean quyen) {
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		Quyen = quyen;
	}
	
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	
	public String getMatKhau() {
		return MatKhau;
	}
	
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	
	public boolean getQuyen() {
		return Quyen;
	}
	
	public void setQuyen(boolean quyen) {
		Quyen = quyen;
	}
}
