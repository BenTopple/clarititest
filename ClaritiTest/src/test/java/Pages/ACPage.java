package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ACPage {
	
	private static WebElement element = null;
	
	public static WebElement SelectLocation(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id=\"acSiteEditionSelectorDesktop-button\"]"));
		return element;
	}
	
	public static WebElement ConfirmLocation(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id=\"acEditionSelectorConfirmButton\"]"));		
		return element;
	}

}
