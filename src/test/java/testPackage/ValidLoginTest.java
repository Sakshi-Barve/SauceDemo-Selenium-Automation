package testPackage;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.Flib;
import pagePackage.LoginPage;


public class ValidLoginTest extends BaseTest {
	
	
	@Test
	public void loginTestCase() throws IOException, InterruptedException {

	    Flib flib = new Flib();
	    LoginPage lp = new LoginPage(driver);

	    // ✅ Wait for username field and perform login
	    waitForElementToBeClickable(lp.getUsername());
	    lp.validLoginMethod(
	            flib.readPropertyData(PROP_PATH, "username"),
	            flib.readPropertyData(PROP_PATH, "password")
	    );

	    // ✅ Assertion: Check page title or URL
	    String currentUrl = driver.getCurrentUrl();
	    if(currentUrl.contains("inventory.html")) {
	        System.out.println("✅ Login Successful - Assertion Passed");
	    } else {
	        System.out.println("❌ Login Failed - Assertion Failed");
	    }

	    Thread.sleep(3000);
	}



}
