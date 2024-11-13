package sachMODEL;

import java.util.ArrayList;

public class sachBO {
	sachDAO sDAO = new sachDAO();
	ArrayList<Sach> listSach = sDAO.getSach();
	
	public ArrayList<Sach> getListSach () {
		return listSach;
	}
	
	public ArrayList<Sach> getListSachPhanTrang(int index) {
		return sDAO.listSachPhanTrang(index);
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
	
	// từ maLoai lấy ra listSachTheoLoai
	public ArrayList<Sach> sachTheoLoai (String maLoai) {
		ArrayList<Sach> listSachTheoLoai = new ArrayList<>();
        for (Sach s : listSach) {
            if (s.getMaLoai().equals(maLoai)) {
                listSachTheoLoai.add(s);
            }
        }
        return listSachTheoLoai;
	}

	// // từ listMaSach lấy ra listSachTheoGio
	// public ArrayList<Sach> getListSachTheoGio (ArrayList<String> listMaSach) {
	// 	ArrayList<Sach> listSachTheoGio = new ArrayList<>();
	// 	for (String maSach : listMaSach) {
	// 		for (Sach s : listSach) {
	// 			if (s.getMaSach().equals(maSach)) {
	// 				listSachTheoGio.add(s);
	// 			}
	// 		}
	// 	}
	// 	return listSachTheoGio;
	// }

	// từ maSach lấy thông tin liên quan từ listSach
	public Sach getThongTinSach (String maSach) {
		Sach sachCanTim = new Sach();
		for (Sach s : listSach) {
			if (s.getMaSach().equals(maSach)) {
				sachCanTim = s;
				sachCanTim.setSoLuong(1);
			}
		}
		return sachCanTim;
	}

	// xoá sách khỏi giỏ
	public ArrayList<Sach> xoaSach (ArrayList<Sach> listSachTrongGio, String maSachCanXoa) {
		for (Sach s : listSachTrongGio) {
			if (s.getMaSach().equals(maSachCanXoa)) {
				listSachTrongGio.remove(s);
				break;
			}
		}
		return listSachTrongGio;
	}
}