package test;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.ACMainPage;
import pages.SelectFlightsPage;

import java.util.concurrent.TimeUnit;

public class ACTesting {
	
	private static WebDriver driver = null;
	
	@BeforeTest
	public void SetupTestDriver()
	{
		//setting up driver and location
		String projectPath = System.getProperty("user.dir");
		//Chrome
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver(); 
		//Firefox
		//System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/geckodriver.exe");
		//driver = new FirefoxDriver(); 
		
		//set implicit wait time for timeouts
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@Test (priority = 0)
	public void ACTest()
	{		   	

		ACMainPage acPage = new ACMainPage(driver);
		
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
		acPage.Wait(4000);
		
		//WebElement ConfirmLocation = driver.findElement(By.xpath("//*[@id=\"acEditionSelectorConfirmButton\"]"));			
		acPage.ConfirmLanguageButton();
		
		acPage.Wait(6000);
		
		//Pick up “Flights” tab
		acPage.ClickFlightsTab();	
	
		//select Round-trip
		//acPage.FlightTypeSelector("Round-Trip");		
		//Select select = new Select(driver.findElement(By.xpath("//select[@id=\"bkmgFlights_tripTypeSelector\"]")));
		//select.selectByIndex(0);
	
		//Set From = “Vancouver YVR”
		acPage.enterFlightOrigin("Vancouver");
		
		//Set To = “Toronto YYZ” 
		acPage.enterFlightDestination("Toronto");
		
		//Set Departure Date = July.15 (select date from calendar) 
		acPage.enterTripStartDate("15/07/2022");
		//Set Return Date= July. 22 (select date from calendar) 
		acPage.enterTripReturnDate("22/07/2022");
		
		//Without Promo Code
		acPage.enterPromoCode("");		
				
		//Click “Find”
		SelectFlightsPage selFlightsPage = acPage.clickFindFlightsBtn();
		selFlightsPage.Wait(5000);
		//driver.manage().window().fullscreen();
		//Wait until the “Select Flights” page displayed.
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("EXECCabin")));
		
		//driver.manage().window().fullscreen();
		
		//selFlightsPage.Wait(8000);
				
		//Assert Displays Date as July 15,2022 on Search Result page
		//Assert.assertEquals(actual,expected);  
		Assert.assertEquals("Fri - Jul 15",driver.findElement(By.xpath("//*[@id=\"fdPanel\"]/div/div/calendar-panel/div/div/ul/li[6]/a/div[2]/span")).getText()); 
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"fdPanel\"]/div/div/calendar-panel/div/div/ul/li[6]/a/div[2]/span")).getText());  
				
		//Assert Displays Economy, Premium Economy and Business Class Tabs on Search Result page	
		//Economy
		Assert.assertEquals("Economy",driver.findElement(By.id("ECOCabin")).getText()); 
		//Premium
		Assert.assertEquals("Premium Economy",driver.findElement(By.id("PREMCabin")).getText()); 
		//Business
		Assert.assertEquals("Business Class",driver.findElement(By.id("EXECCabin")).getText()); 
		
		//selFlightsPage.Wait(5000);
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
