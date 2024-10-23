package sachModel;

import java.util.ArrayList;

public class sachDAO {
    public ArrayList<sach> getSach() {
    	ArrayList<sach> ds = new ArrayList<sach>();
    	ds.add(new sach("s1", "cnt", 10L, 100000L, "cntt", "1", "a1.jpg", null, "Tac gia 1"));
    	ds.add(new sach("s2", "toan", 20L, 200000L, "toan", "2", "a3.jpg", null, "Tac gia 2"));
        return ds;
    }
}