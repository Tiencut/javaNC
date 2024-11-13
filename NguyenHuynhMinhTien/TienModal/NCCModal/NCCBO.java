package NCCModal;

import java.util.ArrayList;

public class NCCBO {
	NCCDAO nccDAO = new NCCDAO();
	ArrayList<NCC> listNCC = nccDAO.getNCC();

	public ArrayList<NCC> getNCC() {
		return listNCC;
	}
	
	public ArrayList<NCCThongKe> getThongKeNCC() {
		return nccDAO.getThongKeNCC();
	}	
}