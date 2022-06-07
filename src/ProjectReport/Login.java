package ProjectReport;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Drivers.LaunchDriver;

public class Login extends LaunchDriver {
	
  @Test(priority = 1)
  public void login() throws Exception {
	  
	  try {
	    driver.findElement(By.id("email")).sendKeys("komluforte@vusra.com");
	    Thread.sleep(1000);
	    driver.findElement(By.id("password")).sendKeys("Chinmayi@123");
	    Thread.sleep(2000);

	    WebDriverWait wait = new WebDriverWait(driver,1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='login']")));
		System.out.println("Element visible");
		driver.findElement(By.id("button")).click();
	
	  }catch(Exception e) {  
		Reporter.log("Fail: Unable to login", true);
	    throw e;	    
  }
		Reporter.log("Pass: Login Successful", true);
	    Thread.sleep(10000);
  }
} 
