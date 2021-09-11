package pageObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver webDriver;
	public LoginPage(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}
	By emailID = By.id("user_email");
	By passWord = By.id("user_password");
	By btnSignId = By.cssSelector("input[type='submit']");
	By textID = By.cssSelector("div[role='alert']");
	By forgotPwID = By.cssSelector("a[href*='password/new']");
	public WebElement emailID() {
		return webDriver.findElement(emailID);
	}
	public ForgotPassword forgotPw() {
		webDriver.findElement(forgotPwID).click();
		ForgotPassword fp = new ForgotPassword(webDriver);
		return fp;
	}
	public WebElement textID() {
		return webDriver.findElement(textID);
	}
	public WebElement passWord() {
		return webDriver.findElement(passWord);
	}
	
	public WebElement btnSignId() {
		return webDriver.findElement(btnSignId);
	}

}
