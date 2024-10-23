package sachModel;

import java.util.ArrayList;

public class sachBO {
	sachDAO sDAO = new sachDAO();
	ArrayList<sach> ds;
	
	public ArrayList<sach> getSach() {
		ds = sDAO.getSach();
		return ds;
	}

	public ArrayList<sach> TimMa (String maLoai) {
		ArrayList<sach> tmp = new ArrayList<sach>();
		for (sach s : ds) {
			if (s.getMaLoai().toLowerCase().trim().equals(maLoai.toLowerCase().trim())) {
				tmp.add(s);
			}
		}
		return tmp;
	}

	public ArrayList<sach> TimLoai (String key) {
		ArrayList<sach> tmp = new ArrayList<sach>();
		for (sach s : ds) {
			if (s.getMaLoai().toLowerCase().trim().equals(key.toLowerCase().trim())) {
				tmp.add(s);
			}
		}
		return tmp;
	}
}
