package loaiModel;

import java.util.ArrayList;

public class loaiBO {
    loaiDAO lDAO = new loaiDAO();
    ArrayList<loai> ds_loai;
    
    public ArrayList<loai> getLoai() {
    	try {
			ds_loai = lDAO.getLoai();
			for (loai l : ds_loai) {
				System.out.println(l.getMaLoai() + " " + l.getTenLoai());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ds_loai;
    }
    
    public loai getLoaiById(String maLoai) {
        for (loai l : getLoai()) {
            if (l.getMaLoai().equals(maLoai)) {
                return l;
            }
        }
        return null;
    }
}
