package com.rogers.testparllel;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.baseclass.Driver;
import com.rogers.pagerepository.LoginPage;

import junit.framework.Assert;

public class TestParllel3 {
	
	public WebDriver driver;
	
	LoginPage lp = new LoginPage(driver);
	
	Driver d = new Driver();
	
	@Parameters ({"browser"})
	@BeforeMethod
	public void bInvoke(String browser)
	{
		driver = d.browserInvoke(browser);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src = '//fiddle.jshell.net/rlourenco/cp6bc9ka/4/show/light/']")));
	}
	
	@Test (priority =1)
	public void firstName()
	{
		lp.fname(driver).clear();
		lp.fname(driver).sendKeys("");
		lp.lName(driver).clear();
		lp.lName(driver).sendKeys("Srivalli");
		lp.email(driver).clear();
		lp.email(driver).sendKeys("Srivalli@gmail.com");
		lp.submit(driver).click();
		String ferror =driver.switchTo().alert().getText();
		Assert.assertEquals("Please enter valid first name.", ferror);
		driver.switchTo().alert().accept();
	}
	
	
	@Test(priority =2)
	public void lastName()
	{
		lp.fname(driver).clear();
		lp.fname(driver).sendKeys("Anil");
		lp.lName(driver).clear();
		lp.lName(driver).sendKeys("");
		lp.email(driver).clear();
		lp.email(driver).sendKeys("Srivalli@gmail.com");
		lp.submit(driver).click();
		String lerror =driver.switchTo().alert().getText();
		Assert.assertEquals("Please enter valid last name.", lerror);
		driver.switchTo().alert().accept();
	}
	
	
	@Test(priority =3)
	public void email()
	{
		lp.fname(driver).clear();
		lp.fname(driver).sendKeys("Anil");
		lp.lName(driver).clear();
		lp.lName(driver).sendKeys("Srivalli");
		lp.email(driver).clear();
		lp.email(driver).sendKeys("S");
		lp.submit(driver).click();
		String lerror =driver.switchTo().alert().getText();
		Assert.assertEquals("Please enter valid email address.", lerror);
		driver.switchTo().alert().accept();
		
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
