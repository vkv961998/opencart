package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_004 extends BaseClass{
	@Test(groups={"Reression","Master"})
	public void account_Registration()
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
			regpage.clickContinue();
			String firstnamemsg=driver.findElement(By.xpath("//input[@name='firstname']//following-sibling::div")).getText();			
			String lastnamemsg=driver.findElement(By.xpath("//input[@name='lastname']//following-sibling::div")).getText();
			String emailmsg=driver.findElement(By.xpath("//input[@name='email']//following-sibling::div")).getText();
			String telephonemsg=driver.findElement(By.xpath("//input[@name='telephone']//following-sibling::div")).getText();
			String passwordmsg=driver.findElement(By.xpath("//input[@name='password']//following-sibling::div")).getText();
			sa.assertEquals(firstnamemsg, "First Name must be between 1 and 32 characters!","First Name message is not matching");
			sa.assertEquals(lastnamemsg, "Last Name must be between 1 and 32 characters!","Last Name message is not matching");
			sa.assertEquals(emailmsg, "E-Mail Address does not appear to be valid!","E-Mail message is not matching");
			sa.assertEquals(telephonemsg, "Telephone must be between 3 and 32 characters!","Telephone message is not matching");
			sa.assertEquals(passwordmsg, "Password must be between 4 and 20 characters!","Password message is not matching");
			sa.assertAll();
			
		}
		catch(Exception e)
		{
			Assert.assertTrue(false);
		}

	}
}
