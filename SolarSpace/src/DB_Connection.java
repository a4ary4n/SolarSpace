import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
	private static final String SERVERNAME = "localhost";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "pass";
	private static final String CONN_STRING = 
			"jdbc:mysql://localhost:3306/solarspace";
	
	public static Connection getConnection() {
		Connection conn = null;
		//MysqlDataSource datasource = new MysqlDataSource();
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(CONN_STRING, 
					USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.err.println(e);
		}
		return conn;
		
	}

}
