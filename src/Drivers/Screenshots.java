package Drivers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;

import ProjectReport.DateTime;

public class Screenshots extends LaunchDriver{
  
  @AfterMethod	
  public static String failedClass(String screenshotname, String ClassName) throws IOException {
		
	    DateTime obj = new DateTime();
		String todaydate = obj.GetTodayDateAndTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		@SuppressWarnings("unused")
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getClassName();
		
		String dest = System.getProperty("user.dir") + "/Screenshots/" + todaydate + "/FailedScreenShots/" + ClassName + "/"
				+ screenshotname + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;	
	}
 
    @AfterMethod	
	public static String passedClass(String screenshotname, String ClassName) throws IOException {
		
		DateTime obj = new DateTime();
		String todaydate = obj.GetTodayDateAndTime();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		@SuppressWarnings("unused")
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getClassName();
		String dest = System.getProperty("user.dir") + "/Screenshots/" + todaydate + "/PassedScreenShots/" + ClassName + "/"
				+ screenshotname + ".png";

		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
		
		}
}
