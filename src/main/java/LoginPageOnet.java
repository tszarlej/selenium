import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by JT on 2016-04-08.
 */
public class LoginPageOnet {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPageOnet(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);

    }

    public void openPage() {
        driver.get("https://konto.onet.pl/auth.html?app_id=poczta.onet.pl.front");
    }

    public void inputEmail(String email) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("f_login")));
        WebElement account = driver.findElement(By.id("f_login"));
        account.sendKeys(email);

    }

    public void inputPassword(String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("f_password")));
        WebElement pass = driver.findElement(By.id("f_password"));
        pass.sendKeys(password);
        WebElement buttonLogin = driver.findElement(By.className("loginButton"));
        buttonLogin.click();
    }

    public String getPasswordErrorMessage() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div[1]/strong/span")));
        WebElement errorMessageSpan = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div[1]/strong/span"));
        String error = errorMessageSpan.getText();
        return error;


    }
}
