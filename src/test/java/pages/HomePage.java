package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	protected WebDriver driver;

	private By btn_logout = By.id("logout");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("TestProject Demo")) {
			throw new IllegalStateException("This is not Home page. The current page is: " + driver.getCurrentUrl());
		}
	}
	
	public void verifyLogOutButtonDisplay() {
		driver.findElement(btn_logout).isDisplayed();
	}
}
