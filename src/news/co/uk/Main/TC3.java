package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

public class TC3 extends AppLauncher {

@Test
	public void ps_update() throws Exception{
		Automation auto = new Automation();
		auto.editionmetadata();
		Thread.sleep(2000);
		auto.workflow_layout();
		Thread.sleep(3000);
		auto.workflowdone_layout();
		Thread.sleep(3000);
		auto.chromeiniti();
		Thread.sleep(3000);
		auto.Edition();
		Thread.sleep(3000);
		//auto.driverclose();
	}
}
