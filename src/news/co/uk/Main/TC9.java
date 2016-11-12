package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

import news.co.uk.Window.MainPage;
import news.co.uk.Window.NewStory;
import news.co.uk.Window.StoryPreparation;
import news.co.uk.Window.Template;

public class TC9 extends AppLauncher{
	
	@Test
	public void lead1_1() throws Exception{
		
		Automation auto = new Automation();
		auto.open_section(MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		Thread.sleep(3000);
		auto.selecting_template(Template.SLICE_FRAME_X_LEAD_1_1,Template.SLICE_FRAME_Y_LEAD_1_1);
		Thread.sleep(3000);
		auto.story_creation(NewStory.STORY_2, Template.SLICE_FRAME_X_LEAD_1_1_2, Template.SLICE_FRAME_Y_LEAD_1_1_2);
		Thread.sleep(3000);
		auto.channelcopy();
		Thread.sleep(3000);
		auto.preparing_story(StoryPreparation.HEADLINE_STORY2, 2, StoryPreparation.IMAGE_2_Y);
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
	}

}
