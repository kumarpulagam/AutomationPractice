package Navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://www.naukri.com/");
	}
	
	@Test
	public void loginTest()
	{
		driver.findElement(By.xpath("//*[@id='login_Layer']")).click();
		driver.findElement(By.id("eLogin")).sendKeys("yessu_91@yahoo.com");
		driver.findElement(By.id("pLogin")).sendKeys("essu");
		driver.findElement(By.xpath("//*[@id='lgnFrm']/div[7]/button")).click();
	}
	
	@AfterTest
	public void closeSetup()
	{
		//driver.close();
	}
}
