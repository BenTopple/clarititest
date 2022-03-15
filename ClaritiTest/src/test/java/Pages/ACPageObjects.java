package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ACPageObjects {
	
	//initialize driver
	WebDriver driver  = null;
	
	//locators
	By selectLanguage = By.xpath("//*[@id=\"acSiteEditionSelectorDesktop-button\"]");
	By confirmLanguage = By.xpath("//*[@id=\"acEditionSelectorConfirmButton\"]");
	
	
	
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
	
	public void Wait(int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
