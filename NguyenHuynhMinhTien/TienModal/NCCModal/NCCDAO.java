package NCCModal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import KetNoiDB.KetNoiDB;

public class NCCDAO {
	public ArrayList<NCC> getNCC () {
		ArrayList<NCC> listNCC = new ArrayList<NCC>();
        Connection conn = null;
		KetNoiDB.getConnection();
		conn = KetNoiDB.conn;
		String sql = "SELECT * FROM NhaCungCap";
		try (PreparedStatement ps = KetNoiDB.conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					String maNCC  = rs.getString("maNCC");
					String tenNCC = rs.getString("tenNCC");
					listNCC.add(new NCC(maNCC, tenNCC));
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

        return listNCC;
	}
	
	public ArrayList<NCCThongKe> getThongKeNCC () {
		ArrayList<NCCThongKe> listNCC = new ArrayList<NCCThongKe>();
        Connection conn = null;
		KetNoiDB.getConnection();
		conn = KetNoiDB.conn;
		String sql = "SELECT NCC.maNCC, NCC.tenNCC, ISNULL(SUM(DT.soLuong), 0) AS tongSoLuong \r\n"
				+ "FROM DienThoai DT RIGHT JOIN NhaCungCap NCC ON DT.maNCC = NCC.maNCC \r\n"
				+ "GROUP BY NCC.maNCC, NCC.tenNCC";
		try (PreparedStatement ps = KetNoiDB.conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					String maNCC  = rs.getString("maNCC");
                    String tenNCC = rs.getString("tenNCC");
					long tongSoLuong = rs.getLong("tongSoLuong");
					listNCC.add(new NCCThongKe(maNCC, tenNCC, tongSoLuong));
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

        return listNCC;
	}
	
//	public static void main(String[] args) {
//		NCCBO nccBO = new NCCBO();
//		ArrayList<NCC> listNCC = nccBO.getDienThoai();
//		for (NCC ncc : listNCC) {
//			System.out.println(ncc.getMaNCC() + " - " + ncc.getTenNCC());
//		}
//	}
	
//	public static void main(String[] args) {
//		NCCBO nccBO = new NCCBO();
//		ArrayList<NCCThongKe> listNCC = nccBO.getThongKeNCC();
//		for (NCCThongKe ncc : listNCC) {
//			System.out.println(ncc.getMaNCC() + " - " + ncc.getTenNCC());
//		}
//	}
}
