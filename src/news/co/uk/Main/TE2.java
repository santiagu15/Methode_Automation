package news.co.uk.Main;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

public class TE2 extends AppLauncher{

	
	@Test(priority = 1)
	public void label_friendurl() throws Exception{
		Automation auto = new Automation();
		auto.update_ps();
		auto.q_metadata();
		Thread.sleep(3000);
		auto.adding_label();
		Thread.sleep(3000);
		auto.friendurl();
		Thread.sleep(3000);
		/*auto.chromeiniti();
		Thread.sleep(3000);
		auto.preview_publish();
		Thread.sleep(3000);
		Assert.assertTrue(auto.amazon_bucket(), "UUID is not displayed");
		Thread.sleep(3000);
		Assert.assertTrue(auto.amazon_freindurl(), "FriendlyURL is not displayed");
		Thread.sleep(3000);
		Assert.assertTrue(auto.LabelS3_bucket(), "Label is not displayed");
		Thread.sleep(3000);*/
		auto.storypreparationclose();
		Thread.sleep(3000);
		auto.templatepageclose();
		Thread.sleep(3000);
		auto.digitalpageclose();
		Thread.sleep(3000);
	/*}
		
		@Test(priority = 2)
		public void closing_windows() throws Exception{
		Automation auto = new Automation();
		auto.storypreparationclose();
		Thread.sleep(3000);
		auto.templatepageclose();
		Thread.sleep(3000);
		auto.digitalpageclose();
		Thread.sleep(3000);*/
	}
}
