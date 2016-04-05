import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class AutomateTest {

	private WebDriver driver;

	@BeforeClass
	public void generalSetUp() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver_mac");
	}

	@BeforeMethod
	public void setUp() {;
		this.driver = new ChromeDriver();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginWithBadPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		loginPage.waitForPageToLoad();
		loginPage.loginAs("tszarlej@gmail.com", "test");
		String wrongPasswordErrorMessage = loginPage.getWrongPasswordErrorMessage();
		assertEquals(wrongPasswordErrorMessage, "The email and password you entered don't match.");
	}

}
