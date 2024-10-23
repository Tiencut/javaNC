package sachModel;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ketNoiModel.KetNoi;
import loaiModel.loai;

public class sachDAO {
    public ArrayList<sach> getSach() throws Exception {
    	ArrayList<sach> ds = new ArrayList<sach>();
		KetNoi kn = new KetNoi();
		kn.ketNoi();
		String sql = "select * from loai";
		PreparedStatement ps = kn.cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maSach = rs.getString("maSach");
			String tenSach = rs.getString("tenSach");
			Long soLuong = rs.getLong("soLuong");
			Long gia = rs.getLong("gia");
			String maLoai = rs.getString("maLoai");
			String soTap = rs.getString("soTap");
			String anh = rs.getString("anh");
			Date ngayNhap = rs.getDate("ngayNhap");
			String tacGia = rs.getString("tacGia");
			ds.add(new sach(maSach, tenSach, soLuong, gia, maLoai, soTap, anh, ngayNhap, tacGia));
		}
		rs.close();
		kn.cn.close();
		return ds;
    }
}