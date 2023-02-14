package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountPage;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.NewsletterSubscriptionPage;
import testBase.BaseClass;

public class TC_RF_005 extends BaseClass{
	@Test
	public void yesNewsletter()
	{
		logger.info("*** Starting account registration test ***");
		try
		{
			SoftAssert sa=new SoftAssert();
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			logger.info("Clicked on register link");

			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);

			regpage.setFirstName(randomString().toUpperCase());

			regpage.setLastName(randomString().toUpperCase());

			logger.info("Providing customer details");
			regpage.setEmail(randomString()+"@gmail.com");// randomly generated the email

			regpage.setTelephone(randomNumber());

			String password=randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickYesButton();
			regpage.clickContinue();
			String confmsg=regpage.getConfirmationMsg();
			
			sa.assertEquals(confmsg, "Your Account Has Been Created!");
			MyAccountPage macc=new MyAccountPage(driver);
			
			macc.clickContinue();
			
			AccountPage ap=new AccountPage(driver);
			ap.clickNewsletterSubsUnsubs();
			
			NewsletterSubscriptionPage nl=new NewsletterSubscriptionPage(driver);
			boolean yesRadio=nl.isYesRadioClicked();
			sa.assertEquals(yesRadio, true);
			
			sa.assertAll();
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
	}
}
