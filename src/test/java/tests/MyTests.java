package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by JT on 2016-01-20.
 */
public class MyTests {

    @Test
    public void wordPress() {

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        AdminLoginPage admLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
        admLoginPage.login("liketobeatester", "jsdke83hs");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.newPost();

        AddNewPostPage addNewPostPage = PageFactory.initElements(driver, AddNewPostPage.class);
        addNewPostPage.addNewPost("TestTitle", "TestContent");

        WebElement element = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/button/strong[contains(text(),'Published')]")));

        mainPage.mySite();

        MySite my = PageFactory.initElements(driver, MySite.class);
        my.blogPosts();

        BlogPages trash = PageFactory.initElements(driver, BlogPages.class);
        trash.trash();
    }

    @Test
    public void addingANewPost() {

        WebDriver driver = new FirefoxDriver();
        AdminLoginPage loginPage = PageFactory.initElements(driver, AdminLoginPage.class);

        AllPostsPage allPostsPage = loginPage.login("liketobeatester", "jsdke83hs");
        allPostsPage.createANewPost("Creating new post using PageObjects", "Its good to use PageObjects");
    }

    @Test
    public void editingANewPost() {

        WebDriver driver = new FirefoxDriver();
        AdminLoginPage loginPage = PageFactory.initElements(driver, AdminLoginPage.class);
        AllPostsPage allPostsPage = loginPage.login("liketobeatester", "jsdke83hs");
        allPostsPage.editAPost("Creating New Post Using PageObjects", "Editing Post using PageObjects", "Test framework low maintenance");
    }

    @Test
    public void deletingAPost() {

        WebDriver driver = new FirefoxDriver();
        AdminLoginPage loginPage = PageFactory.initElements(driver, AdminLoginPage.class);
        AllPostsPage allPostsPage = loginPage.login("liketobeatester", "jsdke83hs");
        allPostsPage.deleteAPost("Creating New Post Using PageObjects");
    }

    @Test
    public void countingPosts() {

        WebDriver driver = new FirefoxDriver();
        AdminLoginPage loginPage = PageFactory.initElements(driver, AdminLoginPage.class);
        AllPostsPage allPostsPage = loginPage.login("liketobeatester", "jsdke83hs");
        System.out.println(allPostsPage.getAllPostsCount());
    }


}
