package loaiModal;

import java.util.ArrayList;

public class loaiBO {
    loaiDAO lDAO = new loaiDAO();
    
    public ArrayList<loai> getLoai() {
        return lDAO.getLoai();
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
