package KloudqTechnologies.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import KloudqTechnologies.PageObjects.Login;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest  {
	
	 public static WebDriver driver;
public static WebDriver initializeDriver() throws IOException {
	
	
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//KloudqTechnologies//resources//GlobalData.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	
	if(browserName.equalsIgnoreCase("chrome")) 
	{
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	
	}
	
	else if (browserName.equalsIgnoreCase("firefox")) 
	{}
	else if (browserName.equalsIgnoreCase("Edge")) 
	{}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
	
}
public String getScreenshot(String testCaseName, WebDriver driver)throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File file=new File(System.getProperty("use.dir")+"//reports//"+testCaseName+".png");
	FileUtils.copyFile(source,file);
	return System.getProperty("use.dir")+"//reports//"+testCaseName+".png";
	
}


public static Login launchApplication(String url) throws IOException
{
	driver=initializeDriver();
Login landingPage=new Login(driver);
	

landingPage.goTo(url);
return landingPage;
	
	
}

}
