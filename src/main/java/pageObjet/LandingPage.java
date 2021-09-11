package pageObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver webDriver;
	
	By sigIn = By.cssSelector("a[href*='sign_in']");
	By menuID = By.cssSelector(".nav.navbar-nav.navbar-right li");
	By titleID = By.cssSelector("div[class='text-center'] h2");
	
	public WebElement titleID() {
		return webDriver.findElement(titleID);
	}
	
	public LoginPage signIn() {
		webDriver.findElement(sigIn).click();
		LoginPage lp = new LoginPage(webDriver);
		return lp;
	}
	public WebElement getBavigationBar() {
		return webDriver.findElement(menuID);
	}

	public LandingPage(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public LandingPage() {
		super();
	}
	
}
