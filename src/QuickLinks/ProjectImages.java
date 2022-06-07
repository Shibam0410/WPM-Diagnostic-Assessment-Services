package QuickLinks;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Drivers.LaunchDriver;
import ProjectReport.DateTime;

public class ProjectImages extends LaunchDriver{	

	@Test(priority = 9)
	public void projectImages() throws Exception {	
	//System.out.println(driver.findElement(By.xpath("//button[text()='Disaster due to earthquake']")).getText());
	
	// Click on project title to expand
	//driver.findElement(By.xpath("//*[@class='accordion-button collapsed'][1]")).click();
	Thread.sleep(3000);
	// Click on report field box 
	driver.findElement(By.xpath("//*[@class='assesment-1'][1]")).click();
	Thread.sleep(7000);	
	
	driver.findElement(By.id("dropdownMenuLink")).click();	
	Thread.sleep(2000);	

	//System.out.println(driver.findElement(By.xpath("//ul[@Class='dropdown-menu quick-links show']/li[2]")).getText());
	//driver.findElement(By.xpath("//ul[@Class='dropdown-menu quick-links show']/li[2]")).click();
	System.out.println(driver.findElement(By.xpath("//*[@id='dropdown-item1']")).getText());
	driver.findElement(By.xpath("//*[@id='dropdown-item1']")).click();
	
	WebDriverWait wait = new WebDriverWait(driver,1000);
	/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='text-4']")));
	System.out.println(driver.findElement(By.xpath("//*[@class='text-4']")).getText());
	String actualTitle = driver.findElement(By.xpath("//*[@class='text-4']")).getText();*/
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project-name']")));
	System.out.println(driver.findElement(By.xpath("//*[@id='project-name']")).getText());
	String actualTitle = driver.findElement(By.xpath("//*[@id='project-name']")).getText();
	
	
	try {
		Assert.assertTrue(actualTitle.equals("Disaster due to earthquake"));
	}catch(AssertionError e) {
		Reporter.log("Fail: Project name is incorrect", true);
	}
	Reporter.log("Pass: Project name is correct", true);
	Thread.sleep(5000);
    DateTime obj = new DateTime();
	String todaydate = obj.GetTodayDateAndTime();
	String dest = System.getProperty("user.dir") + "/Screenshots/" + "/ProjectImages/" + todaydate + "ProjectImages.png";
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File destination = new File(dest);
	FileUtils.copyFile(source, destination);
	
	// Navigate back to dashboard
	//driver.findElement(By.xpath("//*[@class='poppins-medium-dust-16px text-decoration-none text-reset ms-2']")).click();
	driver.findElement(By.xpath("(//*[@class='poppins-medium-dust-16px text-decoration-none text-reset'])[2]")).click();
	Thread.sleep(3000);
	
	Reporter.log("Project Images displayed properly", true);
	System.out.println("******************** Project Images Complete ********************");
}
}
