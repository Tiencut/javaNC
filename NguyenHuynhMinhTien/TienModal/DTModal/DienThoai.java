package DTModal;

public class DienThoai {
	private String maDT;
	private String tenDT;
	private int soLuong;
	private long gia;
	private String maNCC;
	
	public DienThoai() {
		super();
	}

	public DienThoai(String maDT, String tenDT, int soLuong, long gia, String maNCC) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.soLuong = soLuong;
		this.gia = gia;
		this.maNCC = maNCC;
	}

	public String getMaDT() {
		return maDT;
	}

	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
}
