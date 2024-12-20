package KhachHangMODEL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import KetNoiDB.KetNoiDB;

public class KhachHangBO {
    KhachHangDAO khachHangDAO = new KhachHangDAO();
    ArrayList<KhachHang> listKhachHang = khachHangDAO.getKhachHang();
    
    public boolean checkLogin(String username, String password) {
        for (KhachHang khachHang : listKhachHang) {
            if (khachHang.getTenDN().equals(username) && khachHang.getPass().equals(password)) {
                return true;
            }
        }
        return false;
    }
    

    public boolean isUsernameExist(String username) {
        for (KhachHang khachHang : listKhachHang) {
            if (khachHang.getTenDN().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
	public ArrayList<KhachHang> getKhachHang() {
		return listKhachHang;
	}
    
//    public void addKhachHangMoi (String hoTen, String diaChi, String soDT, String email, String tenDN, String pass) {
//        KetNoiDB ketNoi = new KetNoiDB();
//        KetNoiDB.getConnection();
//    	
//    	String sql = "INSERT INTO KhachHang (hoTen, diaChi, soDT, email, tenDN, pass) VALUES (?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement ps = ketNoi.cn.prepareStatement(sql)) {
//            ps.setString(1, hoTen);
//            ps.setString(2, diaChi);
//            ps.setString(3, soDT);
//            ps.setString(4, email);
//            ps.setString(5, tenDN);
//            ps.setString(6, pass);
//            ps.executeUpdate();
//            response.sendRedirect("view/account.jsp");
//        } catch (SQLException e) {
//            throw new ServletException("Database error", e);
//        } finally {
//            try {
//                if (ketNoi.cn != null && !ketNoi.cn.isClosed()) {
//                    ketNoi.cn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    
}
