package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

public class TC5 extends AppLauncher{

	@Test
	public void update_article_timestamp() throws Exception{
		Automation auto = new Automation();
		auto.update_ps();
		auto.q_metadata();
		Thread.sleep(3000);
		auto.article_timestamp();
		Thread.sleep(3000);
		auto.chromeiniti();
		Thread.sleep(3000);
		auto.preview_publish();
		Thread.sleep(3000);
		auto.storypreparationclose();
		Thread.sleep(3000);
		auto.templatepageclose();
		Thread.sleep(3000);
		auto.digitalpageclose();
		Thread.sleep(3000);
	}
	
}
