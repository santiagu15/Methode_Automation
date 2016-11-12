package news.co.uk.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.extentReportManager.AppLauncher;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import autoitx4java.AutoItX;
import news.co.uk.Configuration.Custom;
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
import news.co.uk.Window.WorkflowLayout;

public class Automation {
	protected ExtentReports extent;
	
	public WebDriver driver;
	
	
	
	
	
	
		public void chromeiniti() throws Exception{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sallen\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			Thread.sleep(3000);
			driver.manage().window().maximize();
		}
		
		

		public void app_open() throws Exception{
		AppLauncher.at.run("C:\\Program Files (x86)\\WinBatchScripts\\Methode\\StartMethode.exe", "",AutoItX.SW_SHOW);
		AppLauncher.at.sleep(1000);
		}

	
	
		//Selecting the Publishing system
	
		public void PublishingSystem() throws Exception{
		AppLauncher.at.winWaitActive(Title.PS);
		AppLauncher.at.sleep(1000);
		AppLauncher.at.controlFocus(Title.PS, "", PublicationSelection.ID);
		System.out.println("x");
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlClick(Title.PS, "",PublicationSelection.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, PublicationSelection.TT_X, PublicationSelection.TT_Y);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlClick(Title.PS, "", PublicationSelection.OK_BTN,  Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, PublicationSelection.OK_BTN_X, PublicationSelection.OK_BTN_Y);
		System.out.println("Pass");
		//AppLauncher.at.sleep(50000);
		}
		
		//Login
	
		public void login() throws Exception{ 
		AppLauncher.at.winWaitActive(Title.LOGIN);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlFocus("Connect to", "", "[CLASS:Edit; INSTANCE:1]");
		AppLauncher.at.sleep(1000);
		AppLauncher.at.send("sallen");
		AppLauncher.at.controlFocus("Connect to", "", "[CLASS:Edit; INSTANCE:2]");
		AppLauncher.at.sleep(1000);
		AppLauncher.at.send("Welcome!1");
		AppLauncher.at.sleep(1000);
		AppLauncher.at.controlClick("Connect to", "", "[CLASS:Button; INSTANCE:4]", "left", 1, 31, 12);
		System.out.println("Login Passed");
		//AppLauncher.at.sleep(10000);
		}
		
		//Message of the day pop-up
		
		public void mod() throws Exception{
		AppLauncher.at.winWaitActive(Title.MOD);
		AppLauncher.at.sleep(5000);
		AppLauncher.at.controlFocus(Title.MOD, "", "[CLASS:Button; INSTANCE:1]");
		AppLauncher.at.controlClick(Title.MOD, "", "[CLASS:Button; INSTANCE:1]", "left", 1, 28, 12);
		AppLauncher.at.sleep(4000);
		}
		
		//Create a Page plan
		
		public void create_pp() throws Exception{
		AppLauncher.at.winWaitActive(Title.METHODE);
		AppLauncher.at.sleep(2000);
		
		//Activate File Menu and opening the quick open option
		AppLauncher.at.controlFocus(Title.METHODE, "", MainMenu.ID);
		//Select quick open menu
		AppLauncher.at.controlSend(Title.METHODE, "", "", "{ALT}",false);
		AppLauncher.at.controlClick(Title.METHODE, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.FILE_CORD_X, MainMenu.FILE_CORD_Y);
		AppLauncher.at.controlSend(Title.METHODE, "", "", "u",false);
		AppLauncher.at.sleep(1000);
		System.out.println("File menu clicked");
		}
		
		// Opening a Page plan
		public void openpp() throws Exception{
		AppLauncher.at.winWaitActive(Title.Q_OPEN);
		AppLauncher.at.controlFocus(Title.Q_OPEN, "", QuickOpen.PC_ID);
		AppLauncher.at.sleep(2000);
		}
		
		// Selecting the Digital Plan
	
		public void digital() throws Exception{
		AppLauncher.at.sleep(3000);
		AppLauncher.at.controlCommandShowDropdown(Title.Q_OPEN, "", QuickOpen.PC_ID);
		AppLauncher.at.controlSend(Title.Q_OPEN, "", "", Mouse.getDown(4), false);
		AppLauncher.at.controlSend(Title.Q_OPEN, "", "", Mouse.ENTER, false);
		}
		
		public void date_select() throws Exception{
		// Selecting the Date
		AppLauncher.at.controlFocus(Title.Q_OPEN, "", QuickOpen.PD_ID);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.ControlSetText(Title.Q_OPEN, "", QuickOpen.PD_ID, "09/11/2016");
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlSend(Title.Q_OPEN, "", QuickOpen.PD_ID, Mouse.UP_DOWN);
		AppLauncher.at.sleep(2000);
		}
		// Selecting the Slot Section
		
		public void slot_selection() throws Exception{
		AppLauncher.at.controlFocus(Title.Q_OPEN, "", QuickOpen.PS_ID);
		AppLauncher.at.controlClick(Title.Q_OPEN, "", QuickOpen.PS_ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, QuickOpen.PS_ID_X, QuickOpen.PS_ID_Y);
		
		//Selecting the Page
		AppLauncher.at.controlFocus(Title.Q_OPEN, "", QuickOpen.PP_ID);
		AppLauncher.at.controlClick(Title.Q_OPEN, "", QuickOpen.PP_ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, QuickOpen.PP_ID_X, QuickOpen.PP_ID_Y);
		AppLauncher.at.controlSend(Title.Q_OPEN, "", QuickOpen.PP_ID, Mouse.getDown(1));
		
		// Copying the selected page into the notepad
		/*AppLauncher.at.controlSend(Title.Q_OPEN, "", QuickOpen.PP_ID, "^c");
		AppLauncher.at.sleep(3000);
		AppLauncher.at.run("notepad.exe", "",AutoItX.SW_SHOW);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.winWaitActive("Untitled");
		AppLauncher.at.sleep(5000);
		AppLauncher.at.controlSend("Untitled", "", "[ID:15]", "^v");*/
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlFocus(Title.Q_OPEN, "", QuickOpen.OK_BTN);
		AppLauncher.at.controlClick(Title.Q_OPEN, "", QuickOpen.OK_BTN, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, QuickOpen.OK_BTN_X, QuickOpen.OK_BTN_Y);
		AppLauncher.at.sleep(3000);
		}
		
		// Expand the page plan
	
