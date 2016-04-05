package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by JT on 2016-01-20.
 */
public class MainPage {

    private WebDriver driver;
    @FindBy (how = How.XPATH, using = "/html/body/div[2]/div/header/a[3]")
    private WebElement newPostLink;
    @FindBy (how = How.XPATH, using  = "/html/body/div[2]/div/header/a[1]")
    WebElement mySite;

    public MainPage (WebDriver driver) {

        this.driver = driver;

    }

    public void newPost() {

        newPostLink.click();
    }

    public void mySite() {

        mySite.click();
    }

}
