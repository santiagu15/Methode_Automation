package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

import news.co.uk.Configuration.Mouse;
import news.co.uk.Configuration.Title;
import news.co.uk.Window.MainPage;
import news.co.uk.Window.NewStory;
import news.co.uk.Window.Template;

public class TE6 extends AppLauncher{

	@Test(priority =1)
	public void existing_stories1() throws Exception{
		Automation auto = new Automation();
		auto.open_section(MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		Thread.sleep(3000);
		auto.selecting_template(Template.SLICE_FRAME_X_SECONDARY_2_2, Template.SLICE_FRAME_Y_SECONDARY_2_2);
		Thread.sleep(3000);
		auto.story_rearrange();
		auto.quickacess(Title.TEMPLATE_PAGE, Template.TOOLVIEW,Template.TOOLVIEW_X, Template.TOOLVIEW_Y,4);
		auto.quick_icon_click(Title.TEMPLATE_PAGE,Template.QUICKACCESS,Template.QUICKACCESS_X, Template.QUICKACCESS_Y);
		auto.quickacess_filename(NewStory.STORY_1);
		auto.existing_stroy(520, 120);auto.quick_icon_click(Title.TEMPLATE_PAGE,Template.QUICKACCESS,Template.QUICKACCESS_X, Template.QUICKACCESS_Y);
		auto.quickacess_filename(NewStory.RE_LINK);
		auto.existing_stroy(390, 120);
		/*auto.chromeiniti();
		auto.template_preview();*/
		Thread.sleep(3000);
		auto.templatepageclose();
		Thread.sleep(3000);
		auto.digitalpageclose();
		Thread.sleep(3000);
	}
}
