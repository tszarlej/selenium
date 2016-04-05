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

import static org.testng.Assert.assertEquals;

public class AutomateTest {

	private WebDriver driver;
	private WebDriverWait driverWait;
	private static final String GMAIL_LOGIN_PAGE_URL = "https://mail.google.com";
	private static final String EMAIL_FIELD_ID = "Email";
	private static final String PASSWORD_FIELD_ID = "Passwd";
	private static final String NEXT_BUTTON_ID = "next";
	private static final String SIGN_IN_BUTTON_ID = "signIn";
	private static final String PASSWORD_ERROR_MESSAGE_ID = "errormsg_0_Passwd";

	@BeforeClass
	public void generalSetUp() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver_mac");
	}

	@BeforeMethod
	public void setUp() {;
		this.driver = new ChromeDriver();
		this.driverWait = new WebDriverWait(driver, 10);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void loginWithBadPassword() {
		driver.get(GMAIL_LOGIN_PAGE_URL);

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EMAIL_FIELD_ID)));
		driver.findElement(By.id(EMAIL_FIELD_ID)).sendKeys("tszarlej@gmail.com");
		driver.findElement(By.id(NEXT_BUTTON_ID)).click();

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASSWORD_FIELD_ID)));
		driver.findElement(By.id(PASSWORD_FIELD_ID)).sendKeys("test");
		driver.findElement(By.id(SIGN_IN_BUTTON_ID)).click();

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASSWORD_ERROR_MESSAGE_ID)));
		WebElement webElement = driver.findElement(By.id(PASSWORD_ERROR_MESSAGE_ID));
		assertEquals(webElement.getText(), "The email and password you entered don't match.");
	}

}
