package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//a[normalize-space()='Subscribe / unsubscribe to newsletter']")
	WebElement lnkNewsletterSubsUnsubs;
	
	public void clickNewsletterSubsUnsubs()
	{
		lnkNewsletterSubsUnsubs.click();
	}
}
