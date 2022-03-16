package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ACPageObjects {
	
	//initialize driver
	WebDriver driver  = null;
	
	//locators
	By selectLanguage = By.xpath("//*[@id=\"acSiteEditionSelectorDesktop-button\"]");
	By confirmLanguage = By.xpath("//*[@id=\"acEditionSelectorConfirmButton\"]");
	By flightsTab = By.xpath("//*[@id=\"bkmg-tab-button-flight\"]");
	//By flightTypeSelector = By.id("bkmgFlights_tripTypeSelectorSelectedOption");
	
//	By flightTypeSelector = By.xpath("//*[@id=\"bkmgFlights_tripTypeSelector\"]");
//	
//	public void FlightTypeSelector(int index)
//	{
//		Select select = new Select(driver.findElement(flightTypeSelector));
//
//		select.selectByIndex(index);
//	}
	
	
	
	//constructor
	public ACPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	//locator methods
	public void clickLanguageButton()
	{
		driver.findElement(selectLanguage).click();
	}
	
	public void ConfirmLanguageButton()
	{
		driver.findElement(confirmLanguage).click();
	}
	
	public void ClickFlightsTab()
	{
		driver.findElement(flightsTab).click();
	}
	
		
	public void Wait(int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
