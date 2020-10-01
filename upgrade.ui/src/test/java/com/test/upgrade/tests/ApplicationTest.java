package com.test.upgrade.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.upgrade.pages.ApplicationPage;
import com.test.upgrade.pages.LoginPage;
import com.test.upgrade.pages.OfferPage;


public class ApplicationTest{

	protected WebDriver driver;
	ApplicationPage applicationPage;
	OfferPage offerPage;
	LoginPage loginPage;
	protected static Logger log = Logger.getLogger(ApplicationTest.class.getName());

	@BeforeClass
	public void init() {
		log.info("launching browser");
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("opening webpage");
		
		applicationPage = new ApplicationPage(driver);
		offerPage = new OfferPage(driver);
		loginPage = new LoginPage(driver);
	}
	
	@Test(groups="regression")
	public void testTakeHomeChallenge() throws InterruptedException {
		driver.get("https://www.credify.tech/phone/nonDMFunnel");
		applicationPage.getStarted();
		applicationPage.fillInfo();
		applicationPage.fillIncome();
		applicationPage.createAccount();

		offerPage.saveLoanDetails();
		offerPage.signOut();
		
		driver.get("https://www.credify.tech/portal/login");
		loginPage.login("1234@upgrade-challenge.com", "Upgrade94112");
		
		assertThat("Not a offer page ", offerPage.findUrl(), containsString("offer-page"));
		assertThat("Loan amount didn't match ", offerPage.findLoanAmount(), equalTo("2,000"));
		assertThat("APR didn't match ", offerPage.findAPR(), equalTo("21.99%"));
		assertThat("APR didn't match ", offerPage.findInterestRate(), equalTo("17.48%"));
		assertThat("APR didn't match ", offerPage.findTerm(), equalTo("36 Month Term"));
		assertThat("Loan amount didn't match ", offerPage.findMonthlyPmt(), equalTo("$71.78"));
	}
	
	@AfterClass
	public void cleanUp() {
		log.info("closing browser");
		driver.quit();
	}
}
