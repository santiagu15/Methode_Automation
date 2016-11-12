package news.co.uk.Main;


import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

import news.co.uk.Window.NewStory;
import news.co.uk.Window.StoryPreparation;
import news.co.uk.Window.Template;

public class TC14 extends AppLauncher{
	
	@Test
	public void unlink_story() throws Exception{
		Automation auto = new Automation();
		auto.relink();
		auto.relink_confirm();
		Thread.sleep(3000);
		auto.story_creation(NewStory.RE_LINK,Template.SLICE_FRAME_X_LEAD_1_1, Template.SLICE_FRAME_Y_LEAD_1_1);
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
	}

}
