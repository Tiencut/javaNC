package KetNoiDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoiDB {
	public static Connection conn;
	
	public static void getConnection() {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	String url = "jdbc:sqlserver://localhost:1433;databaseName=NguyenHuynhMinhTien;user=sa;password=123;encrypt=true;trustServerCertificate=true";
            conn = DriverManager.getConnection(url);
            System.out.println("Ket noi thanh cong");
            } catch (Exception e) {
            	System.out.println("Ket noi that bai");
            	e.printStackTrace();
            }
	}
}
