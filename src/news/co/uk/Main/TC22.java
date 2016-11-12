package news.co.uk.Main;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

public class TC22 extends AppLauncher{
	
	@Test
	public void FriendlyURL() throws Exception{
		Automation auto = new Automation();
		auto.update_ps();
		auto.q_metadata();
		auto.friendurl();
		auto.chromeiniti();
		auto.preview_publish();
		auto.amazon_bucket();
		Assert.assertTrue(auto.amazon_freindurl(), "FriendlyURL is not displayed");
		auto.storypreparationclose();
		auto.templatepageclose();
		auto.digitalpageclose();
	}

}
