package news.co.uk.Main;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

public class TE7 extends AppLauncher{

	@Test(priority=1)
	public void Hidesection() throws Exception{
		Automation auto = new Automation();
		auto.hide_section();
		auto.workflow_layout(12);
		auto.workflowdone_layout();
		/*auto.chromeiniti();
		auto.Edition();
		Assert.assertTrue(auto.hide_sections(),"Section is displayed");*/
	}
}
