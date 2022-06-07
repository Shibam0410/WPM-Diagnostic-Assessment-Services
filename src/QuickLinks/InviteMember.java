package QuickLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Drivers.LaunchDriver;

public class InviteMember extends LaunchDriver{
   @Test(priority = 11)
	public void inviteMember() throws Exception {
//		System.out.println(driver.findElement(By.xpath("//button[text()='Disaster due to earthquake']")).getText());
//		
//		// Click on project title to expand
		//driver.findElement(By.xpath("//button[text()='Disaster due to earthquake']")).click();
	   driver.findElement(By.xpath("//*[@class='accordion-button collapsed'][1]")).click();
	   Thread.sleep(3000);
		// Click on report field box 
		driver.findElement(By.xpath("//*[@class='assesment-1'][1]")).click();
		Thread.sleep(7000);	
		
		WebDriverWait wait = new WebDriverWait(driver,1000);
		driver.findElement(By.id("dropdownMenuLink")).click();	
		Thread.sleep(2000);	
	
		//System.out.println(driver.findElement(By.xpath("//ul[@Class='dropdown-menu quick-links show']/li[4]")).getText());
		//driver.findElement(By.xpath("//ul[@Class='dropdown-menu quick-links show']/li[4]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='dropdown-item4']")).getText());
		driver.findElement(By.xpath("//*[@id='dropdown-item4']")).click();


		Thread.sleep(2000);
		//System.out.println(driver.findElement(By.xpath("//*[@class='modal-title h4']")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id='heading']")).getText());
      
		// Invitation to Guest
		try {
			driver.findElement(By.id("fname")).sendKeys("John");
			Thread.sleep(2000);
			driver.findElement(By.id("lname")).sendKeys("Watson");
			Thread.sleep(2000);
			driver.findElement(By.id("email")).sendKeys("hugnuvemle@vusra.com");
			Thread.sleep(2000);

			// Select role as Guest
			driver.findElement(By.xpath("//*[@id='formVerticalRadios1']")).click();
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.id("submit-btn")).getText());
			driver.findElement(By.id("submit-btn")).click();

			String Message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Invitation sent']"))).getText();
			System.out.println(Message);
			Thread.sleep(4000);
		} catch (Exception e) {
			Reporter.log("Fail: Unable to send an invite to Guest", true);
			throw e;
		}Reporter.log("Pass: Invite sent successfully to Guest", true);
		
		// Again select Invite Member quick link to send another invite	
		driver.findElement(By.id("dropdownMenuLink")).click();
		Thread.sleep(2000);

		//System.out.println(driver.findElement(By.xpath("//ul[@Class='dropdown-menu quick-links show']/li[4]")).getText());
		//driver.findElement(By.xpath("//ul[@Class='dropdown-menu quick-links show']/li[4]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='dropdown-item4']")).getText());
		driver.findElement(By.xpath("//*[@id='dropdown-item4']")).click();

		Thread.sleep(2000);
		//System.out.println(driver.findElement(By.xpath("//*[@class='modal-title h4']")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id='heading']")).getText());
			
		// Invitation to PM
		try {
			 driver.findElement(By.id("fname")).sendKeys("Greg");
			 Thread.sleep(2000);
			 driver.findElement(By.id("lname")).sendKeys("Kail");
			 Thread.sleep(2000);
			 driver.findElement(By.id("email")).sendKeys("koltavurda@vusra.com");
			 Thread.sleep(2000);
		
			 // Select role as PM
			 driver.findElement(By.xpath("//*[@id='formVerticalRadios2']")).click();
			 Thread.sleep(2000);
			 System.out.println(driver.findElement(By.id("submit-btn")).getText());
			 driver.findElement(By.id("submit-btn")).click();
		
			 String Message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Invitation sent']"))).getText(); 
			 System.out.println(Message);
			 Thread.sleep(4000);
		}catch(Exception e) {
		Reporter.log("Fail: Unable to send an invite to PM", true);
		throw e;
		}Reporter.log("Pass: Invite sent successfully to PM", true);
	}
}
