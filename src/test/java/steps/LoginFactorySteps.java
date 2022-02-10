package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
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
	
	@Before
	public void browserSetup() {
	    String projectPath = System.getProperty("user.dir");
	    System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}
	
	@After()
	public void browserTeardown() {
		driver.close();
		driver.quit();
	}
	
//	@After(value = "@smoke", order = 2)
//	public void browserTeardown1() {
//		System.out.println("hook be @smoke tag only");
//	}
//	
//	@BeforeStep
//	public void beforeStep() {
//		System.out.println("before step hook");
//	}
//	
//	@AfterStep
//	public void afterStep1() {
//		System.out.println("after step hook");
//	}
//	
//	@AfterAll
//	public static void before_or_after_all() {
//		System.out.println("after all hook");
//	}
	
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
}
