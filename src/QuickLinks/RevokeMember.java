package QuickLinks;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Drivers.LaunchDriver;

public class RevokeMember extends LaunchDriver {
  
  @Test(priority = 13)
  public void revokeMember() throws Exception {
	  
	  //Robot robot = new Robot();
	  Screen s = new Screen();
	 
	  // Revoke PM user access
	  try {
	 // driver.findElement(By.xpath("//table/tr[last()]/td[6]")).click();
	  
		//Pattern filePath = new Pattern(".\\Images\\" + "FilePath.PNG"); 
		//Pattern fileInputTextBox = new Pattern(".\\Images\\" + "FileName.PNG"); 
		Pattern RevokeIcon = new Pattern(".\\Images\\" + "Revoke.png"); 
		
		//s.type(filePath,"C:\\Users\\chinmayi\\eclipse-workspace\\WPM\\Images");
		//robot.keyPress(KeyEvent.VK_ENTER);
		//robot.keyRelease(KeyEvent.VK_ENTER);
		//s.type(fileInputTextBox, "Revoke");
		s.click(RevokeIcon);
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//*[@class='btn btn-danger mb-2']")).click();
		driver.findElement(By.xpath("//*[@id='yes']")).click();
		Thread.sleep(2000);
	  }catch(Exception e) {
		  Reporter.log("Fail: Unable to revoke the access", true);
		  throw e;
	  } Reporter.log("Pass: PM Access revoked successfully", true);
	  Thread.sleep(3000);
	  
	  // Revoke Guest user access
	  try {
		//Pattern filePath = new Pattern(".\\Images\\" + "FilePath.PNG"); 
		//Pattern fileInputTextBox = new Pattern(".\\Images\\" + "FileName.PNG"); 
		Pattern RevokeIcon = new Pattern(".\\Images\\" + "Revoke.png"); 
		
		//s.type(filePath,"C:\\Users\\chinmayi\\eclipse-workspace\\WPM\\Images");
		//robot.keyPress(KeyEvent.VK_ENTER);
		//robot.keyRelease(KeyEvent.VK_ENTER);
		//s.type(fileInputTextBox, "Revoke");
		s.click(RevokeIcon);
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//*[@class='btn btn-danger mb-2']")).click();
		driver.findElement(By.xpath("//*[@id='yes']")).click();
		Thread.sleep(2000);
	  }catch(Exception e) {
		  Reporter.log("Unable to revoke the access", true);
		  throw e;
	  } Reporter.log("Guest Access revoked successfully", true);
	  Thread.sleep(3000);
	  
		// Close the pop up	
		//driver.findElement(By.xpath("//*[@class='pointer mobile-hide']")).click();
	    driver.findElement(By.xpath("//*[@id='close-btn']")).click();
		Thread.sleep(2000);
	
	  System.out.println("Member revoked");  
  }
}
