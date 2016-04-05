package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by JT on 2016-01-23.
 */
public class BlogPages {

    private WebDriver driver;
    @FindBy (how = How.XPATH, using = "/html/body/div[2]/div/div[2]/div[1]/main/div[2]/div[1]/article/div[2]/ul/li[4]/a")
    private WebElement trash;


    public BlogPages (WebDriver driver) {
        this.driver = driver;
    }

    public void trash() {

        trash.click();
    }

}

