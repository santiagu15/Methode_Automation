package news.co.uk.Main;

import org.testng.annotations.Test;

import com.extentReportManager.AppLauncher;

import news.co.uk.Window.MainPage;
import news.co.uk.Window.Template;

public class TC30 extends AppLauncher{

	@Test
	public void dummy() throws Exception{
		Automation auto = new Automation();
		auto.open_section(MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		Thread.sleep(3000);
		auto.selecting_template(Template.SLICE_FRAME_X_LEAD_1_1,Template.SLICE_FRAME_Y_LEAD_1_1);
		auto.chromeiniti();
		Thread.sleep(3000);
		auto.template_preview();
		Thread.sleep(3000);
		auto.dummy();
	}
	
}
