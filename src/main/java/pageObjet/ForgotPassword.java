package pageObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	public WebDriver webDriver;
	
	By userEmail = By.cssSelector("input[id='user_email']");
	By btnSubmit = By.cssSelector("input[type='submit']");
	
	public WebElement userEmailID() {
		return webDriver.findElement(userEmail);
	}
	public WebElement btnSubmit() {
		return webDriver.findElement(btnSubmit);
	}
	
	/*public LoginPage signIn() {
		webDriver.findElement(btnSubmit).click();
		LoginPage lp = new LoginPage(webDriver);
		return lp;
	}*/


	public ForgotPassword(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public ForgotPassword() {
		super();
	}
	
}
