package Question1;
import java.sql.*;
import java.util.*;

public class DBimplement {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DBconnection db = new DBconnection();
		
		Connection con = db.connect();
		
		String query = "select * from Employee";
		// Statement is also interface which is implemented by the connection object
		Statement st = con.createStatement();
		
		// resultset is an interface that is why to implement it use statement object
		ResultSet rs = st.executeQuery(query);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee id...Fetching from the database");
		int empId = sc.nextInt();
				
		while(rs.next()) {
			if(rs.getInt(1) == empId) {
				System.out.println("Employee : "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		}
	}

}
