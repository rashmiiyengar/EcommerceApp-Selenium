package FrameworkDesign.SeleniumFrameworkDesign;

import java.io.IOException;
import java.net.SocketException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.Retry;
import pageobjects.CartPage;
import pageobjects.ProductCatalouge;


public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"errorhandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException,InterruptedException {
		// TODO Auto-generated method stub
		
		 landingPage.checkIncorrectAuth("rashmisoundar@gmail.com", "Test13234");
		 String a=landingPage.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.", a);
	}
	
	@Test
	public void productErrorValidations() throws IOException,InterruptedException,SocketException {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";

		ProductCatalouge productCatalog = landingPage.loginApp("rashmisoundar@gmail.com", "Test1234");

		List<WebElement> products = productCatalog.getProductList();

		productCatalog.addProductToCart(productName);
		CartPage cartPage = productCatalog.goToCart();

		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);// validations cannot go in page object files
		
	}
	}


