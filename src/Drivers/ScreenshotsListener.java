package Drivers;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class ScreenshotsListener implements ITestListener {
  
	@AfterMethod	
	public void onTestSuccess(ITestResult result) {
		String ClassName = result.getInstanceName();
		try {
			Screenshots.passedClass(result.getName(), ClassName);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@AfterMethod	
	public void onTestFailure(ITestResult result) {
		String ClassName = result.getInstanceName();

		try {
			Screenshots.failedClass(result.getName(), ClassName);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
