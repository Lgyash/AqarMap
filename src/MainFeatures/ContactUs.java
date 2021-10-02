package MainFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUs {
	
	WebDriver driver = null;
	
	@BeforeMethod
	public void BasicRequest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aliab\\OneDrive\\Desktop\\Automation\\chromedriver.exe");
		driver = new ChromeDriver(); 
		String baseUrl = "https://aqarmap.com.eg/en/feedback";
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	}
	
	@AfterMethod
	public void Closing() {			
		driver.close();
	}
	
	@Test(priority=1)
	public void FillForm() throws InterruptedException{
		//Feedback message
		driver.findElement(By.id("feedback_message")).sendKeys("this is so bad");
	    Thread.sleep(3000);
		//customer name
		driver.findElement(By.id("feedback_author")).sendKeys("Ali");
	    Thread.sleep(3000);
		//customer email
		driver.findElement(By.id("feedback_email")).sendKeys("abc@xyz.abc");
	    Thread.sleep(3000);
		//submit button
		driver.findElement(By.className("gtm-btn-submit-problem")).click();
	    Thread.sleep(3000);
	}

	
}
