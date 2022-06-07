package QuickLinks;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Drivers.LaunchDriver;
import ProjectReport.DateTime;

public class UploadInvoice extends LaunchDriver{
  @Test(priority = 10)
  public void uploadInvoice() throws Exception {
		
		Robot robot = new Robot();
		
	   // System.out.println(driver.findElement(By.xpath("//button[text()='Disaster due to earthquake']")).getText());
		
		// Click on project title to expand
		//driver.findElement(By.xpath("//button[text()='Disaster due to earthquake']")).click();
		driver.findElement(By.xpath("//*[@class='accordion-button collapsed'][1]")).click();
		Thread.sleep(3000);
		// Click on report field box 
		driver.findElement(By.xpath("//*[@class='assesment-1'][1]")).click();
		Thread.sleep(7000);	
		
		// Click on quick links icon
		WebDriverWait wait = new WebDriverWait(driver,1000);
		driver.findElement(By.id("dropdownMenuLink")).click();	
		Thread.sleep(2000);	

		// Click on View Invoices
		//System.out.println(driver.findElement(By.xpath("//ul[@Class='dropdown-menu quick-links show']/li[3]")).getText());
		//driver.findElement(By.xpath("//ul[@Class='dropdown-menu quick-links show']/li[3]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='dropdown-item2']")).getText());
		driver.findElement(By.xpath("//*[@id='dropdown-item2']")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='text-4']")));
		//System.out.println(driver.findElement(By.xpath("//*[@class='text-4']")).getText());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project-name']")));
		System.out.println(driver.findElement(By.xpath("//*[@id='project-name']")).getText());
		Thread.sleep(2000);

		try {
		//System.out.println(driver.findElement(By.xpath("//*[(@class='btn btn-primary text-4 pointer text-center position-absolute end-0') and (text()='Upload Invoice')]")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@class='btn btn-primary text-5 pointer text-center position-absolute end-0 me-5']")).getText());
			
		driver.findElement(By.xpath("//*[@class='btn btn-primary text-5 pointer text-center position-absolute end-0 me-5']")).click();
		Thread.sleep(2000);

		StringSelection invoice = new StringSelection("C:\\Users\\kanaka\\eclipse-workspace\\WPM_Maven\\Images\\Disaster.pdf");
		//StringSelection invoice = new StringSelection("Disaster.pdf");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(invoice,null);
		 
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		  
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.setAutoDelay(1000);
		  
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(2000);
		
		String Message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Invoice uploaded successfully']"))).getText(); 
		System.out.println(Message);
		Thread.sleep(4000);
		}catch(Exception e) {
			Reporter.log("Fail: Unable to upload invoice", true);
			throw e;
		}Reporter.log("Pass: Invoice uploaded successfully", true);
		
		DateTime obj = new DateTime();
		String todaydate = obj.GetTodayDateAndTime();
		String dest = System.getProperty("user.dir") + "/Screenshots/" + "/UploadInvoice/" + todaydate + "UploadInvoice.png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);

		// Navigate back to dashboard
		//driver.findElement(By.xpath("//*[@class='poppins-medium-dust-16px text-decoration-none text-reset ms-2']")).click();
		driver.findElement(By.xpath("(//*[@class='poppins-medium-dust-16px text-decoration-none text-reset'])[2]")).click();
		Thread.sleep(3000);
		
		System.out.println("******************** Upload Invoice Complete ********************");

		}
}
