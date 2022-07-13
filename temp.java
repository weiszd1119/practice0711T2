import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends StartDriver {
	public Cart(WebDriver driver) {
		super(driver);
	}
	
	private final By findAddToCartFirst = By.id("add-to-cart-sauce-labs-backpack");
	
	private final By findAddToCartSecond = By.id("add-to-cart-sauce-labs-bike-light");
	
	private final By findCardIcon = By.id("shopping_cart_container");
	
	public void clickCartFirst() {
		driver.findElement(findAddToCartFirst).click();
	}
	
	public void clickCartSecond() {
		driver.findElement(findAddToCartSecond).click();
	}
	
	public void clickCartIcon() {
		driver.findElement(findCardIcon).click();
	}
	
}