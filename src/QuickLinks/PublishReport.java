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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Drivers.LaunchDriver;
import ProjectReport.DateTime;

public class PublishReport extends LaunchDriver{
   
	@Test(priority = 14)
	public void publishReport() throws Exception {
		
		Screen s = new Screen();
		Robot robot = new Robot();
		//System.out.println(driver.findElement(By.xpath("//button[text()='Disaster due to earthquake']")).getText());
		
		// Click on project title to expand
		//driver.findElement(By.xpath("//*[@class='accordion-button collapsed'][1]")).click();
		Thread.sleep(3000);
		// Click on report field box 
		driver.findElement(By.xpath("//*[@class='assesment-1'][1]")).click();
		Thread.sleep(7000);	
		
		// Click on quick links icon
		WebDriverWait wait = new WebDriverWait(driver,1000);
		driver.findElement(By.id("dropdownMenuLink")).click();	
		Thread.sleep(2000);	

		// Click on publish report
		//System.out.println(driver.findElement(By.xpath("//ul[@class='dropdown-menu quick-links show']/li[1]")).getText());
		//driver.findElement(By.xpath("//ul[@class='dropdown-menu quick-links show']/li[1]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='dropdown-item']")).getText());
		driver.findElement(By.xpath("//*[@id='dropdown-item']")).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='heading'])[1]")));	
		//System.out.println(driver.findElement(By.xpath("//*[@class='modal-title h4']")).getText());
		System.out.println(driver.findElement(By.xpath("(//*[@id='heading'])[1]")).getText());
		Thread.sleep(2000);
		// Choose files
		//System.out.println(driver.findElement(By.id("fileLabel")).getText());
		//System.out.println("Test");
		//driver.findElement(By.id("fileLabel")).click();
		Thread.sleep(2000);

		Pattern chooseFile = new Pattern(".\\Images\\" + "Choose_File.PNG"); 
		s.click(chooseFile);
		//driver.findElement(By.xpath("//*[@id='fileLabel']")).click();
		Thread.sleep(2000);
		  StringSelection stamp = new StringSelection("C:\\Users\\kanaka\\eclipse-workspace\\WPM_Maven\\Images\\Stamp.png");
		  //StringSelection stamp = new StringSelection("Stamp.png");
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stamp,null);
		 
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.setAutoDelay(1000);
		  
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  Thread.sleep(2000);
		
		DateTime obj = new DateTime();
		String todaydate = obj.GetTodayDateAndTime();
		String dest = System.getProperty("user.dir") + "/Screenshots/" + "/UploadStamp/" + todaydate + "UploadStamp.png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		try {	
		//Click on Submit
		//driver.findElement(By.xpath("//button[@class='btn image-container']")).click();
		driver.findElement(By.xpath("//*[@id='submit-btn']")).click();
		Thread.sleep(8000);
		}catch(Exception e) {
			Reporter.log("Fail: Unable to publish report", true);
			throw e;
		}Reporter.log("Pass: Report published successfully", true);
		
		// Navigate on main window
		Pattern MainWindow = new Pattern(".\\Images\\" + "MainWindow.png");
		Pattern DownloadReport = new Pattern(".\\Images\\" + "DownloadReport.png"); 
	   //Navigate back to main window		
       s.click(MainWindow);
       Thread.sleep(4000);
       
       // Check if edit icon is disabled
       try {
       //driver.findElement(By.xpath("//img[contains(@src,'/static/media/edit.426ef45b.svg') and (@class='disabled')]"));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='edit-icon' and @class='disabled'])[1]")));	
       }catch(Exception e) {
    	   Reporter.log("Fail: Edit icon is enabled even if report is published", true);
    	   throw e;
       } Reporter.log("Pass: Edit icon is disabled as the report is published", true);
       Thread.sleep(2000);
       
       try {
       s.click(DownloadReport);
       Thread.sleep(8000);
		}catch(Exception e) {
			Reporter.log("Fail: Unable to download report", true);
			throw e;
		}Reporter.log("Pass: Report downloaded successfully", true);
	
	 //Navigate back to main window	
      s.click(MainWindow);
      Thread.sleep(4000);
      
      System.out.println("******************** Publish Report Complete ********************");
	}
}
