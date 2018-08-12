package com.bluesky.object.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement getUsernameTextbox()
	{
		WebElement un=driver.findElement(By.xpath("//input[@type='text']"));
		return un;
	}
	
	public WebElement getPasswordTextbox()
	{
		WebElement pass=driver.findElement(By.xpath("//input[@type='password']"));
		return pass;
	}
	
	public WebElement getLoginButton()
	{
		WebElement lbtn=driver.findElement(By.xpath("//input[@type='submit']"));
		return lbtn;
	}
	
	public WebElement getLoginErrorMsg()
	{
		WebElement msg=driver.findElement(By.xpath("//span[contains(text(),'Password is invalid')]"));
		return msg;
	}

	public void waitForLoginPageToLoad()
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("LoginForm"))));
	}
}

