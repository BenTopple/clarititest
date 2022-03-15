package com.testcode.ClaritiTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ACTest{
	
	
	public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Benjamin\\Documents\\GitHub\\clarititest\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();    	 
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Benjamin\\Documents\\GitHub\\clarititest\\drivers\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		    	 
		//declare site url
		String baseUrl = "https://www.aircanada.com/ca/en/aco/home.html";
		
		//launch a new browser session and direct it to the URL
		//go to www.aircanada.com/ca/en/aco/home.html (aircanada.ca)
		driver.get(baseUrl);	
		
		//full screen the window so the language button is visible
		driver.manage().window().fullscreen();
		
		//pause so the test doesn't go too fast for the code to run
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//Pick up “English Canada” to dismiss “Site Edition” dialog.	
		WebElement selectLocation = driver.findElement(By.xpath("//*[@id=\"acSiteEditionSelectorDesktop-button\"]"));
		selectLocation.click();
		
		//pause so the test doesn't go too fast for the code to run
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement ConfirmLocation = driver.findElement(By.xpath("//*[@id=\"acEditionSelectorConfirmButton\"]"));		
		ConfirmLocation.click();
		
		
		
		
		System.out.println("Test Complete!"); 
		
        //close browser
        driver.close();    
        
       
    }
	
	
	
//	@Test
//	public void TestMethod1()
//	{
//		//launch a new Chrome driver
//		WebDriver driver = new ChromeDriver();
//		
//		String baseUrl = "www.aircanada.com/ca/en/aco/home.html";
//		
//		//launch a new browser session and direct it to the URL
//		//go to www.aircanada.com/ca/en/aco/home.html (aircanada.ca)
//		driver.get(baseUrl);	
//				
//		//Pick up “English Canada” to dismiss “Site Edition” dialog.		
//		WebElement selectLocation = driver.findElement(By.id("acSiteEditionSelectorDesktop-button"));		
//		selectLocation.click();
//		
//		WebElement ConfirmLocation = driver.findElement(By.id("acEditionSelectorConfirmButton"));		
//		ConfirmLocation.click();
//		
//		//Thread.sleep(3000);
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
//	}
//	
	//ids
	//acSiteEditionSelectorDesktop-button
	//acEditionSelectorConfirmButton
}