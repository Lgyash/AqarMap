package MainFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriceGuides {
	WebDriver driver = null;
	@BeforeMethod
	public void BasicRequest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aliab\\OneDrive\\Desktop\\Automation\\chromedriver.exe");
		driver = new ChromeDriver(); 
		String baseUrl = "https://aqarmap.com.eg/en/neighborhood/";
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	}
	@AfterMethod
	public void Closing() {			
		driver.close();
	}
	@Test(priority=2)
	public void clickOnPhoto() throws InterruptedException {
		//Click on governerate price guide
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[1]/div[1]/div[1]/div[3]/div[1]/a[1]/div[1]")).click();
	    Thread.sleep(3000);
	    //Open places details
		driver.findElement(By.xpath("//body/div[@id='vueApp']/section[@id='neighborhood_main_page']/div[2]/div[1]/div[3]/div[1]/div[1]/a[1]")).click();
	    Thread.sleep(3000);
	}
	@Test(priority=1)
	public void clickOnText() throws InterruptedException {
		//Click on cities price guide
		driver.findElement(By.xpath("//a[contains(text(),'Greater Cairo (77526)')]")).click();
	    Thread.sleep(3000);
	}
}
