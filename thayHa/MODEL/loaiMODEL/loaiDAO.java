package loaiMODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import KetNoiDB.KetNoiDB;

public class loaiDAO {
    public ArrayList<loai> getLoai() {
        ArrayList<loai> listLoai = new ArrayList<loai>();
        Connection conn = null;

        try {
            KetNoiDB.getConnection();
            conn = KetNoiDB.conn;

            String sql = "SELECT * FROM loai";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                loai l = new loai();
                l.setMaLoai(rs.getString("maLoai"));
                l.setTenLoai(rs.getString("tenLoai"));
                listLoai.add(l);
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
        return listLoai;
    }
}