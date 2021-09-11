package Tutorial;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjet.ForgotPassword;
import pageObjet.LandingPage;
import pageObjet.LoginPage;
import resource.Base;
import resource.ReadExcel;

public class HomePage extends Base {
	public WebDriver webDriver;
	@BeforeTest
	public void initializeDriver() throws IOException {
		webDriver = initialBrowsers("browser");

		
	}
	
	@Test(dataProvider = "getData")
	
	public void basePageNavigation(String userName, String passWord, String text) throws IOException {
		
		webDriver.get(prop.getProperty("baseURL"));
		webDriver.manage().window().maximize();
		
		LandingPage lp = new LandingPage(webDriver);
		LoginPage lg = lp.signIn();
		lg.emailID().sendKeys(userName);
		lg.passWord().sendKeys(passWord);
		System.out.println(text);
		ForgotPassword fp = lg.forgotPw();
		fp.userEmailID().sendKeys("as@dd");
		fp.btnSubmit().click();
	}
	@DataProvider(name = "SearchProvider")
	public Object[][] getDataFromDataProvider(Method m){
		if(m.getName().equalsIgnoreCase("LoginGuru99")) {
		return new Object [][] 
			{
				{"mngr1336","dAnavUq"},
				{"invalid","valid"},
				{"valid","invalid"},

			};
		}
		else {
			  return new Object[][] 
			{			  };
		}
	}
	@DataProvider
	public Object[][] getData(){
		Object [][]data = new Object[2][3];
		data[0][0]="abc@gmail.com";
		data[0][1]="12354";
		data[0][2]="not right user";
		
		data[1][0]="jahsh@gmail.com";
		data[1][1]="855";
		data[1][2]="right user";
		return data;
	}
	@AfterTest
	public void tearDown() {
		webDriver.close();
	}

}
