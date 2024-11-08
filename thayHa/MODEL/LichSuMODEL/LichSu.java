package LichSuMODEL;

import java.util.Date;

public class LichSu {
	private long makh;
	private String tensach;
	private int SoLuongMua;
	private long gia;
	private long thanhTien;
	private Date NgayMua;
	private int damua;
	
	public LichSu() {
		super();
	}

	public LichSu(long makh, String tensach, int SoLuongMua, long gia, long thanhTien, Date ngayMua, int damua) {
		super();
		this.makh = makh;
		this.tensach = tensach;
		this.SoLuongMua = SoLuongMua;
		this.gia = gia;
		this.thanhTien = thanhTien;
		NgayMua = ngayMua;
		this.damua = damua;
	}

	public long getMakh() {
		return makh;
	}

	public void setMakh(long makh) {
		this.makh = makh;
	}

	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public int getSoLuongMua() {
		return SoLuongMua;
	}

	public void setSoLuongMua(int SoLuongMua) {
		this.SoLuongMua = SoLuongMua;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}

	public Date getNgayMua() {
		return NgayMua;
	}

	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}

	public int isDamua() {
		return damua;
	}

	public void setDamua(int damua) {
		this.damua = damua;
	}
}
