package com.rogers.baseclass;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
public WebDriver driver;
	
	public WebDriver browserInvoke(String browser)
	{
		
		
		if(browser.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath()+File.separator+"DriverSource"+File.separator+"chromedriver");
		
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://jsfiddle.net/rlourenco/cp6bc9ka/4/embedded/result/");
		
		driver.manage().window().fullscreen();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}
		else if (browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", new File("").getAbsolutePath()+File.separator+"DriverSource"+File.separator+"geckodriver 2");
			
			driver = new FirefoxDriver();
			
			driver.manage().deleteAllCookies();
			
			driver.get("https://jsfiddle.net/rlourenco/cp6bc9ka/4/embedded/result/");
			
			driver.manage().window().fullscreen();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		
		return driver;
	}


}
