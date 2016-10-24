package news.co.uk.Main;

import org.testng.annotations.Test;

public class TC4 {
	
@Test
	public void articletimestamp() throws Exception{
	Automation auto = new Automation();
	auto.launching();
	Thread.sleep(3000);
	auto.update_ps();
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
