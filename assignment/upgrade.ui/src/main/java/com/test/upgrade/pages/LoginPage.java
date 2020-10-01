package com.test.upgrade.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.test.upgrade.pages.base.BasePage;

public class LoginPage extends BasePage{
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign in to your account']")
	private WebElement signin;

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUsername(String query) {
		username.clear();
		username.sendKeys(query);
	}
	
	public void enterPwd(String query) {
		password.clear();
		password.sendKeys(query);
	}
	
	public void signIn() {
		signin.click();
	}
	
	public void login(String username, String password){
		this.enterUsername(username);
		this.enterPwd(password);
		this.signIn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
