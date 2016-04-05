package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by JT on 2016-01-20.
 */
public class AdminLoginPage {

    WebDriver driver;
    @FindBy (how = How.ID, using = "user_login")
    WebElement email;
    @FindBy (how = How.ID, using = "user_pass")
    WebElement password;
    @FindBy (how = How.ID, using = "wp-submit")
    WebElement submit;

    public AdminLoginPage(WebDriver driver) {

        this.driver = driver;
        driver.get("https://pl.wordpress.com/wp-login.php");
    }

    public AllPostsPage login(String userValue, String passwordValue) {

        email.sendKeys(userValue);
        password.sendKeys(passwordValue);
        submit.click();

        return PageFactory.initElements(driver, AllPostsPage.class);
    }


}
