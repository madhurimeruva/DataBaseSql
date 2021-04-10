import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {


	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/guru", "root", "madhu1@sql");

		System.out.println("connected to database");

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select * from LoginInfo");

		while (rs.next()) {

			String user = rs.getString("username");

			String password = rs.getString("password");

			System.setProperty("webdriver.chrome.driver", "C:\\chrome_driver1\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.get("http://demo.guru99.com/V4/");

			driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(user);

			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

			driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

			System.out.println(user + " | " + password + " |");

			driver.quit();
		}
		System.out.println();
	}

}


