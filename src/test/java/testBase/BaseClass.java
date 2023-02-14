package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	@BeforeClass(groups = {"Master","Sanity","Regression"})
	@Parameters
	public void setup()
	{
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		rb=ResourceBundle.getBundle("config");
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		logger=LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(rb.getString("appURL"));
	}
	@AfterClass(groups = {"Master","Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomNumber()
	{
		String generatedString2=RandomStringUtils.randomNumeric(10);
		return generatedString2;
	}
	public String randomAlphaNumeric()
	{
		String st=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(4);
		return (st+"@"+num);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}
