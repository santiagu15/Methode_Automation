package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

import news.co.uk.Window.StoryPreparation;

public class TC24 extends AppLauncher{
	
	@Test
	public void Inlineimage() throws Exception{
		Automation auto = new Automation();
		auto.update_ps();
		auto.Article_Text();
		auto.Insert_Image(1,StoryPreparation.IMAGE_1_Y);
		auto.image3_2();
		auto.image2_3();
		auto.chromeiniti();
		auto.preview_publish();
		auto.storypreparationclose();
		auto.templatepageclose();
		auto.digitalpageclose();
	}

}
