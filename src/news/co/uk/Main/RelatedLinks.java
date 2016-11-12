package news.co.uk.Main;

import org.testng.annotations.Test;

import news.co.uk.Configuration.Title;
import news.co.uk.Window.StoryPreparation;

public class RelatedLinks {
	
	@Test
	public void related_links() throws Exception{
		Automation auto = new Automation();
		auto.related_link();
		auto.lead_lead();
		auto.quickacess(Title.STORY_PREPARATION, StoryPreparation.QUERY,StoryPreparation.QUERY_X, StoryPreparation.QUERY_Y,5);
		auto.quick_icon_click(Title.STORY_PREPARATION,StoryPreparation.QUERY_BUTTON,StoryPreparation.QUERY_BUTTON_X,StoryPreparation.QUERY_BUTTON_Y);
		auto.quickacess_filename(StoryPreparation.RELATED_LINK);
		auto.existing_stroy_relatedlinks(181, 930);
		auto.assert_links();
		Thread.sleep(3000);
	}

}
