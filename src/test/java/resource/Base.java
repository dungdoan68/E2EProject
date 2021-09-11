package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import net.bytebuddy.implementation.bytecode.Duplication;

public class Base {
	public WebDriver webDriver;
	public Properties prop;
	public WebDriver initialBrowsers(String key) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream
				(System.getProperty("user.dir")+"\\src\\test\\java\\resource\\global.propoties");
		//i edit line
		prop.load(fis);
		String value = prop.getProperty(key);
		System.out.println(value); 
		if(value.equals("chrome") ){
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			webDriver = new ChromeDriver();
			
		}
		else if (value.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			webDriver = new FirefoxDriver();
			
		} else if (value.equals("IE")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			webDriver = new InternetExplorerDriver();
			
		} 	
			
		//webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return webDriver;
	}
	
	public String takeScreenShot(String testCaseName, WebDriver webDriver) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) webDriver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		String fileDes = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(src,new File(fileDes));
		return fileDes;
	}
}
