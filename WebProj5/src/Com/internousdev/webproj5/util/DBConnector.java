package Com.internousdev.webproj5.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	/*JDBCドライバー名 */
	private static String driverName ="com.mysql.jdbc.Driver";
	
	/*データーベース接続URL */
	private static String url="jdbc:mysql://localhost/testdb";
	
	/*データーベース接続ユーザー名*/
	private static String user ="root";
	
	/*データーベース接続パスワード*/
	private static String password = "mysql";
	
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,password);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
