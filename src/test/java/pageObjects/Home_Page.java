package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	WebDriver driver;

	public Home_Page(WebDriver driver) {
		this.driver = driver;
       PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	private WebElement selectRegisterOption;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	private WebElement selectLoginOption;

	public void clickMyAccountDropMenu() {
		myAccountDropMenu.click();

	}

	public Register_Page selectRegisterOption() {
		selectRegisterOption.click();
		return new Register_Page(driver);
	}

	public void selectLoginOption() {
		selectLoginOption.click();
	}
	public Register_Page navigateIntoRegisterPage() {
		clickMyAccountDropMenu();
		
		selectRegisterOption();
		return new Register_Page(driver);
}
}
