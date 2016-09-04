import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AutomateTest {

	private WebDriver driver;

	@BeforeClass
	public void generalSetUp() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
	}

	@BeforeMethod
	public void setup() {
		this.driver = new ChromeDriver();
	}

	@AfterMethod
	public void close() {
		this.driver.close();
	}

	@Test
	public void testWrongPasswordErrorMessage() {

		LoginPage page = new LoginPage(driver);
		page.openPage();
		page.inputEmail("julia.szarlej");
		page.inputPassword("wrongPassword");
		String text = page.getPasswordErrorMessage();

		assertEquals(text, "Podany przez Ciebie adres e-mail i hasło nie zgadzają się.");

	}

	@Test
	public void testWrongPasswordErrorMessageOnet() {

		LoginPageOnet onet = new LoginPageOnet(driver);
		onet.openPage();
		onet.inputEmail("juliachroscicka@poczta.onet.pl");
		onet.inputPassword("wrong");
		String text = onet.getPasswordErrorMessage();

		assertEquals(text, "Wprowadź poprawne dane.");


	}


	@Test
	public void testWrongPasswordMessage(WebDriver driver) {

		LoginPageBG loginPage = new LoginPageBG(driver);
		loginPage.openPage();
		loginPage.inputEmail(driver);
		loginPage.inputPassword(driver);
		loginPage.clickLoginButton();
		String text = loginPage.GetPasswordErrorMessage(driver);

		assertEquals(text, "Logowanie nie powiodło się. Niepoprawny login lub hasło.");

	}

}
