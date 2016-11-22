package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

import news.co.uk.Window.MainPage;
import news.co.uk.Window.NewStory;
import news.co.uk.Window.StoryPreparation;
import news.co.uk.Window.Template;

public class TC11 extends AppLauncher{
	
	@Test
	public void scotland_section() throws Exception{
		Automation auto = new Automation();
		//auto.insert_section(1);
		auto.scotlant(8);
		auto.selecting_buisness(MainPage.Sco_Section_X, MainPage.Sco_Section_X);
		auto.swap_section();
		auto.open_section(MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		Thread.sleep(3000);
		auto.candidate_browser();
		Thread.sleep(3000);
		auto.template_selection_lead_1_and_1();
		Thread.sleep(3000);
		auto.selecting_template(Template.SLICE_FRAME_X_LEAD_1_1,Template.SLICE_FRAME_Y_LEAD_1_1);
		Thread.sleep(3000);
		auto.story_creation(NewStory.SCOT_STORY,Template.SLICE_FRAME_X_LEAD_1_1, Template.SLICE_FRAME_Y_LEAD_1_1);
		Thread.sleep(3000);
		auto.channelcopy();
		Thread.sleep(3000);
		auto.preparing_story(StoryPreparation.HEADLINE_STORY1,1,StoryPreparation.IMAGE_1_Y);
		Thread.sleep(3000);
		auto.chromeiniti();
		Thread.sleep(3000);
		auto.preview_publish();
		Thread.sleep(3000);
		auto.amazon_bucket();
		Thread.sleep(3000);
		auto.storypreparationclose();
		Thread.sleep(3000);
		auto.templatepageclose();
		Thread.sleep(3000);
		auto.digitalpageclose();
		Thread.sleep(3000);
		/*auto.chromeiniti();
		Thread.sleep(3000);
		auto.Edition();*/
	}

}
