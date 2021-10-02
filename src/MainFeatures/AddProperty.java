package MainFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public void login() throws InterruptedException {
		driver.findElement(By.className("login")).click();
		Thread.sleep(3000);
		//Login to list property
		driver.findElement(By.id("username")).sendKeys("ali.abdullah.abdelghany@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Aliali123321@");
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/section[1]/div[1]/div[1]/div[2]/form[1]/div[1]/button[1]")).click();
		Thread.sleep(4000);
	}
	@Test(priority=1)
	public void Addproperty () throws InterruptedException {
		login(); // Calling Login method
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
		Thread.sleep(2000);
		driver.findElement(By.className("form-control")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='vueApp']/div[3]/div[1]/section[1]/div[2]/form[1]/div[4]/div[1]/span[2]/select[1]/option[2]")).click();
		//select location
		driver.findElement(By.id("listing_title")).sendKeys("Property is titled");
		Thread.sleep(2000);
		driver.findElement(By.id("listing_description")).sendKeys("Property is described");
		//Title and description of the unit
		driver.findElement(By.id("listing_area")).sendKeys("120"); //the area
		driver.findElement(By.id("listing_propertyView")).click(); // property view
		driver.findElement(By.xpath("//option[contains(text(),'Main Street')]")).sendKeys("120");
		//the price
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='vueApp']/div[4]/div[1]/section[1]/div[3]/form[1]/fieldset[2]/div[1]/div[3]/input[2]")).sendKeys("120000");
		//payment method
		driver.findElement(By.id("listing_paymentMethod")).click(); //the payment method
		Thread.sleep(2000);
		driver.findElement(By.id("//body/div[@id='vueApp']/div[4]/div[1]/section[1]/div[3]/form[1]/fieldset[2]/div[1]/div[4]/div[1]/select[1]/option[1]")).click();
		//number of rooms 
		driver.findElement(By.id("listing_attributes_0_value")).sendKeys("4");
		//number of floors 
		driver.findElement(By.id("listing_attributes_1_value")).sendKeys("4");
		//number of bathrooms 
		driver.findElement(By.id("listing_attributes_2_value")).sendKeys("1");
		//year of building 
		driver.findElement(By.id("listing_attributes_3_value")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[contains(text(),'2030')]")).click();
		//type of finish 
		driver.findElement(By.id("listing_attributes_4_value")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[contains(text(),'Extra Super Lux')]")).click();
		//Listing address
		Thread.sleep(2000);
		driver.findElement(By.id("listing_address")).sendKeys("Zahraa elmaadi");
		//NextButton
		driver.findElement(By.id("forward_btn")).click();
		Thread.sleep(4000);
		//Uploaded photos
        WebElement uploadElement = driver.findElement(By.id("photos_file"));
        uploadElement.sendKeys("\"C:\\Users\\aliab\\Desktop\\243206681_4399959753430426_2120507036452597910_n.jpg\"");
		driver.findElement(By.id("forward_btn")).click(); // next button
		Thread.sleep(4000);
	}
}
