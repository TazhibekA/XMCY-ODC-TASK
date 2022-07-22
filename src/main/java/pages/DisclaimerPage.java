package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DisclaimerPage extends AbstractPage{

	@FindBy(xpath = "//section[@class='page-content']//div[@class='container mt-350']/h2")
	WebElement header;

	@FindBy(xpath = "//div[@class='container mt-350']/p[11]/a")
	WebElement hereLink;

	public DisclaimerPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public DisclaimerPage waitScreenLoaded(){
		wait.until(ExpectedConditions.visibilityOf(header));
		return this;
	}

	public void clickHereLink(){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", hereLink);
	}
}
