package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

public class TE8 extends AppLauncher{
	
	@Test(priority =1)
	public void Edition_update_9AM() throws Exception{
		Automation auto = new Automation();
		auto.editionmetadata();
		Thread.sleep(2000);
		auto.workflow_layout(12);
		Thread.sleep(3000);
		auto.workflowdone_layout();
		Thread.sleep(3000);
		/*auto.chromeiniti();
		Thread.sleep(3000);
		auto.Edition();
		Thread.sleep(3000);*/
		//auto.driverclose();
	}

}
