package pages;

import org.openqa.selenium.WebDriver;

public class SelectFlightsPage {
		
	//initialize driver
	WebDriver driver  = null;
	
	//constructor
	public SelectFlightsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	
	
	//methods
	public void Wait(int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
