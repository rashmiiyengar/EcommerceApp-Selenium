package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> ordersPlaced;

	public Boolean verifyOrderDisplay(String productName) {

		Boolean match = ordersPlaced.stream().anyMatch(p -> p.getText().equalsIgnoreCase(productName));

		return match;

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
