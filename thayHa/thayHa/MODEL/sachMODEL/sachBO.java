package sachMODEL;

import java.util.ArrayList;

public class sachBO {
	sachDAO sDAO = new sachDAO();
	ArrayList<Sach> listSach = sDAO.getSach();
	
	public ArrayList<Sach> getListSach () {
		return listSach;
	}
	
	public ArrayList<Sach> TimSachTheoMaSach(String maSach) {
		ArrayList<Sach> listSachCanTimTheoMaSach = new ArrayList<>();
		for (Sach s : listSach) {
			if (s.getMaSach().toLowerCase().contains(maSach.toLowerCase())) {
				listSachCanTimTheoMaSach.add(s);
			}
		}
		return listSachCanTimTheoMaSach;
	}
	
	public ArrayList<Sach> sachTheoLoai (String maLoai) {
		ArrayList<Sach> listSachTheoLoai = new ArrayList<>();
        for (Sach s : listSach) {
            if (s.getMaLoai().equals(maLoai)) {
                listSachTheoLoai.add(s);
            }
        }
        return listSachTheoLoai;
	}
}