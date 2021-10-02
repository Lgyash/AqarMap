package MainFeatures;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Compounds {
	WebDriver driver = null;
	@BeforeMethod
	public void BasicRequest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aliab\\OneDrive\\Desktop\\Automation\\chromedriver.exe");
		driver = new ChromeDriver(); 
		String baseUrl = "https://aqarmap.com.eg/en/compounds/";
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	}
	@AfterMethod
	public void Closing() {			
		driver.close();
	}
	@Test(priority=1)
	public void FilterCompound() throws InterruptedException {
		//select Locations
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/a[1]/label[2]/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/tree-view[1]/ul[1]/li[1]/div[1]/label[1]")).click();
		//property types
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/a[1]/label[2]/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Apartments')]")).click();
		//price level
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Economic')]")).click();
		//status
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[1]/a[1]/label[2]/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Under Construction')]")).click();
		//Finish Type
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[5]/div[1]/div[1]/div[1]/a[1]/label[2]/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Super lux')]")).click();
		//Payment method
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[7]/div[1]/div[1]/div[1]/a[1]/label[2]/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/label[1]")).click();
		//Compound Name
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[7]/div[1]/div[1]/div[1]/a[1]/label[2]/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]/span[1]/span[1]/ul[1]/li[1]/input[1]")).sendKeys("O West");
		Thread.sleep(3000);
		//submit filter
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[4]/div[1]/div[2]/form[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();
	}
	
	@Test(priority = 2)
	public void selectCompound() throws InterruptedException {
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[5]/div[1]/div[1]/div[1]/a[1]/div[1]/div[2]")).click();
		Thread.sleep(3000);
		Boolean titleBoolean = driver.findElement(By.xpath("//h1[contains(text(),'Linx Tower')]")).isDisplayed();
		assertTrue(titleBoolean);
	}
}
