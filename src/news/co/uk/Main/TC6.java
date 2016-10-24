package news.co.uk.Main;

import org.testng.annotations.Test;

public class TC6 {
	
	@Test
	public void currenttimestamp() throws Exception{
		Automation auto = new Automation();
		auto.launching();
		Thread.sleep(3000);
		//auto.update_ps();
		auto.q_metadata();
		Thread.sleep(3000);
		auto.currentimestamp();
		auto.chromeiniti();
		auto.preview_publish();
		auto.storypreparationclose();
		Thread.sleep(3000);
		auto.templatepageclose();
		Thread.sleep(3000);
		auto.digitalpageclose();
		Thread.sleep(3000);
	}
	
	
	
}
