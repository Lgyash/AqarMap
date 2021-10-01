package MainFeatures;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchAndFilter {

	WebDriver driver = null;
	@BeforeMethod
	public void BasicRequest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aliab\\OneDrive\\Desktop\\Automation\\chromedriver.exe");
		driver = new ChromeDriver(); 
		String baseUrl = "https://aqarmap.com.eg/en/search-page-filters";
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	}
	@AfterMethod
	public void Closing() {			
		driver.close();
	}
	
	@Test(priority=1)
	public void Search() throws InterruptedException {
		driver.findElement(By.cssSelector("body.ltr:nth-child(2) div.home-image-container.home-image-container__search-box:nth-child(2) div.container.home-image-container__header-wrapper.w-100.position-relative div.homepage-container div.hero div.hero-content form.search-box-form.ng-pristine.ng-valid div.full-width div.w-100 div.search-box-container.ng-scope div.input-group.listing-search div.full-width.search-box-seaction-margin.d-flex.justify-content-between.flex-column:nth-child(1) div.search-location-container div.drop-down-container.border-0 span.select2.select2-container.select2-container--default span.selection > span.select2-selection.select2-selection--multiple")).sendKeys("za");
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[2]/span[1]/span[1]/ul[1]/li[1]/div[1]/label[1]")).click();
		//Search For Location
	    Thread.sleep(1000);
		driver.findElement(By.id("search_propertyType")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Apartments')]")).click();
		//Select the property type
	    Thread.sleep(3000);
		driver.findElement(By.id("search_section")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'For Sale')]")).click();
		//Select the Section type
	    Thread.sleep(3000);
		driver.findElement(By.id("search_min_price")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'100,000')]")).click();
		//Select the Min Price 
	    Thread.sleep(3000);
		driver.findElement(By.id("search_max_price")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'400,000')]")).click();
		//Select the Max Price 
	    Thread.sleep(3000);
		driver.findElement(By.id("search_min_area")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'10')]")).click();
		//Select the Min area 
	    Thread.sleep(3000);
		driver.findElement(By.id("search_max_area")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'150')]")).click();
		//Select the Max area 
	    Thread.sleep(3000);
		driver.findElement(By.id("search_btn")).click();
	    Thread.sleep(5000);
		//Submit Search Button
		Boolean property = driver.findElement(By.xpath("//span[contains(text(),'370,000 ')]")).isDisplayed();
		assertTrue(property);
	}
	
	@Test(priority=2)
	public void Filter() throws InterruptedException {
		driver.navigate().to("https://aqarmap.com.eg/en/for-sale/property-type/?default=1");
	    Thread.sleep(3000);
	    driver.findElement(By.className("photos-only")).click();
	    //Results Filter
	    driver.findElement(By.xpath("//body/div[@id='vueApp']/div[2]/div[3]/div[2]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[contains(text(),'Cash')]")).click();
	    //Payment Method
	    driver.findElement(By.xpath("//body/div[@id='vueApp']/div[2]/div[3]/div[2]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/label[2]/span[1]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[contains(text(),'Main Street')]")).click();
	    //View
	    Thread.sleep(3000);
	    driver.findElement(By.id("te-submit-filters")).click();
	    //Submit Filter
	}
}
