package MainFeatures;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopAgents {
	WebDriver driver = null;
	@BeforeMethod
	public void BasicRequest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aliab\\OneDrive\\Desktop\\Automation\\chromedriver.exe");
		driver = new ChromeDriver(); 
		String baseUrl = "https://aqarmap.com.eg/en/agents/cairo?tab=agents";
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	}
	@AfterMethod
	public void Closing() {			
		driver.close();
	}
	
	@Test(priority=1)
	public void ClickOnAgent() throws InterruptedException {
		//Click on agent show number 
		driver.findElement(By.xpath("//body[1]/div[3]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/button[1]/b[1]")).click();
		Thread.sleep(3000);
		
        String MainWindow=driver.getWindowHandle();		
		
        // To handle all new opened window.				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);	                                                                                                           
                    driver.findElement(By.xpath("//body/div[@id='vueApp']/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/button[1]"))
                    .click(); 
            		Thread.sleep(3000);
			// Closing the Child Window.
                    driver.close();		
            }		
        }		
        // Switching to Parent window
            driver.switchTo().window(MainWindow);				

	}
}
