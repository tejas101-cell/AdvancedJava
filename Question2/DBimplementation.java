package Question2;
import java.sql.*;
public class DBimplementation {
	public static void main(String[] args) throws Exception {
		DBConnection db = new DBConnection();
		
		String query = "select * from Employee";
		String query2 = "select * from Employee where empSal = (select max(empSal) from Employee)";
		Connection con = db.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		ResultSet rs2 = st.executeQuery(query2);
		while(rs2.next()) {
			System.out.println("Employee with highest salary : "+rs2.getInt(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+" "+rs2.getInt(4));
		}
		con.close();
	}
}
