package testcases;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Home_Page;
import pageObjects.MyaccountSuccess_Page;
import pageObjects.Register_Page;

public class TC_001_Register_Test {
	WebDriver driver;
	Properties prop = null;
	Home_Page home_page = null;
	Register_Page reg_page = null;
	MyaccountSuccess_Page myaccsuccpage = null;

	@BeforeMethod
	public void setUp() {
		
		driver = new ChromeDriver();

	driver.get("https://tutorialsninja.com/demo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().deleteAllCookies();

		home_page = new Home_Page(driver);
		home_page.navigateIntoRegisterPage();
	}

	@Test(priority = 1)
	public void registerAccountwith_all_fields() {
		reg_page.accountRegister("ANAKfir", "kANAK", dynamicEmail_ID(), "98765678978", "anak123456789", true,true);
		String expect_txtmsg = "Your Account Has Been Created!";
		String actual_txtmsg = myaccsuccpage.getaccountsuccess_txtmessage();
		Assert.assertEquals(expect_txtmsg, actual_txtmsg);

	}

	@Test(priority = 2)
	public void registerAccountwith_mandatory_fields() {
		reg_page.accountRegister("ANAKrfir", "AkANAK", dynamicEmail_ID(), "98765678978", "anak123456789", false,true);
		String expect_txtmsg = "Your Account Has Been Created!";
		// MyaccountSuccess_Page myacc2 = new MyaccountSuccess_Page(driver);
		String actual_txtmsg = myaccsuccpage.getaccountsuccess_txtmessage();
		Assert.assertEquals(expect_txtmsg, actual_txtmsg);

	}

	@Test(priority = 3)
	public void registerAccount_withoutprovidinganyfields() {
		reg_page.accountRegister("", "", "", "", "", false,false);

		String expectedFirstNameErrormsg = "First Name must be between 1 and 32 characters!";
		String actfirstnameWarnMessage = reg_page.getfirst_Name_ErrorMsg();
		Assert.assertEquals(expectedFirstNameErrormsg, actfirstnameWarnMessage);

		String expectedlastNameErrormsg = "Last Name must be between 1 and 32 characters!";
		String actlastnameWarnMessage = reg_page.getlast_Name_ErrorMsg();
		Assert.assertEquals(expectedlastNameErrormsg, actlastnameWarnMessage);

		String expectedEmailErrormsg = "E-Mail Address does not appear to be valid!";
		String actEmailWarnMessage = reg_page.getemail_ErrorMsg();
		Assert.assertEquals(expectedEmailErrormsg, actEmailWarnMessage);

		String expectedtelephErrormsg = "Telephone must be between 3 and 32 characters!";
		String acttelephWarnMessage = reg_page.gettelephone_ErrorMsg();
		Assert.assertEquals(expectedtelephErrormsg, acttelephWarnMessage);

		String expectedPassErrormsg = "Password must be between 4 and 20 characters!";
		String actPassWarnMessage = reg_page.getpassword_ErrorMsg();
		Assert.assertEquals(expectedtelephErrormsg, acttelephWarnMessage);

		String expectedPvcyErrormsg = "Warning: You must agree to the Privacy Policy!";
		String actPvcyWarnMessage = reg_page.getpvcy_checkbox_ErrorMsg();
		Assert.assertEquals(expectedPvcyErrormsg, actPvcyWarnMessage);

	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}

	}

	public String dynamicEmail_ID() {
		Random r = new Random();
		int val2 = r.nextInt();
		String dynamicEmail = val2 +"@gmail.com";
		return dynamicEmail;

	}

}
