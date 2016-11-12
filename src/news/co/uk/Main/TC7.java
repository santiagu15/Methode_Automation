package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

public class TC7 extends AppLauncher{
	
	@Test
	public void article_preview() throws Exception{
		Automation auto = new Automation();
		auto.update_ps();
		Thread.sleep(3000);
		auto.chromeiniti();
		Thread.sleep(3000);
		auto.q_metadata();
		Thread.sleep(3000);
		auto.adding_label();
		Thread.sleep(2000);
		auto.preview();
		Thread.sleep(3000);
		auto.storypreparationclose();
		Thread.sleep(3000);
		auto.templatepageclose();
		Thread.sleep(3000);
		auto.digitalpageclose();
		Thread.sleep(3000);
	}

}
