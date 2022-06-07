package ProjectReport;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class CreateNewReport extends LaunchDriver{
	
	 Screen s = new Screen();

	 Pattern calendar = new Pattern(".\\Images\\" + "Calendar.PNG"); 
	 Pattern date = new Pattern(".\\Images\\" + "TodaysDate.PNG"); 
	 
	  @Test(priority=2)
	  public void navigateOnCreateReport() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver,1000);	
		// Click on Create New button
		  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-btn")));
		driver.findElement(By.id("create-btn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title col-3 p-0']")));
		System.out.println(driver.findElement(By.xpath("//*[@class='title col-3 p-0']")).getText());
		Thread.sleep(2000);
		Reporter.log("Successfully navigated on create report", true);
	  }
	  
	  @Test(priority = 3)
	  public void addProjectBrief() throws Exception{
		  
		  Pattern calendar = new Pattern(".\\Images\\" + "Calendar.PNG"); 
		  Pattern date = new Pattern(".\\Images\\" + "TodaysDate.PNG"); 
			// Project Number
			driver.findElement(By.id("projectNumber")).sendKeys("DC-412.461");
			Thread.sleep(2000);
			
			// Project Name
	/*	driver.findElement(By.xpath("//*[@type='text']//following::input[1]")).sendKeys("Disaster due to earthquake1");
		Thread.sleep(2000);
			
			// Client Name
			driver.findElement(By.xpath("//*[@type='text']//following::input[2]")).sendKeys("Greg S");
			Thread.sleep(2000);		*/
			
			// Insured Name
			driver.findElement(By.id("insuredName")).sendKeys("John Wilson");
			Thread.sleep(2000);
			
			// Policy Number
			driver.findElement(By.id("policyNumber")).sendKeys("45254");
			Thread.sleep(2000);
			
			// Issue Date
			//driver.findElement(By.id("issueDate")).sendKeys("05112020");
			//driver.findElement(By.id("issueDate")).click();
			Thread.sleep(2000);

			 // s.click(calendar);
			  Thread.sleep(2000);
			//  s.click(date);
			  Thread.sleep(2000);
			
			// Claim Number
			driver.findElement(By.id("claimNumber")).sendKeys("7889658");
			Thread.sleep(2000);
			
			//Actions actions = new Actions(driver);
			//actions.sendKeys(Keys.PAGE_DOWN).perform(); Thread.sleep(3000);
			 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)");
			// Client File Number
			driver.findElement(By.id("clientFileNumber")).sendKeys("5469896");
			Thread.sleep(2000);
			
			// Loss Location
			driver.findElement(By.id("lossLocation")).sendKeys("3917 CRAFTSMAN LN BATON ROUGE LA 70809");
			Thread.sleep(2000);
			// Reported Date of Loss
			//driver.findElement(By.id("reportedDateOfLoss")).sendKeys("05062020");
			//Thread.sleep(2000);
				
			Reporter.log("Project Brief section completed", true);			
		}	 
	  
	  @Test(priority=4)
	  public void manageImages() throws Exception {
	  WebDriverWait wait = new WebDriverWait(driver,1000);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	
	  Robot robot = new Robot();
	  Screen s = new Screen();
	
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='position-absolute end-0 btn btn-link']")));
//      driver.findElement(By.xpath("//button[@class='position-absolute end-0 btn btn-link']")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("projectimagesbutton")));
      driver.findElement(By.id("projectimagesbutton")).click();
      
	  js.executeScript("window.scrollBy(0,-110)");
	  //actions.sendKeys(Keys.PAGE_UP).perform(); 
	  //Actions actions = new Actions(driver);
	  //actions.sendKeys(Keys.PAGE_UP).perform(); 
	  Thread.sleep(2000);
	  // Get title and project name
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title p-0']")));
	  System.out.println(driver.findElement(By.xpath("//*[@class='title p-0']")).getText());
	  System.out.println(driver.findElement(By.xpath("//*[@class='p-0 fw-bold']")).getText()); 
	  Thread.sleep(2000);
	
	 //Click on Add Pictures and Upload 1st image
	  driver.findElement(By.xpath("//*[@class='camera-reactangle col-1 mb-3 border border-secondary position-relative'][2]")).click();
	  Thread.sleep(2000); 

	//StringSelection is a used for copy and paste operations
	  StringSelection image1 = new StringSelection("C:\\Users\\kanaka\\eclipse-workspace\\WPM_Maven\\Images\\Image1");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(image1,null);
	 
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.setAutoDelay(1000);
	  
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  Thread.sleep(2000);
	
	 //Click on Add Pictures and Upload 2nd image
	  driver.findElement(By.xpath("//*[@class='camera-reactangle col-1 mb-3 border border-secondary position-relative'][2]")).click();
	  Thread.sleep(2000); 
	  
	  StringSelection image2 = new StringSelection("C:\\Users\\kanaka\\eclipse-workspace\\WPM_Maven\\Images\\Image2");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(image2,null);
	  
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.setAutoDelay(1000);
	  
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  Thread.sleep(2000);
	
	  driver.findElement(By.xpath("(//*[@class='images position-absolute top-0 start-50 translate-middle-x'])[2]")).click();
	  Thread.sleep(2000);
	
	  driver.findElement(By.xpath("(//*[@class='form-control' and @placeholder='Write comment here'])[2]")).sendKeys("This is a test comment for image1");
	  Thread.sleep(4000);
	 // driver.findElement(By.xpath("//*[@class='btn btn-secondary'][1]")).click();
	  driver.findElement(By.xpath("(//*[@id='savebutton'])[2]")).click();
	  Reporter.log("Manage images completed successfully",true);
	
	js.executeScript("window.scrollBy(0,-1000)");
	Thread.sleep(2000);
	
	//Navigate back to create new report
	driver.findElement(By.xpath("//span[.='Create New Report']")).getText();
	driver.findElement(By.xpath("//span[.='Create New Report']")).click();
	}
		 
	@Test(priority = 5)
	public void addSection() throws Exception 
	{

	Actions actions = new Actions(driver);	

	Robot robot = new Robot();
	Screen s = new Screen();
	Pattern ckEditorBox = new Pattern(".\\Images\\" + "CK_Editor.PNG");
	Pattern uploadInlineImage = new Pattern(".\\Images\\" + "UploadInlineImage.png"); 
	JavascriptExecutor js = (JavascriptExecutor) driver;		
	//actions.sendKeys(Keys.PAGE_UP).perform(); 
	js.executeScript("window.scrollBy(0,-3000)");
	Thread.sleep(4000);
	// Select Introduction and background
	// Add Section click 
	  // driver.findElement(By.xpath("//button[@class='add-section-btn btn btn-link text-end']")).click();
	   driver.findElement(By.id("addsectionbutton")).click();
	   Thread.sleep(2000);
			
	// Select section to add
	String actualTitle1= driver.findElement(By.xpath("//li[@class='dropdown-item'][1]")).getText();
	Thread.sleep(2000);
			
	try {
		Assert.assertTrue(actualTitle1.equals("Introduction and Background"));
	}catch(AssertionError e) {
	Reporter.log("Fail: <b>Introduction and Background:</b> Section name is incorrect", true);
	throw e;
		}Reporter.log("Pass: <b>Introduction and Background:</b> Section name is correct", true);	
	
	driver.findElement(By.xpath("//li[@class='dropdown-item'][1]")).click();	
	Thread.sleep(3000);
	// scroll down upto added section
	//actions.sendKeys(Keys.PAGE_DOWN).perform();
	 WebElement Introduction=driver.findElement(By.xpath("//span[.='Introduction and Background']"));
	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Introduction);
	Thread.sleep(2000);
	
	// ck editor
	s.type(ckEditorBox,"First section added as Introduction and Background");
	Thread.sleep(2000);
	
	// upload image
	robot.keyPress(KeyEvent.VK_ENTER);
	s.click(uploadInlineImage);
	robot.setAutoDelay(1000);
	 StringSelection inlineimage1 = new StringSelection("C:\\Users\\kanaka\\eclipse-workspace\\WPM_Maven\\Images\\Image1");
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(inlineimage1,null);
	 
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.setAutoDelay(1000);
	  
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  Thread.sleep(2000);

	Thread.sleep(2000);
	js.executeScript("window.scrollBy(0,-1000)");
	Thread.sleep(2000);
	
	// Select Building and Site Description
	// Add Section click 
	   //driver.findElement(By.xpath("//button[@class='add-section-btn btn btn-link text-end']")).click();
	driver.findElement(By.id("addsectionbutton")).click();   
	Thread.sleep(2000);		
	      String actualTitle2= driver.findElement(By.xpath("//li[@class='dropdown-item'][1]")).getText();
	
	try {
		Assert.assertTrue(actualTitle2.equals("Building and Site Description"));
	}catch(AssertionError e) {
		Reporter.log("Fail: <b>Building and Site Description:</b> Section name is incorrect", true);
		throw e;
	}Reporter.log("Pass: <b>Building and Site Description:</b> Section name is correct", true);
			
	driver.findElement(By.xpath("//li[@class='dropdown-item'][1]")).click();
	Thread.sleep(2000);
	// Scroll down upto added section
	/*for(int i=1; i<=2; i++) {
	actions.sendKeys(Keys.PAGE_DOWN).perform();
	Thread.sleep(1000);
	}*/
	 WebElement Building=driver.findElement(By.xpath("//span[.='Building and Site Description']"));
	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Building);
	Thread.sleep(2000);
	//js.executeScript("window.scrollBy(0,1000)", "");
	s.type(ckEditorBox, "Second section added as Building and Site Description");
	
	// Enter bullet points
	Pattern enterBulletPoints = new Pattern(".\\Images\\" + "BulletPoints.png");
	robot.keyPress(KeyEvent.VK_ENTER);
	s.type(enterBulletPoints, "A parapet wall is present at the front, north elevation of the roof.");
	robot.keyPress(KeyEvent.VK_ENTER);
	s.type("The exterior walls of the building are clad with vinyl siding on the east.");
	
	// Scroll upto add section
	robot.keyPress(KeyEvent.VK_HOME);
	robot.keyRelease(KeyEvent.VK_HOME);
	
	// Select Scope of Work
	// Add Section click 
	//driver.findElement(By.xpath("//button[@class='add-section-btn btn btn-link text-end']")).click();
	driver.findElement(By.id("addsectionbutton")).click();
	Thread.sleep(2000);
			
		  String actualTitle3= driver.findElement(By.xpath("//li[@class='dropdown-item'][1]")).getText();
	
	try {
		Assert.assertTrue(actualTitle3.equals("Scope of Work"));
	}catch(AssertionError e) {
		Reporter.log("Fail: <b>Scope of Work:</b> Section name is incorrect", true);
		throw e;
	}Reporter.log("Pass: <b>Scope of Work:</b> Section name is correct", true);
			
	driver.findElement(By.xpath("//li[@class='dropdown-item'][1]")).click();
	Thread.sleep(2000);
	// Scroll down upto added section
		/*for(int i=1; i<=3; i++) {
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		}*/
	 WebElement Scope=driver.findElement(By.xpath("//span[.='Scope of Work']"));
	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Scope);
		
	Thread.sleep(2000);
	s.type(ckEditorBox, "Third section added as Scope of Work");
	
	// Enter numbered list  
	Pattern enterNumbers = new Pattern(".\\Images\\" + "Numbers.png");
	robot.keyPress(KeyEvent.VK_ENTER);
	s.type(enterNumbers, "The interior finishes generally consist of painted gypsum board wall.");
	robot.keyPress(KeyEvent.VK_ENTER);
	s.type("The building is surrounded by concrete flatwork at the north and west elevation.");
	
	// Scroll up to add new section
	js.executeScript("window.scrollBy(0,-10000)");
	Thread.sleep(2000); 
	
	// Select Conclusions
	// Add Section click 
	 //driver.findElement(By.xpath("//button[@class='add-section-btn btn btn-link text-end']")).click();
	driver.findElement(By.id("addsectionbutton")).click();	
	Thread.sleep(2000);
	
	  String actualTitle4= driver.findElement(By.xpath("//li[@class='dropdown-item'][1]")).getText();
		
		try {
			Assert.assertTrue(actualTitle4.equals("Conclusions"));
		}catch(AssertionError e) {
			Reporter.log("Fail: <b>Conclusions:</b> Section name is incorrect", true);
			throw e;
		}Reporter.log("Pass: <b>Conclusions:</b> Section name is correct", true);
				
		driver.findElement(By.xpath("//li[@class='dropdown-item'][1]")).click();
		Thread.sleep(2000);
	// Scroll down upto added section
	/*for(int i=1; i<=4; i++) {
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		}	*/
	//actions.sendKeys(Keys.PAGE_UP).perform();
	
	 WebElement Conclusion=driver.findElement(By.xpath("//span[.='Conclusions']"));
	 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Conclusion);
		
	Thread.sleep(1000);
	// Type in bold font
	Pattern BoldFont = new Pattern(".\\Images\\" + "Bold.png");
	//s.click(BoldFont);
	Thread.sleep(2000);
	s.type(BoldFont, "Forth section added as Conclusions.");		
	
	// Scroll up to add new section
	js.executeScript("window.scrollBy(0,-10000)");
	Thread.sleep(2000); 
		
		 
		// Select Documents Reviewed
	// Add Section click 
	//   driver.findElement(By.xpath("//button[@class='add-section-btn btn btn-link text-end']")).click();
	driver.findElement(By.id("addsectionbutton")).click();
	Thread.sleep(2000);
	
	  String actualTitle5= driver.findElement(By.xpath("//li[@class='dropdown-item'][1]")).getText();
		
		try {
			Assert.assertTrue(actualTitle5.equals("Documents Reviewed"));
		}catch(AssertionError e) {
			Reporter.log("Fail: <b>Documents Reviewed:</b> Section name is incorrect", true);
			throw e;
		}Reporter.log("Pass: <b>Documents Reviewed:</b> Section name is correct", true);
				
		driver.findElement(By.xpath("//li[@class='dropdown-item'][1]")).click();
		Thread.sleep(2000);
		
	// Scroll down upto added section
	/*	for(int i=1; i<=4; i++) {
			actions.sendKeys(Keys.PAGE_DOWN).perform();
			Thread.sleep(1000);
			}	*/
		 WebElement Documents=driver.findElement(By.xpath("//span[.='Documents Reviewed']"));
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Documents);
			
		Thread.sleep(1000);
	
	// Type in Italic font
	Pattern ItalicFont = new Pattern(".\\Images\\" + "Italic.png");
	//s.click(ItalicFont);
	s.type(ItalicFont, "Fifth section added as Documents Reviewed");	
	
	// Scroll down to save the report
	//js.executeScript("window.scrollBy(0,2000)");
	actions.sendKeys(Keys.PAGE_DOWN).perform();
	Thread.sleep(2000); 
	System.out.println(driver.findElement(By.xpath("//*[@id='submitbutton']")).getText());
	//driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
	driver.findElement(By.xpath("//*[@id='submitbutton']")).click();
	//Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(driver,1000);
	String Message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Report has been created']"))).getText(); 
	System.out.println(Message);
	// Scroll up and Navigate back to dashboard
	js.executeScript("window.scrollBy(0,-10000)");
	Thread.sleep(8000); 
	Reporter.log("Add section completed successfully", true);
	//driver.findElement(By.xpath("(//*[@class='poppins-medium-dust-16px text-decoration-none text-reset'])[2]")).click();
	Thread.sleep(3000); 
	}
	
 // Check publish report without saving Reported Date of Loss	
	@Test(priority = 6)
	public void checkPublishReport() throws Exception {
		
		// Click on project title to expand
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Reporter.log("Check Publish Report without saving Reported Date Of Loss:");
		
		// Check warning message 
		driver.findElement(By.xpath("//button[@class='btn btn-secondary text-1 position-absolute top-0 end-0']")).click();
		Thread.sleep(2000);

		try {		
		String ActualWarnMessage = driver.findElement(By.xpath("//*[@class='alert alert-warning']")).getText();
		String ExpectedWarnMessage = "Please provide Reported Date of Loss for this report before publish.";
		Assert.assertEquals(ExpectedWarnMessage, ActualWarnMessage);
		Reporter.log("Message Displayed: "+ActualWarnMessage);
		}catch(AssertionError e) {
		Reporter.log("Fail: Warning messsage is not present", true);
		throw e;
		}Reporter.log("Pass: Warning message is present", true);
		
		// Close the Publish Report pop up
		//driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		driver.findElement(By.xpath("//*[@id='close-button']")).click();
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000); 
		
		// Now save the Reported Date of Loss 
		// Reported Date of Loss
	    driver.findElement(By.id("reportedDateOfLoss")).click();
		Thread.sleep(2000);
		  s.click(calendar);
		  Thread.sleep(2000);
		  s.click(date);
		  Thread.sleep(2000);
		
		for(int i=1; i<=2; i++) {
			actions.sendKeys(Keys.PAGE_DOWN).perform();
		}
		/*System.out.println(driver.findElement(By.xpath("//*[@class='btn btn-primary']")).getText());
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();*/
		//System.out.println(driver.findElement(By.xpath("//*[@id='submitbutton']")).getText());
		//driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//*[@id='submitbutton']")).click();
		WebDriverWait wait = new WebDriverWait(driver,1000);
		String Message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Report has been updated']"))).getText();
		Reporter.log(Message, true);
		
		// scroll up
		js.executeScript("window.scrollBy(0,-10000)");
		Thread.sleep(2000); 
		
		Reporter.log("Check Publish Report after saving Reported Date Of Loss:");
		// Check warning message again
		driver.findElement(By.xpath("//button[@class='btn btn-secondary text-1 position-absolute top-0 end-0']")).click();
		Thread.sleep(2000);
		
	    String PublishReportActualMessage = driver.findElement(By.xpath("//*[@class='title']")).getText();
	    String PublishReportExpectedMessage = "Upload Seal image which has to be used in published report";
	    try {
	    SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(PublishReportExpectedMessage, PublishReportActualMessage);
	    Reporter.log("Message Displayed: "+PublishReportActualMessage);
		}catch(AssertionError e) {
			Reporter.log("Fail: Warning message is still displayed", true);
			throw e;
		}Reporter.log("Pass: Warning message is not displayed", true);
		Thread.sleep(2000);
		// Close the Publish Report pop up
		//driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		driver.findElement(By.xpath("//*[@id='close-button']")).click();
		Thread.sleep(2000);
		// Navigate back to dashboard
		//driver.findElement(By.xpath("//*[@class='poppins-medium-dust-16px text-decoration-none text-reset']")).click();
		driver.findElement(By.xpath("(//*[@class='poppins-medium-dust-16px text-decoration-none text-reset'])[2]")).click();
		Thread.sleep(3000); 
	}
	
}
