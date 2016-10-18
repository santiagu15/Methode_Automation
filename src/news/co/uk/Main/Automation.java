package news.co.uk.Main;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;
import news.co.uk.Configuration.MainMenu;
import news.co.uk.Configuration.Mouse;
import news.co.uk.Configuration.SliceTemplate;
import news.co.uk.Configuration.Title;
import news.co.uk.Enum.TemplateSlice;
import news.co.uk.Window.ChannelCopy;
import news.co.uk.Window.ConfirmPopup;
import news.co.uk.Window.MainPage;
import news.co.uk.Window.NewStory;
import news.co.uk.Window.PublicationSelection;
import news.co.uk.Window.QuickOpen;
import news.co.uk.Window.StoryPreparation;
import news.co.uk.Window.Template;

public class Automation {
	
	public AutoItX at;
	public WebDriver driver;
	
	public static String jvmBitVersion(){
		return System.getProperty("sun.arch.data.model");
	}
	@BeforeSuite
	public void launching() throws InterruptedException {
		String jacobDllVersionToUse;
		if (jvmBitVersion().contains("32")) {
			jacobDllVersionToUse = "jacob-1.18-x86.dll";
		} else {
			jacobDllVersionToUse = "jacob-1.18-x64.dll";
		}
		File file = new File("lib", jacobDllVersionToUse);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		
		at = new AutoItX();
		at.setOption(AutoItX.OPT_CARET_COORD_MODE, "2");
		at.setOption(AutoItX.OPT_MOUSE_COORD_MODE, "2");
		at.setOption(AutoItX.OPT_WIN_TITLE_MATCH_MODE, "4");
	}
	
		@Test
		public void chromeiniti() throws Exception{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sallen\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			Thread.sleep(3000);
			driver.manage().window().maximize();
		}
		
		
		@Test
		public void app_open() throws Exception{
		at.run("C:\\Program Files (x86)\\WinBatchScripts\\Methode\\StartMethode.exe", "",AutoItX.SW_SHOW);
		at.sleep(10000);
		}

	
	
		//Selecting the Publishing system
		@Test
		public void PublishingSystem() throws Exception{
		at.winActivate(Title.PS);
		at.sleep(1000);
		at.controlFocus(Title.PS, "", PublicationSelection.ID);
		System.out.println("x");
		at.sleep(2000);
		at.controlClick(Title.PS, "",PublicationSelection.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, PublicationSelection.TT_X, PublicationSelection.TT_Y);
		at.sleep(2000);
		at.controlClick(Title.PS, "", PublicationSelection.OK_BTN,  Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, PublicationSelection.OK_BTN_X, PublicationSelection.OK_BTN_Y);
		System.out.println("Pass");
		at.sleep(50000);
		}
		
		//Login
		@Test
		public void login() throws Exception{ 
		at.controlFocus("Connect to", "", "[CLASS:Edit; INSTANCE:1]");
		at.sleep(1000);
		at.send("sallen");
		at.controlFocus("Connect to", "", "[CLASS:Edit; INSTANCE:2]");
		at.sleep(1000);
		at.send("Welcome@1");
		at.sleep(1000);
		at.controlClick("Connect to", "", "[CLASS:Button; INSTANCE:4]", "left", 1, 31, 12);
		System.out.println("Login Passed");
		at.sleep(10000);
		}
		
		//Message of the day pop-up
		@Test
		public void mod() throws Exception{
		at.winActivate(Title.MOD);
		at.sleep(5000);
		at.controlFocus(Title.MOD, "", "[CLASS:Button; INSTANCE:1]");
		at.controlClick(Title.MOD, "", "[CLASS:Button; INSTANCE:1]", "left", 1, 28, 12);
		at.sleep(4000);
		}
		
