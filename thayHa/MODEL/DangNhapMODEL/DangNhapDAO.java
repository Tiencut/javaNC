package DangNhapMODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import KetNoiDB.KetNoiDB;

public class DangNhapDAO {
	public ArrayList<DangNhap> getDangNhap() {
		ArrayList<DangNhap> listDangNhap = new ArrayList<>();
		Connection conn = null;
		
        try {
            KetNoiDB.getConnection();
            conn = KetNoiDB.conn;

            String sql = "SELECT * FROM DangNhap";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DangNhap dangNhap = new DangNhap();
                dangNhap.setTenDangNhap(rs.getString("TenDangNhap"));
                dangNhap.setMatKhau(rs.getString("MatKhau"));
                dangNhap.setQuyen(rs.getBoolean("Quyen"));
                listDangNhap.add(dangNhap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("Dong ket noi thanh cong");
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
		
		return listDangNhap;
	}
}
