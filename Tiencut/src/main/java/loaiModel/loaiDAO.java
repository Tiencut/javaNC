package loaiModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModel.KetNoi;

public class loaiDAO {

	public ArrayList<loai> getLoai() throws Exception {
		ArrayList<loai> ds = new ArrayList<loai>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from loai";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maLoai = rs.getString("maLoai");
			String tenLoai = rs.getString("tenLoai");
			ds.add(new loai(maLoai, tenLoai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}