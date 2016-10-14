package news.co.uk.Main;

import org.testng.annotations.Test;

public class TC1 {
	
	@Test
	public void tc1() throws Exception{
		Automation auto = new Automation();
		auto.launching();
		Thread.sleep(3000);
		auto.PublishingSystem();
		Thread.sleep(3000);
		auto.login();
		Thread.sleep(3000);
		auto.mod();
		Thread.sleep(3000);
		auto.create_pp();
		Thread.sleep(3000);
		auto.openpp();
		Thread.sleep(3000);
		auto.digital();
		Thread.sleep(3000);
		auto.date_select();
		Thread.sleep(3000);
		auto.slot_selection();
		Thread.sleep(3000);
		auto.pageplan();
		Thread.sleep(3000);
		auto.selecting_buisness();
		Thread.sleep(3000);
		auto.candidate_browser();
		Thread.sleep(3000);
		auto.template_selection();
		Thread.sleep(3000);
		auto.story_creation();
		Thread.sleep(3000);
		auto.channelcopy();
		Thread.sleep(3000);
		auto.preparing_story();
		Thread.sleep(3000);
		auto.preview_publish();
		Thread.sleep(3000);
		auto.amazon_bucket();
		Thread.sleep(3000);
		auto.close_window();
		Thread.sleep(3000);
		auto.confirm_popup();
		Thread.sleep(3000);
	}
	
}
