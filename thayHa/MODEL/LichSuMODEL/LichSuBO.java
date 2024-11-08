package LichSuMODEL;

import java.util.ArrayList;

public class LichSuBO {
	LichSuDAO  lichSuDAO = new LichSuDAO();

	public ArrayList<LichSu> getLichSu (long makh, int damua) {
		ArrayList<LichSu> listLichSu = lichSuDAO.getLichSu(makh, damua);
		return listLichSu;
    }
	
	public void displayLichSu () {
		ArrayList<LichSu> listLichSu = lichSuDAO.getLichSu(20, 1);
		for (LichSu lichSu : listLichSu) {
			System.out.println(lichSu.getMakh() + " " + lichSu.getTensach() + " " + lichSu.getSoLuongMua() + " " + lichSu.getGia() + " " + lichSu.getThanhTien() + " " + lichSu.getNgayMua() + " " + lichSu.isDamua());
		}
	}

//	public static void main(String[] args) {
//		LichSuBO lichSuBO = new LichSuBO();
//		lichSuBO.displayLichSu();
//	}
}
