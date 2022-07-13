import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartOperations extends StartDriver {
	public CartOperations(WebDriver driver) {
		super(driver);
	}
	
	private final By findAddToCartFirst = By.id("add-to-cart-sauce-labs-backpack");
	
	private final By findAddToCartSecond = By.id("add-to-cart-sauce-labs-bike-light");
	
	private final By findCardIcon = By.id("shopping_cart_container");
	
	private final By findCheckout = By.id("checkout");
	
	private final By findContinue = By.id("continue");
	
	private final By findFinish = By.id("finish");
	
	private final By findFirstNameFieldCheckout = By.id("first-name");
	
	private final By findLastNameFieldCheckout = By.id("last-name");
	
	private final By findZipFieldCheckout = By.id("postal-code");
	
	private final String stringFirstNameFieldCheckout = "Wolfgang";
	
	private final String stringLastNameFieldCheckout = "Petersen";
	
	private final String stringZipFieldCheckout = "1986";
	
	public void clickCartFirst() {
		driver.findElement(findAddToCartFirst).click();
	}
	
	public void clickCartSecond() {
		driver.findElement(findAddToCartSecond).click();
	}
	
	public void clickCartIcon() {
		driver.findElement(findCardIcon).click();
	}
	
	public void clickCheckout() { driver.findElement(findCheckout).click();}
	
	public void clickContinue() { driver.findElement(findContinue).click();}
	
	public void clickFinish() { driver.findElement(findFinish).click();}
	
	public void writeIntoFirstNameFieldCheckout() {
		driver.findElement(findFirstNameFieldCheckout).sendKeys(stringFirstNameFieldCheckout);
	}
	
	public void writeIntoLastNameFieldCheckout() {
		driver.findElement(findLastNameFieldCheckout).sendKeys(stringLastNameFieldCheckout);
	}
	
	public void writeIntoZipFieldCheckout()  {
		driver.findElement(findZipFieldCheckout).sendKeys(stringZipFieldCheckout);
	}
	
	public String currentBasketNumber() {
		String currentBasket = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		return currentBasket;
	}
	
	public String currentCheckoutTitle() {
		String currentCheckout = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		return currentCheckout;
	}
	
	public String currentCheckoutFinishTitle() {
		String currentCheckout = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		return currentCheckout;
	}
	
	public String currentCheckoutFinishTitleThanks() {
		String currentThanks = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
		return currentThanks;
	}
	
	
}