package news.co.uk.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC2 {
	
	@Test
	public void tc2() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sallen\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.get("http://cps-render-si.elb.tnl-dev.ntch.co.uk/preview/edition/d5ce3c7a-893d-11e6-8b30-b2e24c58588e?t=1476368239540");
		Thread.sleep(3000);
		String ab = driver.findElement(By.xpath("//*[@id='top']/section/header/div/time")).getText();
		System.out.println(ab);
	}
}
