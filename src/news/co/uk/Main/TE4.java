package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

import news.co.uk.Window.NewStory;
import news.co.uk.Window.StoryPreparation;
import news.co.uk.Window.Template;

public class TE4 extends AppLauncher{
	
	@Test
	public void dummy_Unlink() throws Exception{
		Automation auto = new Automation();
		auto.relink();
		auto.relink_confirm();
		Thread.sleep(3000);
		/*auto.chromeiniti();
		Thread.sleep(3000);
		auto.template_preview();
		Thread.sleep(3000);
		auto.dummy();*/
		auto.story_creation(NewStory.RE_LINK,Template.SLICE_FRAME_X_LEAD_1_1_2, Template.SLICE_FRAME_Y_LEAD_1_1_2);
		Thread.sleep(3000);
		auto.channelcopy();
		Thread.sleep(3000);
		auto.preparing_story(StoryPreparation.HEADLINE_STORY4,1,StoryPreparation.IMAGE_2_Y);
		Thread.sleep(3000);
		auto.storypreparationclose();
		Thread.sleep(3000);
		/*auto.chromeiniti();
		Thread.sleep(3000);
		auto.template_preview();
		Thread.sleep(3000);*/
		auto.templatepageclose();
		Thread.sleep(3000);
		auto.digitalpageclose();
		Thread.sleep(3000);
	}

}
