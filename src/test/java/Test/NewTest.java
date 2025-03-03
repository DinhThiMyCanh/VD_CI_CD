package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;

	@Test(priority = 1)
	public void loginValid() {
		driver.get("http://practice.bpbonline.com");
		
		driver.findElement(By.linkText("My Account")).click();
		
		driver.findElement(By.name("email_address")).sendKeys("bpb@bpb.com");
		driver.findElement(By.name("password")).sendKeys("bpb@123");
		// Tìm và click Sign in
		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
		//driver.findElement(By.id("tdb5")).click();

		if (driver.getPageSource().contains("My Account Information")) {
			
			driver.findElement(By.linkText("Log Off"));
			driver.findElement(By.id("tdb4")).click();// nút Continue
			
			//Nhật ký đăng nhập thành công
			Reporter.log("User information is valid");
			
		} else {
			//Nhật ký đăng nhập không thành công
			Reporter.log("User information is invalid");
			
		}
	}
	
//First Commit, Second commit, three commint, five commit
	@BeforeMethod
	public void setupBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}

}