		public void pageplan() throws Exception{
		AppLauncher.at.winWaitActive(Title.PAGE_PLANNER);
		AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.PAGE_EXPANDER);
		AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.PAGE_EXPANDER, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.PAGE_EXPANDER_X, MainPage.PAGE_EXPANDER_Y);
		AppLauncher.at.sleep(4000);
		
		// Clicking on the Main Page page plan
		
		AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Clicking_MP);
		AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.Clicking_MP, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, MainPage.Clicking_MP_X, MainPage.CLICKING_MP_Y);
		AppLauncher.at.sleep(3000);
	}
		
		// Business Page section
		public void selecting_buisness(int Section_X,int Section_Y) throws Exception{
		AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);
		AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, Section_X,Section_Y);
		AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.getDown(1));
		AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.ENTER);
		AppLauncher.at.sleep(3000);
		}
		
		public void open_section(int Section_X,int Section_Y) throws Exception{
		AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, Section_X,Section_Y);
		AppLauncher.at.sleep(3000);
		}
		
		//Selecting a candidate browser in the dwp page
		public void candidate_browser() throws Exception{
		AppLauncher.at.winWaitActive(Title.DIGITAL_PAGE);
		AppLauncher.at.sleep(3000);
		AppLauncher.at.controlFocus(Title.DIGITAL_PAGE, "", MainMenu.ID);
		AppLauncher.at.controlClick(Title.DIGITAL_PAGE, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.VIEW_CORD_X, MainMenu.VIEW_CORD_Y);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlSend(Title.DIGITAL_PAGE, "", MainMenu.ID, Mouse.getDown(1));
		AppLauncher.at.sleep(5000);
		AppLauncher.at.controlSend(Title.DIGITAL_PAGE, "", MainMenu.ID, Mouse.ENTER);
		AppLauncher.at.sleep(3000);
		}
		
		// Selecting the templates
		public void template_selection_lead_1_and_1() throws Exception{
		AppLauncher.at.controlFocus(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE);
		AppLauncher.at.controlClick(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.SLICE_TEMPLATE_X, Template.SLICE_TEMPLATE_Y);
		AppLauncher.at.controlSend(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE, SliceTemplate.getTemplate(TemplateSlice.LEAD_1_AND_1));
		AppLauncher.at.sleep(3000);
		
		// Drag and drop the slice template
		int mx = AppLauncher.at.controlGetPosX(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE);
		int my = AppLauncher.at.controlGetPosY(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE);
		int position = SliceTemplate.getTemplatePosition(TemplateSlice.LEAD_1_AND_1);
		int positionLength  = position * 19; 
		AppLauncher.at.mouseMove(mx, my + positionLength,200);
		int y_axis =  my + positionLength;
		System.out.println(mx +" "+my);
		System.out.println(positionLength);
		AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, mx, y_axis, 295, 106, 200);
		AppLauncher.at.sleep(3000);
		}
		
		public void template_rechange() throws Exception{
			AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, 500, 254, 295, 106, 2000);
			AppLauncher.at.sleep(3000);
		}
		
		public void story_rearrange() throws Exception{
			AppLauncher.at.winActivate(Title.TEMPLATE_PAGE);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, 520, 120, 100,120);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, 390, 120, 250, 120);
		}
		
		// Moving into the template page
		
		public void selecting_template(int slice_x, int slice_y) throws Exception{
		AppLauncher.at.controlFocus(Title.DIGITAL_PAGE, "", Template.SLICE_FRAME);
		AppLauncher.at.controlClick(Title.DIGITAL_PAGE, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, slice_x, slice_y);
		AppLauncher.at.sleep(3000);
		}
		
		// Creating a story
		public void story_creation(String name, int slice_x, int slice_y) throws Exception{
		AppLauncher.at.winActive(Title.TEMPLATE_PAGE);
		AppLauncher.at.controlFocus(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME);
		AppLauncher.at.sleep(3000);
		AppLauncher.at.controlClick(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, slice_x, slice_y);
		AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.getDown(3));
		AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.ENTER);
		AppLauncher.at.sleep(3000);
		AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.ENTER);
		AppLauncher.at.sleep(3000);
		AppLauncher.at.controlFocus(Title.NEWSTORY, "", NewStory.NEW_STORY);
		AppLauncher.at.controlClick(Title.NEWSTORY, "", NewStory.NEW_STORY, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, NewStory.NEW_STORY_X, NewStory.NEW_STORY_Y);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlFocus(Title.NEWSTORY, "", NewStory.CREATE_NEW_STORY);
		AppLauncher.at.controlClick(Title.NEWSTORY, "", NewStory.CREATE_NEW_STORY, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, NewStory.CREATE_NEW_STORY_X, NewStory.CREATE_NEW_STORY_Y);
		AppLauncher.at.sleep(3000);
		AppLauncher.at.winActivate(Title.SAVE_AS);
		AppLauncher.at.controlFocus(Title.SAVE_AS, "", NewStory.FILENAME);
		AppLauncher.at.controlClick(Title.SAVE_AS, "", NewStory.FILENAME, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, NewStory.FILENAME_X, NewStory.FILENAME_Y);
		AppLauncher.at.ControlSetText(Title.SAVE_AS, "", NewStory.FILENAME, name);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlFocus(Title.SAVE_AS, "", NewStory.SAVE_AS);
		AppLauncher.at.controlClick(Title.SAVE_AS, "", NewStory.SAVE_AS, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, NewStory.SAVE_AS_X, NewStory.SAVE_AS_Y);
		AppLauncher.at.sleep(5000);
		AppLauncher.at.winActivate(Title.TEMPLATE_PAGE);
		AppLauncher.at.controlFocus(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME);
		AppLauncher.at.controlClick(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.SLICE_FRAME_OUTSIDE_X, Template.SLICE_FRAME_OUTSIDE_Y);
		AppLauncher.at.sleep(4000);
		AppLauncher.at.controlClick(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, slice_x, slice_y);
		AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.getDown(1));
		AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.ENTER);
		AppLauncher.at.sleep(5000);
		}
		
		public void lead_1(int slice_x, int slice_y) throws Exception{
			AppLauncher.at.winActivate(Title.TEMPLATE_PAGE);
			AppLauncher.at.controlFocus(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME);
			AppLauncher.at.controlClick(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.SLICE_FRAME_OUTSIDE_X, Template.SLICE_FRAME_OUTSIDE_Y);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlClick(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, slice_x, slice_y);
			AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.getDown(1));
			AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.ENTER);
			AppLauncher.at.sleep(5000);
		}
		
		//Channel Copy
		public void channelcopy() throws Exception{
		AppLauncher.at.winWaitActive(Title.CHANNEL_COPY);
		AppLauncher.at.sleep(5000);
		AppLauncher.at.controlFocus(Title.CHANNEL_COPY, "", ChannelCopy.CHANNEL_COPY);
		AppLauncher.at.controlClick(Title.CHANNEL_COPY, "", ChannelCopy.CHANNEL_COPY, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, ChannelCopy.CHANNEL_COPY_X, ChannelCopy.CHANNEL_COPY_Y);
		AppLauncher.at.sleep(5000);
		AppLauncher.at.controlFocus(Title.CHANNEL_COPY, "", ChannelCopy.CHANNEL_COPY_OK);
		AppLauncher.at.controlClick(Title.CHANNEL_COPY, "", ChannelCopy.CHANNEL_COPY_OK, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, ChannelCopy.CHANNEL_COPY_OK_X, ChannelCopy.CHANNEL_COPY_OK_Y);
		AppLauncher.at.sleep(3000);
		}

		//Preparing a Story
		public void preparing_story(String storyheadline, int down_count, int image) throws Exception{
		AppLauncher.at.winWaitActive(Title.STORY_PREPARATION);
		AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", Template.SLICE_FRAME);
		AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, StoryPreparation.HEADLINE_X, StoryPreparation.HEADLINE_Y);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, storyheadline);
		AppLauncher.at.sleep(3000);
		AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", Template.SLICE_FRAME);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, StoryPreparation.STRAPLINE_X, StoryPreparation.STRAPLINE_Y);
		AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, "This is for testing purpose");
		AppLauncher.at.sleep(3000);
		AppLauncher.at.winActivate(Title.STORY_PREPARATION);
		AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", MainMenu.ID);
		AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.VIEW_CORD_X, MainMenu.VIEW_CORD_Y);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.getDown(1));
		AppLauncher.at.sleep(4000);
		AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.ENTER);
		AppLauncher.at.sleep(3000);
		
		AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.SELECTING_IMAGE);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlCommandShowDropdown(Title.STORY_PREPARATION, "", StoryPreparation.SELECTING_IMAGE);
		AppLauncher.at.sleep(5000);
		//AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.SELECTING_IMAGE);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getDown(1), false);
		AppLauncher.at.sleep(3000);
		AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getDown(down_count), false);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, 1700, image, 400, 600, 2000);
		AppLauncher.at.sleep(2000);
		}
		
		
		public void Article_Text() throws Exception{
			AppLauncher.at.winWaitActive(Title.STORY_PREPARATION);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", Template.SLICE_FRAME);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, StoryPreparation.HEADLINE_X, StoryPreparation.HEADLINE_Y);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getTab(9));
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", Template.SLICE_FRAME);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, StoryPreparation.TEXT_CONTENT_X, StoryPreparation.TEXT_CONTENT_Y);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", StoryPreparation.TEXT);
			AppLauncher.at.sleep(4000);
		}
		
		// Clicking on the preview button
		public void preview_publish() throws Exception{
		AppLauncher.at.winActive(Title.STORY_PREPARATION);
		AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.PREVIEW_BUTTON);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.PREVIEW_BUTTON, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.PREVIEW_BUTTON_X, StoryPreparation.PREVIEW_BUTTON_Y);
		AppLauncher.at.sleep(5000);
		AppLauncher.at.winWaitActive(Title.PREVIEW_BROWSER);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlClick(Title.PREVIEW_BROWSER, "", "", Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, 400, 45);
		AppLauncher.at.sleep(3000);
		AppLauncher.at.controlSend(Title.PREVIEW_BROWSER, "", "", "^a");
		AppLauncher.at.controlSend(Title.PREVIEW_BROWSER, "", "", "^c");
		AppLauncher.at.sleep(3000);
		String preview = AppLauncher.at.clipGet();
		System.out.println(preview);
		
		
		// Published the article
		AppLauncher.at.winActivate(Title.STORY_PREPARATION);
		AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.PREVIEW_BUTTON);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.PREVIEW_BUTTON, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, 668, 12);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.winActivate(Title.PUBLISH_CONFIRMATION);
		AppLauncher.at.sleep(2000);
		AppLauncher.at.controlFocus(Title.PUBLISH_CONFIRMATION, "", StoryPreparation.PUBLISH_CONFIRMATION);
		AppLauncher.at.controlClick(Title.PUBLISH_CONFIRMATION, "", StoryPreparation.PUBLISH_CONFIRMATION, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.PUBLISH_CONFIRMATION_X, StoryPreparation.PUBLISH_CONFIRMATION_Y);
		AppLauncher.at.sleep(5000);
		String plink = preview.replace("sip", "si");
		driver.get(plink);
		Thread.sleep(3000);
		String article_date = driver.findElement(By.xpath("//*[@id='article-main']/section/div[1]/div/p/time")).getText();
		System.out.println(article_date);
		//*[@id="article-main"]/section/div[1]/div/p/time
		}
		
		public boolean amazon_bucket() throws Exception{
		String uuid = driver.findElement(By.xpath("//*[@id='ArticleMetaBanner-uuid']")).getAttribute("value");
		//String preview = driver.getCurrentUrl();
		System.out.println(uuid);
		Thread.sleep(3000);
		driver.navigate().to("https://nu-cps-hub-dev-assets.s3.amazonaws.com/methode/times/si/web/articles/"+uuid);
		Thread.sleep(3000);
		return driver.getPageSource().contains(uuid);
		}
		
		public boolean LabelS3_bucket() throws Exception{
			/*String uuid = driver.findElement(By.xpath("//*[@id='ArticleMetaBanner-uuid']")).getAttribute("value");
			//String preview = driver.getCurrentUrl();
			System.out.println(uuid);
			Thread.sleep(3000);
			driver.navigate().to("https://nu-cps-hub-dev-assets.s3.amazonaws.com/methode/times/si/web/articles/"+uuid);
			Thread.sleep(3000);*/
			return driver.getPageSource().contains(StoryPreparation.LABEL_CONTENT);
		}
		
		
		

		
		public void storypreparationclose() throws Exception{
			AppLauncher.at.winActivate(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.FILE_CORD_X, MainMenu.FILE_CORD_Y);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getDown(6));
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.winClose(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(3000);
			
		}
		
		
		public void templatepageclose() throws Exception{
			AppLauncher.at.winActivate(Title.TEMPLATE_PAGE);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.TEMPLATE_PAGE, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.FILE_CORD_X, MainMenu.FILE_CORD_Y);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", "", Mouse.getDown(5));
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.winClose(Title.TEMPLATE_PAGE);
			AppLauncher.at.sleep(3000);
		}
		
		public void digitalpageclose() throws Exception{
			AppLauncher.at.winActivate(Title.DIGITAL_PAGE);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.DIGITAL_PAGE, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.FILE_CORD_X, MainMenu.FILE_CORD_Y);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlSend(Title.DIGITAL_PAGE, "", "", Mouse.getDown(5));
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.DIGITAL_PAGE, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.winClose(Title.DIGITAL_PAGE);
			AppLauncher.at.sleep(3000);
		}
		public void workflow_layout() throws Exception{
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.OVERALLEDITION);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.OVERALLEDITION, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, MainPage.OVERALLEDITION_X, MainPage.OVERALLEDITION_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.WORKFLOW);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.WORKFLOW, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, MainPage.WORKFLOW_X, MainPage.WORKFLOW_Y);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.getDown(12));
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
		}
		
		public void workflowdone_layout() throws Exception{
			AppLauncher.at.winActivate(Title.WORKFLOW);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlFocus(Title.WORKFLOW, "", MainPage.WORKFLOW_DONE);
			AppLauncher.at.controlClick(Title.WORKFLOW, "", MainPage.WORKFLOW_DONE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.WORKFLOW_DONE_X, MainPage.WORKFLOW_DONE_Y);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlFocus(Title.WORKFLOW, "", MainPage.WORKFLOW_DONE_OK);
			AppLauncher.at.controlClick(Title.WORKFLOW, "", MainPage.WORKFLOW_DONE_OK, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.WORKFLOW_DONE_OK_X, MainPage.WORKFLOW_DONE_OK_Y);
			AppLauncher.at.sleep(3000);
		}
		
		public void Edition() throws Exception{
	/*		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sallen\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			Thread.sleep(3000);*/
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.EDITION_PREVIEW);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.EDITION_PREVIEW, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.EDITION_PREVIEW_X, MainPage.EDITION_PREVIEW_Y);
			AppLauncher.at.sleep(5000);
			
			//String ptitle  = "cps-render-sip.elb.tnl-dev.ntch.co.uk/preview/article/5fdc6a04-8704-11e6-9ed4-f2b74109bf85?t=1475548325574";
			// Verifying in the Preview
			AppLauncher.at.winActive(Title.PREVIEW_BROWSER_EDITION);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.PREVIEW_BROWSER_EDITION, "", "", Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, 400, 45);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.PREVIEW_BROWSER_EDITION, "", "", "^a");
			//AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.PREVIEW_BROWSER_EDITION, "", "", "^c");
			//AppLauncher.at.send("{CTRL}a{CTRL}c");
			AppLauncher.at.sleep(3000);
			String preview = AppLauncher.at.clipGet();
			System.out.println(preview);
			AppLauncher.at.sleep(3000);
			
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
			// Published the article
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.EDITION_PUBLISH);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.EDITION_PUBLISH, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.EDITION_PUBLISH_X, MainPage.EDITION_PUBLISH_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActivate(Title.PUBLISH_CONFIRMATION);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlFocus(Title.PUBLISH_CONFIRMATION, "", StoryPreparation.PUBLISH_CONFIRMATION);
			AppLauncher.at.controlClick(Title.PUBLISH_CONFIRMATION, "", StoryPreparation.PUBLISH_CONFIRMATION, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.PUBLISH_CONFIRMATION_X, StoryPreparation.PUBLISH_CONFIRMATION_Y);
			AppLauncher.at.sleep(5000);AppLauncher.at.sleep(5000);
			String plink = preview.replace("sip", "si");
			AppLauncher.at.sleep(3000);
			driver.get(plink);
			Thread.sleep(3000);
			String publishing_date = driver.findElement(By.xpath("//*[@id='top']/section/header/div/time")).getText();
			System.out.println(publishing_date);
		}
		
		public void update_ps() throws Exception{
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActivate(Title.DIGITAL_PAGE);
			AppLauncher.at.controlFocus(Title.DIGITAL_PAGE, "", Template.SLICE_FRAME);
			AppLauncher.at.controlClick(Title.DIGITAL_PAGE, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, Template.SLICE_FRAME_X_LEAD_1_1, Template.SLICE_FRAME_Y_LEAD_1_1);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActivate(Title.TEMPLATE_PAGE);
			AppLauncher.at.controlClick(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, Template.SLICE_FRAME_X_LEAD_1_1, Template.SLICE_FRAME_Y_LEAD_1_1);
			AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.getDown(1));
			AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.ENTER);
			AppLauncher.at.sleep(5000);
		}
		
		public void q_metadata() throws Exception{
			AppLauncher.at.winActive(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.FILE_CORD_X, MainMenu.FILE_CORD_Y);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getDown(15));
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(4000);
		}
		
		public void editionmetadata() throws Exception{
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.OVERALLEDITION);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.OVERALLEDITION, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, MainPage.OVERALLEDITION_X, MainPage.OVERALLEDITION_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.WORKFLOW);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.WORKFLOW, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, MainPage.WORKFLOW_X, MainPage.WORKFLOW_Y);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.getDown(9));
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActivate("Metadata");
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend("Metadata", "", "", Mouse.getDown(6));
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend("Metadata", "", "", "{TAB}");
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend("Metadata", "", "", "09");
			AppLauncher.at.controlSend("Metadata", "", "", "{RIGHT}");
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend("Metadata", "", "", "Nov");
			AppLauncher.at.controlSend("Metadata", "", "", "{RIGHT}");
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend("Metadata", "", "", "2016");
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend("Metadata", "", "", "{RIGHT}");
			AppLauncher.at.controlSend("Metadata", "", "", "09");
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend("Metadata", "", "", "{RIGHT}");
			AppLauncher.at.controlSend("Metadata", "", "", "00");
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend("Metadata", "", "", "{RIGHT}");
			AppLauncher.at.controlSend("Metadata", "", "", "00");
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus("Metadata - GENERAL-01.prx", "", "[ID:1]");
			AppLauncher.at.controlClick("Metadata - GENERAL-01.prx", "", "[ID:1]", Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, 31, 9);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.OVERALLEDITION);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.OVERALLEDITION, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, MainPage.OVERALLEDITION_X, MainPage.OVERALLEDITION_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.WORKFLOW);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.WORKFLOW, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, MainPage.WORKFLOW_X, MainPage.WORKFLOW_Y);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.getDown(11));
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);;
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.EDITION_METADATA);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.EDITION_METADATA, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.EDITION_METADATA_X, MainPage.EDITION_METADATA_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.SET_EDITION_DATE);
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.SET_EDITION_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.UPDATETEXT_EDITION_METADATA_X, MainPage.UPDATETEXT_EDITION_METADATA_Y);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", MainPage.SET_EDITION_DATE, "9AM UPDATE");
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.SET_EDITION_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.EDITION_SAVE_X, MainPage.EDITION_SAVE_Y);
			AppLauncher.at.sleep(3000);
			
		}
		
		public void article_timestamp() throws Exception{
			AppLauncher.at.winActivate(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.SET_ARTICLE_DATE_X, StoryPreparation.SET_ARTICLE_DATE_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.SET_ARTICLE_TIME_X, StoryPreparation.SET_ARTICLE_TIME_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.DONE_ARTICLE_X, StoryPreparation.DONE_ARTICLE_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.ARTICLE_SAVE_X, StoryPreparation.ARTICLE_SAVE_Y);
			
		}
		
		public void currentimestamp() throws Exception{
			Custom cust = new Custom();
			String current_timestamp = cust.currentimestamp();
			AppLauncher.at.winActive(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.SET_ARTICLE_DATE_X, StoryPreparation.SET_ARTICLE_DATE_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", "^a");
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", " "+current_timestamp+" ");
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.DONE_ARTICLE_X, StoryPreparation.DONE_ARTICLE_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.ARTICLE_SAVE_X, StoryPreparation.ARTICLE_SAVE_Y);
		}
		
		public void adding_label() throws Exception{
			AppLauncher.at.winActivate(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.LABEL_X, StoryPreparation.LABEL_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", StoryPreparation.LABEL_CONTENT);
			AppLauncher.at.sleep(3000);
			//AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.ARTICLE_SAVE_X, StoryPreparation.ARTICLE_SAVE_Y);
		}
		
		public void preview() throws Exception{
			AppLauncher.at.winActive(Title.STORY_PREPARATION);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.PREVIEW_BUTTON);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.PREVIEW_BUTTON, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.PREVIEW_BUTTON_X, StoryPreparation.PREVIEW_BUTTON_Y);
			AppLauncher.at.sleep(5000);
			
			//String ptitle  = "cps-render-sip.elb.tnl-dev.ntch.co.uk/preview/article/5fdc6a04-8704-11e6-9ed4-f2b74109bf85?t=1475548325574";
			// Verifying in the Preview
			AppLauncher.at.winWaitActive(Title.PREVIEW_BROWSER);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.PREVIEW_BROWSER, "", "", Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, 400, 45);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.PREVIEW_BROWSER, "", "", "^a");
			//AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.PREVIEW_BROWSER, "", "", "^c");
			//AppLauncher.at.send("{CTRL}a{CTRL}c");
			AppLauncher.at.sleep(3000);
			String preview = AppLauncher.at.clipGet();
			System.out.println(preview);
			driver.get(preview);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='article-main']/header/div/div/p")).isDisplayed();
			String label = driver.findElement(By.xpath("//*[@id='article-main']/header/div/div/p")).getText();
			System.out.println(label);
		}
		
		public void hide_section() throws Exception{
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.EDITION_METADATA);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.EDITION_METADATA, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.SLOT_SECTION_X, MainPage.SLOT_SECTION_Y);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.HIDE_SECTION);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.HIDE_SECTION, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.HIDE_SECTION_X, MainPage.HIDE_SECTION_Y);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.HIDE_SECTION, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.HIDE_SECTION_OK_X, MainPage.HIDE_SECTION_OK_Y);
			AppLauncher.at.sleep(3000);
		}
		
		public boolean hide_sections() throws Exception{
			try{
				driver.findElement(By.xpath("//*[@id='section-news']/header/div/h2/a")).isDisplayed();
			}catch(Exception e){
				System.out.println(e);
			}
			return true;
		}
		
		
		public void friendurl() throws Exception{
			AppLauncher.at.winActivate(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.FRIENDURL_X, StoryPreparation.FRIENDURL_Y);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", "^a");
			//AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", "^c");
			//AppLauncher.at.send("{CTRL}a{CTRL}c");
			AppLauncher.at.sleep(3000);
			AppLauncher.friendlyURL = AppLauncher.at.clipGet();
			System.out.println(AppLauncher.friendlyURL);
		}
		
		public boolean amazon_freindurl() throws Exception{
			return driver.getPageSource().contains(AppLauncher.friendlyURL);
		}
		
		public boolean negative_cropping() throws Exception{
			try
			{
				AppLauncher.at.winActivate(Title.STORY_PREPARATION);
				AppLauncher.at.sleep(3000);
				AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.NEGATIVE_CROPPING1);
				AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.NEGATIVE_CROPPING1, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.NEGATIVE_CROPPING_X, StoryPreparation.NEGATIVE_CROPPING_Y);
				AppLauncher.at.sleep(3000);
				AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, 400, 600, 450, 600, 2000);
				AppLauncher.at.sleep(3000);
				AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.PREVIEW_BUTTON);
				AppLauncher.at.sleep(2000);
				AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.PREVIEW_BUTTON, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.PREVIEW_BUTTON_X, StoryPreparation.PREVIEW_BUTTON_Y);
				AppLauncher.at.sleep(5000);
			}catch(Exception e){
				System.out.println(e);
			}
			return false;
		}
		
		public boolean crop_window() throws Exception{
			try
			{
				AppLauncher.at.winActive(Title.CROPING);
				AppLauncher.at.sleep(3000);
				AppLauncher.at.controlFocus(Title.CROPING, "", StoryPreparation.CROP_POPUP_OK);
				AppLauncher.at.controlClick(Title.CROPING, "", StoryPreparation.CROP_POPUP_OK, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.CROP_POPUP_OK_X, StoryPreparation.CROP_POPUP_OK_Y);
				AppLauncher.at.sleep(4000);
			}catch (Exception e){
				System.out.println(e);
			}
			return false;
		}
		
		
		public void template_selection_secondary_2_2() throws Exception{
		AppLauncher.at.controlFocus(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE);
		AppLauncher.at.controlClick(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.SLICE_TEMPLATE_X, Template.SLICE_TEMPLATE_Y);
		AppLauncher.at.controlSend(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE, SliceTemplate.getTemplate(TemplateSlice.SECONDARY_2_AND_2));
		AppLauncher.at.sleep(3000);
		
		// Drag and drop the slice template
		int mx = AppLauncher.at.controlGetPosX(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE);
		int my = AppLauncher.at.controlGetPosY(Title.DIGITAL_PAGE, "", Template.SLICE_TEMPLATE);
		int position = SliceTemplate.getTemplatePosition(TemplateSlice.SECONDARY_2_AND_2);
		int positionLength  =(position * 19) - 30; 
		System.out.println(positionLength);
		AppLauncher.at.mouseMove(mx, my + positionLength,2000);
		AppLauncher.at.sleep(3000);
		int y_axis =  my + positionLength;
		System.out.println(y_axis);
		System.out.println(mx +" "+my);
		System.out.println(positionLength);
		AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, mx, y_axis, 500, 254, 200);
		AppLauncher.at.sleep(3000);
		}
		
		public void insert_section(int down) throws Exception{
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.INSERT_PAGE);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.INSERT_PAGE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.INSERT_PAGE_X, MainPage.INSERT_PAGE_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.getDown(down));
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
		}
		
		public void scotlant(int down) throws Exception{
			AppLauncher.at.winWaitActive(Title.INSERTPAGES);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.INSERTPAGES, "", MainPage.INSERTPAGES);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.INSERTPAGES, "", MainPage.INSERTPAGES, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.INSERTPAGES_X, MainPage.INSERTPAGES_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.INSERTPAGES, "", "", Mouse.getDown(down));
			AppLauncher.at.controlSend(Title.INSERTPAGES, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
		}
		
		public void swap_section() throws Exception{
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", "", Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.Sco_Section_X, MainPage.Sco_Section_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, 800, 350, 500, 350);
			Thread.sleep(7000);
			/*AppLauncher.at.sleep(5000);
			AppLauncher.at.mouseGetPosX();
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.getDown(1));
			AppLauncher.at.sleep(3000);*/
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.getDown(1));
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
		}
		
		public void relink() throws Exception{
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActivate(Title.DIGITAL_PAGE);
			AppLauncher.at.controlFocus(Title.DIGITAL_PAGE, "", Template.SLICE_FRAME);
			AppLauncher.at.controlClick(Title.DIGITAL_PAGE, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, Template.SLICE_FRAME_X_LEAD_1_1_2, Template.SLICE_FRAME_Y_LEAD_1_1_2);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActivate(Title.TEMPLATE_PAGE);
			AppLauncher.at.controlClick(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, Template.SLICE_FRAME_X_LEAD_1_1_2, Template.SLICE_FRAME_Y_LEAD_1_1_2);
			AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.getDown(4));
			AppLauncher.at.controlSend(Title.TEMPLATE_PAGE, "", Template.SLICE_FRAME, Mouse.ENTER);
			AppLauncher.at.sleep(5000);
		}
		
		public void relink_confirm() throws Exception{
			AppLauncher.at.winWaitActive(Title.CONFIRM_POPUP);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.CONFIRM_POPUP, "", Template.CONFORM_POPUP);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.CONFIRM_POPUP, "", Template.CONFORM_POPUP, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.CONFORM_POPUP_X, Template.CONFORM_POPUP_Y);
			AppLauncher.at.sleep(3000);
		}
		
		public void quickacess(String windowname, String toolview, int toolview_x, int toolview_y, int down) throws Exception{
			AppLauncher.at.winActivate(windowname);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(windowname, "", toolview);
			AppLauncher.at.controlClick(windowname, "", toolview, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, toolview_x, toolview_y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(windowname, "", "", Mouse.getDown(down));
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(windowname, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
		}
		
		public void quick_icon_click(String windowname, String toolview, int toolview_x, int toolview_y) throws Exception{
			AppLauncher.at.winActivate(windowname);
			AppLauncher.at.controlFocus(windowname, "", toolview);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(windowname, "", toolview,Mouse.LEFT_CLICK , Mouse.SINGLE_CLICK, toolview_x, toolview_y);
			AppLauncher.at.sleep(3000);
		}

		public void quickacess_filename(String Storyname) throws Exception{
			AppLauncher.at.winWaitActive(Title.QUICKACCESS);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.QUICKACCESS, "", Template.QUICKACCESS_FILENAME);
			AppLauncher.at.controlClick(Title.QUICKACCESS, "", Template.QUICKACCESS_FILENAME, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.QUICKACESS_FILENAME_X, Template.QUICKACESS_FILENAME_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.ControlSetText(Title.QUICKACCESS, "", "", Storyname);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.QUICKACCESS, "", "", Mouse.ENTER);
			//AppLauncher.at.controlFocus(Title.QUICKACCESS, "", Template.QUICKACCESS_OK_BUTTON);
			//AppLauncher.at.controlClick(Title.QUICKACCESS, "", Template.QUICKACCESS_OK_BUTTON, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, Template.QUICKACESS_OK_BUTTON_X, Template.QUICKACESS_OK_BUTTON_Y);
			AppLauncher.at.sleep(3000);
		}
		
		public void quickacess_filenames(String Storyname) throws Exception{
			AppLauncher.at.winWaitActive(Title.QUICKACCESS);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.QUICKACCESS, "", Template.QUICKACCESS_FILENAME);
			AppLauncher.at.controlClick(Title.QUICKACCESS, "", Template.QUICKACCESS_FILENAME, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.QUICKACESS_FILENAME_X, Template.QUICKACESS_FILENAME_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.ControlSetText(Title.QUICKACCESS, "", "", Storyname);
			AppLauncher.at.sleep(5000);
			//AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.ENTER);
			AppLauncher.at.controlFocus(Title.QUICKACCESS, "", Template.QUICKACCESS_OK_BUTTON);
			AppLauncher.at.controlClick(Title.QUICKACCESS, "", Template.QUICKACCESS_OK_BUTTON, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.QUICKACESS_OK_BUTTON_X, Template.QUICKACESS_OK_BUTTON_Y);
			AppLauncher.at.sleep(3000);
		}
		
		public void existing_stroy(int dest_x, int dest_y) throws Exception{
			AppLauncher.at.winActivate(Title.TEMPLATE_PAGE);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.TEMPLATE_PAGE, "", Template.QUICKACCESS);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, Template.QUERY_X, Template.QUERY_Y, dest_x, dest_y);
		}	
		
		public void major_template() throws Exception{
			AppLauncher.at.winActivate(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.MAJOR_TEMPLATE_X, StoryPreparation.MAJOR_TEMPALTE_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getDown(1));
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.SET_ARTICLE_DATE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.ARTICLE_SAVE_X, StoryPreparation.ARTICLE_SAVE_Y);
		}
		
		public void Insert_Image(int down_count, int image) throws Exception{
			AppLauncher.at.winActivate(Title.STORY_PREPARATION);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", MainMenu.ID);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.VIEW_CORD_X, MainMenu.VIEW_CORD_Y);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.getDown(1));
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.ENTER);
			AppLauncher.at.sleep(3000);
			
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.SELECTING_IMAGE);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlCommandShowDropdown(Title.STORY_PREPARATION, "", StoryPreparation.SELECTING_IMAGE);
			AppLauncher.at.sleep(5000);
			//AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.SELECTING_IMAGE);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getDown(1), false);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getDown(down_count), false);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, 1700, image, 302, 700, 2000);
			AppLauncher.at.sleep(3000);
			}
		
		public void image3_2() throws Exception{
			AppLauncher.at.winActive(Title.ASSERT_IMAGE);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.ASSERT_IMAGE, "", StoryPreparation.ASSERTIMAGE_IMAGESIZE);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.ASSERT_IMAGE, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
		}
		
		public void image2_3() throws Exception{
			AppLauncher.at.winActivate(Title.STORY_PREPARATION);;
			AppLauncher.at.sleep(3000);
			AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, 1700, StoryPreparation.IMAGE_2_Y, 350, 770, 2000);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winActive(Title.ASSERT_IMAGE);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.ASSERT_IMAGE, "", StoryPreparation.ASSERTIMAGE_IMAGESIZE);
			AppLauncher.at.controlClick(Title.ASSERT_IMAGE, "", StoryPreparation.ASSERTIMAGE_IMAGESIZE, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.ASSERTIMAGE_IMAGESIZE_X, StoryPreparation.ASSERTIMAGE_IMAGESIZE_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.ASSERT_IMAGE, "", "", Mouse.getDown(3));
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.ASSERT_IMAGE, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.ASSERT_IMAGE, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
			
		}
		
		
		public void template_preview_publish() throws Exception{
			AppLauncher.at.winActive(Title.TEMPLATE_PAGE);
			AppLauncher.at.controlFocus(Title.TEMPLATE_PAGE, "", Template.PREVIEW_BUTTON);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.TEMPLATE_PAGE, "", Template.PREVIEW_BUTTON, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.PREVIEW_BUTTON_X, Template.PREVIEW_BUTTON_Y);
			AppLauncher.at.sleep(5000);
			AppLauncher.at.winWaitActive(Title.PREVIEW_BROWSER);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.PREVIEW_BROWSER, "", "", Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, 400, 45);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.PREVIEW_BROWSER, "", "", "^a");
			AppLauncher.at.controlSend(Title.PREVIEW_BROWSER, "", "", "^c");
			AppLauncher.at.sleep(3000);
			String preview = AppLauncher.at.clipGet();
			System.out.println(preview);
			
			
			// Published the article
			AppLauncher.at.winActivate(Title.TEMPLATE_PAGE);
			AppLauncher.at.controlFocus(Title.TEMPLATE_PAGE, "", Template.PREVIEW_BUTTON);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.TEMPLATE_PAGE, "", Template.PREVIEW_BUTTON, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, 497, 13);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.winActivate(Title.PUBLISH_CONFIRMATION);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlFocus(Title.PUBLISH_CONFIRMATION, "", Template.PUBLISH_CONFIRMATION);
			AppLauncher.at.controlClick(Title.PUBLISH_CONFIRMATION, "", Template.PUBLISH_CONFIRMATION, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.PUBLISH_CONFIRMATION_X, Template.PUBLISH_CONFIRMATION_Y);
			AppLauncher.at.sleep(5000);
			String plink = preview.replace("sip", "si");
			driver.get(plink);
			Thread.sleep(3000);
		}
		public void template_preview() throws Exception{
			AppLauncher.at.winActive(Title.TEMPLATE_PAGE);
			AppLauncher.at.controlFocus(Title.TEMPLATE_PAGE, "", Template.PREVIEW_BUTTON);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.TEMPLATE_PAGE, "", Template.PREVIEW_BUTTON, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, Template.PREVIEW_BUTTON_X, Template.PREVIEW_BUTTON_Y);
			AppLauncher.at.sleep(5000);
			AppLauncher.at.winWaitActive(Title.PREVIEW_BROWSER);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.PREVIEW_BROWSER, "", "", Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, 362, 45);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.PREVIEW_BROWSER, "", "", "^a");
			AppLauncher.at.controlSend(Title.PREVIEW_BROWSER, "", "", "^c");
			AppLauncher.at.sleep(3000);
			String preview = AppLauncher.at.clipGet();
			System.out.println(preview);
			driver.get(preview);
		}
		
		public boolean dummy() throws Exception{
			try{
				String dummy = driver.findElement(By.xpath("//*[@id='section-preview']/div[1]/div/div[2]/div[2]/h3/a")).getText();
				System.out.println("Dummay Object  " + dummy);
			}catch(Exception e){
				System.out.println(e);
			}
			return false;
		}
	
		
		public void pull_quotes() throws Exception{
			AppLauncher.at.winActivate(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", MainMenu.ID);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", "{ALT}",false);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.VIEW_CORD_X, MainMenu.VIEW_CORD_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", "c",false);
			//AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", MainMenu.ID, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainMenu.VIEW_CORD_X, MainMenu.VIEW_CORD_Y);
			//AppLauncher.at.sleep(3000);
			//AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getDown(3));
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.COMPONENT_WEB);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlCommandShowDropdown(Title.STORY_PREPARATION, "", StoryPreparation.COMPONENT_WEB);
			//AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.COMPONENT_WEB, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.COMPONENT_WEB_X, StoryPreparation.COMPONENT_WEB_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getDown(2));
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
		}
		
		public void pullquotes_select() throws Exception{
			AppLauncher.at.winActivate(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.PULL_QUOTES);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.PULL_QUOTES, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.PULL_QUOTES_X, StoryPreparation.PULL_QUOTES_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", "pu");
			AppLauncher.at.sleep(4000);
			AppLauncher.at.controlListViewGetSelectedCount(Title.STORY_PREPARATION, "", StoryPreparation.PULL_QUOTES);
			//AppLauncher.at.controlTreeViewGetSelectedItemIndex(Title.STORY_PREPARATION, "", StoryPreparation.PULL_QUOTES);
			//AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, 43, 237, 331, 650, 2000);
			//AppLauncher.at.sleep(4000);
			
		}
		
		
		public void quotes_position() throws Exception{
			int mx = AppLauncher.at.controlGetPosX(Title.STORY_PREPARATION, "", StoryPreparation.PULL_QUOTES);
			int my = AppLauncher.at.controlGetPosY(Title.STORY_PREPARATION, "", StoryPreparation.PULL_QUOTES);
			System.out.println(mx + "," +my);
			int mz = AppLauncher.at.mouseGetCursor();
			System.out.println(mz);
			int nx = AppLauncher.at.mouseGetPosX();
			int ny = AppLauncher.at.mouseGetPosY();
			System.out.println(nx + "," +ny);
			//AppLauncher.at.controlClick(title, text, controlID)
		}
		
		
		public void related_link() throws Exception{
			AppLauncher.at.winActivate(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.LINKS);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.LINKS, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.LINKS_X, StoryPreparation.LINKS_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.winWaitActive(Title.STORY_PREPARATION);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", Template.SLICE_FRAME);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", Template.SLICE_FRAME, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, StoryPreparation.HEADLINE_X, StoryPreparation.HEADLINE_Y);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getTab(10));
		}
		
		public void lead_lead() throws Exception{
			AppLauncher.at.winActivate(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.RELATED_LINKS);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.RELATED_LINKS, Mouse.LEFT_CLICK, Mouse.DOUBLE_CLICK, StoryPreparation.RELATED_LINKS_X, StoryPreparation.RELATED_LINKS_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.RELATED_LINKS, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.RELATED_LINKS_X, StoryPreparation.RELATED_LINKS_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getDown(10));
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.STORY_PREPARATION, "", "", Mouse.getTab(2));
		}
		
		public void existing_stroy_relatedlinks(int dest_x, int dest_y) throws Exception{
			AppLauncher.at.winActivate(Title.STORY_PREPARATION);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.STORY_PREPARATION, "", StoryPreparation.QUICKACCESS);
			//AppLauncher.at.controlClick(Title.STORY_PREPARATION, "", StoryPreparation.QUICKACCESS, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.QUERY_STORY_X, StoryPreparation.QUERY_STORY_Y);
			//AppLauncher.at.mouseClick(Mouse.LEFT_CLICK, 1688, 286, Mouse.SINGLE_CLICK, 2000);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.mouseClickDrag(Mouse.LEFT_CLICK, 1688,276,dest_x, dest_y,2000);
			AppLauncher.at.sleep(3000);
		}
		
		public boolean browser_relatedlinks() throws Exception{
			return driver.findElement(By.xpath("//*[@id='Auxiliary-content']/div[1]/h3")).isDisplayed();
		}
		
		public boolean browser_relatedstorylinks() throws Exception{
			return driver.findElement(By.xpath("//*[@id='Auxiliary-content']/div[1]/div/div/div/div[2]/h3/a")).isDisplayed();
		}
		
		
		public void assert_links() throws Exception{
			AppLauncher.at.winWaitActive(Title.ASSERT_IMAGE);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.ASSERT_IMAGE, "", StoryPreparation.LINKS_POPUP_OK);
			AppLauncher.at.controlClick(Title.ASSERT_IMAGE, "", StoryPreparation.LINKS_POPUP_OK, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, StoryPreparation.LINKS_POPUP_OK_X, StoryPreparation.LINKS_POPUP_OK_Y);
			AppLauncher.at.sleep(3000);
		}
		
		public void special_section() throws Exception{
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.RIGHT_CLICK, Mouse.SINGLE_CLICK, MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.getDown(4));
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", Mouse.ENTER);
			AppLauncher.at.sleep(5000);
			
		}
		
		public void section_name_change() throws Exception{
			AppLauncher.at.winActivate(Title.PAGE_PLANNER);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.Bus_Section);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.Bus_Section, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.Bus_Section_X, MainPage.Bus_Section_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.EDITION_METADATA);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.EDITION_METADATA, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.SLOT_SECTION_X, MainPage.SLOT_SECTION_Y);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlFocus(Title.PAGE_PLANNER, "", MainPage.HIDE_SECTION);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.HIDE_SECTION, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.SPECIAL_SECTION_X, MainPage.SPECIAL_SECTION_Y);
			AppLauncher.at.sleep(2000);
			AppLauncher.at.controlSend(Title.PAGE_PLANNER, "", "", MainPage.SPECIAL_SECTION_NAME);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlClick(Title.PAGE_PLANNER, "", MainPage.HIDE_SECTION, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, MainPage.HIDE_SECTION_OK_X, MainPage.HIDE_SECTION_OK_Y);
			AppLauncher.at.sleep(3000);
		}
		
		public void apply_ok() throws Exception{
			AppLauncher.at.winActivate(Title.WORKFLOW_LAYOUT);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.WORKFLOW_LAYOUT, "", WorkflowLayout.APPLY_BUTTON);
			AppLauncher.at.controlClick(Title.WORKFLOW_LAYOUT, "", WorkflowLayout.APPLY_BUTTON, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, WorkflowLayout.APPLY_BUTTON_X, WorkflowLayout.APPLY_BUTTON_Y);
			AppLauncher.at.sleep(3000);
			AppLauncher.at.controlFocus(Title.WORKFLOW_LAYOUT, "", WorkflowLayout.OK_BUTTON);
			AppLauncher.at.controlClick(Title.WORKFLOW, "", WorkflowLayout.OK_BUTTON, Mouse.LEFT_CLICK, Mouse.SINGLE_CLICK, WorkflowLayout.OK_BUTTON_X, WorkflowLayout.OK_BUTON_Y);
			AppLauncher.at.sleep(3000);
		}
		
		public boolean section_name() throws Exception{
			return driver.findElement(By.xpath("//*[@id='top']/section[2]/header/div/h2/a")).isDisplayed();
		}
		
		
		
		public void driverclose() throws Exception{
			driver.quit();
		}
		
}
