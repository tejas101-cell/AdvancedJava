package Question1;
import java.io.IOException;
import java.sql.*;
public class DBconnection {
	
	public Connection connect() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/demoJDBC";
		String user = "root";
		String pass = "tejas@#$";
		
		// Connection is also an interface it is implemented with the DriverManager class
		Connection con = DriverManager.getConnection(url, user, pass);
		
		if(con != null) {
			System.out.println("connection is successful");
			return con;
		}
		return null;
	}
	
}
