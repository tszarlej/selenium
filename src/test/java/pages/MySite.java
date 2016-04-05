package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by JT on 2016-01-23.
 */
public class MySite {

    private WebDriver driver;
    @FindBy (how = How.XPATH, using = "/html/body/div[2]/div/div[2]/div[2]/div/ul/li[2]/ul/li[1]/a[1]")
    private WebElement blogPosts;


    public MySite(WebDriver driver) {

        this.driver = driver;

    }

    public void blogPosts() {

        blogPosts.click();
    }
}
