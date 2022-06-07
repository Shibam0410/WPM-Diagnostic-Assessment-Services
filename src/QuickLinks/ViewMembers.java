package QuickLinks;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Drivers.LaunchDriver;

public class ViewMembers extends LaunchDriver{
   
	@Test(priority = 12)
	public void viewMembers() throws Exception{
		
//		System.out.println(driver.findElement(By.xpath("//button[text()='Disaster due to earthquake']")).getText());
//		
//		// Click on project title to expand
//		driver.findElement(By.xpath("//button[text()='Disaster due to earthquake'][1]")).click();
//		Thread.sleep(3000);
//		// Click on report field box 
//		driver.findElement(By.xpath("//*[@class='assesment-1'][1]")).click();
//		Thread.sleep(7000);	
		
		Thread.sleep(2000);	
		WebDriverWait wait = new WebDriverWait(driver,1000);
		driver.findElement(By.id("dropdownMenuLink")).click();	
		Thread.sleep(2000);	
	
		//System.out.println(driver.findElement(By.xpath("//ul[@Class='dropdown-menu quick-links show']/li[5]")).getText());
		//driver.findElement(By.xpath("//ul[@Class='dropdown-menu quick-links show']/li[5]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='dropdown-item5']")).getText());
		driver.findElement(By.xpath("//*[@id='dropdown-item5']")).click();


		//driver.switchTo().window("//*[@class='modal-title h4']");
		Thread.sleep(2000);
		//System.out.println(driver.findElement(By.xpath("//*[@class='modal-title h4']")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id='heading']")).getText());
 
		
		//System.out.println(driver.findElement(By.xpath("//*[(@class='tableFixHead') and ('tr')]")).Count());
		
		System.out.println(driver.findElement(By.xpath("//table/tr[last()]")).getText());

		 String actualEmail= driver.findElement(By.xpath("//table/tr[last()]")).getText();
		 String expectedEmail = "Greg Kail koltavurda@vusra.com PM Invitation Sent";
		 
			
			try {
				Assert.assertEquals(actualEmail,expectedEmail);
			}catch(AssertionError e) {
				
				Reporter.log("Fail: Details are incorrect", true);
				throw e;
			}Reporter.log("Pass: Details are correct", true);
			Thread.sleep(5000);
		// Close the pop up	
	//	driver.findElement(By.xpath("//*[@class='pointer mobile-hide']")).click();
		Thread.sleep(2000);
		
		System.out.println("******************** View Members Complete ********************");
	}
}
