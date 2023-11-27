package KloudqTechnologies.PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.Status;
import KloudqTechnologies.AbstractComponents.AbstractComponent;

public  class DashboardShield extends AbstractComponent{


	private ExtentTest logger;



	public DashboardShield(WebDriver driver) throws FileNotFoundException, IOException, SQLException
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

	public void HeaderCheck(ExtentReports reportheader) {
		logger = reportheader.createTest("Check -> All Elements in Header");
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
	//	public void AllWebElements() {
	//		//to catch all web elements into list
	//	    List<WebElement> myList=driver.findElements(By.id("kt_content_container"));
	//
	//	    //myList contains all the web elements
	//	    //if you want to get all elements text into array list
	//	    List<String> all_elements_text=new ArrayList<>();
	//
	//	   
	//	    myList.forEach(l -> {
	//	        //loading text of each element in to array all_elements_text
	//	        all_elements_text.add(l.getText());
	//
	//	        //to print directly
	//	        System.out.println(l.getText());
	//	        String a = l.getText();
	//	        if(l.getText().isEmpty() || l.getText().equals("")) {
	//	            System.out.println(l.getText()+" WebElements in UI is blank.");
	//	        } 
	//	        else 
	//	        {
	//	            System.out.println(l.getText()+" Blank Check is sucessfull");
	//	        }
	//	        if(l.getText().equals("0")) {
	//	            System.out.println(l.getText()+" WebElements in UI is zero.");
	//	        } 
	//	        else 
	//	        {
	//	            System.out.println(l.getText()+" Zero Check is sucessfull");
	//	        }
	//	        
	//	    });
	//	}
	//	
	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	private ExtentReports report;



	public void CheckActualConsumptionToday(ExtentReports report1) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{

		Thread.sleep(3000);
		WebElement wecacto=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]"));
		String ecacto = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]")).getText();
		System.out.println("webbrowser:  Actual Consumption Today " +ecacto.replace(",", "").replace(".", ""));

		WebElement wecprto=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[2]/span[3]"));
		String ecprto = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[2]/span[3]")).getText();
		System.out.println("webbrowser:  Predictive Consumption Today " +ecprto.replace(",", ""));

		//logger for blank and zero text
		logger=report1.createTest("Check -> Check Zero blank in Actual Consumption Today ");
		logger.info("Starting Check Zero blank in Actual Consumption Today");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (ecacto == null || ecacto.trim().equals("")) {
			System.out.println("Actual Consumption Today value is null, empty or blank");
			logger.log(Status.FAIL,"Actual Consumption Today value is null, empty or blank");
		}
		else
		{
			System.out.println("Actual Consumption Today value is neither null, empty nor blank");
			logger.log(Status.PASS,"Actual Consumption Today value is neither null, empty nor blank");

		}
		if (ecprto == null || ecprto.trim().equals("")) {
			System.out.println("Actual Consumption Today value is null, empty or blank");
			logger.log(Status.FAIL,"Predictive Consumption Today value is null, empty or blank");
		}
		else
		{
			System.out.println("Actual Consumption Today value is neither null, empty nor blank");
			logger.log(Status.PASS,"Predictive Consumption Today value is neither null, empty nor blank");

		}

		//String ecprto2=ecprto.replace(",", "").replace(".", "");


		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("ECActualPredictive");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Energy Consumption 1.Verifying Actual and Predictive Energy Consumption for Today");

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
					int col2 = rs.getInt(2);

					System.out.println("DB :Actual Consumption kWh: "+col1);
					System.out.println("DB :predictive Consumption kWh: "+col2);

					logger=report1.createTest("Check ->  Actual and Predictive Consumption Today ");
					logger.info("Starting Check Actual and Predictive  Consumption Today");
					logger.pass("Actual and Predictive Consumption Today Success");

					int convert =Integer.parseInt(ecacto.replace(",", "").replace(".", ""));
					int convert2 =Integer.parseInt(ecprto.replace(",", "").replace(".", ""));

					if (convert==col1 ) {	    
						System.out.println("The Actual Energy Consumption for today is matching ");

						logger.log(Status.PASS,"The Actual Energy Consumption for today is matching");
						//	extentTest.log(LogStatus.PASS, "The Actual Energy Consumption are matching for Today");

					} else {
						System.out.println("Error! in matching the Actual Energy Consumption for Today ");
						//	extentTest.log(LogStatus.FAIL, "Error! in matching the Actual Energy Consumption for Today ");
						highLighterMethod(driver,wecacto);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    the Actual Energy Consumption for Today is not matching ");


					}


