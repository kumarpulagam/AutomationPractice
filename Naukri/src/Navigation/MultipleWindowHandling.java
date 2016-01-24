package Navigation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleWindowHandling {
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://www.naukri.com/");
	}
	
	@Test
	public void multiplewindowTest() throws InterruptedException
	{
		driver.findElement(By.xpath("html/body/div[1]/div/ul[1]/li[5]/a")).click();
		Thread.sleep(5000);
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		
		String main = it.next();
		it.next();
		it.next();
		String second = it.next();
		
		driver.switchTo().window(second);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='_globalNav']/ul/li[3]/a")).click();
		Thread.sleep(3000);
		driver.switchTo().window(main);
				
	}
	@AfterTest
	public void closeAll()
	{
		driver.quit();
	}

}
