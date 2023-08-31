package FrameworkDesign.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.OrderPage;
import pageobjects.ProductCatalouge;


public class StandAloneTest extends BaseTest {


	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException, SocketException {
		// TODO Auto-generated method stub
		
		ProductCatalouge productCatalog = landingPage.loginApp(input.get("email"),input.get("password"));

		List<WebElement> products = productCatalog.getProductList();

		productCatalog.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalog.goToCart();

		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);// validations cannot go in page object files

		CheckoutPage cp = cartPage.checkout();
		cp.selectCountry("India");
		ConfirmationPage confirmationPage = cp.placeYourOrder();

		String confirmMessage = confirmationPage.getConfirmationText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest() throws SocketException {
	String productName= "ZARA COAT 3";
		ProductCatalouge productCatalog = landingPage.loginApp("rashmisoundar@gmail.com", "Test1234");
		OrderPage orderPage= productCatalog.goToOrders();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email","rashmisoundar1@gmail.com");
//		map1.put("password", "Test1234");
//		map1.put("product", "ADIDAS ORIGINAL");
//		
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email","rashmisoundar@gmail.com");
//		map.put("password", "Test1234");
//		map.put("product", "ZARA COAT 3");
		
		List<HashMap<String,String>> data = getJsonDataToMap();
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
	
	//Extent Reports
	
	
//	@DataProvider
//	public Object[][] getData() {
//		
//		return new Object[][] {{"rashmisoundar1@gmail.com","Test1234","ADIDAS ORIGINAL"},{"rashmisoundar1@gmail.com","Test1234","ZARA"}};
//		
//		
//	}

}
