package com.bluesky.test.util;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver {
	
	public static WebDriver getDriverInstance()
	{
		WebDriver driver=null;
		String browser=DataHandlers.getDataFromProperties("./config-data/configuration.properties", "browser");
		String url= DataHandlers.getDataFromProperties("./config-data/configuration.properties", "url");
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", "./browser-servers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./browser-servers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else
		{
			System.err.println("----Invalid Browser Option-------");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

}
