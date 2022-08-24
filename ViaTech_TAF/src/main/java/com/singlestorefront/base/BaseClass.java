package com.singlestorefront.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.singlestorefront.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This base class contains method for
 * initialization of the driver and invoking
 * of reporting,and readProperty methods
 *
 * @version 1.0
 *
 */

public class BaseClass {

	public static Properties prop;
	//public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static String getOSPath(String... pathSegments){
		String os_path = null;
		if(System.getProperty("os.name").equals("Windows 10")){
			os_path = "\\" + String.join("\\", pathSegments);
		}
		else if(System.getProperty("os.name").equals("Linux")){
			os_path = "//" + String.join("//", pathSegments);
		}
		else{
			System.out.println("Error in defining OS" + System.getProperty("os.name"));
		}
		return os_path;
	}

	@BeforeSuite(groups={"Smoke", "Regression"})
	public void reporting() {
		ExtentManager.setExtent();
	}

	@BeforeSuite(groups={"Smoke", "Regression"})
	public void loadconfig() throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + getOSPath("Configuration", "config.properties"));

		prop = new Properties();
		prop.load(fis);
	}

	@AfterSuite(groups={"Smoke", "Regression"})
	public void reportingend() {
		ExtentManager.endReport();
	}

	public static void launchApp(String browser) {
		//WebDriverManager.chromedriver().setup();

		String headless = System.getProperty("headless");

		if(browser.equalsIgnoreCase("chrome")) {
			if((headless != null) && headless.equals("yes")) {
				WebDriverManager.chromedriver().setup();
				System.out.println("Running in headless mode");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("enable-automation");
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--window-size=1920,1080");
				chromeOptions.setAcceptInsecureCerts(true);
				chromeOptions.addArguments( "--no-sandbox");
				chromeOptions.addArguments("--disable-dev-shm-usage");
				chromeOptions.addArguments("--disable-gpu");
				chromeOptions.addArguments("--disable-extensions");
				chromeOptions.addArguments("--start-maximized");
				driver.set(new ChromeDriver(chromeOptions));
			} else {
				System.out.println("Running in normal mode");
				WebDriverManager.chromedriver().setup();
				//driver = new ChromeDriver();
				driver.set(new ChromeDriver());
			}
		}

		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}

		if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		try {
			getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageloadtime")), TimeUnit.SECONDS);
		}
		catch (TimeoutException e) {
			getDriver().navigate().refresh();
			getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageloadtime")), TimeUnit.SECONDS);
		}
	}


}







