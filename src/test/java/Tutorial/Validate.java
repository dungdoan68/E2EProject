package Tutorial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjet.LandingPage;
import pageObjet.LoginPage;
import resource.Base;
import resource.ReadExcel;

public class Validate extends Base {
	public WebDriver webDriver;
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initializeDriver() throws IOException {
		webDriver = initialBrowsers("browser");
		webDriver.get(prop.getProperty("baseURL"));
		webDriver.manage().window().maximize();
	}
	@Test
	public void testValidate() throws IOException {
		
		LandingPage lp  = new LandingPage(webDriver);
		
		Assert.assertTrue(lp.getBavigationBar().isDisplayed());
	}
	@AfterTest
	public void tearDown() {
		webDriver.close();
	}

	
}
