package NCCModal;

public class NCCThongKe {
	private String maNCC;
	private String tenNCC;
	private long tongSoLuong;
	
	public NCCThongKe() {
		super();
	}
	
	public NCCThongKe(String maNCC, String tenNCC, long tongSoLuong) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.tongSoLuong = tongSoLuong;
	}
	
	public String getMaNCC() {
		return maNCC;
	}
	
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	
	public String getTenNCC() {
		return tenNCC;
	}
	
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public long getTongSoLuong() {
		return tongSoLuong;
	}

	public void setTongSoLuong(long tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}
}
