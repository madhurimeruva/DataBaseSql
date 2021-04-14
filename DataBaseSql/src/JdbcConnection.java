import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Connection;
public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String host = "localhost";
		String port = "3306";
		Connection con = (Connection) DriverManager.getConnection("Jdbc:mysql://" + host + ":" + port + "/mycategories",
				"root", "madhu1@sql");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from categories where sno = '6'");
		System.out.println("The result set is :" + rs);
		while (rs.next()) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\chrome_driver1\\\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(rs.getString("CategoryName"));
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(rs.getString("Description"));
			System.out.println(rs.getString("CategoryID"));
			System.out.println(rs.getString("CategoryName"));
			//System.out.println(rs.getString("Description"));

			driver.findElement(By.cssSelector("#Login")).click();
			driver.close();

		}

	}
}
