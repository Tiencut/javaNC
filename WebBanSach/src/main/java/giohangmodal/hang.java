package giohangmodal;

public class hang {
	public String masach;
	public String tensach;
	public int soLuong;
	public Long gia;
	public Long thanhTien;

//
	public hang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public hang(String masach, String tensach, int soLuong, Long gia) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.soLuong = soLuong;
		this.gia = gia;
	}

	//
	public String getMasach() {
		return masach;
	}

	public void setMasach(String masach) {
		this.masach = masach;
	}

	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Long getGia() {
		return gia;
	}

	public void setGia(Long gia) {
		this.gia = gia;
	}

	public Long getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(Long thanhTien) {
		this.thanhTien = thanhTien;
	}
}