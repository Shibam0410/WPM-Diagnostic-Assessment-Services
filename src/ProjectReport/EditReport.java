package ProjectReport;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Drivers.LaunchDriver;

public class EditReport extends LaunchDriver{
  @Test(priority = 8)
  public void editReport() throws Exception {
	  
	    // Click on project title to expand
	//driver.findElement(By.xpath("(//*[@class='accordion-button collapsed'])[1]")).click();
 	Thread.sleep(3000);
		// Click on report field box 
	driver.findElement(By.xpath("//*[@class='assesment-1'][1]")).click();
		Thread.sleep(7000);	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//driver.findElement(By.xpath("//img[contains(@src,'/static/media/edit.426ef45b.svg')]")).click();
		driver.findElement(By.xpath("(//*[@id='edit-icon'])[1]")).click();
		Thread.sleep(8000);
		
		// Update Policy Number and Claim Number
//		System.out.println(driver.findElement(By.xpath("//div[@class='col-3'][1]")).getText());
//		Thread.sleep(2000);
       
		WebElement policyNumber = driver.findElement(By.id("policyNumber"));
		/*for(int i=0; i<20;i++){
			policyNumber.sendKeys(Keys.BACK_SPACE);
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		}*/
		policyNumber.sendKeys(Keys.CONTROL + "a");
		policyNumber.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		policyNumber.sendKeys("DC-3225");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		// Claim Number
		WebElement claimNumber = driver.findElement(By.id("claimNumber"));
		/*for(int i=0; i<20;i++){
			claimNumber.sendKeys(Keys.BACK_SPACE);
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		}*/
		claimNumber.sendKeys(Keys.CONTROL + "a");
		claimNumber.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		claimNumber.sendKeys("56665");
		Thread.sleep(2000);
		
		// Scroll up to Add section
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(2000);
		
		// Add Section click  
		driver.findElement(By.id("addsectionbutton")).click();	
		Thread.sleep(2000);
		
		// Add Provided Information section
		String actualTitle5= driver.findElement(By.xpath("//li[@class='dropdown-item'][1]")).getText();

		try {
			Assert.assertTrue(actualTitle5.equals("Provided Information"));
			}catch(AssertionError e) {
				Reporter.log("Fail: <b>Provided Information:</b> Section name is incorrect", true);
				throw e;
			}Reporter.log("Pass: <b>Provided Information:</b> Section name is correct", true);
		
		driver.findElement(By.xpath("//li[@class='dropdown-item'][1]")).click();
		Thread.sleep(2000);	
		
		// Scroll down upto added section
		/*Actions actions = new Actions(driver);
		for(int i=1; i<=2; i++) {
			actions.sendKeys(Keys.PAGE_DOWN).perform();
			Thread.sleep(1000);
			}*/
		 WebElement Provided=driver.findElement(By.xpath("//*[.='Provided Information']"));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Provided);
		Thread.sleep(2000);
		
		Screen s = new Screen();	
		// Type in block quote font
		Pattern BlockQuote = new Pattern(".\\Images\\" + "BlockQuote.png");
		s.type(BlockQuote, "Test update report and block quote functionality");	
		
		// Scroll down to save the report
		js.executeScript("window.scrollBy(0,4000)");
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);	 
		//System.out.println(driver.findElement(By.xpath("//*[@class='btn btn-primary']")).getText());
		// Click on Save
		//driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		//driver.findElement(By.xpath("//*[@class='btn btn-secondary']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='submitbutton']")).getText());
		driver.findElement(By.xpath("//*[@id='submitbutton']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,1000);
		String Message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Report has been updated']"))).getText();
		Reporter.log(Message, true);
		Thread.sleep(10000); 
		// Scroll up and Navigate back to dashboard
		js.executeScript("window.scrollBy(0,-20000)");
		Thread.sleep(2000); 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='poppins-medium-dust-16px text-decoration-none text-reset']")));
		//driver.findElement(By.xpath("//*[@class='poppins-medium-dust-16px text-decoration-none text-reset']")).click();
		driver.findElement(By.xpath("(//*[@class='poppins-medium-dust-16px text-decoration-none text-reset'])[2]")).click();
		Thread.sleep(3000); 
		
		// Verify updated chnages on dashboard
		// Click on project title to expand	
		//driver.findElement(By.xpath("//button[text()='Disaster due to earthquake']")).click();
		driver.findElement(By.xpath("//*[@class='accordion-button collapsed'][1]")).click();
		Thread.sleep(3000);
		// Click on report field box 
		driver.findElement(By.xpath("//*[@class='assesment-1'][1]")).click();
	
		Thread.sleep(5000);	
		
		// First check report name is correct or not
		String actualReportName = driver.findElement(By.xpath("//*[@class='reportname pb-2 title']")).getText();
		
			try {
				Assert.assertTrue(actualReportName.equals("Disaster due to earthquake"));
			}catch(AssertionError e) {
				Reporter.log("Fail: Report name is incorrect", true);
				throw e;
			}Reporter.log("Pass: Report name is correct", true);
		
		js.executeScript("window.scrollBy(0,3500)");
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).perform(); 
		Thread.sleep(3000);
			
		// Check updated changes take screenshot
		
	    DateTime obj = new DateTime();
		String todaydate = obj.GetTodayDateAndTime();
		String dest = System.getProperty("user.dir") + "/Screenshots/" + "/DashboardAfterEditReport/" + todaydate + "Dashboard.png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		  
		Reporter.log("Edit report completed successfully", true);
		
	}
}
