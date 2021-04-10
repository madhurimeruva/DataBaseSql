import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqlConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String host = "localhost";
		String port = "3306";

		Connection con = DriverManager.getConnection("Jdbc:mysql://" + host + ":" + port + "/qadbt", "root",
				"madhu1@sql");

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select * from Employeeinfo where name = 'madhu'");

		while (rs.next()) {
			System.out.println(rs.getString("location"));
			System.out.println(rs.getString("age"));
		}

	}

}
