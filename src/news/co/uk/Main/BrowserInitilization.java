package news.co.uk.Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserInitilization {
	public WebDriver driver;
	@Test
	public void chromeiniti() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sallen\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();
	}
	
	
	
}
