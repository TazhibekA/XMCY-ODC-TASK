package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage{
	private final String BASE_URL = "https://www.xm.com/";
	@FindBy(xpath = "//button[contains(@class,'gtm-acceptDefaultCookieFirstVisit')]")
	WebElement acceptAllButton;

	@FindBy(xpath = "//ul/li[contains(@class,'main_nav_research')]")
	WebElement researchAndEducation;

	@FindBy(xpath = "//ul/li[contains(@class,'main_nav_research')]/div[@class='dropdown']//ul/li[6]/a")
	WebElement economicCalendar;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}

	public MainPage acceptAllCookies(){
		acceptAllButton.click();
		return this;
	}

	public MainPage waitAcceptAllButtonIsNotDisplayed(){
		wait.until(ExpectedConditions.invisibilityOf(acceptAllButton));
		return this;
	}

	public MainPage clickResearchAndEducation(){
		researchAndEducation.click();
		return this;
	}

	public MainPage waitResearchAndEducationAttributeContains(String attributeName, String value){
		wait.until(ExpectedConditions.attributeContains(researchAndEducation,attributeName,value));
		return this;
	}

	public MainPage waitEconomicCalendarIsDisplayed(){
		wait.until(ExpectedConditions.visibilityOf(economicCalendar));
		return this;
	}

	public CalendarPage clickEconomicCalendarOption(){
		economicCalendar.click();
		return new CalendarPage(driver);
	}


}
