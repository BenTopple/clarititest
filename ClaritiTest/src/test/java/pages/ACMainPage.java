package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ACMainPage {
	
	//initialize driver
	WebDriver driver  = null;
	
	//constructor
	public ACMainPage(WebDriver driver) {
		this.driver = driver;
	}
		
	//locators
	By selectLanguage = By.xpath("//*[@id=\"acSiteEditionSelectorDesktop-button\"]");
	By confirmLanguage = By.xpath("//*[@id=\"acEditionSelectorConfirmButton\"]");
	By flightsTab = By.xpath("//*[@id=\"bkmg-tab-button-flight\"]");
	//By flightTypeSelector = By.id("bkmgFlights_tripTypeSelectorSelectedOption");	
	By flightOrigin = By.name("flightsTabOrigin1");
	By flightDestination = By.name("flightsTabDestination1");
	
	By startDate = By.name("bkmgFlights_travelDates_1-formfield-1");
	By returnDate = By.name("bkmgFlights_travelDates_1-formfield-2");
	
	By findFlightsButton = By.id("bkmgFlights_findButton");
	
	By promoCode = By.id("bkmgFlights_promoCode");
	
	By originOption1 = By.id("bkmgFlights_origin_trip_1SearchResult0");
	By destinationOption1 = By.id("bkmgFlights_destination_trip_1SearchResult1");
	//selector//
//	By flightTypeSelector = By.xpath("//*[@id=\"bkmgFlights_tripTypeSelector\"]");
//	
//	public void FlightTypeSelector(int index)
//	{
//		Select select = new Select(driver.findElement(flightTypeSelector));
//
//		select.selectByIndex(index);
//	}
			
	public void enterTripStartDate(String inputDate)
	{
		driver.findElement(startDate).sendKeys(inputDate);
	}
	
	public void enterTripReturnDate(String inputDate)
	{
		driver.findElement(returnDate).sendKeys(inputDate);
	}

	public void enterFlightOrigin(String originText)
	{
		WebElement origin = driver.findElement(flightOrigin);
		origin.sendKeys(originText);
		
		Wait(4000);
		//select index 1 from the list
		WebElement originOption = driver.findElement(originOption1);
		originOption.click();
	}
	
	public void enterFlightDestination(String destinationText)
	{
		WebElement destination = driver.findElement(flightDestination);
		destination.sendKeys(destinationText);
		
		Wait(4000);
		//select index 1 from the list
		WebElement destOption = driver.findElement(destinationOption1);
		destOption.click();
		
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
	
	public SelectFlightsPage clickFindFlightsBtn()
	{
		driver.findElement(findFlightsButton).click();
		
		return new SelectFlightsPage(driver);		
	
	}
	
	public void enterPromoCode(String code)
	{
		driver.findElement(promoCode).sendKeys(code);
	}
		
	public void Wait(int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	////////////////////
//	By calendar = By.id(("bkmgFlights_travelDates_1-showCalendar"));
//	
//	public void ClickCalendar()
//	{
//		driver.findElement(calendar).click();
//	}
//	
//	
//	Date d = new Date(1);
//	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
//	String date = formatter.format(d);
//	String splitter[] = date.split("-");
//	String month_year = splitter[1];
//	String day = splitter[0]; 
//
//
//	public void selectDate(String month_year, String select_day) throws InterruptedException
//	{ 
//	List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[1]"));
//
//	for (int i=0; i<elements.size();i++)
//	{
//	System.out.println(elements.get(i).getText());
//
//	//Selecting the month
//	if(elements.get(i).getText().equals(month_year))
//	{ 
//
//	//Selecting the date 
//	List<WebElement> days = driver.findElements(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/table/tbody/tr/td/a"));
//
//	for (WebElement d:days)
//	{ 
//	System.out.println(d.getText());
//	if(d.getText().equals(select_day))
//	{
//	d.click();
//	Thread.sleep(10000);
//	return;
//	}
//	} 
//
//	} 
//
//	}
//	driver.findElement(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/div/a/span")).click();
//	selectDate(month_year,select_day);
//
//	}
	
	
	////////////////////
	

}
