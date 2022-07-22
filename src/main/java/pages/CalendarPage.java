package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarPage extends AbstractPage{

	@FindBy(xpath = "//section[@class='page-content']//div[@class='container mt-350']/div/div[1]//h2")
	WebElement economicCalendarHeader;

	@FindBy(xpath = "//ul[@id='timeselector']/li/a[@id='timeFrame_yesterday']")
	WebElement yesterdayButton;

	@FindBy(xpath = "//ul[@id='timeselector']/li/a[@id='timeFrame_today']")
	WebElement todayButton;

	@FindBy(xpath = "//ul[@id='timeselector']/li/a[@id='timeFrame_tomorrow']")
	WebElement tomorrowButton;

	@FindBy(xpath = "//ul[@id='timeselector']/li/a[@id='timeFrame_thisWeek']")
	WebElement thisWeekButton;

	@FindBy(xpath = "//div[@id='widgetField']/div")
	WebElement dateInput;

	@FindBy(xpath = "//iframe[@title='economicCalendar']")
	WebElement calendarFrame;

	@FindBy(xpath = "//table[@id='ecEventsTable']")
	WebElement eventsTable;

	@FindBy(xpath = "//div[@class='container mt-400']/div/p/a")
	WebElement hereLink;

	public CalendarPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public CalendarPage waitScreenLoaded(){
		wait.until(ExpectedConditions.visibilityOf(economicCalendarHeader));
		return this;
	}
	public CalendarPage clickYesterdayButton(){
		yesterdayButton.click();
		return this;
	}

	public CalendarPage clickTodayButton(){
		todayButton.click();
		return this;
	}

	public CalendarPage clickTomorrowButton(){
		tomorrowButton.click();
		return this;
	}

	public CalendarPage clickThisWeekButton(){
		thisWeekButton.click();
		return this;
	}

	public String dateInputGetText(){
		return dateInput.getText();
	}

	public CalendarPage switchToCalendarFrame(){
		driver.switchTo().frame(calendarFrame);
		return this;
	}

	public CalendarPage waitEventsTableAttributeToBe(String attributeName, String value){
		wait.until(ExpectedConditions.attributeToBe(eventsTable, attributeName, value));
		return this;
	}

	public DisclaimerPage clickHereLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", hereLink);
		return new DisclaimerPage(driver);
	}
}
