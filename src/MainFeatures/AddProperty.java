package MainFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProperty {

	WebDriver driver = null;
	@BeforeMethod
	public void BasicRequest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aliab\\OneDrive\\Desktop\\Automation\\chromedriver.exe");
		driver = new ChromeDriver(); 
		String baseUrl = "https://aqarmap.com.eg/en/add_listing";
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	}
	@AfterMethod
	public void Closing() {			
		driver.close();
	}
	@Test(priority=1)
	public void Addproperty () throws InterruptedException {
		driver.findElement(By.className("login")).click();
		Thread.sleep(3000);
		//Login to list property
		driver.findElement(By.id("username")).sendKeys("ali.abdullah.abdelghany@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Aliali123321@");
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/section[1]/div[1]/div[1]/div[2]/form[1]/div[1]/button[1]")).click();
		Thread.sleep(4000);
		driver.navigate().to("https://aqarmap.com.eg/en/listing/initialize");
		Thread.sleep(2000);
		//navigate to this website 
		driver.findElement(By.id("propertyType")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[contains(text(),'-- Apartments')]")).click();
		//select property type
		driver.findElement(By.id("section")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[contains(text(),'For Sale')]")).click();
		//select Section type
		driver.findElement(By.className("form-control")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='vueApp']/div[3]/div[1]/section[1]/div[2]/form[1]/div[4]/div[1]/span[1]/select[1]/option[3]")).click();
		driver.findElement(By.className("form-control")).click();
		driver.findElement(By.xpath("//body/div[@id='vueApp']/div[3]/div[1]/section[1]/div[2]/form[1]/div[4]/div[1]/span[2]/select[1]/option[2]")).click();
		//select location
		


	}
}
