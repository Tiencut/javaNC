package giohangmodal;

import java.util.ArrayList;

public class giohangBO {
	public ArrayList<hang> ds = new ArrayList<hang>();
	public void Them(String masach, String tensach, Long gia, int soLuong) {
		for (hang h : ds) {
			if (h.getMasach().equals(masach)) {
				h.setSoLuong(h.getSoLuong()+soLuong);
				return;
			}
		}
		ds.add(new hang(masach, tensach, soLuong, gia));
	}
	public void Xoa(String masach) {
		for (hang h : ds) {
			if (h.getMasach().equals(masach)) {
				ds.remove(h);
				return;
			}
		}
	}
	public long Tong() {
		long tong = 0;
		for (hang h : ds) {
			if (h.getThanhTien() != null) {
				tong += h.getThanhTien().longValue();
			}
		}
		return tong;
	}
}
