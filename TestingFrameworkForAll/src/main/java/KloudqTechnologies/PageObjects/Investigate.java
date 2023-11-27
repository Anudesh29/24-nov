package KloudqTechnologies.PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Date;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import KloudqTechnologies.AbstractComponents.AbstractComponent;

public class Investigate extends AbstractComponent {

	public Investigate(WebDriver driver) 
	{
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}
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


	public void highLighterMethod(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
	public void ClickInvestigateTab() 
	{
		WebElement clickInvestigateTab=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[3]"));
		clickInvestigateTab.click();
		URLInvestigateCheck();

	}

	public void URLInvestigateCheck() 
	{		
		String url = "https://shield.tor-iot.com/reports/investigate";
		driver.get(url);		      
		// get the current URL
		String strUrl = driver.getCurrentUrl();
		//Print the URL
		System.out.println("Current URL : "+strUrl);


	}
	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	private ExtentTest logger;
	private ExtentReports report;
	public void DeviceIDVerification(ExtentReports report1) throws InterruptedException {

		System.out.println("Starting Search function");
		WebElement selectequip = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select"));
		selectequip.click();

		WebElement inputclick = driver.findElement(By.cssSelector("#\\#kt_header_menu > div > form > div > div:nth-child(1) > ng-select > div > div > div.ng-input > input[type=text]"));
		inputclick.click();


		inputclick.sendKeys("23-1");
		Thread.sleep(1000);

		WebElement select231 = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		select231.click();

		System.out.println("Selected Device ");

		System.out.println("Verifying Visibility of Device ID");
		logger=report1.createTest("Check -> Investigate Device information ");
		logger.info("Device Information Visibility Test");
		logger.pass("Visibility Test Success");

		WebElement deviceid = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-reports/app-investigate/div/div/div[2]/app-lenz-details-short/div"));

		boolean isDisplayed = deviceid.isDisplayed();
		if (isDisplayed) 
		{
			System.out.println("The Device ID information is visible.");
			logger.log(Status.PASS,"Device ID information is Visible");
		} else {
			System.out.println("The Device ID information is not visible.");
			logger.log(Status.FAIL,"Device ID information is not Visible");
		}

		Thread.sleep(3000);

		WebElement wpower=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-reports/app-investigate/div/div/div[2]/app-lenz-details-short/div/div[2]/div/div/div/div[1]/span[2]"));
		String wpowerval = wpower.getText().replace("kW", "");
		System.out.println("Value of webbrowser Power " +wpowerval.replace("kW", ""));


		WebElement wvoltage=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-reports/app-investigate/div/div/div[2]/app-lenz-details-short/div/div[2]/div/div/div/div[2]/span[2]"));
		String wvoltageval = wvoltage.getText();
		System.out.println("Value of webbrowser Voltage " +wvoltageval.replace("V", ""));

		WebElement wcurrent=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-reports/app-investigate/div/div/div[2]/app-lenz-details-short/div/div[2]/div/div/div/div[3]/span[2]"));
		String wcurrentval = wcurrent.getText();
		System.out.println("Value of webbrowser Current " +wcurrentval.replace("A", ""));


		WebElement wpowerfactor=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[2]/app-lenz-details-short/div/div[2]/div/div/div/div[4]/span[2]"));
		String wpowerfactorval = wpowerfactor.getText().replace("A", "");
		System.out.println("Value of webbrowser Power Factor " +wpowerfactorval.replace("A", ""));


		WebElement wmachinestatus=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-reports/app-investigate/div/div/div[2]/app-lenz-details-short/div/div[2]/div/div/div/div[5]/span[2]"));
		String wmachinestatusval = wmachinestatus.getText();
		System.out.println("Value of webbrowser Machine Status " +wmachinestatusval);

		//logger for blank and zero text
		logger=report1.createTest("Check -> Check Zero blank in Device Information ");
		logger.info("Starting Check Zero blank in Actual Consumption Today");
		logger.pass("Zero and Blank Check Test Success");


		Thread.sleep(2000);
		//Condition zero and blank
		if (wpowerval == null || wpowerval.trim().equals("")) {
			System.out.println("Web Browser Power value is null, empty or blank");
			logger.log(Status.FAIL,"Web Browser Power value is null, empty or blank");
		}
		else
		{
			System.out.println("Web Browser Power value is neither null, empty nor blank");
			logger.log(Status.PASS,"Web Browser Power value is neither null, empty nor blank");

		}

		if (wvoltageval == null || wvoltageval.trim().equals("")) {
			System.out.println("Web Browser Voltage value is null, empty or blank");
			logger.log(Status.FAIL,"Web Browser Voltage value is null, empty or blank");
		}
		else
		{
			System.out.println("Web Browser Voltage value value is neither null, empty nor blank");
			logger.log(Status.PASS,"Web Browser Voltage value is neither null, empty nor blank");

		}
		if (wcurrentval == null || wcurrentval.trim().equals("")) {
			System.out.println("Web Browser Current value is null, empty or blank");
			logger.log(Status.FAIL,"Web Browser Current value is null, empty or blank");
		}
		else
		{
			System.out.println("Web Browser Current value is neither null, empty nor blank");
			logger.log(Status.PASS,"Web Browser Current value is neither null, empty nor blank");

		}
		if (wpowerfactorval == null || wpowerfactorval.trim().equals("")) {
			System.out.println("Web Browser Power Factor value is null, empty or blank");
			logger.log(Status.FAIL,"Web Browser Power Factor value is null, empty or blank");
		}
		else
		{
			System.out.println("Web Browser Power Factor value is neither null, empty nor blank");
			logger.log(Status.PASS,"Web Browser Power Factor value is neither null, empty nor blank");

		}
		if (wmachinestatusval == null || wmachinestatusval.trim().equals("")) {
			System.out.println("Web Browser Machine Status is null, empty or blank");
			logger.log(Status.FAIL,"Web Browser Machine Status is null, empty or blank");
		}
		else
		{
			System.out.println("Web Browser Machine Status is neither null, empty nor blank");
			logger.log(Status.PASS,"Web Browser Machine Status is neither null, empty nor blank");

		}


		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("DeviceID");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Investigate  1.Verifying Device ID Information");

			ResultSet rs = stmt.executeQuery(Q1);

			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1

			for (int i = 1; i < numberOfColumns + 1; i++) 
			{
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);


				while(rs.next())
				{
					String col1 = rs.getString(1);

					String col8 = rs.getString(8);
					String col9 = rs.getString(9);
					String col10 = rs.getString(10);
					String col11 = rs.getString(11);
					String col12 = rs.getString(12);
					String col13 = rs.getString(13);
					String col14 = rs.getString(14);
					String col15 = rs.getString(15);
					String col16 = rs.getString(16);
					String col17 = rs.getString(17);
					String col18 = rs.getString(18);


					System.out.println("Machine Description: "+col1);

					System.out.println("Last Reported Time: "+col8);

					System.out.println("Machine Status: "+col18);

					//Here we are adding three values of voltage and current converted them into float

					float voltage1=Float.parseFloat(col10);
					float voltage2=Float.parseFloat(col11);
					float voltage3=Float.parseFloat(col12);
					float convertv=(voltage1+voltage2+voltage3);

					float convert =convertv;
					float avgvoltage=(convertv/3);

					//float stavgvoltage = avgvoltage;



					float current1=Float.parseFloat(col13);
					float current2=Float.parseFloat(col14);
					float current3=Float.parseFloat(col15);
					float currentc=(current1+current2+current3);
					float current=currentc;

					float avgcurrent=(currentc/3);
					//float stcurrent = (avgcurrent);


					String stv=String.valueOf(avgvoltage).replace(".","").substring(0,5);  
					String stc=String.valueOf(avgcurrent).replace(".","").substring(0,5);

					System.out.println("Voltage: "+stv);



					System.out.println("Current: "+stc);
					logger=report1.createTest("Check -> Device Information ");
					logger.info("Starting Check for Device Information");
					logger.pass("Actual and Predictive Consumption Today Success");






					if (wvoltageval.replace(".","").equals(stv))
					{	    
						System.out.println("The Voltage value is matching ");
						logger.log(Status.PASS,"The Voltage value for Investigate in Device Information is matching");

					} 
					else 
					{
						System.out.println("Error! in matching the Voltage Value");
						highLighterMethod(driver,wvoltage);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    The Voltage value for Investigate in Device Information is not matching ");
					}

					if (wcurrentval.replace(".","").equals(stc)) {	    
						System.out.println("The Current value is matching ");
						logger.log(Status.PASS,"The Current value for Investigate in Device Information is matching");
					} else 
					{
						System.out.println("Error! in matching the Current value ");
						highLighterMethod(driver,wcurrent);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    The Current value for Investigate in Device Information is not matching ");
					}

					System.out.println("Total Active Power kW : "+col16);
					if (wpowerval.trim().equals(col16.trim())) {	    
						System.out.println("The Power value is matching ");
						logger.log(Status.PASS,"The Total Active Power value for Investigate in Device Information is matching");
					} 
					else
					{
						System.out.println("Error! in matching the Power value ");
						highLighterMethod(driver,wpower);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    The Total Active Power for Investigate in Device Information is not matching ");
					}

					System.out.println("Power Factor: "+col17);

					if (wpowerfactorval.trim().equals(col17.trim())) {	    
						System.out.println("The Power Factor value is matching ");
						logger.log(Status.PASS,"The Power Factor value for Investigate in Device Information is matching");
					} else {
						System.out.println("Error! in matching the Power value ");
						highLighterMethod(driver,wpowerfactor);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    The Power Factor value for Investigate in Device Information is not matching ");
					}
					if (wmachinestatusval.equals(col18)) 
					{	    
						System.out.println("The Machine Status is matching ");
						logger.log(Status.PASS,"The Machine Status value for Investigate in Device Information is matching");
					} 
					else 
					{
						System.out.println("Error! in matching the Machine Status ");
						highLighterMethod(driver,wmachinestatus);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    The Power Factor value for Investigate in Device Information is not matching ");
					}

				}

			}


			rs.close();
			stmt.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Date(ExtentReports report2) throws InterruptedException {

		System.out.println("Starting Search function");
		WebElement selectequip = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select"));
		selectequip.click();

		WebElement inputclick = driver.findElement(By.cssSelector("#\\#kt_header_menu > div > form > div > div:nth-child(1) > ng-select > div > div > div.ng-input > input[type=text]"));
		inputclick.click();
		inputclick.sendKeys("23-1");

		WebElement selectdevice = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		selectdevice.click();
		Thread.sleep(1000);

		System.out.println("Selected Device ");


		WebElement selectdate = driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[2]/app-custom-date-time-range/div[2]/div[2]/label[1]/span/i"));
		selectdate.click();

		WebElement select18 = driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[2]/td[3]/span"));
		select18.click();
		Thread.sleep(2000);
		select18.click();
		Thread.sleep(2000);
		WebElement arrowup=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[2]/button[1]"));
		arrowup.click();
		Thread.sleep(2000);
		arrowup.click();

		Thread.sleep(2000);
		WebElement btnset=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/div[2]/button[2]"));
		btnset.click();


		//Selecting Consumption,Frequency ,RPhase Voltage

		WebElement selectparam1=driver.findElement(By.id("Consumption"));
		selectparam1.click();


		WebElement selectparam2=driver.findElement(By.id("Frequency"));
		selectparam2.click();


		WebElement selectparam3=driver.findElement(By.id("R_Phase_Voltage"));
		selectparam3.click();


		WebElement btnFilter=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[4]/button"));
		btnFilter.click();

		System.out.println("Selecting Consumption ,Frequency ,RPhase Voltage");

		logger=report2.createTest("Check -> Investigate Date function Graph information ");
		logger.info("Date function Graph Visibility Test");
		logger.pass("Visibility Test Success");

		WebElement svgGraph = driver.findElement(By.className("highcharts-root"));

		boolean isDisplayed = svgGraph.isDisplayed();
		if (isDisplayed) 
		{
			System.out.println("The SVG graph for Date Investigate Graph is visible.");
			logger.log(Status.PASS,"SVG graph for Date Investigate Graph is Visible");

		} else {
			System.out.println("The SVG graph for Date Investigate Graph is not visible.");
			logger.log(Status.FAIL,"SVG graph for Date Investigate Graph is not Visible");
		}



	}
	public void TodayFunction(ExtentReports report3) throws InterruptedException
	{


		System.out.println("Starting Today function");
		WebElement selectequip = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select"));
		selectequip.click();

		WebElement inputclick = driver.findElement(By.cssSelector("#\\#kt_header_menu > div > form > div > div:nth-child(1) > ng-select > div > div > div.ng-input > input[type=text]"));
		inputclick.click();
		inputclick.sendKeys("23-1");

		WebElement selectdevice = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		selectdevice.click();
		Thread.sleep(1000);

		System.out.println("Selected Device ");
		WebElement selectToday = driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[2]/app-custom-date-time-range/div[2]/div[1]/div[1]/a"));
		selectToday.click();

		//Selecting Consumption,Frequency ,RPhase Voltage

		WebElement selectparam1=driver.findElement(By.id("Consumption"));
		selectparam1.click();


		WebElement selectparam2=driver.findElement(By.id("Frequency"));
		selectparam2.click();


		WebElement selectparam3=driver.findElement(By.id("R_Phase_Voltage"));
		selectparam3.click();


		WebElement btnFilter=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[4]/button"));
		btnFilter.click();

		logger=report3.createTest("Check -> Investigate Today function Graph information ");
		logger.info("Today function Graph Visibility Test");
		logger.pass("Visibility Test Success");

		WebElement svgGraph = driver.findElement(By.className("highcharts-root"));

		boolean isDisplayed = svgGraph.isDisplayed();
		if (isDisplayed) 
		{
			System.out.println("The SVG graph for Today Investigate Graph is visible.");
			logger.log(Status.PASS,"SVG graph for Today Investigate Graph is Visible");

		} 
		else 
		{
			System.out.println("The SVG graph for Today Investigate Graph is not visible.");
			logger.log(Status.FAIL,"SVG graph for Today Investigate Graph is not Visible");
		}

		
		List<WebElement> graphlist=driver.findElements(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[1]//*[name()='rect']"));
		Actions act=new Actions(driver);
		for(WebElement e :graphlist) {
			
			act.moveToElement(e).perform();
			
		}
		visiblediv();

	}
	public void WeekFunction(ExtentReports report4) throws InterruptedException
	{
		System.out.println("Starting Week function");
		WebElement selectequip = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select"));
		selectequip.click();

		WebElement inputclick = driver.findElement(By.cssSelector("#\\#kt_header_menu > div > form > div > div:nth-child(1) > ng-select > div > div > div.ng-input > input[type=text]"));
		inputclick.click();
		inputclick.sendKeys("23-1");

		WebElement selectdevice = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		selectdevice.click();
		Thread.sleep(1000);

		System.out.println("Selected Device ");
		WebElement selectWeek = driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[2]/app-custom-date-time-range/div[2]/div[1]/div[2]"));
		selectWeek.click();

		//Selecting Consumption,Frequency ,RPhase Voltage

		WebElement selectparam1=driver.findElement(By.id("Consumption"));
		selectparam1.click();


		WebElement selectparam2=driver.findElement(By.id("Frequency"));
		selectparam2.click();


		WebElement selectparam3=driver.findElement(By.id("R_Phase_Voltage"));
		selectparam3.click();


		WebElement btnFilter=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[4]/button"));
		btnFilter.click();

		logger=report4.createTest("Check -> Investigate Week function Graph information ");
		logger.info("Week function Graph Visibility Test");
		logger.pass("Visibility Test Success");

		WebElement svgGraph = driver.findElement(By.className("highcharts-root"));

		boolean isDisplayed = svgGraph.isDisplayed();
		if (isDisplayed) 
		{
			System.out.println("The SVG graph for Week Investigate Graph is visible.");
			logger.log(Status.PASS,"SVG graph for Week Investigate Graph is Visible");

		} else {
			System.out.println("The SVG graph for Week Investigate Graph is not visible.");
			logger.log(Status.FAIL,"SVG graph for Week Investigate Graph is not Visible");
		}


	}

	
	public void MonthFunction(ExtentReports report5) throws InterruptedException
	{
		System.out.println("Starting Month function");
		WebElement selectequip = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select"));
		selectequip.click();

		WebElement inputclick = driver.findElement(By.cssSelector("#\\#kt_header_menu > div > form > div > div:nth-child(1) > ng-select > div > div > div.ng-input > input[type=text]"));
		inputclick.click();
		inputclick.sendKeys("23-1");;

		WebElement selectdevice = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		selectdevice.click();
		Thread.sleep(1000);

		System.out.println("Selected Device ");
		WebElement selectMonth = driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[2]/app-custom-date-time-range/div[2]/div[1]/div[3]"));
		selectMonth.click();

		//Selecting Consumption,Frequency ,RPhase Voltage

		WebElement selectparam1=driver.findElement(By.id("Consumption"));
		selectparam1.click();


		WebElement selectparam2=driver.findElement(By.id("Frequency"));
		selectparam2.click();


		WebElement selectparam3=driver.findElement(By.id("R_Phase_Voltage"));
		selectparam3.click();


		WebElement btnFilter=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[4]/button"));
		btnFilter.click();

		logger=report5.createTest("Check -> Investigate Month function Graph information ");
		logger.info("Month function Graph Visibility Test");
		logger.pass("Visibility Test Success");

		WebElement svgGraph = driver.findElement(By.className("highcharts-root"));

		boolean isDisplayed = svgGraph.isDisplayed();
		if (isDisplayed) 
		{
			System.out.println("The SVG graph for Month Investigate Graph is visible.");
			logger.log(Status.PASS,"SVG graph for Month Investigate Graph is Visible");

		} else {
			System.out.println("The SVG graph for Month Investigate Graph is not visible.");
			logger.log(Status.FAIL,"SVG graph for Month Investigate Graph is not Visible");
		}



	}

	public  void CompareDate() throws InterruptedException {

		System.out.println("Starting Month function");
		WebElement selectequip = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select"));
		selectequip.click();

		WebElement inputclick = driver.findElement(By.cssSelector("#\\#kt_header_menu > div > form > div > div:nth-child(1) > ng-select > div > div > div.ng-input > input[type=text]"));
		inputclick.click();
		inputclick.sendKeys("23-1");

		WebElement selectdevice = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		selectdevice.click();
		Thread.sleep(1000);

		System.out.println("Selected Device ");


		WebElement selectdatepicker = driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[2]/app-custom-date-time-range/div[2]/div[2]/label[1]/span/i"));
		selectdatepicker.click();


		
	}

	public void AlertsDisplay(ExtentReports report7) {

		// Get all the child div elements.
		List<WebElement> elements = driver.findElements(By.className("card-body-alerts-lenz"));  

		// Get the count of child div elements.
		int divcount=elements.size(); 
		
		// Print the count of child div elements.
		System.out.println("The count of child div elements is: " + divcount);
		
		
		logger=report7.createTest("Check -> Investigate Alert Section  ");
		logger.info("Alert Count 10 Visibility Test");
		logger.pass("Visibility Test Success");
		
		
		if(divcount==10)
		{
			
			System.out.println("Alerts Count is 10");
			logger.log(Status.PASS,"Alerts Count is 10 in Alert Section");
		}
		
		else 
		{
			System.out.println("Alerts Count is not 10");
			logger.log(Status.FAIL,"Alerts Count is not 10 in Alert Section");
		}
		
		
		WebElement divalert=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-reports/app-investigate/div/div/div[3]/div[2]/div/div[2]/app-alert-data-lookup/div[2]/div/div/div[1]/div/div"));
		String alertmessage1=divalert.getText();
		System.out.println("Alert1 data please check the recent alert is of date "+alertmessage1);
			
		driver.get(dir);
		
	}

	
	
	public void twohours() 
	{
		
		 Date date = new Date();
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);

		    // Subtract two hours from the current date and time.
		    calendar.add(Calendar.HOUR, -2);
		    date = calendar.getTime();

		    WebElement selectdatepicker = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-investigate/div/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[2]/app-custom-date-time-range/div[2]/div[2]/label[1]/span/i"));
		    selectdatepicker.click();
		    System.out.println("Date"+date);

		    // Set the date and time in the date picker.
		    WebElement datePicker = driver.findElement(By.id("owl-dt-picker-0"));
	
		    	
		    	 WebElement arrowdown = driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[1]/button[2]"));
		    	 arrowdown.click();
		    	 arrowdown.click();
		    	
		    	 
		    	 
		    	 WebElement btnSet=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/owl-date-time-container/div[2]/div[2]/button[2]"));
		    	 btnSet.click();
		    	 
		    	 
		
		
	}
	
	
	public void visiblediv() {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		WebElement element=driver.findElement(By.xpath("//*[@id=\\\"highcharts-9sjqs1q-4\\\"]/svg/g[15]"));
		jse.executeScript("arguments[0].setAttribute('style','visibility:visible;');",element.getText());
		System.out.println("The text:"+element.getText());
		
//		driver.get(dir);
//	}
//	
//
//	public void teardown() {
//		report.flush();
//	}
	}
}
