package pagePackage;
	
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
	
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	import genericPackage.BaseTest;
	import genericPackage.Flib;
	
	
	public class LoginPage extends BaseTest {
		
		// Declaration
			@FindBy(id = "user-name") private WebElement username;
			@FindBy(id = "password") private WebElement password;
			@FindBy(id = "login-button") private WebElement loginButton;
			@FindBy(xpath = "//h3[@data-test='error']") private WebElement errorMessage;
	
				// Initialization
				public LoginPage(WebDriver driver)
				{
					PageFactory.initElements(driver,this);
				}
	
	
				public WebElement getUsername() {
					return username;
				}
	
	
	
				public WebElement getPassword() {
					return password;
				}
	
	
				public WebElement getLoginButton() {
					return loginButton;
				}
	
	
	
				public WebElement getErrorMessage() {
					return errorMessage;
				}
	
	
				// Operational Methods
				public void validLoginMethod(String userName, String Password) throws InterruptedException
				{
					username.sendKeys(userName);
					Thread.sleep(1000);
					password.sendKeys(Password);
					Thread.sleep(1000);
					loginButton.click();
					
					try {
			            // Handle Chrome's "Change password" popup (if appears)
			            Robot robot = new Robot();
			            robot.keyPress(KeyEvent.VK_ESCAPE);
			            robot.keyRelease(KeyEvent.VK_ESCAPE);
			        } 
			        catch (Exception e) {
			            System.out.println("No Chrome password popup appeared.");
			        }
				}
				
				/**
			     * Perform invalid login tests using Excel data
			     */
				public void invalidLoginMethod(String userName, String passWord) throws InterruptedException
				{
					username.clear();
				    username.sendKeys(userName);

				    // Forcefully clear password field
				    password.sendKeys(Keys.CONTROL + "a");
				    password.sendKeys(Keys.DELETE);
				    password.sendKeys(passWord);
				   
				    Thread.sleep(500);
				    loginButton.click();
				    Thread.sleep(1000);
	
				}
				
				
				
			
	}
