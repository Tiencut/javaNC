package sachModal;

import java.util.ArrayList;

public class sachDAO {
    public ArrayList<sach> getSach() {
    	ArrayList<sach> ds = new ArrayList<sach>();
    	ds.add(new sach("s1", "CTDL 1", "Le lai", (long)10000, (long)2, "image_sach/b1.jpg", "cntt"));
    	ds.add(new sach("s2", "CTDL 2", "Le lai", (long)10000, (long)2, "image_sach/b2.jpg", "cntt"));
    	ds.add(new sach("s3", "CTDL 3", "Le lai", (long)10000, (long)2, "image_sach/b3.jpg", "cntt"));
    	ds.add(new sach("s4", "Giai tich", "Le lai", (long)10000, (long)2, "image_sach/b4.jpg", "toan"));
    	ds.add(new sach("s5", "CTDL 5", "Le lai", (long)10000, (long)2, "image_sach/b5.jpg", "toan"));
    	ds.add(new sach("s6", "CTDL 6", "Le lai", (long)10000, (long)2, "image_sach/b6.jpg", "ly"));
    	ds.add(new sach("s7", "CTDL 7", "Le lai", (long)10000, (long)2, "image_sach/b7.jpg", "sinh"));
        return ds;
    }
}
