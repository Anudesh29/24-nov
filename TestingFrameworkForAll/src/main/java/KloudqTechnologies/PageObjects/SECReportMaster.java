package KloudqTechnologies.PageObjects;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import KloudqTechnologies.AbstractComponents.AbstractComponent;
public class SECReportMaster extends AbstractComponent {

	public SECReportMaster(WebDriver driver) 
	{
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}
	public void ClickSLDTab() 
	{
		WebElement clickSLDTab=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[2]/a/div/div/img"));
		clickSLDTab.click();

	}

	public  void AllWebElements() 
	{
		//to catch all web elements into list
		List<WebElement> myList=driver.findElements(By.className("tool"));


		List<String> all_elements_text=new ArrayList<>();


		myList.forEach(l -> {
			//loading text of each element in to array all_elements_text
			all_elements_text.add(l.getText());

			//to print directly
			System.out.println(l.getText());
			String a = l.getText();

		});
		//isEmptyStringArray(all_elements_text);

	}

	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	private ExtentReports report;
	private ExtentTest logger;


	public static  String takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		String dateName =new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/" +  dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(source, finalDestination);

		return destination;
	}


	public void highLighterMethod(WebDriver driver, WebElement parentnode){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		JavascriptExecutor js2 = (JavascriptExecutor) driver;

		//WebElement body=driver.findElement(By.xpath("//*[@id=\"kt_body\"]"));
		//js2.executeScript("arguments[0].setAttribute('style','background-color: green;');", body);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", parentnode);
	}



	public void HeaderCheck(ExtentReports reportheader) {
		logger=reportheader.createTest("Check -> All Elements in Header");
		logger.info("Starting All Elements in Header");
		logger.pass("Visibility Check Test Success");

		if( driver.findElement(By.xpath("//*[@id=\"kt_header\"]/div")).isDisplayed())
		{
			System.out.println("Elements in Header are Visible");
			logger.log(Status.PASS,"Elements in Header are Visible");
		}
		else
		{
			System.out.println("Elements in Header are not Visible");
			logger.log(Status.FAIL,"Error Some Elements in Header are not Visible");
		}		

	}

	public void SECReortandProductMaster(ExtentReports report1) throws SQLException, FileNotFoundException, IOException, InterruptedException	{

		// Check SEC product master in  Administrator 

		driver.findElement(By.xpath("(//div[@class=\"logo-image\"])[5]")).click();


		WebElement	Element = driver.findElement(By.xpath("(//span[@class=\"fw-bold fs-6-dash title-color\"])[19]"));


		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", Element);

		Element.click();



		String SECProductMaster= driver.findElement(By.xpath("(//a[@class=\"text-dark fw-bolder d-block fs-6\"])[1]")).getText();

		System.out.println("SECProductMaster :"+SECProductMaster);


		driver.findElement(By.xpath("(//span[@class=\"menu-title span-top headerfont\"])[6]")).click();

		driver.findElement(By.xpath("(//span[@class=\"menu-title rmenu-width title_color_submenu\"])")).click();

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-report-master/div/div/div/div/form/div/div[1]/div/div[1]/div/div[2]/input")).sendKeys("11/15/2023");

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-report-master/div/div/div/div/form/div/div[1]/div/div[2]/div/div[2]/input")).sendKeys("11/30/2023");

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-report-master/div/div/div/div/form/div/div[2]/button[1]")).click();


		String SECReportMaster= driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-report-master/div/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[1]/a")).getText();

		System.out.println("SECReportMaster :"+SECReportMaster);


		logger=report1.createTest("Check -> SECReportMaster and SECProductMaster code ");
		logger.info("Starting SECReportMaster and SECProductMaster code");
		logger.pass("SECReportMaster and SECProductMaster code Success");

		if (SECProductMaster==SECReportMaster) {

			System.out.println("The SECReportMaster and SECProductMaster  is matching ");
			logger.log(Status.PASS,"The SECReportMaster and SECProductMaster code is matching");
		}
		else {

			System.out.println("Error! in matching The SECReportMaster and SECProductMaster ");
			highLighterMethod(driver,Element);
			String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    the SECReportMaster and SECProductMaster code is not matching ");

		}

	}

	public void SECReortexport(ExtentReports report2) throws SQLException, FileNotFoundException, IOException, InterruptedException	{	

		WebElement exportButton = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-masters/app-sec-report-master/div/div/div/div/form/div/div[2]/button[3]"));
		exportButton.click();


		logger=report2.createTest("Check Export Function->SECReort Data Export ");
		logger.info("SECReort Data Export function Test");
		logger.pass("Visibility Test Success");

		// Verify that the file has been downloaded (replace "your-file-name" with the actual file name)
		String downloadedFileName = "SECReort Data Report.xlsx";
		boolean isFileDownloaded = isFileDownloaded(downloadedFileName);


		if (isFileDownloaded) {
			System.out.println("File downloaded successfully.");
			logger.log(Status.PASS,"SECReort Data Export function file is downloaded successfully");
			// You can add further processing here if needed
		} else {
			System.out.println("File download failed.");
			logger.log(Status.FAIL,"Error! SECReort Data Export function file is not downloaded successfully");
		}


		driver.get(dir);

	}

	private boolean isFileDownloaded(String fileName) {

		String downloadPath = System.getProperty("user.dir") + "/exportdownload/" ;
		File downloadDir = new File(downloadPath);
		File[] downloadedFiles = downloadDir.listFiles();

		if (downloadedFiles != null) 
		{
			for (File file : downloadedFiles) 
			{
				if (file.getName().equals(fileName)) 
				{
					return true;


				}
			}
		}

		return false;
	}
//	public void teardown() {
//		report.flush();
//	}




}
