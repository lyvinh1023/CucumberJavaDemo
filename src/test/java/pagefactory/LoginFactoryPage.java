package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginFactoryPage {
	
	private WebDriver driver;
	
	@FindBy(id="name")
	@CacheLookup
	WebElement txt_username;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement txt_password;
	
	@FindBy(id="login")
	@CacheLookup
	WebElement btn_login;
	
	@FindBy(xpath = "//div[text()=\"Password is invalid\"]")
	WebElement lbl_invalid_password;
	
	public LoginFactoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
//		AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(driver, 30);
//		PageFactory.initElements(ajaxFactory, this);
	}
	
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
	public void verifyPasswordInvalidErrorDisplay() {
		lbl_invalid_password.isDisplayed();
	}
}
