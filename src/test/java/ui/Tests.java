package ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CalendarPage;
import pages.MainPage;
import ui.Commons;

public class Tests extends Commons {
	CalendarPage calendarPage;
	SoftAssert softAssert = new SoftAssert();
	Calendar cal = Calendar.getInstance();
	DateFormat firstDateFormat = new SimpleDateFormat("dd/MM/yyyy - dd/MM/yyyy");
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String eventsTableAttributeClassNotDisplayedValue = "genTable closedTable ecoCalTable displayNone";
	String eventsTableAttributeClassValue = "genTable closedTable ecoCalTable";
	LocalDate lastSunday = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
	LocalDate thisWeeksSaturday = LocalDate.now().with(DayOfWeek.SATURDAY);

	@BeforeMethod
	private void setup() {
		calendarPage = new MainPage(driver)
				.openPage()
				.acceptAllCookies()
				.waitAcceptAllButtonIsNotDisplayed()
				.clickResearchAndEducation()
				.waitResearchAndEducationAttributeContains("class","selected")
				.waitEconomicCalendarIsDisplayed()
				.clickEconomicCalendarOption()
				.waitScreenLoaded();
	}

	@Test(priority = 1)
	public void validateCorrectDates(){
		calendarPage
				.switchToCalendarFrame()
				.clickTodayButton()
				.waitEventsTableAttributeToBe("class",eventsTableAttributeClassNotDisplayedValue)
				.waitEventsTableAttributeToBe("class",eventsTableAttributeClassValue);
		softAssert.assertEquals(calendarPage.dateInputGetText(), firstDateFormat.format(cal.getTime()));

		cal.add(Calendar.DATE, -1);
		calendarPage.clickYesterdayButton()
				.waitEventsTableAttributeToBe("class",eventsTableAttributeClassNotDisplayedValue)
				.waitEventsTableAttributeToBe("class",eventsTableAttributeClassValue);
		softAssert.assertEquals(calendarPage.dateInputGetText(), firstDateFormat.format(cal.getTime()));

		cal.add(Calendar.DATE, +2);
		calendarPage.clickTomorrowButton()
				.waitEventsTableAttributeToBe("class",eventsTableAttributeClassNotDisplayedValue)
				.waitEventsTableAttributeToBe("class",eventsTableAttributeClassValue);
		softAssert.assertEquals(calendarPage.dateInputGetText(), firstDateFormat.format(cal.getTime()));

		calendarPage.clickThisWeekButton()
				.waitEventsTableAttributeToBe("class",eventsTableAttributeClassNotDisplayedValue)
				.waitEventsTableAttributeToBe("class",eventsTableAttributeClassValue);
		softAssert.assertEquals(calendarPage.dateInputGetText(), dateTimeFormatter.format(lastSunday) + " - " + dateTimeFormatter.format(thisWeeksSaturday));

		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void validateHereLinks() {
		calendarPage
				.clickHereLink()
				.waitScreenLoaded()
				.clickHereLink();
		String currentWindow = driver.getWindowHandle();
		List<String> listWindows = new ArrayList<>(driver.getWindowHandles());
		if (currentWindow.equals(listWindows.get(0))) {
			driver.switchTo().window(listWindows.get(listWindows.size() - 1));
		}
		Assert.assertTrue(listWindows.size() > 0);
	}

}
