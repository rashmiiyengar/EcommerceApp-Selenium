package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CartPage  extends AbstractComponent{

		WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productsTitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutButton;
	
	public Boolean verifyProductDisplay(String productName) {
		
		Boolean match = productsTitles.stream().anyMatch(p -> p.getText().equalsIgnoreCase(productName));
		
		return match;
		
	}
	
	
	public CheckoutPage checkout() {
		checkOutButton.click();
		
		return new CheckoutPage(driver);
		
	}
	
	
	
	
//	
//	List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//
//	Boolean match = cartProducts.stream().anyMatch(p -> p.getText().equals(productName));
//
//	Assert.assertTrue(match);
//
//	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	

}
