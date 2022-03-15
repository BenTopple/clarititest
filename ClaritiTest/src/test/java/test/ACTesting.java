package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import Pages.ACPage;
import Pages.ACPageObjects;

public class ACTesting {
	
	private static WebDriver driver = null;
	
	@BeforeTest
	public void SetupTestDriver()
	{
		//setting up driver and location
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver(); 
	}
	
	@Test
	public void ACTest()
	{		   	
		
		ACPageObjects acPage = new ACPageObjects(driver);
		
		//declare site url
		String baseUrl = "https://www.aircanada.com/ca/en/aco/home.html";
		
		//launch a new browser session and direct it to the URL
		//go to www.aircanada.com/ca/en/aco/home.html (aircanada.ca)
		driver.get(baseUrl);	
		
		//full screen the window so the language button is visible
		driver.manage().window().fullscreen();
		
		//pause so the test doesn't go too fast for the code to run
		acPage.Wait(2000);
				
		//Pick up “English Canada” to dismiss “Site Edition” dialog.	
		//WebElement selectLocation = driver.findElement(By.xpath("//*[@id=\"acSiteEditionSelectorDesktop-button\"]"));
		acPage.clickLanguageButton();
		//pause so the test doesn't go too fast for the code to run
		acPage.Wait(2000);
		
		//WebElement ConfirmLocation = driver.findElement(By.xpath("//*[@id=\"acEditionSelectorConfirmButton\"]"));			
		acPage.ConfirmLanguageButton();
		
		 
//		
//		
//		//Pick up “Flights” tab: 
//		//Select “Round-Trip” 
//		//Set From = “Vancouver YVR”
//		//Set To = “Toronto YYZ” 
//		//Set Departure Date = July.15 (select date from calendar) 
//		//Set Return Date= July. 22 (select date from calendar) 
//		//Without Promo Code
//		
//		//Click “Find”
//		//Wait until the “Select Flights” page displayed.
//		
//		//Assert Displays Date as July 15,2022 on Search Result page
//		//Assert Displays Economy, Premium Economy and Business Class Tabs on Search Result page
//		driver.close();
//		
	}
	
	@AfterTest
	public void EndTest()
	{
        //close browser
        driver.close();   
        driver.quit();
        System.out.println("Test Complete!"); 
	}
	
	

}
