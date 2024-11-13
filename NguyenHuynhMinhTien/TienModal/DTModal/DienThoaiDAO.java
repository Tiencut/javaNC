package DTModal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import KetNoiDB.KetNoiDB;

public class DienThoaiDAO {
	public ArrayList<DienThoai> getDienThoai () {
		ArrayList<DienThoai> listDienThoai = new ArrayList<DienThoai>();
        Connection conn = null;
		KetNoiDB.getConnection();
		conn = KetNoiDB.conn;
		String sql = "SELECT * FROM DienThoai";
		try (PreparedStatement ps = KetNoiDB.conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					DienThoai dt = new DienThoai();
					String maDT  = rs.getString("maDT");
					String tenDT = rs.getString("tenDT");
					int soLuong = rs.getInt("soLuong");
					long gia 	 = rs.getLong("gia");
					String maNCC = rs.getString("maNCC");
					listDienThoai.add(new DienThoai(maDT, tenDT, soLuong, gia, maNCC));
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

        return listDienThoai;
	}

	public ArrayList<DienThoai> getDienThoaiTimKiemTheoTenHoacMa (String key) {
		ArrayList<DienThoai> listDienThoai = new ArrayList<DienThoai>();
		Connection conn = null;
		KetNoiDB.getConnection();
		conn = KetNoiDB.conn;
		String sql = "SELECT * FROM DienThoai WHERE tenDT LIKE ? OR maNCC LIKE ?";
		try (PreparedStatement ps = KetNoiDB.conn.prepareStatement(sql)) {
			ps.setString(1, "%" + key + "%");
			ps.setString(2, "%" + key + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					String maDT  = rs.getString("maDT");
					String tenDT = rs.getString("tenDT");
					int soLuong = rs.getInt("soLuong");
					long gia 	 = rs.getLong("gia");
					String maNCC = rs.getString("maNCC");
					listDienThoai.add(new DienThoai(maDT, tenDT, soLuong, gia, maNCC));
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
		
		return listDienThoai;
	}
	
	
	
//	public static void main(String[] args) {
//		DienThoaiDAO dtDAO = new DienThoaiDAO();
//        ArrayList<DienThoai> listDT = dtDAO.getSach();
//        for (DienThoai dt : listDT) {
//            System.out.println(dt.getMaDT() + " - " + dt.getTenDT() + " - " + dt.getSoLuong() + " - " + dt.getGia() + " - " + dt.getMaNCC());
//        }
//	}

	public static void main(String[] args) {
		DienThoaiDAO dtDAO = new DienThoaiDAO();
		ArrayList<DienThoai> listDT = dtDAO.getDienThoaiTimKiemTheoTenHoacMa("J");
		System.out.println(listDT.size());
		System.out.println(listDT);
	}
}
