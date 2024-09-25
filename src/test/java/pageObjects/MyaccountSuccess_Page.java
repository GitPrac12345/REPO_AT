package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyaccountSuccess_Page {

	WebDriver driver;

	public MyaccountSuccess_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement accountsuccess_txtmessage;

	public String getaccountsuccess_txtmessage() {
		String txt_msg = accountsuccess_txtmessage.getText();
		return txt_msg;

	}

}
