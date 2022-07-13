import org.openqa.selenium.WebDriver;

public class SiteFactory {
	public static StartDriver Create(String name, WebDriver driver) {
		switch (name) {
			case "LoginMethod":
				return new LoginMethod(driver);
			case "CartOperations":
				return new CartOperations(driver);
			default:
				return null;
		}
	}
}