package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeFactoryPage {
	private WebDriver driver;
	
	@FindBy(id="logout")
	@CacheLookup
	WebElement btn_logout;
	
	public HomeFactoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void verifyLogOutButtonDisplay() {
		btn_logout.isDisplayed();
	}
	
}
