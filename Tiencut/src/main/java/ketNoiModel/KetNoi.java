package ketNoiModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoi {
	public Connection  cn;
	public void ketNoi () {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=QlSach;user=sa;password=123;encrypt=true;trustServerCertificate=true";
			cn = DriverManager.getConnection(url);
			System.out.println("Ket noi thanh cong");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Ket noi that bat");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Ket noi that bat");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
