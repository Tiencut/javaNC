package loaiModel;

import java.util.ArrayList;

public class loaiBO {
    loaiDAO lDAO = new loaiDAO();
    ArrayList<loai> ds_loai;
    
    public ArrayList<loai> getLoai() {
    	ds_loai = lDAO.getLoai();
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
