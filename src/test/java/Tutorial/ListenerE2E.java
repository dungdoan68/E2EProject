package Tutorial;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.Base;
import resource.ExtentReporterNG;

public class ListenerE2E extends Base implements ITestListener {

	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest extentTest;
	
	ThreadLocal<ExtentTest> testLocal = new ThreadLocal<ExtentTest>();//give pool contain variable "extentTest" to define what test is running
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest = extent.createTest(result.getMethod().getMethodName());
		testLocal.set(extentTest);//set the present running test to the pool
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//extentTest.log(Status.PASS, result.getMethod().getMethodName() + " pass");
		testLocal.get().log(Status.PASS, result.getMethod().getMethodName() + " pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(Status.FAIL, result.getMethod().getMethodName() + " fail");
		//extentTest.fail(result.getThrowable());
		testLocal.get().fail(result.getThrowable());
		
		WebDriver webDriver = null;
		String testCaseName = result.getMethod().getMethodName();
			try {
				webDriver =	(WebDriver) result.getTestClass().getRealClass().getDeclaredField("webDriver")// get webDriver variable to run this case
						.get(result.getInstance());
			} catch(Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	
		try {
			
			//testLocal.get().addScreenCaptureFromPath("user.dir"+"\\reports", testCaseName);
			testLocal.get().addScreenCaptureFromPath(takeScreenShot(testCaseName, webDriver),testCaseName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}

