package Question3;
import java.sql.*;

public class DBConnection {
	public Connection connect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.driver");
		
		String url = "jdbc:mysql://localhost:3306/demoJDBC";
		String pass = "tejas@#$";
		String user = "root";
		
		return
	}
}
