package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

import news.co.uk.Window.MainPage;
import news.co.uk.Window.NewStory;
import news.co.uk.Window.StoryPreparation;
import news.co.uk.Window.Template;

public class TE1 extends AppLauncher{
	@Test(priority = 1)
	public void Publishing_system() throws Exception {
		Automation auto = new Automation();
		auto.app_open();
		Thread.sleep(2000);
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
		auto.selecting_buisness(MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		Thread.sleep(3000);
		auto.open_section(MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		Thread.sleep(3000);
		auto.candidate_browser();
		Thread.sleep(3000);
		auto.template_selection_lead_1_and_1();
		Thread.sleep(3000);
		auto.selecting_template(Template.SLICE_FRAME_X_LEAD_1_1,Template.SLICE_FRAME_Y_LEAD_1_1);
		Thread.sleep(3000);
		auto.story_creation(NewStory.STORY_1,Template.SLICE_FRAME_X_LEAD_1_1, Template.SLICE_FRAME_Y_LEAD_1_1);
		Thread.sleep(3000);
		auto.channelcopy();
		Thread.sleep(3000);
		auto.preparing_story(StoryPreparation.HEADLINE_STORY1,1,StoryPreparation.IMAGE_1_Y);
		Thread.sleep(3000);
/*		auto.chromeiniti();
		Thread.sleep(3000);
		auto.preview_publish();*/
		auto.storypreparationclose();
		Thread.sleep(3000);
		auto.templatepageclose();
		Thread.sleep(3000);
		auto.digitalpageclose();
		Thread.sleep(3000);
	}
	/*@Test(priority=2)
	public void closing() throws Exception{
	Automation auto = new Automation();
	auto.storypreparationclose();
	Thread.sleep(3000);
	auto.templatepageclose();
	Thread.sleep(3000);
	auto.digitalpageclose();
	Thread.sleep(3000);
}*/
}
