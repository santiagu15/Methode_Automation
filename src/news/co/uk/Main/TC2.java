package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

public class TC2 extends AppLauncher{
	
	@Test
	public void tc2() throws Exception{
		Automation auto = new Automation();
		auto.workflow_layout();
		Thread.sleep(2000);
		auto.workflowdone_layout();
		Thread.sleep(3000);
		auto.chromeiniti();
		Thread.sleep(3000);
		auto.Edition();
		Thread.sleep(3000);
		//auto.driverclose();
	}
}
