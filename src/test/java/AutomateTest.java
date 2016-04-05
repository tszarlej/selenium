
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.concurrent.TimeUnit;

public class AutomateTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = new FirefoxDriver();
        //driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        WebElement searchButton = driver.findElement(By.name("btnK"));
        System.out.println(searchButton.getText());
    }

    @Test
    public void test2() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%202/HTML/Sortable.html");

        Actions builder = new Actions(driver);
        // Move tile3 to the position of tile2
        builder.moveByOffset(200, 20).clickAndHold().moveByOffset(120, 0)
                .perform();
    }

    @Test
    public void test3() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%202/HTML/Selectable.html");

        WebElement one = driver.findElement(By.name("one"));
        WebElement three = driver.findElement(By.name("three"));
        WebElement five = driver.findElement(By.name("five"));

        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL)
                .click(one)
                .click(three)
                .click(five)
                .keyUp(Keys.CONTROL);
        builder.perform();
    }

    @Test
    public void test4() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%202/HTML/Selectable.html");

        WebElement one = driver.findElement(By.name("one"));
        WebElement eleven = driver.findElement(By.name("eleven"));
        WebElement five = driver.findElement(By.name("five"));

        int border = 1;
        int tileWidth = 100;
        int tileHeight = 80;

        Actions builder = new Actions(driver);

        builder.moveByOffset(one.getLocation().getX() + border, one.getLocation().getY() + 1).click();
        builder.build().perform();

        builder.moveByOffset(2 * tileWidth + 4 * border, 2 * tileHeight + 4 * border).click();
        builder.build().perform();

        builder.moveByOffset(-2 * tileWidth - 4 * border, -1 + tileHeight - 2 * border).click();
        builder.build().perform();

    }

    @Test
    public void test5() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%202/HTML/Selectable.html");

        WebElement one = driver.findElement(By.name("one"));
        WebElement eleven = driver.findElement(By.name("eleven"));
        WebElement five = driver.findElement(By.name("five"));

        Actions builder = new Actions(driver);

        builder.click(one).click(eleven).click(five);
        builder.build().perform();
    }

    @Test
    public void test6() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%202/HTML/Sortable.html");

        Actions builder = new Actions(driver);

        builder.moveByOffset(207,40)
                .clickAndHold()
                .moveByOffset(106, 0)
                .perform();
    }

    @Test
    public void test7() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%202/HTML/Sortable.html");

        WebElement two = driver.findElement(By.name("two"));
        WebElement three = driver.findElement(By.name("three"));
        Actions builder = new Actions(driver);

        builder.clickAndHold(two)
                .release(three)
                .perform();
    }

    @Test
    public void test8() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%202/HTML/Sortable.html");

        WebElement two = driver.findElement(By.name("two"));
        WebElement three = driver.findElement(By.name("three"));
        Actions builder = new Actions(driver);

        builder.moveToElement(two)
                .clickAndHold()
                .release(three)
                .perform();
    }

    @Test
    public void test9() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%202/HTML/DragMe.html");

        WebElement element = driver.findElement(By.id("draggable"));

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(element, 500, 200)
                .perform();

    }

    @Test
    public void test10() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%202/HTML/DragAndDrop.html");

        WebElement element = driver.findElement(By.id("draggable"));
        WebElement element1 = driver.findElement(By.id("droppable"));

        Actions builder = new Actions(driver);
        builder.dragAndDrop(element, element1)
                .build()
                .perform();

    }

    @Test
    public void test11() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%202/HTML/DoubleClick.html");

        WebElement btn = driver.findElement(By.name("dblClick"));
        Actions builder = new Actions(driver);
        builder.moveToElement(btn).doubleClick()
                .build()
                .perform();

    }

    @Test
    public void test12() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%202/HTML/ContextClick.html");

        WebElement menu = driver.findElement(By.id("div-context"));
        Actions builder = new Actions(driver);
        builder.moveToElement(menu)
                .contextClick()
                .click(driver.findElement(By.name("Item 4")))
                .perform();

    }

    @Test
    public void test13() {
        Map<String, Boolean> capabilitiesMap = new HashMap<String, Boolean>();
        capabilitiesMap.put("takesScreenShot", true);
        DesiredCapabilities capabilities = new DesiredCapabilities(capabilitiesMap);
        WebDriver driverWithCapabilities = new FirefoxDriver(capabilities);
        driverWithCapabilities.get("https://www.packtpub.com/");

        File scrFile = ((TakesScreenshot)driverWithCapabilities).getScreenshotAs(OutputType.FILE);
        System.out.println(scrFile.getAbsolutePath());

    }

    @Test
    public void test14() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%203/HTML/Window.html");

        WebElement link = driver.findElement(By.linkText("Google Search"));

        String window1 = driver.getWindowHandle();
        System.out.println("First Window Handle is: " + window1);

        link.click();

        String window2 = driver.getWindowHandle();
        System.out.println("Second Window Handle is: " + window2);

        System.out.println("Number of Window Handles so far: " + driver.getWindowHandles().size());

        driver.switchTo().window(window1);

    }

    @Test
    public void test15() {
        driver.get("file:///C:/Users/JT/Desktop/8850OS_Code/Chapter%203/HTML/Frames.html");

        Actions action = new Actions(driver);

        driver.switchTo().frame("frameOne");

        WebElement txt = driver.findElement(By.name("1"));
        txt.sendKeys("I'm frame one");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frameTwo");
        txt = driver.findElement(By.name("2"));
        txt.sendKeys("I'm frame two");
    }

    @Test
    public void test16() {

        driver.navigate().to("https://www.google.pl/?gws_rd=ssl");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");

        WebElement searchButton = driver.findElement(By.name("btnG"));
        searchButton.click();

        searchBox.clear();

        searchBox.sendKeys("Packt Publishing");
        searchButton.click();

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        }

    @Test
    public void test17() {

        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("tomass311@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Bravog1!");
        driver.findElement(By.id("loginbutton")).click();


        File f = new File("browser.data");
        try {
            f.delete();
            f.createNewFile();

            FileWriter fos = new FileWriter(f);
            BufferedWriter bos = new BufferedWriter(fos);

            for (Cookie ck : driver.manage().getCookies()) {

                bos.write((ck.getName() + " ; " + ck.getValue() + " ; " + ck.getDomain() + " ; "
                        + ck.getPath() + " ; " + ck.getExpiry() + " ; " + ck.isSecure()));
                bos.newLine();
                }
            bos.flush();
            bos.close();
            fos.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Test
    public void test18() {

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/");

        WebElement account = driver.findElement(By.id("Email"));
        account.clear();
        account.sendKeys("julia.szarlej");

        WebElement next = driver.findElement(By.id("next"));
        next.click();

        WebElement password = driver.findElement(By.id("Passwd"));
        password.sendKeys("jsdke83hs");

        WebElement log = driver.findElement(By.id("signIn"));
        log.click();


        WebElement create = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/div/div"));
        create.click();


        WebElement address = driver.findElement(By.xpath("/html/body/div[13]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[1]/table/tbody/tr[1]/td[2]/div/div/textarea"));
        address.sendKeys("juliachroscicka@gmail.com");

        WebElement subject = driver.findElement(By.id(":nr"));
        subject.sendKeys("MyTests selenium");

        WebElement content = driver.findElement(By.id(":ot"));
        content.sendKeys("Hi, I send you my first Selenium MyTests!");

        WebElement send = driver.findElement(By.id(":nh"));
        send.click();

        WebElement picture = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/a"));
        picture.click();

        WebElement logout = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[3]/div[2]/a"));
        logout.click();

    }





}