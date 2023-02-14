package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsletterSubscriptionPage extends BasePage{

	public NewsletterSubscriptionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@value='1']")
	WebElement radioYes;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement radioNo;
	
	public boolean isYesRadioClicked()
	{
		return radioYes.isSelected();
	}
	
	public boolean isNoRadioClicked()
	{
		return radioNo.isSelected();
	}
}
