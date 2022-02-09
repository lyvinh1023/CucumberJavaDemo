package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.HomeFactoryPage;
import pagefactory.LoginFactoryPage;

public class LoginFactorySteps {
	WebDriver driver = null;
	LoginFactoryPage loginFactoryPage;
	HomeFactoryPage homeFactoryPage;
	
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("-----> I'm inside LoginFactorySteps");
	    String projectPath = System.getProperty("user.dir");
	    System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver.navigate().to("https://example.testproject.io/web");
		loginFactoryPage = new LoginFactoryPage(driver);
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		loginFactoryPage.enterUsername(username);
		loginFactoryPage.enterPassword(password);
		Thread.sleep(2000);
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		loginFactoryPage.clickLogin();
		Thread.sleep(2000);
	}

	@Then("the password invalid error displays")
	public void the_password_invalid_error_displays() {
	    loginFactoryPage.verifyPasswordInvalidErrorDisplay();
	}
	
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		homeFactoryPage = new HomeFactoryPage(driver);
		homeFactoryPage.verifyLogOutButtonDisplay();
	}
	
	@And("user closes the browser")
	public void user_closes_the_browser() {
	    driver.close();
	    driver.quit();
	}
}
