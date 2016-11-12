package com.extentReportManager;


import java.io.File;


import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManager {
private static ExtentReports extent;
public static String suiteName="default";   
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
        	// extent = new ExtentReports("IAPTestReport.htm", true);
        	   
 	       // extent.assignProject("SAFTest");
 	        // extent.x("10.98.5.54", 27017);
           extent = new ExtentReports(System.getProperty("user.dir")+"/TestReport_Enterprise.htm", true);
            
           System.out.println(System.getProperty("user.dir"));
            extent
                .addSystemInfo("Host Name", "Allen")
                .addSystemInfo("Environment", "QA");
            
            //extent.loadConfig(new File(System.getProperty("user.dir")+"/resources/extent-config.xml"));
        }
        
        return extent;
    }
}
