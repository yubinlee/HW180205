import java.sql.*;

public class DAO {
	protected Connection conn;
	private static final String dburl = "jdbc:mysql://localhost:3306/BookMall";
	private static final String userid = "yubin";
	private static final String userpw = "lee";

	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				this.conn = DriverManager.getConnection(dburl, userid, userpw);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}
}
