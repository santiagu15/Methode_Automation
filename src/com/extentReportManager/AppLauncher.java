package com.extentReportManager;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import com.jacob.com.LibraryLoader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import autoitx4java.AutoItX;

public class AppLauncher {
	protected ExtentReports extent;
	public static AutoItX at;
	public static String friendlyURL;
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
		
		/**Assigning the TestSuitename to generate report*/
    	ExtentReportManager.suiteName="Enterprise";
    	/**Creating the instance of the extent report*/
    	extent = ExtentReportManager.getReporter();
	}
	@BeforeMethod
	protected void beforeMethod(Method method){
		ExtentTestManager.startTest(method.getName()).assignCategory("default");
	}
	
	@AfterMethod
    protected void afterMethod(ITestResult result) {

    	/** This after Method annotation checks the result returned from testNg and logging the status into extent report
    	 * and flushing the result .*/


    	if (result.getStatus() == ITestResult.FAILURE) {
    		ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
    	} else if (result.getStatus() == ITestResult.SKIP) {
    		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
    	} else {
    		ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    	}


    	ExtentReportManager.getReporter().endTest(ExtentTestManager.getTest());        
    	ExtentReportManager.getReporter().flush();

    }
	
	@AfterSuite
    protected void afterSuite() {
    	
    	/** Closing the extent report after writing the report */
    	extent.close();
    	/** Quitting the driver*/
    	//  driver.quit();
	}
	
}
