import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by JT on 2016-04-06.
 */
public class LoginPage {

    private static final String LOGIN_PAGE_ADDRESS = "https://accounts.google.com/";
    private static final String EMAIL_ID = "Email";
    private static final String NEXT_BUTTON_ID = "next";
    private static final String PASSWORD_INPUT_ID = "Passwd";
    private static final String LOGIN_BUTTON_ID = "signIn";
    private static final String ERROR_MESSAGE_TEXT_ID = "errormsg_0_Passwd";

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 5);
    }

    public void openPage() {
        driver.get(LOGIN_PAGE_ADDRESS);
    }


    public void inputEmail(String email) {

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EMAIL_ID)));
        WebElement account = driver.findElement(By.id(EMAIL_ID));
        account.sendKeys(email);
        WebElement next = driver.findElement(By.id(NEXT_BUTTON_ID));
        next.click();
    }

    public void inputPassword(String password) {

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASSWORD_INPUT_ID)));
        WebElement pass = driver.findElement(By.id(PASSWORD_INPUT_ID));
        pass.sendKeys(password);
        WebElement login = driver.findElement(By.id(LOGIN_BUTTON_ID));
        login.click();
    }

    public String getPasswordErrorMessage() {

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ERROR_MESSAGE_TEXT_ID)));
        WebElement errorMessageSpan = driver.findElement(By.id(ERROR_MESSAGE_TEXT_ID));
        String error = errorMessageSpan.getText();
        return error;


    }


}
