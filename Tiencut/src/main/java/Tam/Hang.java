package Tam;

public class Hang {
	private String tenHang;
	private int gia;
	private int soLuong;
	private int thanhTien;

	public Hang(String tenHang, int gia, int soLuong) {
		super();
		this.tenHang = tenHang;
		this.gia = gia;
		this.soLuong = soLuong;
		this.thanhTien = gia * soLuong;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenhang(String tenHang) {
		this.tenHang = tenHang;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getSoluong() {
		return soLuong;
	}

	public void setSoluong(int soluong) {
		this.soLuong = soluong;
	}

	public int getThanhtien() {
		return thanhTien;
	}

	public void setThanhtien(int thanhTien) {
		this.thanhTien = thanhTien;
	}
}