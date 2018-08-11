package com.rogers.pagerepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By FName = By.xpath("//input[@id='firstName']");
	By LName = By.xpath("//input[@id ='lastName']");
	By Email = By.xpath("//input[@id='emailAddress']");
	By Submit= By.xpath("//input[@id ='bySubmit']");
	
	public WebElement fname(WebDriver driver)
	{
		return driver.findElement(FName);
	}
	
	public WebElement lName(WebDriver driver)
	{
		return driver.findElement(LName);
		
	}

	public WebElement email(WebDriver driver)
	{
		return driver.findElement(Email);
	}
	
	public WebElement submit(WebDriver driver)
	{
		return driver.findElement(Submit);
	}
}
