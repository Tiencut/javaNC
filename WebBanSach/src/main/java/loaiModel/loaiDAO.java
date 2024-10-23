package loaiModel;

import java.util.ArrayList;

public class loaiDAO {

    public ArrayList<loai> getLoai() {
        ArrayList<loai> ds = new ArrayList<loai>();
        ds.add(new loai("cntt","Cong nghe thong tin"));
        ds.add(new loai("toan","TOÁN"));
        ds.add(new loai("ly","Lý"));
        ds.add(new loai("hoa","Hóa"));
        ds.add(new loai("sinh","SINH"));
		return ds;
    }
}