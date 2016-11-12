package news.co.uk.Main;

import org.testng.annotations.Test;

import news.co.uk.Window.MainPage;
import news.co.uk.Window.NewStory;
import news.co.uk.Window.StoryPreparation;
import news.co.uk.Window.Template;

public class TC10 {
	
	@Test (priority =1)
	public void secondary_1() throws Exception{
		Automation auto = new Automation();
		auto.open_section(MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		Thread.sleep(3000);
		auto.candidate_browser();
		Thread.sleep(3000);
		auto.template_selection_secondary_2_2();
		Thread.sleep(3000);
		auto.selecting_template(Template.SLICE_FRAME_X_SECONDARY_2_2, Template.SLICE_FRAME_Y_SECONDARY_2_2);
		Thread.sleep(3000);
		auto.story_creation(NewStory.STORY_3, Template.SLICE_FRAME_X_SECONDARY_2_2_1, Template.SLICE_FRAME_Y_SECONDARY_2_2_1);
		Thread.sleep(3000);
		auto.channelcopy();
		Thread.sleep(3000);
		auto.preparing_story(StoryPreparation.HEADLINE_STORY3, 3, StoryPreparation.IMAGE_3_Y);
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
	
	@Test(priority =2)
	public void secondary_2() throws Exception{
		Automation auto = new Automation();
		auto.open_section(MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		Thread.sleep(3000);
		auto.selecting_template(Template.SLICE_FRAME_X_SECONDARY_2_2, Template.SLICE_FRAME_Y_SECONDARY_2_2);
		Thread.sleep(3000);
		auto.story_creation(NewStory.STORY_4, Template.SLICE_FRAME_X_SECONDARY_2_2_2, Template.SLICE_FRAME_Y_SECONDARY_2_2_2);
		Thread.sleep(3000);
		auto.channelcopy();
		Thread.sleep(3000);
		auto.preparing_story(StoryPreparation.HEADLINE_STORY4, 1, StoryPreparation.IMAGE_1_Y);
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
	
	@Test (priority =3)
	public void secondary_3() throws Exception{
		Automation auto = new Automation();
		auto.open_section(MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		Thread.sleep(3000);
		auto.selecting_template(Template.SLICE_FRAME_X_SECONDARY_2_2, Template.SLICE_FRAME_Y_SECONDARY_2_2);
		Thread.sleep(3000);
		auto.story_creation(NewStory.STORY_5, Template.SLICE_FRAME_X_SECONDARY_2_2_3, Template.SLICE_FRAME_Y_SECONDARY_2_2_3);
		Thread.sleep(3000);
		auto.channelcopy();
		Thread.sleep(3000);
		auto.preparing_story(StoryPreparation.HEADLINE_STORY5, 2, StoryPreparation.IMAGE_2_Y);
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

	@Test (priority =4)
	public void secondary_4() throws Exception{
		Automation auto = new Automation();
		auto.open_section(MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		Thread.sleep(3000);
		auto.selecting_template(Template.SLICE_FRAME_X_SECONDARY_2_2, Template.SLICE_FRAME_Y_SECONDARY_2_2);
		Thread.sleep(3000);
		auto.story_creation(NewStory.STORY_6, Template.SLICE_FRAME_X_SECONDARY_2_2_4, Template.SLICE_FRAME_Y_SECONDARY_2_2_4);
		Thread.sleep(3000);
		auto.channelcopy();
		Thread.sleep(3000);
		auto.preparing_story(StoryPreparation.HEADLINE_STORY6, 3, StoryPreparation.IMAGE_3_Y);
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
