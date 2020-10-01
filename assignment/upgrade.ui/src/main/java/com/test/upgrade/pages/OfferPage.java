package com.test.upgrade.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.test.upgrade.pages.base.BasePage;

public class OfferPage extends BasePage{
	
	@FindBy(xpath="//label[@class='header-nav__toggle']")
	private WebElement menu;
	
	@FindBy(xpath="//a[@href='/funnel/logout']")
	private WebElement signout;
	
	@FindBy(xpath="//div[text()='Your Loan Amount']")
	private WebElement loanAmountText;
	
	@FindBy(xpath="//span[contains(text(),'2,000')]")
	private WebElement loanAmount;
	
	@FindBy(xpath="//p[text()='Monthly Payment']")
	private WebElement monthlyPayment;
	
	@FindBy(xpath="//span[text()='$71.78']")
	private WebElement monthlyPaymentAmount;
	
	@FindBy(xpath="//div[text()=' Month Term']")
	private WebElement monthlyTerm;
	
	@FindBy(xpath="//div[@class='section--sm']/div[1]")
	private WebElement term;
	
	@FindBy(xpath="//div[@class='section--sm']/div[2]")
	private WebElement interestRate;
	
	@FindBy(xpath="//div[@class='section--sm']/div[3]/div/div")
	
	private WebElement apr;
	Actions actions;
	JavascriptExecutor js;

	public OfferPage(WebDriver driver) {
		super(driver);
	}
	
	public String findLoanAmount() {
		return loanAmount.getText();
	}
	
	public String findMonthlyPmt() {
		return monthlyPaymentAmount.getText();
	}
	
	public String findTerm() {
		return term.getText();
	}
	
	public String findInterestRate() {
		return (interestRate.getText().substring(0, 6));
	}
	
	public String findAPR() {
		return (apr.getText().substring(0, 6));
	}
	
	public void saveLoanDetails() {
		this.findLoanAmount();
		this.findMonthlyPmt();
		this.findTerm();
		this.findInterestRate();
		this.findAPR();
	}
	
	public void signOut() {
		actions = new Actions(driver);
		actions.moveToElement(menu).build().perform();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", signout);
	}
	
	public String findUrl() {
		return driver.getCurrentUrl();
	}

}
