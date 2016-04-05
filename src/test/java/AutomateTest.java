import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AutomateTest {

	private WebDriver driver;
	private static final String BASE_URL = "http://www.allegro.pl";

	@BeforeClass
	public void generalSetUp() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver_mac");
	}

	@BeforeMethod
	public void setUp() {;
		this.driver = new ChromeDriver();
		driver.get(BASE_URL);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


	@Test
	public void firstTest() {

		assertEquals(true, true);

	}

}
