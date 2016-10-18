package news.co.uk.Main;

import org.testng.annotations.Test;

public class TC5 {

	@Test
	public void update_article_timestamp() throws Exception{
		Automation auto = new Automation();
		auto.launching();
		Thread.sleep(3000);
		auto.q_metadata();
		Thread.sleep(3000);
		auto.article_timestamp();
		Thread.sleep(3000);
		auto.chromeiniti();
		Thread.sleep(3000);
		auto.preview_publish();
	}
	
}
