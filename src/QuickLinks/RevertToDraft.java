package QuickLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Drivers.LaunchDriver;

public class RevertToDraft extends LaunchDriver{
  
  @Test(priority = 15)
  public void revertToDraft() throws Exception {
	  
		// Click on project title to expand
//		driver.findElement(By.xpath("//button[text()='Disaster due to earthquake']")).click();
//		driver.findElement(By.xpath("//*[@class='accordion-button collapsed'][1]")).click();
//		Thread.sleep(3000);
//		// Click on report field box 
//		driver.findElement(By.xpath("//*[@class='assesment-1'][1]")).click();
//		Thread.sleep(7000);	
	  
		// Click on quick links icon
		//WebDriverWait wait = new WebDriverWait(driver,1000);
		driver.findElement(By.id("dropdownMenuLink")).click();	
		Thread.sleep(2000);	
		WebDriverWait wait = new WebDriverWait(driver,1000);
		
		try {
		// Click on Revert to Draft
		//System.out.println(driver.findElement(By.xpath("//ul[@class='dropdown-menu quick-links show']/li[1]")).getText());
		//driver.findElement(By.xpath("//ul[@class='dropdown-menu quick-links show']/li[1]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='dropdown-item']")).getText());
		driver.findElement(By.xpath("//*[@id='dropdown-item']")).click();
		Thread.sleep(5000);
		}catch(Exception e) {
			Reporter.log("Fail: Unable to revert the report to draft", true);
			throw e;
		}Reporter.log("Pass: Revert to draft is successful", true);
		
		try {
		//driver.findElement(By.xpath("//img[contains(@src,'/static/media/edit.426ef45b.svg')]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='edit-icon'])[1]")));	
		}catch(Exception e) {
			Reporter.log("Fail: Edit icon is disabled even if report is reverted to draft", true);
			throw e;
		}Reporter.log("Pass: Edit icon enabled as the report is reverted to draft", true);
  }
}
