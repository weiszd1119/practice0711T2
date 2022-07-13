import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginMethod extends StartDriver {
	public LoginMethod(WebDriver driver) {
		super(driver);
	}
	
	private final String entryUrl = "https://www.saucedemo.com/";
	
	private final String stringUserName = "standard_user";
	
	private final String stringPassword = "secret_sauce";
	
	private final By findUsername = By.id("user-name");
	
	private final By findPassword = By.id("password");
	
	private final By findLoginButton = By.id("login-button");
	
	// Metódusok
	
	public void navigate() {
		driver.navigate().to(entryUrl);
	}
	
	public void writeIntoUserNameField() {
		driver.findElement(findUsername).sendKeys(stringUserName);
	}
	
	public void writeIntoPasswordField() {
		driver.findElement(findPassword).sendKeys(stringPassword);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(findLoginButton).click();
	}
	
	public String currentLoginResult() {
		String currentLogin = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		return currentLogin;
	}
	
}