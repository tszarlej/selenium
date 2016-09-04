import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by JT on 2016-04-10.
 */
public class LoginPageBG {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPageBG(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);

    }

    public void openPage() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form1:textField1")));
        driver.get("http://wbpg.org.pl:8080/Opac4/faces/Login.jsp");
    }

    public void inputEmail(WebDriver driver) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form1:textField1")));
        WebElement email = driver.findElement(By.id("form1:textField1"));
        email.sendKeys("00226513");

    }

    public void inputPassword(WebDriver drive) {

        WebElement pswd = driver.findElement(By.id("form1:passwordField1"));
        pswd.sendKeys("wrong");

    }

    public void clickLoginButton() {

        WebElement login = driver.findElement(By.id("form1:button1"));
        login.click();
    }

    public String GetPasswordErrorMessage(WebDriver driver) {

        WebElement error = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li/text()"));
        String text = error.getText();
        return text;
    }

}

