package DangNhapMODEL;

import java.util.ArrayList;

public class DangNhapBO {
 	DangNhapDAO dnDAO = new DangNhapDAO();
	ArrayList<DangNhap> listDangNhap = dnDAO.getDangNhap();
	
	public boolean checkDangNhap(String TenDangNhap, String MatKhau) {
		DangNhapDAO dnDAO = new DangNhapDAO();
		for (DangNhap dangNhap : listDangNhap) {
			if (dangNhap.getTenDangNhap().equals(TenDangNhap) && dangNhap.getMatKhau().equals(MatKhau)) {
				return true;
			}
		}
		return false;
	}
}