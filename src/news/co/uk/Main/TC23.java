package news.co.uk.Main;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

public class TC23 extends AppLauncher{
	
	@Test(priority =1)
	public void clicking_negativecropping() throws Exception{
		Automation auto = new Automation();
		auto.update_ps();
		Assert.assertTrue(auto.negative_cropping(), "Negative cropping doesn't exist and cropping not happen");
		Thread.sleep(3000);
	}
	
	@Test(priority =2)
	public void cropping_window() throws Exception{
		Automation auto = new Automation();
		Assert.assertTrue(auto.crop_window(), "Crop Alert box doesn't appear");
		Thread.sleep(3000);
	}
	
}

