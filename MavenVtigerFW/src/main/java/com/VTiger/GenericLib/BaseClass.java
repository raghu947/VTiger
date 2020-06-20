package com.VTiger.GenericLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.VTiger.GenericLib.DataUtility;
import com.VTiger.GenericLib.WebDriverCommonUtils;
import com.VTiger.ObjectRepositary.HomePageElements;
import com.VTiger.ObjectRepositary.LoginPageElements;

public class BaseClass {
	public static WebDriver driver;
	public DataUtility data =new DataUtility();
	public WebDriverCommonUtils wlib=new WebDriverCommonUtils();
	@BeforeSuite
	public void configBS()
	{
		System.out.println("database connected");
	}
	@BeforeClass
	public void configBC() throws IOException
	{
		System.out.println("browser launch starts");
		String browser=data.getDataFromProperty("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver =new ChromeDriver();
		}else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver =new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(data.getDataFromProperty("url"));
		System.out.println("browser launching ends");
	}
	@BeforeMethod
	public void configBM() throws IOException
	{
		System.out.println("login starts");
		LoginPageElements login = PageFactory.initElements(driver, LoginPageElements.class);
		login.loginToApp(data.getDataFromProperty("un"), data.getDataFromProperty("pwd"));
		System.out.println("login ends");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("logout starts");
		HomePageElements hp = PageFactory.initElements(driver, HomePageElements.class);
		hp.logoutFromApp();
		System.out.println("logout ends");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("close the browser");
		driver.quit();
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("database disconnect");
	}
}
