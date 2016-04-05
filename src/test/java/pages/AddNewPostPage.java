package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by JT on 2016-01-22.
 */
public class AddNewPostPage {

    private WebDriver driver;
    @FindBy(how = How.ID, using = "tinymce-1_ifr")
    WebElement newPostContentFrame;
    @FindBy (how = How.XPATH, using  = "/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[3]/div/input")
    private WebElement newPostTitle;
    @FindBy (how = How.ID, using  = "tinymce")
    private WebElement newPostContentBody;
    @FindBy (how = How.XPATH, using  = "/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]")
    private WebElement newPostPublish;

    public AddNewPostPage(WebDriver driver) {

        this.driver = driver;
        System.out.println(driver.getCurrentUrl());
    }

    public void addNewPost(String title, String descContent) {

        driver.switchTo().frame(newPostContentFrame);
        newPostContentBody.sendKeys(descContent);
        driver.switchTo().defaultContent();
        newPostTitle.sendKeys(title);
        newPostPublish.click();
    }
}
