import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class MainUserTest {
	WebDriver driver;
	
	@BeforeEach
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		// options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	@Epic("Practice")
	@Story("Practice on Swag Labs")
	@Description("LoginMethod to Swag Labs")
	@Severity(SeverityLevel.NORMAL)
	public void loginToSwagLabs() throws InterruptedException {
		LoginMethod loginMethod = (LoginMethod) SiteFactory.Create("LoginMethod", driver);
		loginMethod.navigate();
		Thread.sleep(5000);
		loginMethod.writeIntoUserNameField();
		loginMethod.writeIntoPasswordField();
		loginMethod.clickOnLoginButton();
		// Assertions
		String expectedTitleText = "PRODUCTS";
		String actualTitleText = loginMethod.currentLoginResult();
		Assertions.assertEquals(expectedTitleText, actualTitleText);
		
	}
	
	@Test
	@Epic("Practice")
	@Story("Practice on Swag Labs")
	@Description("Add elements to Cart on Swag Labs")
	@Severity(SeverityLevel.NORMAL)
	public void cartAtSwagLabs() throws InterruptedException {
		loginToSwagLabs();
		CartOperations cartOperations = (CartOperations) SiteFactory.Create("CartOperations", driver);
		Thread.sleep(5000);
		cartOperations.clickCartFirst();
		cartOperations.clickCartSecond();
		cartOperations.clickCartIcon();
		cartOperations.currentBasketNumber();
		// Assertions
		String expectedBasketNumber = "2";
		String actualBasketNumber = cartOperations.currentBasketNumber();
		Assertions.assertEquals(expectedBasketNumber, actualBasketNumber);
		//
		cartOperations.clickCheckout();
		cartOperations.writeIntoFirstNameFieldCheckout();
		cartOperations.writeIntoLastNameFieldCheckout();
		cartOperations.writeIntoZipFieldCheckout();
		cartOperations.clickContinue();
		//
		String expectedCheckoutTitle = "CHECKOUT: OVERVIEW";
		String actualCheckoutTitle = cartOperations.currentCheckoutTitle();
		Assertions.assertEquals(expectedCheckoutTitle, actualCheckoutTitle);
		//
		cartOperations.clickFinish();
		//
		String expectedCheckoutFinishTitle = "CHECKOUT: COMPLETE!";
		String actualCheckoutFinishTitle = cartOperations.currentCheckoutFinishTitle();
		Assertions.assertEquals(expectedCheckoutFinishTitle, actualCheckoutFinishTitle);
		//
		String expectedCheckoutFinishTitleThanks = "THANK YOU FOR YOUR ORDER";
		String actualCheckoutFinishTitleThanks = cartOperations.currentCheckoutFinishTitleThanks();
		Assertions.assertEquals(expectedCheckoutFinishTitleThanks, actualCheckoutFinishTitleThanks);
		
	}
}