		//Create a Page plan
		@Test
		public void create_pp() throws Exception{
		at.winActivate(Title.METHODE);
		at.sleep(2000);
		
		//Activate File Menu and opening the quick open option
		at.controlFocus(Title.METHODE, "", MainMenu.ID);
		//Select quick open menu
		at.controlSend(Title.METHODE, "", "", "{ALT}",false);
		at.controlClick(Title.METHODE, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.FILE_CORD_X, MainMenu.FILE_CORD_Y);
		at.controlSend(Title.METHODE, "", "", "u",false);
		at.sleep(1000);
		System.out.println("File menu clicked");
		}
		
		// Opening a Page plan
		public void openpp() throws Exception{
		at.winActivate(Title.Q_OPEN);
		at.controlFocus(Title.Q_OPEN, "", QuickOpen.PC_ID);
		at.sleep(2000);
		}
		
		// Selecting the Digital Plan
		@Test
		public void digital() throws Exception{
			at.sleep(3000);
		at.controlCommandShowDropdown(Title.Q_OPEN, "", QuickOpen.PC_ID);
		at.controlSend(Title.Q_OPEN, "", "", Mouse.DOWN_4X, false);
		at.controlSend(Title.Q_OPEN, "", "", Mouse.ENTER, false);
		}
		@Test
		public void date_select() throws Exception{
		// Selecting the Date
		at.controlFocus(Title.Q_OPEN, "", QuickOpen.PD_ID);
		at.sleep(2000);
		at.ControlSetText(Title.Q_OPEN, "", QuickOpen.PD_ID, "15/10/2016");
		at.sleep(2000);
		at.controlSend(Title.Q_OPEN, "", QuickOpen.PD_ID, Mouse.UP_DOWN);
		at.sleep(2000);
		}
		// Selecting the Slot Section
		@Test
		public void slot_selection() throws Exception{
		at.controlFocus(Title.Q_OPEN, "", QuickOpen.PS_ID);
		at.controlClick(Title.Q_OPEN, "", QuickOpen.PS_ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, QuickOpen.PS_ID_X, QuickOpen.PS_ID_Y);
		
		//Selecting the Page
		at.controlFocus(Title.Q_OPEN, "", QuickOpen.PP_ID);
		at.controlClick(Title.Q_OPEN, "", QuickOpen.PP_ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, QuickOpen.PP_ID_X, QuickOpen.PP_ID_Y);
		at.controlSend(Title.Q_OPEN, "", QuickOpen.PP_ID, Mouse.DOWN);
		
		// Copying the selected page into the notepad
		/*at.controlSend(Title.Q_OPEN, "", QuickOpen.PP_ID, "^c");
		at.sleep(3000);
		at.run("notepad.exe", "",AutoItX.SW_SHOW);
		at.sleep(2000);
		at.winWaitActive("Untitled");
		at.sleep(5000);
		at.controlSend("Untitled", "", "[ID:15]", "^v");*/
		at.sleep(2000);
		at.controlFocus(Title.Q_OPEN, "", QuickOpen.OK_BTN);
		at.controlClick(Title.Q_OPEN, "", QuickOpen.OK_BTN, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, QuickOpen.OK_BTN_X, QuickOpen.OK_BTN_Y);
		at.sleep(3000);
		}
		
