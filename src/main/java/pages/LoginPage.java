package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private static final String GMAIL_LOGIN_PAGE_URL = "https://mail.google.com";
	private static final String EMAIL_FIELD_ID = "Email";
	private static final String PASSWORD_FIELD_ID = "Passwd";
	private static final String NEXT_BUTTON_ID = "next";
	private static final String SIGN_IN_BUTTON_ID = "signIn";
	private static final String PASSWORD_ERROR_MESSAGE_ID = "errormsg_0_Passwd";

	private WebDriver driver;
	private WebDriverWait driverWait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.driverWait = new WebDriverWait(driver, 10);
	}

	public void open() {
		driver.get(GMAIL_LOGIN_PAGE_URL);
	}

	public void waitForPageToLoad() {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EMAIL_FIELD_ID)));
	}

	public void loginAs(String email, String password) {
		driver.findElement(By.id(EMAIL_FIELD_ID)).sendKeys("tszarlej@gmail.com");
		driver.findElement(By.id(NEXT_BUTTON_ID)).click();

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASSWORD_FIELD_ID)));
		driver.findElement(By.id(PASSWORD_FIELD_ID)).sendKeys("test");
		driver.findElement(By.id(SIGN_IN_BUTTON_ID)).click();
	}

	public String getWrongPasswordErrorMessage() {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASSWORD_ERROR_MESSAGE_ID)));
		WebElement webElement = driver.findElement(By.id(PASSWORD_ERROR_MESSAGE_ID));
		return webElement.getText();
	}

}
