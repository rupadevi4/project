package testScripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;



public class addToCart extends BaseClass{
	@Test
	public void addToCartTest() throws InterruptedException 
	{
		Map<String, String> map=excel.getData("sheet1","add to cart");
		welcome.clickLoginButton();
		login.loginToApp(map.get("email"),map.get("password"));
		Thread.sleep(3000);
		home.mouseHoverToElectronic(webUtil);
		Thread.sleep(3000);
		home.clickHeadPhonelink();
		headPhone.clickAddCart();
		Thread.sleep(3000);
		Assert.assertEquals(headPhone.getAddTOCartText(), "added");
		String itemName=headPhone.getItemName();
		Assert.assertTrue(cart.getCartItem().equalsIgnoreCase(itemName));
		
	}

}