		// Expand the page plan
		@Test
		public void pageplan() throws Exception{
		at.winActivate(Title.PAGE_PLANNER);
		at.controlFocus(Title.PAGE_PLANNER, "", MainPage.PAGE_EXPANDER);
		at.controlClick(Title.PAGE_PLANNER, "", MainPage.PAGE_EXPANDER, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.PAGE_EXPANDER_X, MainPage.PAGE_EXPANDER_Y);
		at.sleep(4000);
		
		// Clicking on the Main Page page plan
		
		at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Clicking_MP);
		at.controlClick(Title.PAGE_PLANNER, "", MainPage.Clicking_MP, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, MainPage.Clicking_MP_X, MainPage.CLICKING_MP_Y);
		at.sleep(3000);
	}
		
		// Business Page section
		public void selecting_buisness() throws Exception{
		at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);
		at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		at.controlSend(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.DOWN);
		at.controlSend(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.ENTER);
		at.sleep(3000);
		at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
		at.sleep(3000);
		}
		
		//Selecting a candidate browser in the dwp page
		@Test
		public void candidate_browser() throws Exception{
		at.winActivate(Title.DIGITAL_PAGE);
		at.sleep(3000);
		at.controlFocus(Title.DIGITAL_PAGE, "", MainMenu.ID);
		at.controlClick(Title.DIGITAL_PAGE, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.VIEW_CORD_X, MainMenu.VIEW_CORD_Y);
		at.sleep(2000);
		at.controlSend(Title.DIGITAL_PAGE, "", MainMenu.ID, Mouse.DOWN);
		at.sleep(5000);
		at.controlSend(Title.DIGITAL_PAGE, "", MainMenu.ID, Mouse.ENTER);
		at.sleep(3000);
		}
		
		// Selecting the templates
		@Test
		public void template_selection() throws Exception{
		at.controlFocus(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE);
		at.controlClick(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.SLICE_TEMPLATE_X, Template.SLICE_TEMPLATE_Y);
		at.controlSend(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE, SliceTemplate.getTemplate(TemplateSlice.LEAD_1_AND_1));
		at.sleep(3000);
		
		// Drag and drop the slice template
		int mx = at.controlGetPosX(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE);
		int my = at.controlGetPosY(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE);
		int position = SliceTemplate.getTemplatePosition(TemplateSlice.LEAD_1_AND_1);
		int positionLength  = position * 19; 
		at.mouseMove(mx, my + positionLength,200);
		int y_axis =  my + positionLength;
		System.out.println(mx +" "+my);
		System.out.println(positionLength);
		at.mouseClickDrag(Mouse.LEFT_CLICK, mx, y_axis, 295, 106, 200);
		at.sleep(3000);
		
		// Moving into the template page
		at.controlFocus(Title.DIGITAL_PAGE, "", Template.SLICE_FRAME);
		at.controlClick(Title.DIGITAL_PAGE, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, Template.SLICE_FRAME_X, Template.SLICE_FRAME_Y);
		at.sleep(3000);
		}
		
		// Creating a story
		@Test
		public void story_creation() throws Exception{
		at.winActivate(Title.TEMPLATE_PAGE);
		at.controlFocus(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME);
		at.sleep(3000);
		at.controlClick(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, Template.SLICE_FRAME_X, Template.SLICE_FRAME_Y);
		at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.DOWN_3X);
		at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.ENTER);
		at.sleep(3000);
		at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.ENTER);
		at.sleep(3000);
		at.controlFocus(Title.NEWSTORY, "", NewStory.NEW_STORY);
		at.controlClick(Title.NEWSTORY, "", NewStory.NEW_STORY, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, NewStory.NEW_STORY_X, NewStory.NEW_STORY_Y);
		at.sleep(2000);
		at.controlFocus(Title.NEWSTORY, "", NewStory.CREATE_NEW_STORY);
		at.controlClick(Title.NEWSTORY, "", NewStory.CREATE_NEW_STORY, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, NewStory.CREATE_NEW_STORY_X, NewStory.CREATE_NEW_STORY_Y);
		at.sleep(3000);
		at.winActivate(Title.SAVE_AS);
		at.controlFocus(Title.SAVE_AS, "", NewStory.FILENAME);
		at.controlClick(Title.SAVE_AS, "", NewStory.FILENAME, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, NewStory.FILENAME_X, NewStory.FILENAME_Y);
		at.ControlSetText(Title.SAVE_AS, "", NewStory.FILENAME, "SA_Auto");
		at.sleep(2000);
		at.controlFocus(Title.SAVE_AS, "", NewStory.SAVE_AS);
		at.controlClick(Title.SAVE_AS, "", NewStory.SAVE_AS, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, NewStory.SAVE_AS_X, NewStory.SAVE_AS_Y);
		at.sleep(5000);
		at.winActivate(Title.TEMPLATE_PAGE);
		at.controlFocus(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME);
		at.controlClick(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.SLICE_FRAME_OUTSIDE_X, Template.SLICE_FRAME_OUTSIDE_Y);
		at.sleep(4000);
		at.controlClick(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, Template.SLICE_FRAME_X, Template.SLICE_FRAME_Y);
		at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.DOWN);
		at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.ENTER);
		at.sleep(5000);
		}
		
		//Channel Copy
		@Test
		public void channelcopy() throws Exception{
		at.winActivate(Title.CHANNEL_COPY);
		at.sleep(5000);
		at.controlFocus(Title.CHANNEL_COPY, "", ChannelCopy.CHANNEL_COPY);
		at.controlClick(Title.CHANNEL_COPY, "", ChannelCopy.CHANNEL_COPY, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, ChannelCopy.CHANNEL_COPY_X, ChannelCopy.CHANNEL_COPY_Y);
		at.sleep(5000);
		at.controlFocus(Title.CHANNEL_COPY, "", ChannelCopy.CHANNEL_COPY_OK);
		at.controlClick(Title.CHANNEL_COPY, "", ChannelCopy.CHANNEL_COPY_OK, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, ChannelCopy.CHANNEL_COPY_OK_X, ChannelCopy.CHANNEL_COPY_OK_Y);
		at.sleep(3000);
		}

		//Preparing a Story
		@Test
		public void preparing_story() throws Exception{
		at.winActivate(Title.STORY_PREPARATION);
		at.controlFocus(Title.STORY_PREPARATION, "", Template.SLICE_FRAME);
		at.controlClick(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, StoryPreparation.HEADLINE_X, StoryPreparation.HEADLINE_Y);
		at.sleep(2000);
		at.controlSend(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, "This is for Automation");
		at.sleep(3000);
		at.controlFocus(Title.STORY_PREPARATION, "", Template.SLICE_FRAME);
		at.sleep(2000);
		at.controlClick(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, StoryPreparation.STRAPLINE_X, StoryPreparation.STRAPLINE_Y);
		at.controlSend(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, "This is for testing purpose");
		at.sleep(3000);
		at.winActivate(Title.STORY_PREPARATION);
		at.controlFocus(Title.STORY_PREPARATION, "", MainMenu.ID);
		at.controlClick(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.VIEW_CORD_X, MainMenu.VIEW_CORD_Y);
		at.sleep(2000);
		at.controlSend(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.DOWN);
		at.sleep(4000);
		at.controlSend(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.ENTER);
		at.sleep(3000);
		
		at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.SELECTING_IMAGE);
		at.sleep(2000);
		at.controlCommandShowDropdown(Title.STORY_PREPARATION, "", StoryPreparation.SELECTING_IMAGE);
		at.sleep(5000);
		//at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.SELECTING_IMAGE);
		at.sleep(2000);
		at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.DOWN, false);
		at.sleep(3000);
		at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.DOWN, false);
		at.sleep(2000);
		at.mouseClickDrag(Mouse.LEFT_CLICK, 1700, 335, 400, 600, 2000);
		at.sleep(2000);
		}
		/*at.winActivate(Title.STORY_PREPARATION);
		at.sleep(3000);
		at.controlClick(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, StoryPreparation.TEXT_CONTENT_X, StoryPreparation.TEXT_CONTENT_Y);
		at.controlSend(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, "All those things which falls under the cognizance of man might "
				+ "very likely be mutually related in the same fashion and there can be nothing so remote that we cannot reach to it."
				+ "All those things which falls under the cognizance of man might very likely be mutually related in "
				+ "the same fashion and there can be nothing so remote that we cannot reach to it."
				+ "All those things which falls under the cognizance of man might very likely be mutually related in "
				+ "the same fashion and there can be nothing so remote that we cannot reach to it."
				+ "All those things which falls under the cognizance of man might very likely be mutually "
				+ "related in the same fashion and there can be nothing so remote that we cannot reach to it.");*/
		
		// Clicking on the preview button
		@Test
		public void preview_publish() throws Exception{
		at.winActivate(Title.STORY_PREPARATION);
		at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.PREVIEW_BUTTON);
		at.sleep(2000);
		at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.PREVIEW_BUTTON, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.PREVIEW_BUTTON_X, StoryPreparation.PREVIEW_BUTTON_Y);
		at.sleep(5000);
		
		//String ptitle  = "cps-render-sip.elb.tnl-dev.ntch.co.uk/preview/article/5fdc6a04-8704-11e6-9ed4-f2b74109bf85?t=1475548325574";
		// Verifying in the Preview
		at.winWaitActive(Title.PREVIEW_BROWSER);
		at.sleep(2000);
		at.controlClick(Title.PREVIEW_BROWSER, "", "", Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, 400, 45);
		at.sleep(3000);
		at.controlSend(Title.PREVIEW_BROWSER, "", "", "^a");
		//at.sleep(2000);
		at.controlSend(Title.PREVIEW_BROWSER, "", "", "^c");
		//at.send("{CTRL}a{CTRL}c");
		at.sleep(3000);
		String preview = at.clipGet();
		System.out.println(preview);
		
		
		// Published the article
		at.winWait(Title.STORY_PREPARATION);
		at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.PREVIEW_BUTTON);
		at.sleep(2000);
		at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.PREVIEW_BUTTON, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, 668, 12);
		at.sleep(2000);
		at.winActivate(Title.PUBLISH_CONFIRMATION);
		at.sleep(2000);
		at.controlFocus(Title.PUBLISH_CONFIRMATION, "", StoryPreparation.PUBLISH_CONFIRMATION);
		at.controlClick(Title.PUBLISH_CONFIRMATION, "", StoryPreparation.PUBLISH_CONFIRMATION, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.PUBLISH_CONFIRMATION_X, StoryPreparation.PUBLISH_CONFIRMATION_Y);
		at.sleep(5000);
		String plink = preview.replace("sip", "si");
		driver.get(plink);
		Thread.sleep(3000);
		String article_date = driver.findElement(By.xpath("//*[@id='article-main']/section/div[1]/div/p/time")).getText();
		System.out.println(article_date);
		//*[@id="article-main"]/section/div[1]/div/p/time
		}
		
		@Test
		public void amazon_bucket() throws Exception{
			
		String uuid = driver.findElement(By.xpath("//*[@id='ArticleMetaBanner-uuid']")).getAttribute("value");
		//String preview = driver.getCurrentUrl();
		System.out.println(uuid);
		Thread.sleep(3000);
		driver.navigate().to("https://nu-cps-hub-dev-assets.s3.amazonaws.com/methode/times/si/web/articles/"+uuid);
		Thread.sleep(3000);
		}
		
		@Test
		public void storypreparationclose() throws Exception{
			at.winActivate(Title.STORY_PREPARATION);
			at.sleep(3000);
			at.controlClick(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.FILE_CORD_X, MainMenu.FILE_CORD_Y);
			at.sleep(4000);
			at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.DOWN_6X);
			at.sleep(3000);
			at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.ENTER);
			at.sleep(4000);
			at.winClose(Title.STORY_PREPARATION);
			at.sleep(3000);
			
		}
		
		
		@Test
		public void templatepageclose() throws Exception{
			at.winActivate(Title.TEMPLATE_PAGE);
			at.sleep(3000);
			at.controlClick(Title.TEMPLATE_PAGE, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.FILE_CORD_X, MainMenu.FILE_CORD_Y);
			at.sleep(4000);
			at.controlSend(Title.TEMPLATE_PAGE, "", "", Mouse.DOWN_5X);
			at.sleep(3000);
			at.controlSend(Title.TEMPLATE_PAGE, "", "", Mouse.ENTER);
			at.sleep(4000);
			at.winClose(Title.TEMPLATE_PAGE);
			at.sleep(3000);
		}
		
		@Test
		public void digitalpageclose() throws Exception{
			at.winActivate(Title.DIGITAL_PAGE);
			at.sleep(3000);
			at.controlClick(Title.DIGITAL_PAGE, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.FILE_CORD_X, MainMenu.FILE_CORD_Y);
			at.sleep(4000);
			at.controlSend(Title.DIGITAL_PAGE, "", "", Mouse.DOWN_5X);
			at.sleep(3000);
			at.controlSend(Title.DIGITAL_PAGE, "", "", Mouse.ENTER);
			at.sleep(4000);
			at.winClose(Title.DIGITAL_PAGE);
			at.sleep(3000);
		}
		@Test
		public void workflow_layout() throws Exception{
			at.winActivate(Title.PAGE_PLANNER);
			at.sleep(3000);
			at.controlFocus(Title.PAGE_PLANNER, "", MainPage.OVERALLEDITION);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.OVERALLEDITION, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, MainPage.OVERALLEDITION_X, MainPage.OVERALLEDITION_Y);
			at.sleep(3000);
			at.winActivate(Title.PAGE_PLANNER);
			at.sleep(2000);
			at.controlFocus(Title.PAGE_PLANNER, "", MainPage.WORKFLOW);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.WORKFLOW, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, MainPage.WORKFLOW_X, MainPage.WORKFLOW_Y);
			at.sleep(4000);
			at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.DOWN_12X);
			at.sleep(2000);
			at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.ENTER);
			at.sleep(3000);
		}
		
		@Test
		public void workflowdone_layout() throws Exception{
			at.winActivate(Title.WORKFLOW);
			at.sleep(2000);
			at.controlFocus(Title.WORKFLOW, "", MainPage.WORKFLOW_DONE);
			at.controlClick(Title.WORKFLOW, "", MainPage.WORKFLOW_DONE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.WORKFLOW_DONE_X, MainPage.WORKFLOW_DONE_Y);
			at.sleep(4000);
			at.controlFocus(Title.WORKFLOW, "", MainPage.WORKFLOW_DONE_OK);
			at.controlClick(Title.WORKFLOW, "", MainPage.WORKFLOW_DONE_OK, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.WORKFLOW_DONE_OK_X, MainPage.WORKFLOW_DONE_OK_Y);
			at.sleep(3000);
		}
		
		@Test
		public void Edition() throws Exception{
	/*		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sallen\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			Thread.sleep(3000);*/
			at.winActivate(Title.PAGE_PLANNER);
			at.controlFocus(Title.PAGE_PLANNER, "", MainPage.EDITION_PREVIEW);
			at.sleep(2000);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.EDITION_PREVIEW, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.EDITION_PREVIEW_X, MainPage.EDITION_PREVIEW_Y);
			at.sleep(5000);
			
			//String ptitle  = "cps-render-sip.elb.tnl-dev.ntch.co.uk/preview/article/5fdc6a04-8704-11e6-9ed4-f2b74109bf85?t=1475548325574";
			// Verifying in the Preview
			at.winWaitActive(Title.PREVIEW_BROWSER_EDITION);
			at.sleep(2000);
			at.controlClick(Title.PREVIEW_BROWSER_EDITION, "", "", Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, 400, 45);
			at.sleep(3000);
			at.controlSend(Title.PREVIEW_BROWSER_EDITION, "", "", "^a");
			//at.sleep(2000);
			at.controlSend(Title.PREVIEW_BROWSER_EDITION, "", "", "^c");
			//at.send("{CTRL}a{CTRL}c");
			at.sleep(3000);
			String preview = at.clipGet();
			System.out.println(preview);
			at.sleep(3000);
			
			at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
			// Published the article
			at.sleep(3000);
			at.winActivate(Title.PAGE_PLANNER);
			at.controlFocus(Title.PAGE_PLANNER, "", MainPage.EDITION_PUBLISH);
			at.sleep(2000);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.EDITION_PUBLISH, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.EDITION_PUBLISH_X, MainPage.EDITION_PUBLISH_Y);
			at.sleep(5000);
			String plink = preview.replace("sip", "si");
			at.sleep(3000);
			driver.get(plink);
			Thread.sleep(3000);
			String publishing_date = driver.findElement(By.xpath("//*[@id='top']/section/header/div/time")).getText();
			System.out.println(publishing_date);
		}
		
		@Test
		public void update_ps() throws Exception{
			at.winActivate(Title.PAGE_PLANNER);
			at.sleep(3000);
			at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
			at.sleep(3000);
			at.winActivate(Title.DIGITAL_PAGE);
			at.controlFocus(Title.DIGITAL_PAGE, "", Template.SLICE_FRAME);
			at.controlClick(Title.DIGITAL_PAGE, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, Template.SLICE_FRAME_X, Template.SLICE_FRAME_Y);
			at.sleep(3000);
			at.winActivate(Title.TEMPLATE_PAGE);
			at.controlClick(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, Template.SLICE_FRAME_X, Template.SLICE_FRAME_Y);
			at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.DOWN);
			at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.ENTER);
			at.sleep(5000);
		}
		
		@Test
		public void q_metadata() throws Exception{
			at.winActivate(Title.STORY_PREPARATION);
			at.sleep(3000);
			at.controlClick(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.FILE_CORD_X, MainMenu.FILE_CORD_Y);
			at.sleep(4000);
			at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.DOWN_15X);
			at.sleep(3000);
			at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.ENTER);
			at.sleep(4000);
		}
		
		@Test
		public void editionmetadata() throws Exception{
			at.winActivate(Title.PAGE_PLANNER);
			at.sleep(3000);
			at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);;
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
			at.sleep(3000);
			at.controlFocus(Title.PAGE_PLANNER, "", MainPage.EDITION_METADATA);
			at.sleep(3000);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.EDITION_METADATA, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.EDITION_METADATA_X, MainPage.EDITION_METADATA_Y);
			at.sleep(3000);
			at.controlFocus(Title.PAGE_PLANNER, "", MainPage.SET_EDITION_DATE);
			at.sleep(4000);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.SET_EDITION_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.UPDATETEXT_EDITION_METADATA_X, MainPage.UPDATETEXT_EDITION_METADATA_Y);
			at.sleep(2000);
			at.controlSend(Title.PAGE_PLANNER, "", MainPage.SET_EDITION_DATE, "9AM UPDATE");
			at.sleep(3000);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.SET_EDITION_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.SET_EDITION_DATE_X, MainPage.SET_EDITION_DATE_Y);
			at.sleep(3000);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.SET_EDITION_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.SET_EDITION_TIME_X, MainPage.SET_EDITION_TIME_Y);
			at.sleep(3000);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.SET_EDITION_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.DONE_EDITION_X, MainPage.DONE_EDITION_Y);
			at.sleep(3000);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.SET_EDITION_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.SET_NOW_X, MainPage.SET_NOW_Y);
			at.sleep(3000);
			at.controlClick(Title.PAGE_PLANNER, "", MainPage.SET_EDITION_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.EDITION_SAVE_X, MainPage.EDITION_SAVE_Y);
		}
		
		@Test
		public void article_timestamp() throws Exception{
			at.winActivate(Title.STORY_PREPARATION);
			at.sleep(3000);
			at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE);
			at.sleep(3000);
			at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.SET_ARTICLE_DATE_X, StoryPreparation.SET_ARTICLE_DATE_Y);
			at.sleep(3000);
			at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.SET_ARTICLE_TIME_X, StoryPreparation.SET_ARTICLE_TIME_Y);
			at.sleep(3000);
			at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.DONE_ARTICLE_X, StoryPreparation.DONE_ARTICLE_Y);
			at.sleep(3000);
			at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.ARTICLE_SAVE_X, StoryPreparation.ARTICLE_SAVE_Y);
			
		}
		
		@Test
		public void driverclose() throws Exception{
			driver.quit();
		}
}
