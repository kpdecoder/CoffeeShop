package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import com.mysql.jdb.Driver;
public class DBConfig {

	private final String CONNECTION = "jdbc:mysql://localhost:3306/coffee?";
	private final String PASSWORD = "root";
	private final String USERNAME = "root";
	private static Connection con = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		if (con == null) {
			con = (Connection) DriverManager.getConnection(this.CONNECTION, this.USERNAME, this.PASSWORD);
		}
		System.out.print(con);
		return con;
	}
}

