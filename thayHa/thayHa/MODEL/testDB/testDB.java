package testDB;

import java.util.ArrayList;

import KhachHangMODEL.KhachHang;
import KhachHangMODEL.KhachHangBO;
import loaiMODEL.loai;
import loaiMODEL.loaiBO;

public class testDB {
	static void testKhachHang() {
        KhachHangBO khBO = new KhachHangBO();
        ArrayList<KhachHang> listKH = khBO.getKhachHang();
		for (KhachHang kh : listKH) {
			System.out.println(kh.getTenDN() + " " + kh.getPass());
		}
	}
	
	public static void main(String[] args) {
		testKhachHang();
	}
}
