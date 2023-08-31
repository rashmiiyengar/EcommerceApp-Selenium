package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement countrySelected;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	By searchElements = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		
		waitForElementToAppear(searchElements);
		countrySelected.click();
	}
	
	
	public ConfirmationPage placeYourOrder() {
		
		placeOrder.click();
		return new ConfirmationPage(driver);
	}
	
//	Actions a = new Actions(driver);
//
//	a.sendKeys(country, "india").build().perform();
//
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//
//	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//
//	driver.findElement(By.cssSelector(".action__submit")).click();

	
	
}
