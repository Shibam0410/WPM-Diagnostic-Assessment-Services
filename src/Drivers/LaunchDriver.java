
package Drivers;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class LaunchDriver {
  
  public static ChromeDriver driver;	
  @BeforeSuite
  public void driverLaunch() throws Exception {
	  
	  String driverPath = ".\\Drivers\\";
		System.out.println("Driver Path is:" + driverPath);
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver(options);
		
		  driver.get("https://synapticallake.z21.web.core.windows.net/");
		
		    Thread.sleep(4000);
		    
		    System.out.println(driver.getTitle());
		    
		driver.manage().window().maximize();
		Thread.sleep(4000);
  }
  
  //@AfterSuite
  public void logout() throws Exception {
	  
	  driver.findElement(By.xpath("//*[@class='image-4 pointer']")).click();
	  Thread.sleep(3000);
	//  driver.close();
	//  driver.quit();
  }
}
