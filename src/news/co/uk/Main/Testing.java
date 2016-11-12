package news.co.uk.Main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

import news.co.uk.Configuration.Mouse;
import news.co.uk.Configuration.Title;
import news.co.uk.Enum.TemplateSlice;
import news.co.uk.Window.NewStory;
import news.co.uk.Window.StoryPreparation;
import news.co.uk.Window.Template;

public class Testing extends AppLauncher{
	public WebDriver driver;
	@Test
	public void test1() throws Exception{
	/*String link = "http://cps-render-sip.elb.tnl-dev.ntch.co.uk/preview/article/544bb8b6-a1b2-11e6-8ec7-cc3b73de63ff?t=1478610409246";
	link.tr*/
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
	
	
	/*String pageSource= "";
	String unid="";
	
	public void checkUnid(){
		
		pageSource.contains(unid);
	}
	@Test
	public void test1() throws Exception{
			Automation auto = new Automation();
			auto.launching();*/
			
			//Assert.assertTrue(auto.q_metadata(), "");
			/*auto.app_open();
			auto.PublishingSystem();
			auto.login();*/
	}//


	/*public static void main(String[] args) {
		System.out.println(TemplateSlice.COMMENT_1_AND_CARTOON);
		String te = test(TemplateSlice.COMMENT_2_AND_NOTEBOOK);
		System.out.println(te);
		
	}
	
	public static String test(TemplateSlice name) {
		int col = 0;
		switch(name) {
		
		case COMMENT_1_AND_CARTOON:
			col = 1;
			break;
		case COMMENT_2_AND_NOTEBOOK:
			col =5;
			break;
		}
		
		return getStep(col);
	}
	
	public static String getStep(int step) {
		StringBuilder name = new StringBuilder();
		int count = 0;
		for(;;) {
			if (count == step) {
				break;
			}
			name.append("{DOWN}");
			count++;
		}
		return name.toString();
	}*/


