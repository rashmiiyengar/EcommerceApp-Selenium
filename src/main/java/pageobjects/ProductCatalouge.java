package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

import org.openqa.selenium.WebDriver;

public class ProductCatalouge extends AbstractComponent {

	WebDriver driver;

	public ProductCatalouge(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	// driver.findElement(By.cssSelector(".ng-animating")
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By prodsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {

		waitForElementToAppear(prodsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {

		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);

		return prod;
	}

	public void addProductToCart(String productName) {
		WebElement p = getProductByName(productName);

		p.findElement(addToCart).click();

		waitForElementToAppear(toastMsg);
		waitForElementToDissapear(spinner);

	}

}
