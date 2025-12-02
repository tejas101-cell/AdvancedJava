package Question2;
import java.sql.*;
public class DBConnection {
	public Connection connect() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/demoJDBC";
		String user = "root";
		String pass = "tejas@#$";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		if(con != null) {
			System.out.println("Connection is successful");
			return con;
		}
		return null;
	}
}
