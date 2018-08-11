package com.rogers.testparllel;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.baseclass.Driver;
import com.rogers.pagerepository.LoginPage;

public class TestParllel2 {
	
	public WebDriver driver;
	
	LoginPage lp = new LoginPage(driver);
	
	Driver d = new Driver();
	
	//@Parameters ({"browser"})
	@BeforeTest
	public void bInvoke()
	{
		driver = d.browserInvoke("Firefox");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src = '//fiddle.jshell.net/rlourenco/cp6bc9ka/4/show/light/']")));
	}
	
	@Test
	public void form()
	{
		lp.fname(driver).clear();
		lp.fname(driver).sendKeys("Anil");
		lp.lName(driver).clear();
		lp.lName(driver).sendKeys("Srivalli");
		lp.email(driver).clear();
		lp.email(driver).sendKeys("Srivalli@gmail.com");
		lp.submit(driver).click();
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
