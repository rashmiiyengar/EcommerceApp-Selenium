package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

import org.openqa.selenium.WebDriver;

public class LandingPage extends AbstractComponent{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	// PageFactory
	// id = userEmail will be assigned to the variable in runtime

	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	//driver.findElement(By.id("userPassword")).sendKeys("Test1234");
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMsg;
	
	public ProductCatalouge loginApp(String email,String pwd) {
		
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		ProductCatalouge productCatalog = new ProductCatalouge(driver);
		return productCatalog;
		
	}
	
	public void checkIncorrectAuth(String email,String pwd) {
		
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		
	}
	
	public String getErrorMessage() {
		
		waitForElementAppearance(errorMsg);
		System.out.println(errorMsg.getText());
		return errorMsg.getText();
		
	}
	
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
	
}
