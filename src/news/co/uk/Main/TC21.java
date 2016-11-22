package news.co.uk.Main;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

public class TC21 extends AppLauncher{
	
	@Test
	public void Hidesection() throws Exception{
		Automation auto = new Automation();
		auto.hide_section();
		//auto.workflow_layout();
		auto.workflowdone_layout();
		auto.chromeiniti();
		auto.Edition();
		Assert.assertTrue(auto.hide_sections(),"Section is displayed");
	}

}
