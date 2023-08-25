package testScripts;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pomPages.signupPage;



public class register_shopper extends BaseClass{
	@Test
	public void create_account() throws InterruptedException
	{
		welcome.clickLoginButton();
		login.clickCreateACCOUNTbutton();
		
		Map<String, String> map=excel.getData("sheet","Shopper Registration");
		int randomNum=jutil.generatRandomNum(100);
		String email=randomNum+map.get("email adress");
		String pwd=map.get("password")+randomNum;
		
		signup.createUserAccount(map.get("first name"),map.get("last name"),map.get("gender"),map.get("phone number"),email,pwd);
		
		Thread.sleep(4000);
		welcome.clickLoginButton();
		login.loginToApp(email,pwd);
		Thread.sleep(3000);
		assertTrue(driver.getTitle().contains("home"));
		
	}

}
