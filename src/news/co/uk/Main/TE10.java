package news.co.uk.Main;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

import news.co.uk.Window.MainPage;

public class TE10 extends AppLauncher{

	@Test(priority =1)
	public void special_section() throws Exception{
		Automation auto = new Automation();
		auto.insert_section(1,MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		auto.scotlant(33);
		auto.selecting_buisness(MainPage.Sco_Section_X, MainPage.Sco_Section_X);
		auto.swap_section();
		Thread.sleep(3000);
		auto.section_name_change();
		Thread.sleep(3000);
		auto.workflow_layout(11);
		auto.workflowdone_layout();
		/*auto.chromeiniti();
		auto.Edition();
		Assert.assertTrue(auto.section_name(), "Style section is not displayed");
		Thread.sleep(3000);*/
	}
	
}