					if (convert2==col2) {	             	   
						System.out.println("The Predictive Energy Consumption are matching for Today ");
						//	extentTest.log(LogStatus.PASS, "The Predictive Energy Consumption are matching for Today ");
						logger.log(Status.PASS,"The Predictive Energy Consumption are matching for Today");

					}else {
						System.out.println("Error! in matching the Predictive Energy Consumption for Today ");
						//extentTest.log(LogStatus.FAIL, "Error! in matching the Predictive Energy Consumption for Today ");
						highLighterMethod(driver,wecprto);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   the Predictive Energy Consumption for Today is not matching  ");



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
	public void CheckCostOFActualPredToday(ExtentReports report2) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{
		Thread.sleep(4000);

		WebElement wecoacto = driver.findElement(By.xpath("//span[@class=\"text-danger fw-bolder mb-1 valuesize\"])[3]"));
		String coacto = driver.findElement(By.xpath("//span[@class=\\\"text-danger fw-bolder mb-1 valuesize\\\"])[3]")).getText();
		System.out.println("Value of webbrowser AC " +coacto.replace(",", "").replace(".", ""));


		WebElement wecoprto = driver.findElement(By.xpath("(//span[@class=\"text-danger fw-bolder mb-1 valuesize\"])[4]"));
		String coprto = driver.findElement(By.xpath("(//span[@class=\"text-danger fw-bolder mb-1 valuesize\"])[4]")).getText();
		System.out.println("Value of webbrowser AC " +coprto.replace(",", "").replace(".", ""));

		//logger for blank and zero text
		logger=report2.createTest("Check -> Check Zero blank in Cost Actual Predictive Today ");
		logger.info("Starting Check Zero blank in  Cost Actual Pred Today");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (coacto == null || coacto.trim().equals("")) {
			System.out.println("Cost Actual  Today value is null, empty or blank");
			logger.log(Status.FAIL,"Cost Actual Today value is null, empty or blank");
		}
		else
		{
			System.out.println("Actual Consumption Today value is neither null, empty nor blank");
			logger.log(Status.PASS,"Actual Consumption Today value is neither null, empty nor blank");

		}
		if (coprto == null || coprto.trim().equals("")) {
			System.out.println("Cost Predictive Today value is null, empty or blank");
			logger.log(Status.FAIL,"Cost Predictive Today value is null, empty or blank");
		}
		else
		{
			System.out.println("Cost Predictive Today value is neither null, empty nor blank");
			logger.log(Status.PASS,"Cost Predictive Today value is neither null, empty nor blank");

		}


		try {

			{
				Properties prop = new Properties();
				prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

				String Q2=prop.getProperty("CostActualPredictive");
				Connection conn = DriverManager.getConnection(url,user,password);
				Statement stmt = conn.createStatement();
				System.out.println("Inside Energy Consumption 1.Verifying Cost for  Actual and Predictive for Today");

				ResultSet rs = stmt.executeQuery(Q2);


				java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
				int numberOfColumns = rsMetaData.getColumnCount();

				// get the column names; column indexes start from 1
				for (int i = 1; i < numberOfColumns + 1; i++) {
					String columnName = rsMetaData.getColumnName(i);
					String tableName = rsMetaData.getTableName(i);

					while(rs.next())
					{
						int col1 = rs.getInt(1);
						int col2 = rs.getInt(2);

						System.out.println("Actual Cost of Energy Consumption kWh: "+col1);
						logger=report2.createTest("Check ->Actual and Predictive cost of Energy Consumption Today ");
						logger.info("Starting Check Actual and Predictive Cost of Energy Consumption Today");
						logger.pass(" Actual and Predictive Cost of Energy Consumption Today Success");

						System.out.println("Predictive Cost of Energy Consumption kWh: "+col2);



						int convert =Integer.parseInt(coacto.replace(",", "").replace(".", ""));
						int convert2 =Integer.parseInt(coprto.replace(",", "").replace(".", ""));

						if (convert==col1) {
							System.out.println("The Actual Cost of Energy Consumption are matching for Today ");
							//test.log(LogStatus.PASS, "The Actual Cost of Energy Consumption are matching for Today");
							logger.log(Status.PASS,"The Actual Cost of Energy Consumption are matching for Today");
							//	extentTest.log(LogStatus.PASS, "The Actual cost of Energy Consumption are matching for Today");


						} else {
							System.out.println("Error! in matching the Actual Cost of Energy Consumption for Today ");
							//test.log(LogStatus.FAIL, "Error! in matching the Actual Cost of Energy Consumption for Today");
							highLighterMethod(driver,wecoacto);
							String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

							logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   the Actual cost of  Energy Consumption for Today is not matching  ");


						}

						if (convert2==col1) {
							System.out.println("The predictive Cost of Energy Consumption are matching for Today ");
							//test.log(LogStatus.PASS, "The predictive Cost of Energy Consumption are matching for Today");
							logger.log(Status.PASS,"The Predictive Cost of Energy Consumption are matching for Today");
							//	extentTest.log(LogStatus.PASS, "The predictive cost of  Energy Consumption are matching for Today");


						} else {
							System.out.println("Error! in matching the predictive Cost of Energy Consumption for Today ");
							//test.log(LogStatus.FAIL, "Error! in matching the predictive Cost of Energy Consumption for Today");
							highLighterMethod(driver, wecoprto);
							String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

							logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   the Predictive cost of  Energy Consumption for Today is not matching  ");


						}

					}

				}

				rs.close();
				stmt.close();
			}

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


	public  void CheckPowerFactor(ExtentReports report3) throws InterruptedException {

		Thread.sleep(2000);
		
		
		WebElement wepftoday = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[4]/td[1]/span[3]"));
		String pftoday = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[4]/td[1]/span[3]")).getText();
		System.out.println("webbrowser: Actual power factor " +pftoday);
		//logger for blank and zero text
		logger=report3.createTest("Check -> Zero and Blank in Power Factor ");
		logger.info("Starting Check Zero blank in PowerFactor");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (pftoday == null || pftoday.trim().equals("")) {
			System.out.println("Power Factor value is null, empty or blank");
			logger.log(Status.FAIL,"Power Factor value is null, empty or blank");
		}
		else
		{
			System.out.println("Power Factor value is neither null, empty nor blank");
			logger.log(Status.PASS,"Power Factor value is neither null, empty nor blank");

		}



		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("ActualPF");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("Inside Energy Consumption 1.Verifying Actual Power Factor");




			ResultSet rs = stmt.executeQuery(Q2);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);

				while(rs.next())
				{
					int col1 = rs.getInt(1);


					System.out.println(" DB: Actual Power Factor: "+col1);

					logger=report3.createTest("Check ->Actual Power Factor ");
					logger.info("Starting Actual Power Factor");
					logger.pass(" Actual Power Factor Success");

					 
				        
					int convert =Integer.parseInt(pftoday.replace(",", "").replace(".", ""));


					if (convert==col1) {
						System.out.println("Power Factor is Matching");
						//test.log(LogStatus.PASS, "Power Factor is Matching");
						logger.log(Status.PASS,"Check Power Factor is matching ");

					}
					else {

						System.out.println("Power Factor is not Matching");


						//	test.log(LogStatus.FAIL, "Power Factor is not Matching");
						highLighterMethod(driver, wepftoday);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"      Error!   Check Power Factor is not matching ");

					}

					rs.close();
					stmt.close();
				}

			}}
		catch (FileNotFoundException e) {
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



	public  void CheckAvgKwhToday(ExtentReports report4) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{    
		
		Thread.sleep(2000);
		WebElement weavgkwhtoday = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[4]/td[2]/span[3]"));
		
		String avgkwhtoday = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[4]/td[2]/span[3]")).getText();
		System.out.println("webbrowser:  Average Kwh for Today " +avgkwhtoday.replace(",", "").replace(".", ""));
		
		
		//logger for blank and zero text
		logger=report4.createTest("Check -> Zero and Blank in Average Kwh Today");
		logger.info("Starting Check Zero blank in Average Kwh Today");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (avgkwhtoday == null || avgkwhtoday.trim().equals("")) {
			System.out.println("Average Kwh Today value is null, empty or blank");
			logger.log(Status.FAIL,"Average Kwh Today value is null, empty or blank");
		}
		else
		{
			System.out.println("Average Kwh Today value is neither null, empty nor blank");
			logger.log(Status.PASS,"Average Kwh Today value is neither null, empty nor blank");

		}

		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("AvgKwhToday");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("Inside Energy Consumption 1.Verifying Average Kwh for Today");

			ResultSet rs = stmt.executeQuery(Q2);


			while (rs.next())
			{      
				int col1 = rs.getInt(1);
				int col2 = rs.getInt(2);
				int col3=col2/col1;

				System.out.println(" DB: Average Kwh for Today: "+col3);

				

				logger=report4.createTest("Check -> Average Kwh for Today ");
				logger.info("Starting Average Kwh for Today");
				logger.pass("Average Kwh for Today Success");



				int convert =Integer.parseInt(avgkwhtoday.replace(",", "").replace(".", ""));

				if (convert==col3) {
					System.out.println("Average Kwh for Today is matching ");
					logger.log(Status.PASS,"Average Kwh for Today");



				} else {
					System.out.println("Error! in matching Average Kwh for Today ");
					highLighterMethod(driver, weavgkwhtoday);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"    Error!    Average Kwh for Today is not matching ");

				}
				rs.close();
				stmt.close();
			}


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



	public  void CheckEnergyTreeToday(ExtentReports report5) throws InterruptedException {



		//Today

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[1]/div/ul/li[1]/a")).click();

		// Actual consumption today 
		WebElement mainvalue=driver.findElement(By.xpath("//*[@id=\\\"kt_content_container\\\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]"));

		String mainvalue1=driver.findElement(By.xpath("//*[@id=\\\"kt_content_container\\\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]")).getText();

		System.out.println("Today actual consumption value:"+mainvalue1);

		//  main candle value today
		WebElement mainvalue11 = driver.findElement(By.xpath("//*[local-name()='svg'and @class='highcharts-root'][1]//*[name()='path'][2]"));

		String mainvalue111 = "//*[local-name()='svg'and @class='highcharts-root'][1]//*[name()='path'][2]";

		String Tvalue    = driver.findElement(By.xpath(mainvalue111)).getText();

		System.out.println("Energy Tree Today main candle value:"+Tvalue);




		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("EnergyTreeToday");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Energy Tree 1.Energy Tree Today");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1



			System.out.println("No of columns"+numberOfColumns);




			while(rs.next())
			{
				String col1 = rs.getString(1);
				String col2 = rs.getString(2);

				System.out.println("Energy Tree Today: col1 "+col1);

				System.out.println("Energy Tree Today: col2 "+col2);


				String convert =Tvalue.replace(",", "").replace(".", "");
				logger=report5.createTest("Check -> Energy Tree Today ");
				logger.info("Starting Energy Tree Today");
				logger.pass("Energy Tree TodaySuccess");




				String convert2=Tvalue.replace(",", "").replace(".", "");


				if (convert==col1) {
					System.out.println("Today's Energy Tree Graph values are matching  ");
					logger.log(Status.PASS," Energy Tree Graph for Today");




				} else {
					System.out.println("Error! in Today's Energy Tree Graph values are matching ");
					highLighterMethod(driver, mainvalue);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"    Error!   Energy Tree Graph for Today is not matching ");


				}

				System.out.println("Energy Tree Today: "+col2);

				if (convert2==col2) {
					System.out.println("Today's Energy Tree Graph values are matching  ");
					logger.log(Status.PASS," Energy Tree Graph for Today");


				} else {
					System.out.println("Error! in Today's Energy Tree Graph values are matching ");
					highLighterMethod(driver, mainvalue11);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"    Error!   Energy Tree Graph for Today is not matching ");


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



	public  void CheckEcActualPrYesterday(ExtentReports report6) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{
		Thread.sleep(4000);
		WebElement clickyes=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[1]/div/ul/li[2]/a"));
		clickyes.click(); 


		WebElement ecacyes = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]"));

		String wecacyes = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]")).getText();
		System.out.println("webbrowser:  Actual Consumption Yesterday " +wecacyes.replace(",", ""));

		WebElement ecacpryes = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[2]/span[3]"));

		String wecacpryes = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[2]/span[3]")).getText();
		System.out.println("webbrowser:  predictive Consumption Yesterday " +wecacpryes.replace(",", "").replace(".", ""));

		//logger for blank and zero text
		logger=report6.createTest("Check -> Zero and Blank in Energy COnsumptuion Actual Predictive for Yesterday");
		logger.info("Starting Check Zero blank in Energy COnsumptuion Actual Predictive for Yesterday");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (wecacyes == null || wecacyes.trim().equals("")) {
			System.out.println("Energy Consumptuion Actual for Yesterday value is null, empty or blank");
			logger.log(Status.FAIL,"Energy Consumptuion Actual for Yesterday value is null, empty or blank");
		}
		else
		{
			System.out.println("Energy Consumptuion Actual for Yesterday is neither null, empty nor blank");
			logger.log(Status.PASS,"Energy Consumptuion Actual for Yesterday value is neither null, empty nor blank");

		}
		//		//if (wecacpryes == null || wecacpryes.trim().equals("")) {
		//			System.out.println("Energy Consumptuion Predictive for Yesterday value is null, empty or blank");
		//			logger.log(Status.FAIL,"Energy Consumptuion Predictive for Yesterday value is null, empty or blank");
		//		}
		//		else
		//		{
		//			System.out.println("Energy Consumptuion  Predictive for Yesterday is neither null, empty nor blank");
		//			logger.log(Status.PASS,"Energy Consumptuion  Predictive for Yesterday value is neither null, empty nor blank");
		//
		//		}
		try {

			{
				Properties prop = new Properties();
				prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

				String Q2=prop.getProperty("ECActualPredYesterday");
				Connection conn = DriverManager.getConnection(url,user,password);
				Statement stmt = conn.createStatement();
				System.out.println("Inside Energy Consumption 1.Verifying  Actual and Predictive for Yesterday");

				ResultSet rs = stmt.executeQuery(Q2);


				java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
				int numberOfColumns = rsMetaData.getColumnCount();

				// get the column names; column indexes start from 1
				for (int i = 1; i < numberOfColumns + 1; i++) {
					String columnName = rsMetaData.getColumnName(i);
					String tableName = rsMetaData.getTableName(i);

					while(rs.next())
					{
						int col1 = rs.getInt(1);


						System.out.println("DB: Actual Consumption Yesterday: "+col1);

						logger=report6.createTest("Check -> Actual Consumption Yesterday ");
						logger.info("Starting Actual Consumption Yesterday");
						logger.pass("Actual Consumption Yesterday Success");


						int convert =Integer.parseInt(wecacyes.replace(",", "").replace(".", ""));


						if (convert==col1) {
							System.out.println("The Actual Energy Consumption are matching for Yesterday ");
							logger.log(Status.PASS,"The Actual Energy Consumption for Yesterday is matching ");


						} else {
							System.out.println("Error! in matching the Actual Energy Consumption for Yesterday ");
							highLighterMethod(driver, ecacyes);
							String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

							logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    The Actual Energy Consumption for Yesterday is not matching ");

						}


					}

				}

				rs.close();
				stmt.close();
			}

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



	public  void CheckCostActualPrYesterday(ExtentReports report7) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{
		Thread.sleep(4000);

		WebElement coacyes = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[3]/td[1]/span[3]"));

		String wcoacyes = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[3]/td[1]/span[3]")).getText();
		System.out.println("webbrowser:  Actual Cost Yesterday " +wcoacyes.replace(",", "").replace(".", ""));

		WebElement coacpryes = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/span[3]"));

		String wcoacpryes = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/span[3]")).getText();
		System.out.println("webbrowser:  Predictive Cost Yesterday " +wcoacpryes.replace(",", "").replace(".", ""));

		//logger for blank and zero text
		logger=report7.createTest("Check -> Zero and Blank in Cost in Actual and Predictive for Yesterday");
		logger.info("Starting Check Zero blank in Cost in Actual and Predictive for Yesterday");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (wcoacyes == null || wcoacyes.trim().equals("")) {
			System.out.println("Cost in Actual for Yesterday value is null, empty or blank");
			logger.log(Status.FAIL,"Cost in Actual for Yesterday value is null, empty or blank");
		}
		else
		{
			System.out.println("Cost in Actual for Yesterday value is neither null, empty nor blank");
			logger.log(Status.PASS,"Cost in Actual for Yesterday value is neither null, empty nor blank");

		}

		//Condition zero and blank
		if (wcoacpryes == null || wcoacpryes.trim().equals("")) {
			System.out.println("Cost Predictive for Yesterday value is null, empty or blank");
			logger.log(Status.FAIL,"Cost Predictive for Yesterday value is null, empty or blank");
		}
		else
		{
			System.out.println("Cost in Actual and Predictive for Yesterday value is neither null, empty nor blank");
			logger.log(Status.PASS,"Cost in Actual and Predictive for Yesterday value is neither null, empty nor blank");

		}


		try {

			{
				Properties prop = new Properties();
				prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

				String Q2=prop.getProperty("CostActualPredYesterday");
				Connection conn = DriverManager.getConnection(url,user,password);
				Statement stmt = conn.createStatement();
				System.out.println("Inside Energy Consumption 1.Verifying Cost for  Actual and Predictive for Yesterday");

				ResultSet rs = stmt.executeQuery(Q2);


				java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
				int numberOfColumns = rsMetaData.getColumnCount();

				// get the column names; column indexes start from 1
				for (int i = 1; i < numberOfColumns + 1; i++) {
					String columnName = rsMetaData.getColumnName(i);
					String tableName = rsMetaData.getTableName(i);

					while(rs.next())
					{
						int col1 = rs.getInt(1);


						System.out.println("DB: Actual Cost  of Energy Consumption kWh: "+col1);

						logger=report7.createTest("Check -> Actual Cost  of Energy Consumption kWh ");
						logger.info("Starting Actual Cost  of Energy Consumption kWh");
						logger.pass("Actual Cost  of Energy Consumption kWh Success");


						int convert =Integer.parseInt(wcoacyes.replace(",", "").replace(".", ""));


						if (convert==col1) {
							System.out.println("The Actual Cost are matching for Yesterday ");
							logger.log(Status.PASS,"  Actual Cost  of Energy Consumption kWh for Yesterday is matching ");


						} else {
							System.out.println("Error! in matching Actual Cost for Yesterday ");
							highLighterMethod(driver, coacyes);
							String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

							logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    Actual Cost  of Energy Consumption kWh for Yesterday is not matching ");

						}

					}


				}



				rs.close();
				stmt.close();
			}	

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

	public  void CheckAvgKwhYesterday(ExtentReports report8) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{
		WebElement avgkwhysday = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[4]/td/span[3]"));

		String wavgkwhysday = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[4]/td/span[3]")).getText();
		System.out.println("webbrowser:  Average Kwh for Yesterday " +wavgkwhysday.replace(",", "").replace(".", ""));

		//logger for blank and zero text
		logger=report8.createTest("Check -> Zero and Blank in Average Kwh for Yesterday");
		logger.info("Starting Check Zero blank in Average Kwh for Yesterday");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (wavgkwhysday == null || wavgkwhysday.trim().equals("")) {
			System.out.println("Average Kwh for Yesterday value is null, empty or blank");
			logger.log(Status.FAIL,"Average Kwh for Yesterday value is null, empty or blank");
		}
		else
		{
			System.out.println("Average Kwh for Yesterday value is neither null, empty nor blank");
			logger.log(Status.PASS,"Average Kwh for Yesterday value is neither null, empty nor blank");

		}

		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("AvgKwhYesterday");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("Inside Energy Consumption 1.Verifying Average Kwh for Yesterday");

			ResultSet rs = stmt.executeQuery(Q2);


			while (rs.next())
			{      
				int col1 = rs.getInt(1);
				int col2 = rs.getInt(2);
				int col3=col2/col1;

				
				System.out.println("DB: Average Kwh for Yesterday: "+col3);

				logger=report8.createTest("Check -> Average Kwh for Yesterday ");
				logger.info("Average Kwh for Yesterday");
				logger.pass("Average Kwh for YesterdaySuccess");


				int convert =Integer.parseInt(wavgkwhysday.replace(",", "").replace(".", ""));

				if (convert==col3) {
					System.out.println("The Actual Energy Consumption are matching for Yesterday ");
					logger.log(Status.PASS,"The Actual Energy Consumption for Yesterday is matching ");



				} else {
					System.out.println("Error! in matching the Energy Consumption for Yesterday ");
					highLighterMethod(driver,  avgkwhysday);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   The Actual Energy Consumption for Yesterday is not matching ");


				}
			}

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



	public  void CheckEcActualMonthly(ExtentReports report9) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{
		Thread.sleep(4000);

		WebElement clickyes=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[1]/div/ul/li[3]/a"));
		clickyes.click(); 


		WebElement ecacmon = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]"));

		String wecacmon = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]")).getText();
		System.out.println("webbrowser:  Actual Energy Consumption Monthly " +wecacmon.replace(",", "").replace(".", ""));

		WebElement eccomon = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[2]/span[3]"));

		String weccomon = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[2]/span[3]")).getText();
		System.out.println("webbrowser:  Predictive Energy Consumption Monthly" +weccomon.replace(",", "").replace(".", ""));

		//logger for blank and zero text
		logger=report9.createTest("Check -> Zero and Blank in Energy Consumption Actual and Predictive for Monthly");
		logger.info("Starting Check Zero blank in in Energy Consumption Actual and Predictive for Monthly");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (wecacmon == null || wecacmon.trim().equals("")) {
			System.out.println("Energy Consumption Actual for Monthly value is null, empty or blank");
			logger.log(Status.FAIL,"Energy Consumption Actual for Monthly value is null, empty or blank");
		}
		else
		{
			System.out.println("Energy Consumption Actual for Monthly value is neither null, empty nor blank");
			logger.log(Status.PASS,"Energy Consumption Actual for Monthly value is neither null, empty nor blank");

		}
		//Condition zero and blank
		if (weccomon == null || weccomon.trim().equals("")) {
			System.out.println("Energy Consumption Predictive for Monthly value is null, empty or blank");
			logger.log(Status.FAIL,"Energy Consumption Predictive for Monthly value is null, empty or blank");
		}
		else
		{
			System.out.println("Energy Consumption Predictive for Monthly value is neither null, empty nor blank");
			logger.log(Status.PASS,"Energy Consumption Predictive for Monthly value is neither null, empty nor blank");

		}

		try {

			{
				Properties prop = new Properties();
				prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

				String Q2=prop.getProperty("ECActualPredMonthly");
				Connection conn = DriverManager.getConnection(url,user,password);
				Statement stmt = conn.createStatement();
				System.out.println("Inside Energy Consumption 1.Verifying Cost for  Actual and Predictive for Monthly");

				ResultSet rs = stmt.executeQuery(Q2);


				java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
				int numberOfColumns = rsMetaData.getColumnCount();

				// get the column names; column indexes start from 1
				for (int i = 1; i < numberOfColumns + 1; i++) {
					String columnName = rsMetaData.getColumnName(i);
					String tableName = rsMetaData.getTableName(i);

					while(rs.next())
					{
						int col1 = rs.getInt(1);
						int col2 = rs.getInt(2);

						System.out.println("DB: Actual Energy Consumption Monthly: "+col1);
						System.out.println("DB: Predictive Energy Consumption Monthly: "+col2);

						logger=report9.createTest("Check -> Actual and Predictive Energy Consumption Monthly ");
						logger.info("Starting Actual and Predictive Energy Consumption Monthly");
						logger.pass("Actual and Predictive Energy Consumption Monthly Success");

						int convert =Integer.parseInt(wecacmon.replace(",", "").replace(".", ""));
						int convert2 =Integer.parseInt(weccomon.replace(",", "").replace(".", ""));

						if (convert==col1) {
							System.out.println("The Actual Energy Consumption are matching for Monthly ");
							logger.log(Status.PASS,"The Actual Energy Consumption are matching for Monthly");


						} else {
							System.out.println("Error! in matching the Actual Energy Consumption for Monthly ");
							highLighterMethod(driver, ecacmon);
							String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

							logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"      Error!     The Actual Energy Consumption for Monthly is not matching ");


						}
						if (convert2==col2) {
							System.out.println("The Predictive Energy Consumption are matching for Monthly ");
							logger.log(Status.PASS,"The Predictive Energy Consumption are matching for Monthly");


						} else {
							System.out.println("Error! in matching the Predictive Energy Consumption for Monthly ");
							highLighterMethod(driver, eccomon);
							String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

							logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    The Predictive Energy Consumption for Monthly is not matching ");


						}

					}

				}

				rs.close();
				stmt.close();
			}

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


	public  void CheckCostActualPredMonthly(ExtentReports report10) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{
		Thread.sleep(4000);

		WebElement coacmon = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[3]/td[1]/span[3]"));

		String wcoacmon = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[3]/td[1]/span[3]")).getText();
		
		System.out.println("webbrowser:  Actual Cost Monthly " +wcoacmon.replace(",", "").replace(".", ""));


		
		WebElement coprmon = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/span[3]"));

		String wcoprmon = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/span[3]")).getText();
		
		System.out.println("webbrowser:  Pred Cost Monthly " +wcoprmon.replace(",", "").replace(".", ""));
		
		//logger for blank and zero text
		logger=report10.createTest("Check -> Zero and Blank in Energy Consumption Actual and Predictive cost for Monthly");
		logger.info("Starting Check Zero blank in in Energy Consumption Actual and Predictive cost for Monthly");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (wcoacmon == null || wcoacmon.trim().equals("")) {
			System.out.println("Energy Consumption Actual cost for Monthly value is null, empty or blank");
			logger.log(Status.FAIL,"Energy Consumption Actual cost for Monthly value is null, empty or blank");
		}
		else
		{
			System.out.println("Energy Consumption Actualcost for Monthly value is neither null, empty nor blank");
			logger.log(Status.PASS,"Energy Consumption Actual for Monthly value is neither null, empty nor blank");

		}
		//Condition zero and blank
		if (wcoprmon == null || wcoprmon.trim().equals("")) {
			System.out.println("Energy Consumption Predictive cost for Monthly value is null, empty or blank");
			logger.log(Status.FAIL,"Energy Consumption Predictive cost for Monthly value is null, empty or blank");
		}
		else
		{
			System.out.println("Energy Consumption Predictive cost for Monthly value is neither null, empty nor blank");
			logger.log(Status.PASS,"Energy Consumption Predictive cost for Monthly value is neither null, empty nor blank");

		}

		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("CostActualPredMonthly");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Energy Consumption 1.Verifying Cost for  Actual and Predictive for Monthly");

			ResultSet rs = stmt.executeQuery(Q2);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String tableName = rsMetaData.getTableName(i);

				while(rs.next())
				{
					int col1 = rs.getInt(1);
					int col2 = rs.getInt(2);



					System.out.println("DB:  Actual Cost Monthly: "+col1);

					System.out.println("DB: Predictive Cost Monthly: "+col2);

					logger=report10.createTest("Check -> Actual Predictive Cost Monthly ");
					logger.info("Starting Actual Predictive Cost Monthly");
					logger.pass("Actual Predictive Cost Monthly Success");


					int convert =Integer.parseInt(wcoprmon.replace(",", "").replace(".", ""));

					int convert2 =Integer.parseInt(wcoprmon.replace(",", "").replace(".", ""));

					
					
					if (convert==col1) {
						System.out.println("The Actual Cost of  Energy Consumption are matching for Monthly ");
						logger.log(Status.PASS,"The Actual Predictive Cost Energy Consumption are matching for Monthly");

					} else {
						System.out.println("Error! in matching  Actual Cost of  Energy Consumption for Monthly ");
						highLighterMethod(driver, coacmon);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"   Error!   The Actual Predictive Cost Energy Consumption for Monthly is not matching ");


					}
					if (convert2==col2) {
						System.out.println("The  Predictive Cost Energy Consumption are matching for Monthly ");
						logger.log(Status.PASS,"The  Predictive Cost Energy Consumption are matching for Monthly");

					} else {
						System.out.println("Error! in matching Predictive Cost Energy Consumption for Monthly ");
						highLighterMethod(driver, coprmon);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    The  Predictive Cost Energy Consumption for Monthly is not matching ");


					}

				}
				rs.close();
				stmt.close();
			}





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

	public  void CheckAvgKwhMonthly(ExtentReports report11) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{

		WebElement avgkwhmon = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[4]/td/span[3]"));

		String wavgkwhmon = driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[4]/td/span[3]")).getText();
		System.out.println("webbrowser:  Average Kwh for Monthly " +wavgkwhmon.replace(",", "").replace(".", ""));

		logger=report11.createTest("Check -> Zero and Blank in Average Kwh for Monthly");
		logger.info("Starting Check Zero blank in Average Kwh for Monthly");
		logger.pass("Zero and Blank Check Test Success");

		//Condition zero and blank
		if (wavgkwhmon == null || wavgkwhmon.trim().equals("")) {
			System.out.println("Average Kwh for Monthly value is null, empty or blank");
			logger.log(Status.FAIL,"Average Kwh for Monthly value is null, empty or blank");
		}
		else
		{
			System.out.println("Average Kwh for Monthly value is neither null, empty nor blank");
			logger.log(Status.PASS,"Average Kwh for Monthly is neither null, empty nor blank");

		}

		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("AvgKwhMonthly");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("Inside Energy Consumption 1.Verifying Average Kwh for Monthly");

			ResultSet rs = stmt.executeQuery(Q2);


			while (rs.next())
			{      
				int col1 = rs.getInt(1);
				int col2 = rs.getInt(2);
				int col3=col2/col1;

				
				System.out.println("DB: Average Kwh for Monthly: "+ col3);

				logger=report11.createTest("Check -> Average Kwh for Monthly ");
				logger.info("Starting Average Kwh for Monthly");
				logger.pass("Average Kwh for Monthly Success");



				int convert =Integer.parseInt(wavgkwhmon.replace(",", "").replace(".", ""));

				if (convert==col3) {
					System.out.println("The Average Kwh are matching for Monthly ");
					logger.log(Status.PASS,"The Average Kwh are matching for Monthly");


				} else {
					System.out.println("Error! in matching the Average Kwh for Monthly ");
					highLighterMethod(driver, avgkwhmon);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    the Energy Consumption for Monthly is not matching ");




				}
			}

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


	public  void CheckEnergyTreeYesterday(ExtentReports report12) throws InterruptedException {

		Thread.sleep(3000);

		// Energy tree yesterday 

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[1]/div/ul/li[2]/a")).click();

		// actual consumption value 

		WebElement EnergyTY= driver.findElement(By.xpath("//*[@id=\\\"kt_content_container\\\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]"));

		String mainvalue = "//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]";

		String value    = driver.findElement(By.xpath(mainvalue)).getText();

		System.out.println("Yesterday actual consumption value:"+value);

		//  main candle value

		WebElement EnergyTY1= driver.findElement(By.xpath("//*[local-name()='svg'and @class='highcharts-root'][1]//*[name()='path'][2]"));


		String mainlvalue = "//*[local-name()='svg'and @class='highcharts-root'][1]//*[name()='path'][2]";

		String Tvalue    = driver.findElement(By.xpath(mainlvalue)).getText();

		System.out.println("Energy tree yesterday main candle value:"+Tvalue);



		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("EnergyTreeYesterday");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Energy Tree 1.Energy Tree Yesterday");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1



			System.out.println("No of columns"+numberOfColumns);




			while(rs.next())
			{
				String col1 = rs.getString(1);
				String col2 = rs.getString(2);

				System.out.println("Energy Tree Yesterday: col1 "+col1);

				System.out.println("Energy Tree Yesterday: col2 "+col2);

				logger=report12.createTest("Check -> Energy Tree Yesterday ");
				logger.info("Starting Energy Tree Yesterday");
				logger.pass("Average Energy Tree Yesterday");

				String convert =Tvalue.replace(",", "").replace(".", "");
				String convert2=Tvalue.replace(",", "").replace(".", "");


				if (convert==col1) {
					System.out.println("Yesterday's Energy Tree Graph values are matching  ");
					logger.log(Status.PASS,"Yerday's Energy Tree Graph values are matchingest");


				} else {
					System.out.println("Error! in Yesterday's Energy Tree Graph values are matching ");
					highLighterMethod(driver,  EnergyTY);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   the Energy Tree Yesterday is not matching ");



				}

				System.out.println("Energy Tree Yesterday: "+col2);

				if (convert2==col2) {
					System.out.println("Yesterday's Energy Tree Graph values are matching  ");
					logger.log(Status.PASS,"Yesterday's Energy Tree Graph values are matching");



				} else {
					System.out.println("Error! in Yesterday's Energy Tree Graph values are matching ");
					highLighterMethod(driver,  EnergyTY1);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    the Energy Tree Yesterday is not matching ");



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




	public  void CheckEnergyTreeMonthly(ExtentReports report13) throws InterruptedException {

		Thread.sleep(3000);

		// Energy tree Month 

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[1]/div/ul/li[3]/a")).click();

		// actual consumption value 

		WebElement EnergyTY= driver.findElement(By.xpath("//*[@id=\\\"kt_content_container\\\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]"));


		String mainvalue = "//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[1]/app-energy-consumption/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/span[3]";

		String value    = driver.findElement(By.xpath(mainvalue)).getText();

		System.out.println(" Month actual consumption value:"+value);

		//  main candle value

		WebElement EnergyTY1= driver.findElement(By.xpath("//*[local-name()='svg'and @class='highcharts-root'][1]//*[name()='path'][2]"));

		String mainlvalue = "//*[local-name()='svg'and @class='highcharts-root'][1]//*[name()='path'][2]";

		String Tvalue    = driver.findElement(By.xpath(mainlvalue)).getText();

		System.out.println("Energy Tree Month main candle value:"+Tvalue);


		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q1=prop.getProperty("EnergyTreeMonth");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Energy Tree 1.Energy Tree Month");

			ResultSet rs = stmt.executeQuery(Q1);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1



			System.out.println("No of columns"+numberOfColumns);

			logger=report13.createTest("Check -> Energy Tree monthly ");
			logger.info("Starting Energy Tree monthly");
			logger.pass("Average Energy Tree monthly");


			while(rs.next())
			{
				String col1 = rs.getString(1);
				String col2 = rs.getString(2);

				System.out.println("Energy Tree Month: col1 "+col1);

				System.out.println("Energy Tree Month: col2 "+col2);


				String convert =Tvalue.replace(",", "").replace(".", "");
				String convert2=Tvalue.replace(",", "").replace(".", "");


				if (convert==col1) {
					System.out.println("Month Energy Tree Graph values are matching  ");
				} 

				else {
					System.out.println("    Error!  the  Energy Tree monthly Graph is not matching ");
				}

				System.out.println("Energy Tree Month: "+col2);

				if (convert2==col2) {
					System.out.println("Month Energy Tree Graph values are matching  ");
				}

				else {
					System.out.println("     Error!    the  Energy Tree monthly Graph is not matching");
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





	public  void CheckEnegryConsumptionTrendGraph(ExtentReports report14) throws InterruptedException
	{

		Thread.sleep(3000);
		// energy consumption trend grapgh 

		//showing xand y coordinate value

		String ectgraph = "//*[local-name()='svg'and @class='highcharts-root'][1]//*[name()='path'][4]";

		Point graph = driver.findElement(By.xpath(ectgraph)).getLocation();

		System.out.println("ectgraph value:"+graph);

		// maximum value of ect graph and DB maximum value verify

		List<WebElement> graphlist = driver.findElements(By.xpath("((//*[local-name()='svg' and @class='highcharts-root'])[3]//*[name()='path'])[11]"));	
		Actions act = new Actions(driver);

		for (WebElement e1 : graphlist) {

			act.doubleClick(e1).moveToElement(e1).build().perform();

			System.out.println("moving point :"+e1.getSize()); 


			WebElement graph1  = driver.findElement(By.xpath("//div[@class='col-md-12 trendcss']"));

			String graph2= driver.findElement(By.xpath("//div[@class='col-md-12 trendcss']")).getText();

			System.out.println("value:"+graph2);	



			try {


				Properties prop = new Properties();
				prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

				String Q2=prop.getProperty("EnergyConsumptionTrend");
				Connection conn = DriverManager.getConnection(url,user,password);
				Statement stmt = conn.createStatement();
				System.out.println("Inside Energy Consumption Trend 1.Verifying Energy Consumption Trend value ");

				ResultSet rs = stmt.executeQuery(Q2);


				java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
				int numberOfColumns = rsMetaData.getColumnCount();

				// get the column names; column indexes start from 1



				System.out.println("No of columns"+numberOfColumns);




				while(rs.next())
				{
					String col1 = rs.getString(1);
					String col2 = rs.getString(2);

					System.out.println("Energy Consumption Trend value: col1 "+col1);

					System.out.println("Energy Consumption Trend value: col2 "+col2);
					logger=report14.createTest("Check -> Energy Consumption Trend value ");
					logger.info("Starting Energy Consumption Trend value");
					logger.pass("Energy Consumption Trend value succesful");

					String convert =graph2.replace(",", "").replace(".", "");
					String convert2=graph2.replace(",", "").replace(".", "");


					if (convert==col1) {
						System.out.println(" Energy Consumption Trend value matching  ");
						logger.log(Status.PASS,"Energy Consumption Trend value matching");



					} else {
						System.out.println(" Energy Consumption Trend value are matching ");
						highLighterMethod(driver,  graph1);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"    Error!   The Energy Consumption Trend graph is not matching");


					}



					if (convert2==col2) {
						System.out.println("Energy Consumption Trend value are matching  ");

						logger.log(Status.PASS,"Energy Consumption Trend value matching");


					} else {
						System.out.println("error!Energy Consumption Trend value are matching ");
						highLighterMethod(driver,  graph1);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!      The Energy Consumption Trend graph is not matching ");



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




	}



	public  void CheckEnergyUsageDaywise(ExtentReports report15) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{
		
		Thread.sleep(2000);
		
		WebElement EUgraph = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[5]"));

		String candle1= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[5]")).getText();

		System.out.println("Browser Value of candle1:"+candle1.replace(",", ""));



		WebElement EUgraph1 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]"));


		String candle2= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]")).getText();

		System.out.println("Browser Value of candle2:"+candle2.replace(",", ""));



		WebElement EUgraph2 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[7]"));


		String candle3= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[7]")).getText();

		System.out.println("Browser Value of candle3:"+candle3.replace(",", ""));


		WebElement EUgraph3 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[8]"));



		String candle4= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[8]")).getText();

		System.out.println("Browser Value of  candle4:"+candle4.replace(",", ""));


		WebElement EUgraph4 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[9]"));


		String candle5= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[9]")).getText();

		System.out.println("Browser Value of candle5:"+candle5.replace(",", ""));


		WebElement EUgraph5 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[10]"));


		String candle6= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[10]")).getText();

		System.out.println("Browser Value of candle6:"+candle6.replace(",", ""));



		WebElement EUgraph6 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[11]"));


		String candle7= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[11]")).getText();

		System.out.println("Browser Value of candle 7:"+candle7.replace(",", ""));



		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("EnergyUsageDaywise");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("Inside EnergyUsageDaywise 1.Verifying EnergyUsageDaywise");

			ResultSet rs = stmt.executeQuery(Q2);


			while (rs.next())
			{      


				String col3 = rs.getString(3);

				System.out.println("Energy usage day wise graph "+ col3.replace(".", ""));
				logger=report15.createTest("Check -> Checking Energy usage day wise graph  ");
				logger.info("Starting Checking Energy usage day wise graph");
				logger.pass("Checking Energy usage day wise graph succesful");

				String val=col3.replace(".", "");
				ArrayList<String> CValues1 = new ArrayList<String>();
				CValues1.add(candle1);
				CValues1.add(candle2);
				CValues1.add(candle3); 
				CValues1.add(candle4);
				CValues1.add(candle5);
				CValues1.add(candle6); 
				CValues1.add(candle7);
				boolean found = false;
				for (String temp : CValues1.subList(0, 7)) {

					if (temp.replace(",", "").contains(val.substring(0, 3))) {

						found = true;
						break;
					}
				}

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle1 = Check Energy Usage Daywise value matching ");


				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle1 = The Energy Usage Daywise graph is not matching");


				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS,"  candle2 = Check Energy Usage Daywise value matching ");


				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph1);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"    Error!   candle2 = The Energy Usage Daywise graph is not matching");

				}
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle3 = Check Energy Usage Daywise value matching ");


				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph2);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle3 =  The Energy Usage Daywise graph is not matching");


				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle4 = Check Energy Usage Daywise value matching ");


				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph3);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"      Error!   candle4 = The Energy Usage Daywise graph is not matching");


				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS,"candle5 = Check Energy Usage Daywise value matching ");


				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph4);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"      Error!   candle5 =   The Energy Usage Daywise graph is not matching");


				}  

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle6 = Check Energy Usage Daywise value matching ");


				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph5);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle6 =  The Energy Usage Daywise graph is not matching");


				}    

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle7 = Check Energy Usage Daywise value matching ");


				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph6);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    candle 7 = The Energy Usage Daywise graph is not matching");


				}    

				rs.close();
				stmt.close();
			}


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

	public  void CheckEnergyUsageMonthwise(ExtentReports report16) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{



		WebElement cli=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[2]/app-energy-usage/div[2]/ul/li[2]/a"));
		cli.click();
		Thread.sleep(5000);

		WebElement EUgraph = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]"));

		String canmon1= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]")).getText();
		System.out.println("value:" +canmon1);

		WebElement EUgraph1= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[7]"));

		String canmon2= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[7]")).getText();
		System.out.println("value:" +canmon2);

		WebElement EUgraph2= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[8]"));

		String canmon3= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[8]")).getText();
		System.out.println("value:" +canmon3);

		WebElement EUgraph3 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[9]"));

		String canmon4= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[9]")).getText();
		System.out.println("value:" +canmon4);

		WebElement EUgraph4= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[10]"));

		String canmon5= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[10]")).getText();
		System.out.println("value:" +canmon5);

		WebElement EUgraph5= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[11]"));

		String canmon6= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[11]")).getText();
		System.out.println("value:" +canmon6);

		WebElement EUgraph6= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[12]"));

		String canmon7= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[12]")).getText();
		System.out.println("value:" +canmon7);


		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("EnergyUsageMonthwise");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("Inside Energy Consumption 1.Verifying Average Kwh for Month Wise");

			ResultSet rs = stmt.executeQuery(Q2);


			while (rs.next())
			{      


				String col3 = rs.getString(3);

				System.out.println(" Energy usage month wise graph "+ col3.replace(".", ""));
				logger=report16.createTest("Check -> Checking Energy usage month wise graph  ");
				logger.info("Starting Checking Energy usage month wise graph");
				logger.pass("Checking Energy usage month wise graph succesful");



				String val1=col3.replace(".", "");


				ArrayList<String> CMValues = new ArrayList<String>();
				CMValues.add(canmon1.replace(",", ""));
				CMValues.add(canmon2.replace(",", ""));
				CMValues.add(canmon3.replace(",", "")); 
				CMValues.add(canmon4.replace(",", ""));
				CMValues.add(canmon5.replace(",", ""));
				CMValues.add(canmon6.replace(",", "")); 
				CMValues.add(canmon7.replace(",", ""));

				boolean found = false;
				for (String temp : CMValues.subList(0, 7)) {

					if (temp.replace(",", "").contains(val1.substring(0, 3))) {

						found = true;
						break;
					}
				}

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle1 = Check Energy Usage monthwise value matching ");



				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"      Error!   candle1 = The Energy Usage Monthwise graph is not matching");


				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS,"  candle2 = Check Energy Usage monthwise value matching ");



				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph1);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!     candle2 = The Energy Usage Monthwise graph is not matching");

				}
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle3 = Check Energy Usage monthwise value matching ");



				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph2);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!     candle3 =  The Energy Usage Monthwise graph is not matching");
				}		

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle4 = Check Energy Usage monthwise value matching ");



				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph3);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"      Error!    candle4 =  The Energy Usage Monthwise graph is not matching");
				}		

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle5 = Check Energy Usage monthwise value matching ");



				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph4);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"      Error!    candle5 =  The Energy Usage Monthwise graph is not matching");
				}		

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle6 = Check Energy Usage monthwise value matching ");



				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph5);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"      Error!     candle6 = The Energy Usage Monthwise graph is not matching");
				}		

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle7 = Check Energy Usage monthwise value matching ");



				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph6);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!     candle7 = The Energy Usage Monthwise graph is not matching");
				}		
				rs.close();
				stmt.close();
			}

		}

		catch (FileNotFoundException e) {
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



	public  void CheckEnergyUsageDivisionWise(ExtentReports report17) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{
		WebElement clidiv=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[2]/app-energy-usage/div[2]/ul/li[3]/a"));
		clidiv.click();

		Thread.sleep(5000);

		WebElement EUgraph = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]"));

		String candiv1= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]")).getText();

		System.out.println("value:" +candiv1);


		WebElement EUgraph1 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[7]"));


		String candiv2= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[7]")).getText();

		System.out.println("value:" +candiv2);


		WebElement EUgraph2 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[8]"));

		String candiv3= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[8]")).getText();

		System.out.println("value:" +candiv3);


		WebElement EUgraph3 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[9]"));

		String candiv4= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[9]")).getText();

		System.out.println("value:" +candiv4);


		WebElement EUgraph4 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[10]"));

		String candiv5= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[10]")).getText();

		System.out.println("value:" +candiv5);



		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("EnergyUsageDivisionwise");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("Inside Energy Consumption 1.Verifying Average Kwh for Division Wise");

			ResultSet rs = stmt.executeQuery(Q2);


			while (rs.next())
			{      


				String col3 = rs.getString(4);

				System.out.println("Energy usage division wise graph "+ col3.replace(".", ""));
				logger=report17.createTest("Check -> Checking Energy usage division wise graph  ");
				logger.info("Starting Checking Energy usage division wise graph");
				logger.pass("Checking Energy usage division wise graph succesful");

				String val3=col3.replace(".", "");

				ArrayList<String> CDValues = new ArrayList<String>();
				CDValues.add(candiv1.replace(",", ""));
				CDValues.add(candiv2.replace(",", ""));
				CDValues.add(candiv3.replace(",", "")); 
				CDValues.add(candiv4.replace(",", ""));
				CDValues.add(candiv5.replace(",", ""));

				boolean found = false;
				for (String tempd : CDValues.subList(0, 5)) {

					if (tempd.replace(",", "").contains(val3)) {

						found = true;
						break;
					}
				}

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle 1 = Check Energy Usage division wise value matching ");


				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"    Error!    candle1 = The Energy Usage Divisionwise graph is not matching");
				}	


				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle2 = Check Energy Usage division wise value matching ");


				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph1);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   candle2 =  The Energy Usage Divisionwise graph is not matching");
				}		


				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle3 = Check Energy Usage division wise value matching ");


				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph2);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   candle3=  The Energy Usage Divisionwise graph is not matching");
				}		


				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle4 = Check Energy Usage division wise value matching ");


				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph3);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   candle4 = The Energy Usage Divisionwise graph is not matching");
				}		


				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle5 = Check Energy Usage division wise value matching ");


				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph4);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!    candle5 = The Energy Usage Divisionwise graph is not matching");
				}		

				rs.close();
				stmt.close();  


			}

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


	public  void CheckEnergyUsageSiteWise(ExtentReports report18) throws SQLException, FileNotFoundException, IOException, InterruptedException
	{

		WebElement clidiv=driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[2]/app-energy-usage/div[2]/ul/li[4]/a"));
		clidiv.click();

		Thread.sleep(4000);

		WebElement EUgraph1= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]"));
		String candsit1= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]")).getText();

		System.out.println("value:" +candsit1);



		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("EnergyUsageSitewise");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("Inside Energy Consumption 1.Verifying Average Kwh for Site Wise");

			ResultSet rs = stmt.executeQuery(Q2);


			while (rs.next())
			{      

				String col3 = rs.getString(3);

				System.out.println("Energy Usage SiteWise graph "+ col3.replace(".", ""));
				logger=report18.createTest("Check -> checking Energy Usage SiteWise graph  ");
				logger.info("Starting Energy Usage SiteWise graph ");
				logger.pass(" Energy Usage sitewise graph successful ");

				String val3=col3.replace(".", "");

				ArrayList<String> CSValues = new ArrayList<String>();
				CSValues.add(candsit1.replace(",", ""));


				boolean found = false;
				for (String tempd : CSValues.subList(0, 1)) {

					if (tempd.replace(",", "").contains(val3)) {

						found = true;
						break;
					}
				}

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle1 = Check Energy Usage sitewise value matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph1);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   candle1 = The Energy Usage Sitewise graph is not matching");

				}    

			}

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

	public  void EnergyUsageCostDaywiseGraph(ExtentReports report19) throws InterruptedException {

		//cost

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[2]/app-energy-usage/div[1]/div/ul/li[2]/a")).click();

		Thread.sleep(3000);

		//day wise
		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[2]/app-energy-usage/div[2]/ul/li[1]/a")).click();


		Thread.sleep(3000);

		WebElement  EUgraph1  = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]"));
		String candle1 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]")).getText();

		System.out.println("value:" +candle1);



		WebElement EUgraph2 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[7]"));

		String candle2= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[7]")).getText();

		System.out.println("value:" +candle2);


		WebElement EUgraph3 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[8]"));

		String candle3= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[8]")).getText();

		System.out.println("value:" +candle3);



		WebElement EUgraph4 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[9]"));

		String candle4= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[9]")).getText();

		System.out.println("value:" +candle4);



		WebElement EUgraph5 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[10]"));

		String candle5= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[10]")).getText();

		System.out.println("value:" +candle5);



		WebElement EUgraph6 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[11]"));

		String candle6= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[11]")).getText();

		System.out.println("value:" +candle6);


		WebElement EUgraph7 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[12]"));

		String candle7= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[12]")).getText();

		System.out.println("value:" +candle7);

		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("EnergyUsageCostDaywiseGraph");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Energy Usage Cost Day wise Graph 1.Verifying Energy Usage Cost Day wise Graph value ");

			ResultSet rs = stmt.executeQuery(Q2);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1



			System.out.println("No of columns"+numberOfColumns);




			while(rs.next())
			{
				String col1 = rs.getString(1);


				System.out.println("Energy Usage Cost Daywise Graph value: col1 "+col1);

				logger=report19.createTest("Check -> checking Energy Usage Cost Daywise Graph ");
				logger.info("Starting Energy Usage Cost Daywise Graph ");
				logger.pass(" Energy Usage Cost Daywise Graph successful ");



				String val3=col1.replace(".", "");

				ArrayList<String> CDValues = new ArrayList<String>();
				CDValues.add(candle1.replace(",", ""));
				CDValues.add(candle2.replace(",", ""));
				CDValues.add(candle3.replace(",", "")); 
				CDValues.add(candle4.replace(",", ""));
				CDValues.add(candle5.replace(",", ""));
				CDValues.add(candle6.replace(",", ""));
				CDValues.add(candle7.replace(",", ""));



				boolean found = false;
				for (String tempd : CDValues.subList(0, 1)) {

					if (tempd.replace(",", "").contains(val3)) {

						found = true;
						break;
					}
				}

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle1 = Energy Usage Cost Daywise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph1);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle1 = The Energy Usage Cost Daywise Graph value is not matching");

				}    

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle2 = Energy Usage Cost Daywise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph2);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   candle2 = The Energy Usage Cost Daywise Graph value is not matching");

				}    

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle3 = Energy Usage Cost Daywise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph3);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   candle3 = The Energy Usage Cost Daywise Graph value is not matching");

				}

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle4 = Energy Usage Cost Daywise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph4);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   candle4 = The Energy Usage Cost Daywise Graph value is not matching");

				}  

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle5 = Energy Usage Cost Daywise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph5);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!   candle5 = The Energy Usage Cost Daywise Graph value is not matching");

				} 
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle6 = Energy Usage Cost Daywise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph6);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle6 = The Energy Usage Cost Daywise Graph value is not matching");

				}  

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle7 = Energy Usage Cost Daywise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph7);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle7 = The Energy Usage Cost Daywise Graph value is not matching");

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

	public  void EnergyUsageCostMonthWiseGraph(ExtentReports report20) throws InterruptedException {


		//cost


		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[2]/app-energy-usage/div[1]/div/ul/li[2]/a")).click();

		Thread.sleep(3000);


		// month wise 

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[2]/app-energy-usage/div[2]/ul/li[2]/a")).click();

		Thread.sleep(3000);



		WebElement EUgraph1 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]"));

		String candle1= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]")).getText();

		System.out.println("value:" +candle1);



		WebElement EUgraph2 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[7]"));


		String candle2= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[7]")).getText();

		System.out.println("value:"+candle2);



		WebElement EUgraph3 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[8]"));

		String candle3= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[8]")).getText();

		System.out.println("value:"+candle3);


		WebElement EUgraph4 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[9]"));

		String candle4= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[9]")).getText();

		System.out.println("value:"+candle4);


		WebElement EUgraph5 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[10]"));

		String candle5= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[10]")).getText();


		System.out.println("value:" +candle5);



		WebElement EUgraph6 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[11]"));

		String candle6= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[11]")).getText();

		System.out.println("value:"+candle6);



		WebElement EUgraph7 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[12]"));

		String candle7= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[12]")).getText();

		System.out.println("value:"+candle7);



		WebElement EUgraph8 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[13]"));

		String candle8= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[13]")).getText();


		System.out.println("value:" +candle8);


		WebElement EUgraph9 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[14]"));

		String candle9= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[14]")).getText();

		System.out.println("value:"+candle9);



		WebElement EUgraph10 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[15]"));

		String candle10= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[15]")).getText();

		System.out.println("value:"+candle10);



		WebElement EUgraph11 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[16]"));

		String candle11= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[16]")).getText();

		System.out.println("value:"+candle11);


		WebElement EUgraph12 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[17]"));


		String candle12= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[17]")).getText();


		System.out.println("value:" +candle12);



		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("EnergyUsageCostMonthWiseGraph");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Energy Usage Cost Month wise Graph 1.Verifying Energy Usage Cost Month wise Graph value ");

			ResultSet rs = stmt.executeQuery(Q2);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1



			System.out.println("No of columns"+numberOfColumns);




			while(rs.next())
			{
				String col1 = rs.getString(1);


				System.out.println("Energy Usage Cost MonthWise Graph value: col1 "+col1);

				logger=report20.createTest("Check -> checking Energy Usage Cost MonthWise Graph   ");
				logger.info("Starting Energy Usage Cost MonthWise Graph  ");
				logger.pass(" Energy Usage Cost MonthWise Graph  successful ");



				String val3=col1.replace(".", "");

				ArrayList<String> CDValues = new ArrayList<String>();
				CDValues.add(candle1.replace(",", ""));
				CDValues.add(candle2.replace(",", ""));
				CDValues.add(candle3.replace(",", "")); 
				CDValues.add(candle4.replace(",", ""));
				CDValues.add(candle5.replace(",", ""));
				CDValues.add(candle6.replace(",", ""));
				CDValues.add(candle7.replace(",", ""));
				CDValues.add(candle8.replace(",", ""));
				CDValues.add(candle9.replace(",", ""));
				CDValues.add(candle10.replace(",", "")); 
				CDValues.add(candle11.replace(",", ""));
				CDValues.add(candle12.replace(",", ""));


				boolean found = false;
				for (String tempd : CDValues.subList(0, 1)) {

					if (tempd.replace(",", "").contains(val3)) {

						found = true;
						break;
					}
				}

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle1 = Energy Usage Cost Monthwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph1);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle1 = The Energy Usage Cost Monthwise Graph value is not matching");

				}  
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle2 = Energy Usage Cost Monthwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph2);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle2 = The Energy Usage Cost Monthwise Graph value is not matching");

				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle3 = Energy Usage Cost Monthwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph3);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle3 = The Energy Usage Cost Monthwise Graph value is not matching");

				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle4 = Energy Usage Cost Monthwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph4);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle4 = The Energy Usage Cost Monthwise Graph value is not matching");

				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle5 = Energy Usage Cost Monthwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph5);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle5 = The Energy Usage Cost Monthwise Graph value is not matching");

				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle6 = Energy Usage Cost Monthwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph6);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle6 = The Energy Usage Cost Monthwise Graph value is not matching");

				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle7 = Energy Usage Cost Monthwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph7);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle7 = The Energy Usage Cost Monthwise Graph value is not matching");

				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle8 = Energy Usage Cost Monthwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph8);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle8 = The Energy Usage Cost Monthwise Graph value is not matching");

				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle9 = Energy Usage Cost Monthwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph9);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle9 = The Energy Usage Cost Monthwise Graph value is not matching");

				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle10 = Energy Usage Cost Monthwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph10);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle10 = The Energy Usage Cost Monthwise Graph value is not matching");

				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle11 = Energy Usage Cost Monthwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph11);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle11 = The Energy Usage Cost Monthwise Graph value is not matching");

				}    
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle12 = Energy Usage Cost Monthwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph12);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle12 = The Energy Usage Cost Monthwise Graph value is not matching");

				}   




				rs.close();
				stmt.close();


			}

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

	public void EnergyUsageCostDivisionWiseGraph(ExtentReports report21) throws InterruptedException {


		//cost


		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[2]/app-energy-usage/div[1]/div/ul/li[2]/a")).click();


		Thread.sleep(3000);


		// Division wise

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[2]/app-energy-usage/div[2]/ul/li[3]/a")).click();

		Thread.sleep(3000);


		WebElement EUgraph1 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]"));

		String candle1= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]")).getText();


		System.out.println("value:" +candle1);


		WebElement EUgraph2 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[7]"));


		String candle2= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[7]")).getText();

		System.out.println("value:"+candle2);



		WebElement EUgraph3 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[8]"));

		String candle3= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[8]")).getText();

		System.out.println("value:"+candle3);


		WebElement EUgraph4 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[9]"));


		String candle4= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[9]")).getText();

		System.out.println("value:"+candle4);



		WebElement EUgraph5 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[10]"));

		String candle5= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[10]")).getText();


		System.out.println("value:" +candle5);



		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("EnergyUsageCostDivisionWiseGraph");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Energy Usage Cost Division wise Graph 1.Verifying Energy Usage Cost Division wise Graph value ");

			ResultSet rs = stmt.executeQuery(Q2);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			//get the column names; column indexes start from 1



			System.out.println("No of columns"+numberOfColumns);




			while(rs.next())
			{
				String col1 = rs.getString(1);

				System.out.println("Energy Usage Cost DivisionWise Graph value: col1 "+col1);

				logger=report21.createTest("Check -> checking Energy Usage Cost DivisionWise Graph  ");
				logger.info("Starting Energy Usage Cost DivisionWise Graph ");
				logger.pass(" Energy Usage Cost DivisionWise Graph successful ");



				String val3=col1.replace(".", "");

				ArrayList<String> CDValues = new ArrayList<String>();
				CDValues.add(candle1.replace(",", ""));
				CDValues.add(candle2.replace(",", ""));
				CDValues.add(candle3.replace(",", "")); 
				CDValues.add(candle4.replace(",", ""));
				CDValues.add(candle5.replace(",", ""));



				boolean found = false;
				for (String tempd : CDValues.subList(0, 1)) {

					if (tempd.replace(",", "").contains(val3)) {

						found = true;
						break;
					}
				}

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle1 = Energy Usage Cost Divisionwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph1);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle1 = The Energy Usage Cost Divisionwise Graph value is not matching");

				} 
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle2 = Energy Usage Cost Divisionwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph2);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle2 = The Energy Usage Cost Divisionwise Graph value is not matching");

				}  

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle3 =Energy Usage Cost Divisionwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph3);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle3 = The Energy Usage Cost Divisionwise Graph value is not matching");

				}  

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle4 = Energy Usage Cost Divisionwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph4);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle4 = The Energy Usage Cost Divisionwise Graph value is not matching");

				}  

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle5 = Energy Usage Cost Divisionwise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph5);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle5 = The Energy Usage Cost Divisionwise Graph value is not matching");

				} 


				rs.close();
				stmt.close();
			}



		} catch (FileNotFoundException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 


	public void EnergyUsageCostSiteWiseGraph(ExtentReports report22) throws InterruptedException {


		//cost


		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[2]/app-energy-usage/div[1]/div/ul/li[2]/a")).click();


		Thread.sleep(3000);


		// Site wise

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[1]/div[2]/app-energy-usage/div[2]/ul/li[4]/a")).click();

		Thread.sleep(3000);



		WebElement EUgraph1 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]"));

		String candle1= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[2]//*[name()='text'])[6]")).getText();


		System.out.println("value:" +candle1);


		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("EnergyUsageCostSiteWiseGraph");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside Energy Usage Cost Site wise Graph 1.Verifying Energy Usage Cost Site wise Graph value ");

			ResultSet rs = stmt.executeQuery(Q2);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			//get the column names; column indexes start from 1



			System.out.println("No of columns"+numberOfColumns);




			while(rs.next())
			{
				String col1 = rs.getString(1);

				System.out.println("Energy Usage Cost SiteWise Graph value: col1 "+col1);

				logger=report22.createTest("Check -> checking Energy Usage Cost SiteWise Graph  ");
				logger.info("Starting Energy Usage Cost SiteWise Graph ");
				logger.pass("Energy Usage Cost SiteWise Graph successful ");



				String val3=col1.replace(".", "");

				ArrayList<String> CDValues = new ArrayList<String>();
				CDValues.add(candle1.replace(",", ""));



				boolean found = false;
				for (String tempd : CDValues.subList(0, 1)) {

					if (tempd.replace(",", "").contains(val3)) {

						found = true;
						break;
					}
				}



				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle1 = Energy Usage Cost SiteWise Graph value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph1);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle1 = The Energy Usage Cost SiteWise Graph value is not matching");

				} 


				rs.close();
				stmt.close();

			}




		}catch (FileNotFoundException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	public  void MaximumDemandMain(ExtentReports report23) {

		// for main 

		List<WebElement> graphlist = driver.findElements(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='path'])[21]"));	


		Actions act = new Actions(driver);

		for (WebElement e1 : graphlist) {

			act.doubleClick(e1).moveToElement(e1).build().perform();

			System.out.println("moving point :"+e1.getText()); 					 


			WebElement EUgraph = driver.findElement(By.xpath("//div[@id=\\\"DemandMain\\\"]"));

			String point2= driver.findElement(By.xpath("//div[@id=\"DemandMain\"]")).getText();

			System.out.println("value:"+point2);	


			try {


				Properties prop = new Properties();
				prop.load(new FileInputStream("C:\\plaftform-QA\\src\\main\\java\\KloudqTechnologies\\config\\config.properties"));

				String Q2=prop.getProperty("MaximumDemandMain");
				Connection conn = DriverManager.getConnection(url,user,password);
				Statement stmt = conn.createStatement();
				System.out.println("Inside MaximumDemandMain Graph 1.Verifying MaximumDemandMain Graph value ");

				ResultSet rs = stmt.executeQuery(Q2);


				java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
				int numberOfColumns = rsMetaData.getColumnCount();

				//get the column names; column indexes start from 1



				System.out.println("No of columns"+numberOfColumns);




				while(rs.next())
				{
					String col1 = rs.getString(1);


					System.out.println("Maximum Demand Main Graph value: col1 "+col1);

					logger=report23.createTest("Check -> checking Maximum Demand Main Graph  ");
					logger.info("Starting Maximum Demand Main Graph ");
					logger.pass("Maximum Demand Main Graph successful ");



					String val3=col1.replace(".", "");

					ArrayList<String> CDValues = new ArrayList<String>();
					CDValues.add(point2.replace(",", ""));



					boolean found = false;
					for (String tempd : CDValues.subList(0, 1)) {

						if (tempd.replace(",", "").contains(val3)) {

							found = true;
							break;
						}
					}

					if (found) {
						System.out.println("**** Match Found ***");
						logger.log(Status.PASS,"Maximum Demand Main Graph value is matching");

					} else {
						System.out.println("**** No Match Found ****");
						highLighterMethod(driver, EUgraph);
						String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

						logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  The Maximum Demand Main Graph value is not matching");

					} 






					rs.close();
					stmt.close();

				}}




			catch (FileNotFoundException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}
	public  void MaximumDemandIND(ExtentReports report24) throws InterruptedException {


		// 	for IND

		driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/app-tor-lenz/div/app-energy-lenz/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div/ul/li[2]/a")).click();

		Thread.sleep(3000);


		WebElement EUgraph1 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[6]"));

		String candle1= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[6]")).getText();

		System.out.println("value:"+candle1);



		WebElement EUgraph2 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[7]"));

		String candle2= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[7]")).getText();

		System.out.println("value:"+candle2);



		WebElement EUgraph3 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[8]"));

		String candle3= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[8]")).getText();

		System.out.println("value:"+candle3);



		WebElement EUgraph4 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[9]"));

		String candle4= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[9]")).getText();

		System.out.println("value:"+candle4);



		WebElement EUgraph5 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[10]"));

		String candle5= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[10]")).getText();

		System.out.println("value:"+candle5);



		WebElement EUgraph6 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[11]"));

		String candle6= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[11]")).getText();

		System.out.println("value:"+candle6);



		WebElement EUgraph7 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[12]"));

		String candle7= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[12]")).getText();

		System.out.println("value:"+candle7);



		WebElement EUgraph8 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[13]"));

		String candle8= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[13]")).getText();

		System.out.println("value:"+candle8);




		WebElement EUgraph9 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[14]"));

		String candle9= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[14]")).getText();

		System.out.println("value:"+candle9);



		WebElement EUgraph10 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[15]"));

		String candle10= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[15]")).getText();

		System.out.println("value:"+candle10);




		WebElement EUgraph11 = driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[16]"));

		String candle11= driver.findElement(By.xpath("((//*[name()='svg' and @class='highcharts-root'])[4]//*[name()='text'])[16]")).getText();

		System.out.println("value:"+candle11);


		try {


			Properties prop = new Properties();
			prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));

			String Q2=prop.getProperty("MaximumDemandIND");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			System.out.println("Inside  MaximumDemandIND Graph 1.Verifying  MaximumDemandIND Graph value ");

			ResultSet rs = stmt.executeQuery(Q2);


			java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
			int numberOfColumns = rsMetaData.getColumnCount();

			//get the column names; column indexes start from 1



			System.out.println("No of columns"+numberOfColumns);




			while(rs.next())
			{
				String col1 = rs.getString(1);


				System.out.println( "Maximum Demand IND Graph value: col1 "+col1);

				logger=report24.createTest("Check -> checking Maximum Demand IND Graph   ");
				logger.info("Starting Maximum Demand IND Graph  ");
				logger.pass("Maximum Demand IND Graph  successful ");



				String val3=col1.replace(".", "");

				ArrayList<String> CDValues = new ArrayList<String>();
				CDValues.add(candle1.replace(",", ""));
				CDValues.add(candle2.replace(",", ""));
				CDValues.add(candle3.replace(",", ""));
				CDValues.add(candle4.replace(",", ""));
				CDValues.add(candle5.replace(",", ""));
				CDValues.add(candle6.replace(",", ""));
				CDValues.add(candle7.replace(",", ""));
				CDValues.add(candle8.replace(",", ""));
				CDValues.add(candle9.replace(",", ""));
				CDValues.add(candle10.replace(",", ""));
				CDValues.add(candle11.replace(",", ""));




				boolean found = false;
				for (String tempd : CDValues.subList(0, 1)) {

					if (tempd.replace(",", "").contains(val3)) {

						found = true;
						break;
					}
				}

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS,"candle1 =  Maximum Demand IND Graph  value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph1);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle1 = The Maximum Demand IND Graph  value is not matching");

				} 
				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle2 = Maximum Demand IND Graph  value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph2);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle2 = The Maximum Demand IND Graph  value is not matching");

				} 

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle3 = Maximum Demand IND Graph  value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph3);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle3 = The Maximum Demand IND Graph  value is not matching");

				} 

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle4 = Maximum Demand IND Graph  value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph4);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle4= The Maximum Demand IND Graph  value is not matching");

				} 

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle5 = Maximum Demand IND Graph  value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph5);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle5 = The Maximum Demand IND Graph  value is not matching");

				} 

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle6 = Maximum Demand IND Graph  value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph6);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle6= The Maximum Demand IND Graph  value is not matching");

				} 

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle7 = Maximum Demand IND Graph  value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph7);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle7= The Maximum Demand IND Graph  value is not matching");

				} 

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle8 = Maximum Demand IND Graph  value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph8);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error! candle8 =  The Maximum Demand IND Graph  value is not matching");

				} 

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle9 = Maximum Demand IND Graph  value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph9);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle9 = The Maximum Demand IND Graph  value is not matching");

				} 

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle10 = Maximum Demand IND Graph  value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph10);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle10 = The Maximum Demand IND Graph  value is not matching");

				} 

				if (found) {
					System.out.println("**** Match Found ***");
					logger.log(Status.PASS," candle11 = Maximum Demand IND Graph  value is matching");

				} else {
					System.out.println("**** No Match Found ****");
					highLighterMethod(driver, EUgraph11);
					String screenshotPath = DashboardShield.takeScreenshotAtEndOfTest(driver);

					logger.log(Status.FAIL,logger.addScreenCaptureFromPath(screenshotPath)+"     Error!  candle11 = The Maximum Demand IND Graph  value is not matching");

				} 









				rs.close();
				stmt.close();

			}}




		catch (FileNotFoundException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.get(dir);
	} 




	public void teardown() {
		report.flush();
	}



}