package sachMODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import KetNoiDB.KetNoiDB;

public class sachDAO {
	public ArrayList<Sach> getSach () {
		ArrayList<Sach> listSach = new ArrayList<Sach>();
        Connection conn = null;
		KetNoiDB.getConnection();
		conn = KetNoiDB.conn;
		String sql = "SELECT * FROM sach";
		try (PreparedStatement ps = KetNoiDB.conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
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
					listSach.add(new Sach(maSach, tenSach, soLuong, gia, maLoai, soTap, anh, ngayNhap, tacGia));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (KetNoiDB.conn != null && !KetNoiDB.conn.isClosed()) {
					KetNoiDB.conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
        return listSach;
	}
}
