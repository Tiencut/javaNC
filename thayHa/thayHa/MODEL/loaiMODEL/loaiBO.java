package loaiMODEL;

import java.util.ArrayList;

public class loaiBO {
	loaiDAO loaiDAO = new loaiDAO();
	ArrayList<loai> listLoai = loaiDAO.getLoai();
	private ArrayList<loai> listTenLoai;
		
	public ArrayList<loai> getListTenLoai() {
		listTenLoai = new ArrayList<loai>();
		for (loai l : listLoai) {
			loai loai = new loai();
			loai.setTenLoai(l.getTenLoai());
			listTenLoai.add(loai);
		}
		return listTenLoai;
	}
}
