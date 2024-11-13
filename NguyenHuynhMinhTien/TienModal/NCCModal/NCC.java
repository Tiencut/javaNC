package NCCModal;

public class NCC {
	private String maNCC;
	private String tenNCC;
	
	public NCC() {
		super();
	}
	
	public NCC(String maNCC, String tenNCC) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
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
}
