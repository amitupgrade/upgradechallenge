package com.test.upgrade.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.test.upgrade.pages.base.BasePage;

public class ApplicationPage extends BasePage{
	
	@FindBy(css = "div>h1")
	protected WebElement pageHeader;
	
	@FindBy(xpath = "//a[text()='Advanced Query']")
	private WebElement advancedQueryTab;
	
	@FindBy(xpath = "//input[@name='desiredAmount' and @type='tel']")
	private WebElement loanAmount;
	
	@FindBy(xpath = "//select[@aria-label='Loan Purpose']")
	private WebElement loanPurpose;
	
	@FindBy(xpath = "//button[text()='Check your rate']")
	private WebElement checkYourRate;
	
	@FindBy(xpath = "//input[@type='text' and @name='borrowerFirstName']") 
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@type='text' and @name='borrowerLastName']")
	private WebElement lastName;
	
	@FindBy(id = "borrowerStreet")
	private WebElement street;
	
	@FindBy(xpath = "//input[@type='text' and @name='borrowerCity']")
	private WebElement city;
	
	@FindBy(xpath = "//input[@type='text' and @name='borrowerState']")
	private WebElement state;
	
	@FindBy(xpath = "//input[@type='text' and @name='borrowerZipCode']")
	private WebElement zipcode;
	
	@FindBy(xpath = "//input[@type='text' and @name='borrowerDateOfBirth']")
	private WebElement dob;
	
	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement cont;
	
	@FindBy(xpath = "//input[@type='text' and @name='borrowerIncome']")
	private WebElement indiIncome;
	
	@FindBy(xpath = "//input[@type='text' and @name='borrowerAdditionalIncome']")
	private WebElement addiIncome;
	
	@FindBy(xpath = "//button[@data-auto='continuePersonalInfo' and @type='submit']")
	private WebElement contIncome;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='checkbox']/following::div[1]")
	private WebElement checkbox;
	
	@FindBy(xpath = "//button[text()='Check Your Rate']")
	private WebElement checkRateButton;
	
	public ApplicationPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterLoanAmount() {
		loanAmount.sendKeys("2000");
	}
	
	public void selectLoanPurpose() {
		Select select = new Select(loanPurpose);
		select.selectByVisibleText("Business");
	}
	
	public void clickCYR() {
		checkYourRate.click();
	}
	
	public void enterFirstName() {
		firstName.sendKeys("John");
	}
	
	public void enterLastName() {
		lastName.sendKeys("Doe");
	}
	
	public void enterStreet() {
		street.sendKeys("Kifer Road Apt#23");
	}
	
	public void enterCity() {
		city.sendKeys("San Francisco");
	}
	
	public void enterState() {
		state.sendKeys("CA");
	}
	
	public void enterZipcode() {
		zipcode.sendKeys("94111");
	}
	
	public void enterDOB() {
		dob.sendKeys("10/24/1978");
	}
	
	public void clickCont() {
		cont.click();
	}
	
	public void enterIndiIncome() {
		indiIncome.sendKeys("150,000");
	}
	
	public void enterAddiIncome() {
		addiIncome.sendKeys("6000");
	}
	
	public void clickContIncome() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", contIncome);
	}
	
	public void enterEmail() {
		email.sendKeys("1234@upgrade-challenge.com");
	}
	
	public void enterPwd() {
		password.sendKeys("Upgrade94112");
	}
	
	public void clickCheckbox() {
		checkbox.click();
	}
	
	public void clickCheckRateButton() {
		checkRateButton.click();
	}
	
	public void getStarted(){
		this.enterLoanAmount();
		this.selectLoanPurpose();
		this.clickCYR();
	}
	
	public void fillInfo() {
		this.enterFirstName();
		this.enterLastName();
		this.enterStreet();
		this.enterCity();
		this.enterState();
		this.enterZipcode();
		this.enterDOB();
		this.clickCont();
	}
	
	public void fillIncome() {
		this.enterIndiIncome();
		this.enterAddiIncome();
		this.clickContIncome();
	}
	
	public void createAccount() {
		this.enterEmail();
		this.enterPwd();
		this.clickCheckbox();
		this.clickCheckRateButton();
	}

}
