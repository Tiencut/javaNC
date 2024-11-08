package LichSuMODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoiDB.KetNoiDB;

public class LichSuDAO {
	ArrayList<LichSu> getLichSu (long makh, int damua) {
		ArrayList<LichSu> listLichSu = new ArrayList<LichSu>();
		Connection conn = null;
		
		try {
			KetNoiDB.getConnection();
			conn = KetNoiDB.conn;
			
			String sql = "SELECT * FROM View_LichSuMuaHang WHERE makh=? and damua = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, makh);
			ps.setInt(2, damua);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LichSu lichSu = new LichSu();
				lichSu.setMakh(rs.getLong("makh"));
				lichSu.setTensach(rs.getString("tensach"));
				lichSu.setSoLuongMua(rs.getInt("SoLuongMua"));
				lichSu.setGia(rs.getLong("gia"));
				lichSu.setThanhTien(rs.getLong("thanhTien"));
				lichSu.setNgayMua(rs.getDate("NgayMua"));
				lichSu.setDamua(rs.getInt("damua"));
				listLichSu.add(lichSu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
					System.out.println("Dong ket noi thanh cong");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return listLichSu;
	}
}
