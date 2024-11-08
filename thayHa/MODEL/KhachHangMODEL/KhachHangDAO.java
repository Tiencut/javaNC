package KhachHangMODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import KetNoiDB.KetNoiDB;

public class KhachHangDAO {
    public ArrayList<KhachHang> getKhachHang() {
        ArrayList<KhachHang> listKhachHang = new ArrayList<KhachHang>();
        Connection conn = null;

        try {
            KetNoiDB.getConnection();
            conn = KetNoiDB.conn;

            String sql = "SELECT * FROM KhachHang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setMaKH(rs.getLong("makh"));
                khachHang.setHoTen(rs.getString("hoten"));
                khachHang.setDiaChi(rs.getString("diachi"));
                khachHang.setSoDT(rs.getString("sodt"));
                khachHang.setEmail(rs.getString("email"));
                khachHang.setTenDN(rs.getString("tendn"));
                khachHang.setPass(rs.getString("pass"));
                listKhachHang.add(khachHang);
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
        return listKhachHang;
    }

    public void addKhachHang () {
        Connection conn = null;

        try {
            KetNoiDB.getConnection();
            conn = KetNoiDB.conn;

            String sql = "INSERT INTO KhachHang() VALUES ()";
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
