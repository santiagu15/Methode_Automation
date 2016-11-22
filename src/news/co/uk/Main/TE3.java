package news.co.uk.Main;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

import news.co.uk.Configuration.Title;
import news.co.uk.Window.MainPage;
import news.co.uk.Window.NewStory;
import news.co.uk.Window.StoryPreparation;
import news.co.uk.Window.Template;

public class TE3 extends AppLauncher{
	
	@Test(priority = 1)
	public void adding_related_link() throws Exception{
		Automation auto = new Automation();
		auto.open_section(MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		Thread.sleep(3000);
		auto.selecting_template(Template.SLICE_FRAME_X_LEAD_1_1,Template.SLICE_FRAME_Y_LEAD_1_1);
		Thread.sleep(3000);
		auto.story_creation(NewStory.STORY_2, Template.SLICE_FRAME_X_LEAD_1_1_2, Template.SLICE_FRAME_Y_LEAD_1_1_2);
		Thread.sleep(3000);
		auto.channelcopy();
		Thread.sleep(3000);
		auto.related_link();
		auto.lead_lead();
		auto.quickacess(Title.STORY_PREPARATION, StoryPreparation.QUERY,StoryPreparation.QUERY_X, StoryPreparation.QUERY_Y,5);
		auto.quick_icon_click(Title.STORY_PREPARATION,StoryPreparation.QUERY_BUTTON,StoryPreparation.QUERY_BUTTON_X,StoryPreparation.QUERY_BUTTON_Y);
		auto.quickacess_filename(StoryPreparation.RELATED_LINK);
		auto.existing_stroy_relatedlinks(181, 930);
		auto.assert_links();
		Thread.sleep(3000);
		auto.storypreparationclose();
		Thread.sleep(3000);
		auto.lead_1(Template.SLICE_FRAME_X_LEAD_1_1_2, Template.SLICE_FRAME_Y_LEAD_1_1_2);
		auto.Article_Text();
		Thread.sleep(3000);
		auto.storypreparationclose();
		Thread.sleep(3000);
		auto.lead_1(Template.SLICE_FRAME_X_LEAD_1_1_2, Template.SLICE_FRAME_Y_LEAD_1_1_2);
		Thread.sleep(3000);
		auto.preparing_story(StoryPreparation.HEADLINE_STORY2, 2, StoryPreparation.IMAGE_2_Y);
		Thread.sleep(3000);
		auto.chromeiniti();
		Thread.sleep(3000);
		auto.preview_publish();
		Thread.sleep(3000);
		auto.browser_relatedlinks();
		Thread.sleep(2000);
		auto.browser_relatedstorylinks();
		auto.storypreparationclose();
		Thread.sleep(3000);
		auto.templatepageclose();
		Thread.sleep(3000);
		auto.digitalpageclose();
		Thread.sleep(3000);
	}
}
