package KloudqTechnologies.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import KloudqTechnologies.AbstractComponents.AbstractComponent;
import java.util.List;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;
import java.text.SimpleDateFormat;


import java.util.Calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;


import org.openqa.selenium.io.FileHandler;

public class SLD extends AbstractComponent
{
	public SLD(WebDriver driver) 
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
	private ExtentTest logger;
	private ExtentReports report;


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

	public void SLDParentNodesCount(ExtentReports report1) throws SQLException, FileNotFoundException, IOException, InterruptedException	{

		driver.findElement(By.xpath("(//div[@class=\"logo-image\"])[2]")).click();

		Thread.sleep(1000);

		WebElement parentnode = driver.findElement(By.xpath("//div[@class=\"node-button-div\"]"));


		String node1= driver.findElement(By.xpath("//div[@class=\"node-button-div\"]")).getText();

		System.out.println("parent Node count :"+node1);




		//logger for blank and zero text
		logger=report1.createTest("Check -> Check Zero blank in SLD Parent Nodes Count  ");
		logger.info("Starting Check Zero blank in SLD Parent Nodes Count ");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (node1 == null || node1.trim().equals("")) {
			System.out.println("SLD Nodes Count value is null, empty or blank");
			logger.log(Status.FAIL,"SLD Parent Nodes Count value is null, empty or blank");
		}
		else
		{
			System.out.println("SLD Nodes Count value is neither null, empty nor blank");
			logger.log(Status.PASS,"SLD Parent Nodes Count value is neither null, empty nor blank");

		}
		if (node1 == null || node1.trim().equals("")) {
			System.out.println("SLD Parent  Nodes Countvalue is null, empty or blank");
			logger.log(Status.FAIL,"SLD Parent Nodes Count value is null, empty or blank");
		}
		else
		{
			System.out.println("SLD Parent Nodes Count value is neither null, empty nor blank");
			logger.log(Status.PASS,"SLD Parent Nodes Count value is neither null, empty nor blank");

		}




		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("SLDparentnode");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside SLD parent node  1.Verifying SLD parent node count");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);

				while(rs.next())
				{
					int col1 = rs.getInt(1);

					System.out.println("SLD nodes count: "+col1);

					logger=report1.createTest("Check -> SLD Parent Nodes Count ");
					logger.info("Starting SLD Parent Nodes Count");
					logger.pass("SLD Parent Nodes Count Success");




					int convert =Integer.parseInt(node1.replace(",", "").replace(".", ""));


					if (convert==col1) {	    
						System.out.println("The SLD Parent Nodes Count is matching ");

						logger.log(Status.PASS,"The SLD Parent Nodes Count is matching");
						//	extentTest.log(LogStatus.PASS, "The Actual Energy Consumption are matching for Today");

					} else {
						System.out.println("Error! in matching SLD Parent Nodes Count");
						//	extentTest.log(LogStatus.FAIL, "Error! in matching the Actual Energy Consumption for Today ");
						highLighterMethod(driver,parentnode);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    the SLD parent node count is not matching ");


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

	public void SLDChildNodesCount(ExtentReports report2) throws SQLException, FileNotFoundException, IOException, InterruptedException	{

		driver.findElement(By.xpath("(//div[@class=\"logo-image\"])[2]")).click();

		Thread.sleep(1000);

		WebElement childnode = driver.findElement(By.xpath("(//div[@class=\"node-button-div\"])[2]"));


		String node1= driver.findElement(By.xpath("(//div[@class=\"node-button-div\"])[2]")).getText();

		System.out.println(" Child Node count :"+node1);




		//logger for blank and zero text
		logger=report2.createTest("Check -> Check Zero blank in SLD Child Nodes Count  ");
		logger.info("Starting Check Zero blank in SLD  Child Nodes Count ");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (node1 == null || node1.trim().equals("")) {
			System.out.println("SLD Child Nodes Count value is null, empty or blank");
			logger.log(Status.FAIL,"SLD Child Nodes Count value is null, empty or blank");
		}
		else
		{
			System.out.println("SLD Child Nodes Count value is neither null, empty nor blank");
			logger.log(Status.PASS,"SLD Child Nodes Count value is neither null, empty nor blank");

		}
		if (node1 == null || node1.trim().equals("")) {
			System.out.println("SLD Child Nodes Countvalue is null, empty or blank");
			logger.log(Status.FAIL,"SLD Child Nodes Count value is null, empty or blank");
		}
		else
		{
			System.out.println("SLD Child Nodes Count value is neither null, empty nor blank");
			logger.log(Status.PASS,"SLD Child Nodes Count value is neither null, empty nor blank");

		}




		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("SLDChildnode");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside SLD Child node  1.Verifying SLD Child node count");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);

				while(rs.next())
				{
					int col1 = rs.getInt(1);

					System.out.println("SLD Child nodes count: "+col1);

					logger=report2.createTest("Check -> SLD Child Nodes Count ");
					logger.info("Starting SLD Child Nodes Count");
					logger.pass("SLD Child Nodes Count Success");




					int convert =Integer.parseInt(node1.replace(",", "").replace(".", ""));


					if (convert==col1) {	    
						System.out.println("The SLD Child Nodes Count is matching ");

						logger.log(Status.PASS,"The SLD Child Nodes Count is matching");
						//	extentTest.log(LogStatus.PASS, "The Actual Energy Consumption are matching for Today");

					} else {
						System.out.println("Error! in matching SLD Child Nodes Count");
						//	extentTest.log(LogStatus.FAIL, "Error! in matching the Actual Energy Consumption for Today ");
						highLighterMethod(driver,childnode);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    the SLD parent node count is not matching ");


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
	
	
	
	public void SLDOnineStatus(ExtentReports report3) throws SQLException, FileNotFoundException, IOException, InterruptedException	{

		driver.findElement(By.xpath("(//div[@class=\"logo-image\"])[2]")).click();

		Thread.sleep(1000);

		WebElement c = driver.findElement(By.cssSelector("#chartContainer > svg > g.chart > g > g.nodes-wrapper > g:nth-child(2) > foreignObject > div > div.tool > div > span.online"));

		String Statuscolor=c.getCssValue("background-color");

		System.out.println(Statuscolor);

		logger=report3.createTest("Check -> Online background-color ");
		logger.info("Starting online  background-color");
		logger.pass("online background-color Success");



		if (Statuscolor=="#31d18b"){ 
			Statuscolor = "<background-color=\"#31d18b\">success</font>";
			System.out.println("background-color is matching ");
			logger.log(Status.PASS,"Online backgroun-colour is matching");


		} else {
			Statuscolor = "<background-color=\"#e64343\">Error</font>";
			System.out.println("Online background-color is not matching ");

			String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"  Error!  Online background-color is not matching ");



		}
	}
	
	
	public void SLDOfflineStatus(ExtentReports report4) throws SQLException, FileNotFoundException, IOException, InterruptedException	{

		driver.findElement(By.xpath("(//div[@class=\"logo-image\"])[2]")).click();

		Thread.sleep(1000);

		WebElement c = driver.findElement(By.cssSelector("#chartContainer > svg > g.chart > g > g.nodes-wrapper > g:nth-child(106) > foreignObject > div > div.tool > div > span.offline"));

		String Statuscolor=c.getCssValue("background-color");

		System.out.println(Statuscolor);

		logger=report4.createTest("Check -> offline background-color ");
		logger.info("Starting offline background-color");
		logger.pass("offline background-color Success");


		if (Statuscolor=="#ed1b2f")
		{ 
			Statuscolor = "<background-color=\"#ed1b2f\">success</font>";
			System.out.println("offline background-color is matching ");
			logger.log(Status.PASS,"offline background-color is matching");


		} else {
			Statuscolor = "<background-color=\"#e64343\">Error</font>";
			System.out.println(" Offline background-color is not matching ");

			String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

			logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"  Error!  Offline background-color is not matching ");



		}
	}
	
	
	public void MachineSpecificationfrequency(ExtentReports report5) throws SQLException, FileNotFoundException, IOException, InterruptedException	{



		WebElement childnode=driver.findElement(By.cssSelector("#chartContainer > svg > g.chart > g > g.nodes-wrapper > g:nth-child(14) > foreignObject > div > div.tool"));
		childnode.click();


		WebElement Frequency1= driver.findElement(By.xpath("(//*[name()='svg' and @class=\"highcharts-root\"]//*[name()='g'])[5]"));

		String freq =Frequency1.getText().replace("Hz", "");
		String freq2=freq.substring(0, 2);

		System.out.println(" Machine Specification frequency on browser:"+ freq2);


		//logger for blank and zero text
		logger=report5.createTest("Check -> Check Machine Specification frequency  ");
		logger.info("Starting Machine Specification frequency ");
		logger.pass("Machine Specification frequency Success");

		//Condition zero and blank
		if ( freq2== null || freq2.trim().equals("")) {
			System.out.println("Machine Specification frequency value is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification frequency value is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification frequency value is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification frequency value is neither null, empty nor blank");

		}
		if (freq2 == null || freq2.trim().equals("")) {
			System.out.println("Machine Specification frequency value is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification frequency value is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification frequency value is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification frequency value is neither null, empty nor blank");

		}




		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("MachineSpecificationfrequency");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Machine Specification frequency  1.Verifying Machine Specification frequency ");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);

				while(rs.next())
				{
					double col1 = rs.getInt(1);

					System.out.println("Machine Specification frequency: "+col1);

					logger=report5.createTest("Check -> Machine Specification frequency ");
					logger.info("Starting Machine Specification frequency");
					logger.pass("Machine Specification frequency Success");


					double convert=Double.parseDouble(freq2);

					

					if (convert==col1) {	    
						System.out.println("The Machine Specification frequency is matching ");

						logger.log(Status.PASS,"The Machine Specification frequency is matching");
						//	extentTest.log(LogStatus.PASS, "The Actual Energy Consumption are matching for Today");

					} else {
						System.out.println("Error! in matching Machine Specification frequency");
						//	extentTest.log(LogStatus.FAIL, "Error! in matching the Actual Energy Consumption for Today ");
						highLighterMethod(driver,Frequency1);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    the Machine Specification frequency is not matching ");


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
	
	public void MachineSpecificationPowerFactor(ExtentReports report6) throws SQLException, FileNotFoundException, IOException, InterruptedException	{


		WebElement PowerFactor1 =driver.findElement(By.xpath("((//*[name()='svg' and @class=\"highcharts-root\"])[2]//*[name()='g'])[5]"));

		String PowerFactor =PowerFactor1.getText();
		
		
		
		System.out.println("09 PH Machine shop. Power Factor :"+PowerFactor );
		
		


		//logger for blank and zero text
		logger=report6.createTest("Check -> Check Machine Specification Power Factor ");
		logger.info("Starting Check Machine Specification Power Factor ");
		logger.pass("Machine Specification Power Factor Success");

		//Condition zero and blank
		if (PowerFactor == null || PowerFactor.trim().equals("")) {
			System.out.println("Machine Specification Power Factor is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification Power Factor is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification Power Factor is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification Power Factor is neither null, empty nor blank");

		}
		if (PowerFactor == null || PowerFactor.trim().equals("")) {
			System.out.println("Machine Specification Power Factor is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification Power Factor is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification Power Factor is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification Power Factor is neither null, empty nor blank");

		}




		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("MachineSpecificationPowerFactor");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Machine Specification Power Factor  1.Verifying Machine Specification Power Factor");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);

				while(rs.next())
				{
					int col1 = rs.getInt(1);

					System.out.println("Machine Specification Power Factor: "+col1);

					logger=report6.createTest("Check -> Machine Specification Power Factor ");
					logger.info("Starting Machine Specification Power Factor");
					logger.pass("Machine Specification Power Factor Success");




					int convert =Integer.parseInt(PowerFactor.replace(",", "").replace(".", ""));


					if (convert==col1) {	    
						System.out.println("Machine Specification Power Factor is matching ");

						logger.log(Status.PASS,"Machine Specification Power Factor is matching");
						//	extentTest.log(LogStatus.PASS, "The Actual Energy Consumption are matching for Today");

					} else {
						System.out.println("Error! in matching Machine Specification Power Factor");
						//	extentTest.log(LogStatus.FAIL, "Error! in matching the Actual Energy Consumption for Today ");
						highLighterMethod(driver,PowerFactor1);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    the Machine Specification Power Factor is not matching ");


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

	public void MachineSpecificationPower(ExtentReports report7) throws SQLException, FileNotFoundException, IOException, InterruptedException	{



		WebElement power1 =driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy/app-device-details-lenz/div/div/div[3]/div[1]/div/div[2]/div/div[1]/span"));


		String power =driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy/app-device-details-lenz/div/div/div[3]/div[1]/div/div[2]/div/div[1]/span")).getText();

		System.out.println("03 PH MSEDCL 4000Amp.Power :"+power);



		//logger for blank and zero text
		logger=report7.createTest("Check -> Check Zero blank in Machine Specification Power ");
		logger.info("Starting Check Zero blank in Machine Specification Power ");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (power == null || power.trim().equals("")) {
			System.out.println("Machine Specification Power is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification Power is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification Power is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification Power is neither null, empty nor blank");

		}
		if (power == null || power.trim().equals("")) {
			System.out.println("Machine Specification Power is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification Power is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification Power is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification Power is neither null, empty nor blank");

		}




		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("MachineSpecificationPower");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Machine Specification Power  1.Verifying Machine Specification Power");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);

				while(rs.next())
				{
					int col1 = rs.getInt(1);

					System.out.println("Machine Specification Power: "+col1);

					logger=report7.createTest("Check -> Machine Specification Power ");
					logger.info("Starting Machine Specification Power");
					logger.pass("Machine Specification Power Success");




					int convert =Integer.parseInt(power.replace(",", "").replace(".", ""));


					if (convert==col1) {	    
						System.out.println("Machine Specification Power is matching ");

						logger.log(Status.PASS,"Machine Specification Power is matching");
						//	extentTest.log(LogStatus.PASS, "The Actual Energy Consumption are matching for Today");

					} else {
						System.out.println("Error! in matching Machine Specification Power");
						//	extentTest.log(LogStatus.FAIL, "Error! in matching the Actual Energy Consumption for Today ");
						highLighterMethod(driver,power1);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    the Machine Specification Power is not matching ");


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

	public void MachineSpecificationStatus(ExtentReports report8) throws SQLException, FileNotFoundException, IOException, InterruptedException	{


		WebElement Status1 =driver.findElement(By.xpath("//a[@class=\"fw-bolder px-4 me-1\"]"));

		String StatusOnOff =Status1.getText();

		System.out.println("09 PH Machine shop.Status :"+StatusOnOff);


		//logger for blank and zero text
		logger=report8.createTest("Check -> Check Zero blank in Machine Specification Status  ");
		logger.info("Starting Check Zero blank in Machine Specification Status ");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (StatusOnOff == null || StatusOnOff.trim().equals("")) {
			System.out.println("Machine Specification Status is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification Status is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification Status is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification Status is neither null, empty nor blank");

		}
		if (StatusOnOff == null || StatusOnOff.trim().equals("")) {
			System.out.println("Machine Specification Status is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification Status is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification Status is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification Status is neither null, empty nor blank");

		}




		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("MachineSpecificationStatus");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Machine Specification Status  1.Verifying Machine Specification Status");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);

				while(rs.next())
				{
					String col1 = rs.getString(1);

					System.out.println("Machine Specification Status: "+col1);

					logger=report8.createTest("Check -> Machine Specification Status ");
					logger.info("Starting Machine Specification Status");
					logger.pass("Machine Specification Status Success");




					//int convert =Integer.parseInt(StatusOnOff.replace(",", "").replace(".", ""));


					if (StatusOnOff.equals(col1)) {	    
						System.out.println("Machine Specification Status is matching ");

						logger.log(Status.PASS,"Machine Specification Status is matching");
						//	extentTest.log(LogStatus.PASS, "The Actual Energy Consumption are matching for Today");

					} else {
						System.out.println("Error! in matching Machine Specification Status");
						//	extentTest.log(LogStatus.FAIL, "Error! in matching the Actual Energy Consumption for Today ");
						highLighterMethod(driver,Status1);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  Machine Specification Status  is not matching ");


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
	
	public void MachineSpecificationVoltage(ExtentReports report9) throws SQLException, FileNotFoundException, IOException, InterruptedException	{


		WebElement RVoltage1 =driver.findElement(By.xpath("//a[@class=\"text-dark fw-bold text-hover-primary mb-1 valuelenz\"]"));

		String RVoltage =RVoltage1.getText();

		System.out.println("03 PH MSEDCL 4000Amp.Voltage :"+RVoltage);


		//logger for blank and zero text
		logger=report9.createTest("Check -> Check Zero blank in Machine Specification Voltage  ");
		logger.info("Starting Check Zero blank in Machine Specification Voltage ");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (RVoltage == null || RVoltage.trim().equals("")) {
			System.out.println("Machine Specification Voltage is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification Voltage is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification Voltage is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification Voltage is neither null, empty nor blank");

		}
		if (RVoltage == null || RVoltage.trim().equals("")) {
			System.out.println("Machine Specification Voltage is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification Voltage is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification Voltage is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification Voltage is neither null, empty nor blank");

		}




		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("MachineSpecificationVoltage");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Machine Specification Voltage  1.Verifying Machine Specification Voltage");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);

				while(rs.next())
				{
					int col1 = rs.getInt(1);

					System.out.println("Machine Specification Voltage: "+col1);

					logger=report9.createTest("Check -> Machine Specification Voltage ");
					logger.info("Starting Machine Specification Voltage");
					logger.pass("Machine Specification Voltage Success");




					int convert =Integer.parseInt(RVoltage.replace(",", "").replace(".", ""));


					if (convert==col1) {	    
						System.out.println("Machine Specification Voltage is matching ");

						logger.log(Status.PASS,"Machine Specification Voltage is matching");
						//	extentTest.log(LogStatus.PASS, "The Actual Energy Consumption are matching for Today");

					} else {
						System.out.println("Error! in matching Machine Specification Voltage");
						//	extentTest.log(LogStatus.FAIL, "Error! in matching the Actual Energy Consumption for Today ");
						highLighterMethod(driver,RVoltage1);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Machine Specification Voltage is not matching ");


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
	
	public void MachineSpecificationCurrent(ExtentReports report10) throws SQLException, FileNotFoundException, IOException, InterruptedException	{


		WebElement RCurrent1 =driver.findElement(By.xpath("(//a[@class=\"text-dark fw-bold text-hover-primary mb-1 valuelenz\"])[4]"));

		String RCurrent =RCurrent1.getText();

		System.out.println("03 PH MSEDCL 4000Amp.Current :"+RCurrent);


		//logger for blank and zero text
		logger=report10.createTest("Check -> Check Zero blank in Machine Specification Current  ");
		logger.info("Starting Check Zero blank in Machine Specification Current ");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (RCurrent == null || RCurrent.trim().equals("")) {
			System.out.println("Machine Specification Current is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification Current is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification Current is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine SpecificationCurrent is neither null, empty nor blank");

		}
		if (RCurrent == null || RCurrent.trim().equals("")) {
			System.out.println("Machine Specification Current is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification Current is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification Current is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification Current is neither null, empty nor blank");

		}




		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("MachineSpecificationCurrent");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Machine Specification Current  1.Verifying Machine Specification Current");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);

				while(rs.next())
				{
					int col1 = rs.getInt(1);

					System.out.println("Machine Specification Current : "+col1);

					logger=report10.createTest("Check -> Machine Specification Current ");
					logger.info("Starting Machine Specification Current");
					logger.pass("Machine Specification Current Success");




					int convert =Integer.parseInt(RCurrent.replace(",", "").replace(".", ""));


					if (convert==col1) {	    
						System.out.println("Machine Specification Current is matching ");

						logger.log(Status.PASS,"Machine Specification Current is matching");
						//	extentTest.log(LogStatus.PASS, "The Actual Energy Consumption are matching for Today");

					} else {
						System.out.println("Error! in matching Machine Specification Current");
						//	extentTest.log(LogStatus.FAIL, "Error! in matching the Actual Energy Consumption for Today ");
						highLighterMethod(driver,RCurrent1);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    the Machine Specification Current is not matching ");


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
	
	public void MachineSpecificationVTHD(ExtentReports report11) throws SQLException, FileNotFoundException, IOException, InterruptedException	{


		WebElement RVTHD1 =driver.findElement(By.xpath("(//a[@class=\"text-dark fw-bold text-hover-primary mb-1 valuelenz\"])[7]"));

		String RVTHD =RVTHD1.getText();

		System.out.println("09  PH Machine shop :"+RVTHD);


		//logger for blank and zero text
		logger=report11.createTest("Check -> Check Zero blank in Machine Specification VTHD  ");
		logger.info("Starting Check Zero blank in Machine SpecificationVTHD ");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (RVTHD == null || RVTHD.trim().equals("")) {
			System.out.println("Machine Specification VTHD is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification VTHD is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification VTHD is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification VTHD is neither null, empty nor blank");

		}
		if (RVTHD == null || RVTHD.trim().equals("")) {
			System.out.println("Machine Specification VTHD is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification VTHD is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification VTHD is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification VTHD is neither null, empty nor blank");

		}




		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("MachineSpecificationVTHD");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Machine Specification VTHD 1.Verifying Machine Specification VTHD");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);

				while(rs.next())
				{
					int col1 = rs.getInt(1);

					System.out.println("Machine Specification VTHD: "+col1);

					logger=report11.createTest("Check -> Machine Specification VTHD ");
					logger.info("Starting Machine Specification VTHD");
					logger.pass("Machine Specification VTHD Success");




					int convert =Integer.parseInt(RVTHD.replace(",", "").replace(".", ""));


					if (convert==col1) {	    
						System.out.println("Machine Specification VTHD is matching ");

						logger.log(Status.PASS,"Machine Specification VTHD is matching");
						//	extentTest.log(LogStatus.PASS, "The Actual Energy Consumption are matching for Today");

					} else {
						System.out.println("Error! in matching Machine Specification VTHD");
						//	extentTest.log(LogStatus.FAIL, "Error! in matching the Actual Energy Consumption for Today ");
						highLighterMethod(driver,RVTHD1);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Machine Specification VTHD  is not matching ");


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
	
	public void MachineSpecificationCTHD(ExtentReports report12) throws SQLException, FileNotFoundException, IOException, InterruptedException	{


		WebElement RCTHD1 =driver.findElement(By.xpath("(//a[@class=\"text-dark fw-bold text-hover-primary mb-1 valuelenz\"])[10]"));

		String RCTHD =driver.findElement(By.xpath("(//a[@class=\"text-dark fw-bold text-hover-primary mb-1 valuelenz\"])[10]")).getText();

		System.out.println("03 PH MSEDCL 4000Amp.Status :"+RCTHD);


		//logger for blank and zero text
		logger=report12.createTest("Check -> Check Zero blank in Machine Specification CTHD  ");
		logger.info("Starting Check Zero blank in Machine Specification CTHD ");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (RCTHD == null || RCTHD.trim().equals("")) {
			System.out.println("Machine Specification CTHD is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification CTHD is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification CTHD is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification CTHD is neither null, empty nor blank");

		}
		if (RCTHD == null || RCTHD.trim().equals("")) {
			System.out.println("Machine Specification CTHD is null, empty or blank");
			logger.log(Status.FAIL,"Machine Specification CTHD is null, empty or blank");
		}
		else
		{
			System.out.println("Machine Specification CTHD is neither null, empty nor blank");
			logger.log(Status.PASS,"Machine Specification CTHD is neither null, empty nor blank");

		}




		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("MachineSpecificationCTHD");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Machine Specification CTHD  1.Verifying Machine Specification CTHD");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);

				while(rs.next())
				{
					int col1 = rs.getInt(1);

					System.out.println("Machine Specification CTHD: "+col1);

					logger=report12.createTest("Check -> Machine Specification CTHD ");
					logger.info("Starting Machine Specification CTHD");
					logger.pass("Machine Specification CTHD Success");




					int convert =Integer.parseInt(RCTHD.replace(",", "").replace(".", ""));


					if (convert==col1) {	    
						System.out.println("Machine Specification CTHD is matching ");

						logger.log(Status.PASS,"Machine Specification CTHD is matching");
						//	extentTest.log(LogStatus.PASS, "The Actual Energy Consumption are matching for Today");

					} else {
						System.out.println("Error! in matching Machine Specification CTHD");
						//	extentTest.log(LogStatus.FAIL, "Error! in matching the Actual Energy Consumption for Today ");
						highLighterMethod(driver,RCTHD1);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Machine Specification CTHD is not matching ");


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




		driver.get(dir);
	} 


	public void teardown() {
		report.flush();
	}
	


}