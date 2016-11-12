package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

public class TC19 extends AppLauncher{
	
	@Test
	public void label() throws Exception{
		Automation auto = new Automation();
		auto.update_ps();
		auto.q_metadata();
		Thread.sleep(3000);
		auto.adding_label();
		Thread.sleep(3000);
		auto.chromeiniti();
		Thread.sleep(3000);
		auto.preview_publish();
		Thread.sleep(3000);
		auto.LabelS3_bucket();
		Thread.sleep(3000);
		auto.storypreparationclose();
		Thread.sleep(3000);
		auto.templatepageclose();
		Thread.sleep(3000);
		auto.digitalpageclose();
		Thread.sleep(3000);
	}
	

}
