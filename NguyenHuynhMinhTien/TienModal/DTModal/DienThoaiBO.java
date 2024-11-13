package DTModal;

import java.util.ArrayList;

public class DienThoaiBO {
	DienThoaiDAO dtDAO = new DienThoaiDAO();
	ArrayList<DienThoai> listDT = dtDAO.getDienThoai();
	
	public ArrayList<DienThoai> getListDT() {
		return listDT;
	}
	
	public ArrayList<DienThoai> getListDTSearch(String search) {
		return dtDAO.getDienThoaiTimKiemTheoTenHoacMa(search);
	}
}
