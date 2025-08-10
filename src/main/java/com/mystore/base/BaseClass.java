package com.mystore.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;





public class BaseClass {

	
	public static Properties prop;
	//public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	
	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() {
		ExtentManager.setExtent();
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\configuration\\config.properties");
			
			prop.load(ip);
          System.out.println("driver: "+ driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	@AfterSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void AfterSuite() {
		ExtentManager.endReport();
	}
	 
	/*
	 * @BeforeTest(groups = { "Smoke", "Sanity", "Regression" }) public void
	 * loadConfig() { try { prop = new Properties(); FileInputStream ip = new
	 * FileInputStream( System.getProperty("user.dir") +
	 * "\\configuration\\config.properties");
	 * 
	 * prop.load(ip); System.out.println("driver: "+ driver); } catch
	 * (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	//@Parameters("browser")
	public static void launchApp() {
		 String browserName = prop.getProperty("browser");
		 System.out.println("browser is :"+browserName);
		 System.out.println("url is :"+prop.getProperty("url"));
		
			
			if (browserName.equalsIgnoreCase("Chrome")) {
				
				//driver=new ChromeDriver();
				driver.set(new ChromeDriver());
			
		} else if (browserName.equalsIgnoreCase("FireFox")) {
		
			driver.set(new FirefoxDriver());
			// Set Browser to ThreadLocalMap
			
		} 
		try {
			//getDriver.manage().window().maximize();
			getDriver().manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("url"));
		getDriver().get(prop.getProperty("url"));
	}


}


