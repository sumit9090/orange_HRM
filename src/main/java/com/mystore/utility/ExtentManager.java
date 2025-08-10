package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author Hitendra: ExtentManager class is used for Extent Report
 *  
 */import com.aventstack.extentreports.ExtentReports;
 import com.aventstack.extentreports.ExtentTest;
 import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

 public class ExtentManager {

     public static ExtentHtmlReporter htmlReporter;
     public static ExtentReports extent;
     public static ExtentTest test;

     public static void setExtent() {
         if (extent == null) { // Prevent multiple initializations
             String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport/MyReport.html";
             htmlReporter = new ExtentHtmlReporter(reportPath);

             try {
                 htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
             } catch (Exception e) {
                 System.out.println("Warning: Could not load extent-config.xml. Using default config.");
             }

             extent = new ExtentReports();
             extent.attachReporter(htmlReporter);

             extent.setSystemInfo("HostName", "MyHost");
             extent.setSystemInfo("ProjectName", "MyAutomationStore");
             extent.setSystemInfo("Tester", "Sumit");
             extent.setSystemInfo("OS", "Win10");
             extent.setSystemInfo("Browser", "Chrome");
         }
     }

     public static void endReport() {
         if (extent != null) {
             extent.flush();
         }
     }
 }
