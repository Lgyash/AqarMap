package MainFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Valuations {
	WebDriver driver = null;
	@BeforeMethod
	public void BasicRequest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aliab\\OneDrive\\Desktop\\Automation\\chromedriver.exe");
		driver = new ChromeDriver(); 
		String baseUrl = "https://i.aqarmap.com/estimates/step1.php";
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	}
	@AfterMethod
	public void Closing() {			
		driver.close();
	}
	
	@Test(priority=1)
	public void Evaluation() throws InterruptedException {
		//Add City
		driver.findElement(By.xpath("//select[@id='cities']")).click();
	    Thread.sleep(3000);
	    //Add area
		driver.findElement(By.xpath("//body/div[3]/form[1]/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys("200");
	    Thread.sleep(3000);
	    //property data
		driver.findElement(By.xpath("//body/div[3]/form[1]/div[1]/div[1]/div[3]/select[1]")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//option[contains(text(),'لدي عقار بهذه المواصفات')]")).click();
		//name,phone,email
		driver.findElement(By.xpath("//body/div[3]/form[1]/div[1]/div[1]/div[4]/div[1]/input[1]")).sendKeys("Ali");
	    Thread.sleep(3000);
		driver.findElement(By.cssSelector("#phone")).sendKeys("01096368360");
	    Thread.sleep(3000);
		driver.findElement(By.cssSelector("#email")).sendKeys("abc@xyz.abc");
	    Thread.sleep(3000);
		//submit
		driver.findElement(By.xpath("//input[@id='submit']")).click();
	    Thread.sleep(3000);
	}
}
