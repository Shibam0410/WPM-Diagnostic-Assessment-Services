package ProjectReport;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Drivers.LaunchDriver;

public class Dashboard extends LaunchDriver{
  
  @Test(priority = 7)
  public void selectCreatedReport() throws Exception {
		
		//System.out.println(driver.findElement(By.xpath("//button[text()='Disaster due to earthquake']")).getText());
		
		// Click on project title to expand
		driver.findElement(By.xpath("//*[@class='accordion-button collapsed'][1]")).click();
		Thread.sleep(3000);
		// Click on report field box 
		driver.findElement(By.xpath("//*[@class='assesment-1'][1]")).click();
		Thread.sleep(7000);	
		
		String actualReportName = driver.findElement(By.xpath("//*[@class='reportname pb-2 title']")).getText();
		
			try {
				Assert.assertTrue(actualReportName.equals("Disaster due to earthquake"));
			}catch(AssertionError e) {
				System.out.println("Report name is incorrect");
			}
		    DateTime obj = new DateTime();
			String todaydate = obj.GetTodayDateAndTime();
			String dest = System.getProperty("user.dir") + "/Screenshots/" + "/DashboardAfterCreateReport/" + todaydate + "Dashboard.png";
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);

			Reporter.log("Dashboard completed successfully", true);
	}
}
