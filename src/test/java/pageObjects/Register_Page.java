package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Page {

	WebDriver driver;

	public Register_Page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement first_Name;
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement last_Name;
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephone;
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirm_password;
	@FindBy(xpath = "//input[@value='0']")
	private WebElement newsLetter_RadioButton;
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement pvcy_checkbox;
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continue_button;
	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement first_Name_ErrorMsg;
	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement last_Name_ErrorMsg;
	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement email_ErrorMsg;
	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephone_ErrorMsg;
	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement password_ErrorMsg;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement pvcy_checkbox_ErrorMsg;

	public void enterFirstName(String f_Name) {
		first_Name.sendKeys(f_Name);
	}

	public void enterLast_name(String l_Name) {
		last_Name.sendKeys(l_Name);
	}

	public void enterEmail(String emailtext) {
		email.sendKeys(emailtext);

	}

	public void enterTelephone(String telephoneNum) {
		telephone.sendKeys(telephoneNum);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void enterConfirm_password(String confirm_pass) {
		confirm_password.sendKeys(confirm_pass);
	}
	public void newLetter_RadioButton() {
		newsLetter_RadioButton.click();
		
}
	public void selec_Pvcy_checkbox() {

		pvcy_checkbox.click();
	}

	public MyaccountSuccess_Page click_Continue_button() {
		continue_button.click();
		return new MyaccountSuccess_Page(driver);
	}

	public String getfirst_Name_ErrorMsg() {

		String txt = first_Name_ErrorMsg.getText();
		return txt;
	}

	public String getlast_Name_ErrorMsg() {

		String txt2 = last_Name_ErrorMsg.getText();
		return txt2;
	}

	public String getemail_ErrorMsg() {

		String txt3 = email_ErrorMsg.getText();
		return txt3;
	}

	public String gettelephone_ErrorMsg() {

		String txt4 = telephone.getText();
		return txt4;
	}

	public String getpassword_ErrorMsg() {

		String txt5 = password.getText();
		return txt5;
	}

	public String getpvcy_checkbox_ErrorMsg() {

		String txt6 = pvcy_checkbox_ErrorMsg.getText();
		return txt6;
	}
	public MyaccountSuccess_Page accountRegister(String f_Name,String l_Name,String emailtext,String telephoneNum,String pass,boolean newsletter,boolean privacy) {
		enterFirstName(f_Name);
		enterLast_name(l_Name);
		enterEmail(emailtext);
		enterTelephone(telephoneNum);
		enterPassword(pass);
		enterConfirm_password(pass);
		if(newsletter)
		newLetter_RadioButton();
		if(privacy)
		selec_Pvcy_checkbox();
		return click_Continue_button();
		
}
}
