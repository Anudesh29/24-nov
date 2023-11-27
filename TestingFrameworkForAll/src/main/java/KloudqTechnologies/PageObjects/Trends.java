package KloudqTechnologies.PageObjects;

import java.sql.Date;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import KloudqTechnologies.AbstractComponents.AbstractComponent;

public class Trends extends AbstractComponent {

	public Trends(WebDriver driver) {
		super(driver);

		this.driver=driver;

		PageFactory.initElements(driver,this);
	}
	public void ClickTrendsTab() 
	{
		WebElement clickTrendsTab=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[4]/a"));
		clickTrendsTab.click();
		URLCheck();

	}

	public void ClickReportsShieldHistoryTab() 
	{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");

		//Switch to new tab 
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://shield.tor-iot.com/tor-lenz/energy/energy-reports/lenz-parameter-history");

		//		WebElement clickReportsTab=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]"));
		//		clickReportsTab.click();
		//		
		//		WebElement clickShieldHistory=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div[6]/div/div[2]/div/div/div[4]/div/div/div[35]"));
		//		clickShieldHistory.click();
		//Open new tab
		System.out.println("ClickReportsShieldHistoryTab");

	}

	public void URLCheck() 
	{		
		String url = "https://shield.tor-iot.com/reports/trends";
		driver.get(url);		      
		// get the current URL
		String strUrl = driver.getCurrentUrl();
		//Print the URL
		System.out.println("Current URL : "+strUrl);


	}
	String dir = System.getProperty("user.dir")+"\\Reports\\ShieldTest1.html";
	private ExtentTest logger;
	private ExtentReports report;
	public void Search(ExtentReports reportheader)
	{
		System.out.println("Starting Search function");
		WebElement selectsite = driver.findElement(By.className("ng-select-container"));
		selectsite.click();
		WebElement selectKTL = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div[3]")); 
		selectKTL.click();


		WebElement selectequip = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[2]/ng-select"));
		selectequip.click();
		WebElement select73000059 = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[2]")); 
		select73000059.click();




		//Selecting Consumption,Frequency ,RPhase Voltage
		WebElement selectparam1=driver.findElement(By.xpath("//*[@id=\"Consumption\"]"));
		selectparam1.click();



		WebElement selectparam2=driver.findElement(By.xpath("//*[@id=\"Frequency\"]"));
		selectparam2.click();


		WebElement selectparam3=driver.findElement(By.xpath("//*[@id=\"R_Phase_Voltage\"]"));
		selectparam3.click();


		WebElement clickFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		clickFilter.click();
		System.out.println("Selecting Consumption ,Frequency ,RPhase Voltage");

		logger=reportheader.createTest("Check -> Trends Search Function Graph ");
		logger.info("Graph Visibility Test");
		logger.pass("Visibility Test Success");

		boolean highchartdisplay = driver.findElement(By.className("highcharts-background")).isDisplayed();
		if (highchartdisplay) {
			System.out.println("High Chart is displaying");
			logger.log(Status.PASS,"Graph of High Chart is Visible");
		} else {
			System.out.println("High Chart is not displaying");
			logger.log(Status.FAIL,"Graph of High Chart is not Visible");
		} 

		WebElement highchart = driver.findElement(By.className("highcharts-background"));

		//Instantiating Actions class
		Actions actions = new Actions(driver);

		//Hovering on main menu
		actions.moveToElement(highchart);
		// Locating the element from Sub Menu
		WebElement subMenu = driver.findElement(By.className("highcharts-markers"));


		//build()- used to compile all the actions into a single step 
		actions.moveByOffset(280, 400) ;   
		actions.perform();

	}
	public void DateFunction(ExtentReports report1) throws InterruptedException {


		//Checking the graph for one sing;e date
		//We need to add time for day 1 if 18 Oct 2023
		//If we take time 10:00 then in date selector we will add 5.30 hours to it to TO and FROM date time 2 seconds time
		//added time will be selected in the Date Time Selector in Shield History

		//We need to add time for day 1 if 18 Oct 2023
		//If we take time 10:00 then in date selector TO and FROM date time 2 seconds time date time 2 seconds time
		//added time will be selected in the Date Time Selector in Trends

		//Then we can verify the date exact graph 


		System.out.println("Starting Date function");
		WebElement selectsite = driver.findElement(By.className("ng-select-container"));
		selectsite.click();
		WebElement selectKTL = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div[3]")); 
		selectKTL.click();
		System.out.println("Selected KTL ");

		WebElement selectequip = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[2]/ng-select"));
		selectequip.click();
		WebElement select73000059 = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div[2]")); 
		select73000059.click();
		System.out.println("Selected Device ");

		WebElement dateselectoricon=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[3]/app-custom-date-time-range/div[2]/div[2]/label[1]/span/i"));
		dateselectoricon.click();


		String  actualmonth=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[1]/div/button")).getText();
		String  actualyear=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[1]/div/button")).getText();
		System.out.println("Selected actual month and year ");

		if (actualmonth.equals("Oct 2023")) 
		{
			System.out.println("In If loop ");
			//driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-1\"]/div[2]/owl-date-time-calendar/div[1]/button[1]")).click();
			actualmonth=driver.findElement(By.className("owl-dt-calendar-main")).getText();
			// actualyear=driver.findElement(By.className("owl-dt-control owl-dt-control-button owl-dt-control-period-button")).getText();
		}
		//Thread.sleep(3000);
		//	WebElement selectdateinCalendar=driver.findElement(By.xpath("//span[contains(.,'18')]"));
		WebElement selectdateinCalendar=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/owl-date-time-container/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[3]/td[4]/span"));
		//		
		//((JavascriptExecutor) driver).executeScript("arguments[0].value='18'", selectdateinCalendar); 

		Actions actions = new Actions(driver);  
		actions.moveToElement(selectdateinCalendar).click().build().perform();
		selectdateinCalendar.click();

		System.out.println(selectdateinCalendar.getText());
		Thread.sleep(3000);

		WebElement enterhour=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[1]/label/input"));
		enterhour.click();
		JavascriptExecutor jhour = (JavascriptExecutor)driver;
		jhour.executeScript("arguments[0].value='10';", enterhour);
		System.out.println("Value Hour entered is: " +enterhour.getAttribute("value"));

		WebElement hourdownarr=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[2]/label/input"));
		hourdownarr.click();

		WebElement entermin=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[2]/label/input"));
		entermin.click();
		JavascriptExecutor jmin = (JavascriptExecutor)driver;
		jmin.executeScript("arguments[0].value='15';", entermin);
		System.out.println("Value Min entered is: " +entermin.getAttribute("value"));


		WebElement ClickTo=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/div[1]/div[2]/span/span[1]"));
		ClickTo.click();


		WebElement uparrowmin=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[2]/button[1]"));
		uparrowmin.click();
		uparrowmin.click();


		WebElement btnSet=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/owl-date-time-container/div[2]/div[2]/button[2]"));
		btnSet.click();


		//Selecting Consumption,Frequency ,KVAH
		WebElement selectparam1=driver.findElement(By.xpath("//*[@id=\"Consumption\"]"));
		selectparam1.click();

		WebElement selectparam2=driver.findElement(By.xpath("//*[@id=\"Frequency\"]"));
		selectparam2.click();

		WebElement selectparam3=driver.findElement(By.xpath("//*[@id=\"kVAH\"]"));
		selectparam3.click();
		Thread.sleep(2000);

		WebElement btnFilter=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[5]/button"));
		btnFilter.click();

		Thread.sleep(3000);
		System.out.println("Graph will be displayed");

		logger=report1.createTest("Check -> The Date Function Graph for Trends");
		logger.info("Graph Visibility Test");
		logger.pass("Visibility Test Success");
		WebElement svgGraph = driver.findElement(By.className("highcharts-root"));

		boolean isDisplayed = svgGraph.isDisplayed();
		if (isDisplayed) 
		{
			System.out.println("The Date function graph for Trends is visible.");
			logger.log(Status.PASS,"Date function graph for Trends is Visible");
		} else {
			System.out.println("The Date function graph for Trends is not visible.");
			logger.log(Status.FAIL,"Date function graph for Trends is not Visible");
		}




		WebElement graph1value=driver.findElement(By.xpath("(//*[name()='svg' and @class=\"highcharts-root\"]//*[name()='path'])[18]"));
		//Actions actions2 = new Actions(driver);  



		WebElement elem = driver.findElement(By.xpath("//*[name()='svg' and @class=\"highcharts-root\"]//*[name()='g'][2]"));
		new Actions(driver).moveToElement(elem).clickAndHold().build().perform();



		String gvalstor1=graph1value.getText();
		System.out.println("Point 1 value on Graph: "+gvalstor1);



	}
	public void OpenShieldHistory() {

		//--------------------Shield History Page------------------------------
		System.out.println("Shield History Page");

		ClickReportsShieldHistoryTab();

		//Going to Shield History Page


		WebElement selectsiteSH = driver.findElement(By.className("ng-select-container"));
		selectsiteSH.click();

		WebElement selectKTLSH = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-lenz-parameter-history/div/div[2]/div/div/div/div/form/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div[3]")); 
		selectKTLSH.click();

		WebElement selectequip=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div[2]/ng-select/div/div/div[2]/input"));
		selectequip.click();
		selectequip.sendKeys("23-1");

		WebElement select23=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-tor-lenz/div/app-energy/app-energy-reports/app-lenz-parameter-history/div/div[2]/div/div/div/div/form/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		select23.click();

		WebElement Daily=driver.findElement(By.xpath("//*[@id=\"Daily\"]"));
		Daily.click();

		WebElement dateselectoriconSH=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/app-custom-date-time-range/div[2]/div[2]/label[1]/span/i"));
		dateselectoriconSH.click();


		WebElement selectdateCMSH=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[3]/td[4]"));
		selectdateCMSH.click();

		WebElement enterhourSH=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[1]/label/input"));

		enterhourSH.sendKeys("03");

		WebElement enterminSH=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[2]/label/input"));
		enterminSH.sendKeys("30");

		//Select 18 october again

		selectdateCMSH.click();
		enterhourSH.sendKeys("03");
		enterminSH.sendKeys("32");

		WebElement btnSetSH=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/div[2]/button[2]"));
		btnSetSH.click();

		WebElement btnFilterSH=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btnFilterSH.click();
	}

	public void CompareDate(ExtentReports report2) throws InterruptedException 
	{

		System.out.println("Starting Compare Date function");
		WebElement selectsite = driver.findElement(By.className("ng-select-container"));
		selectsite.click();
		WebElement selectKTL = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div[3]")); 
		selectKTL.click();
		System.out.println("Selected KTL ");

		WebElement selectequip = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[2]/ng-select"));
		selectequip.click();

		WebElement inputclick = driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[2]/ng-select/div/div/div[2]/input"));
		inputclick.click();

		inputclick.sendKeys("23-1");
		Thread.sleep(1000);

		WebElement select231 = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		select231.click();

		System.out.println("Selected Device ");

		WebElement dateselectoricon=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[3]/app-custom-date-time-range/div[2]/div[2]/label[1]/span/i"));
		dateselectoricon.click();


		String  actualmonth=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[1]/div/button")).getText();
		String  actualyear=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[1]/div/button")).getText();
		System.out.println("Selected actual month and year ");

		if (actualmonth.equals("Oct 2023")) 
		{
			System.out.println("In If loop ");
			//driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-1\"]/div[2]/owl-date-time-calendar/div[1]/button[1]")).click();
			actualmonth=driver.findElement(By.className("owl-dt-calendar-main")).getText();
			// actualyear=driver.findElement(By.className("owl-dt-control owl-dt-control-button owl-dt-control-period-button")).getText();
		}

		WebElement selectdateinCalendar=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/owl-date-time-container/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[3]/td[4]/span"));

		Actions actions = new Actions(driver);  
		actions.moveToElement(selectdateinCalendar).click().build().perform();
		selectdateinCalendar.click();

		System.out.println(selectdateinCalendar.getText());
		Thread.sleep(3000);

		WebElement enterhour=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[1]/label/input"));
		enterhour.click();
		JavascriptExecutor jhour = (JavascriptExecutor)driver;
		jhour.executeScript("arguments[0].value='10';", enterhour);
		System.out.println("Value Hour entered is: " +enterhour.getAttribute("value"));

		WebElement hourdownarr=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[2]/label/input"));
		hourdownarr.click();

		WebElement entermin=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[2]/label/input"));
		entermin.click();
		JavascriptExecutor jmin = (JavascriptExecutor)driver;
		jmin.executeScript("arguments[0].value='15';", entermin);
		System.out.println("Value Min entered is: " +entermin.getAttribute("value"));


		WebElement ClickTo=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/div[1]/div[2]/span/span[1]"));
		ClickTo.click();


		WebElement uparrowmin=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-timer/owl-date-time-timer-box[2]/button[1]"));
		uparrowmin.click();
		uparrowmin.click();

		WebElement btnSet=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/owl-date-time-container/div[2]/div[2]/button[2]"));
		btnSet.click();

		WebElement checkboxcompare=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[4]/input"));
		checkboxcompare.click();

		WebElement selectcompareequip=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[5]/div[1]/ng-select/div"));
		selectcompareequip.click();
		WebElement inputcompclick = driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[5]/div[1]/ng-select/div/div/div[2]/input"));
		inputcompclick.click();

		inputclick.sendKeys("23-1");
		Thread.sleep(1000);

		WebElement selectcomp231 = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[5]/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		selectcomp231.click();
		Thread.sleep(2000);

		WebElement selectcomparedateselector=driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[5]/div[2]/label[2]/span"));
		selectcomparedateselector.click();
		Thread.sleep(1000);
		WebElement select18date=driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-1\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[3]/td[4]"));
		select18date.click();

		WebElement btncompset=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/owl-date-time-container/div[2]/div/button[2]"));
		btncompset.click();

		//Selecting Consumption,Frequency ,KVAH
		WebElement selectparam1=driver.findElement(By.xpath("//*[@id=\"Consumption\"]"));
		selectparam1.click();

		WebElement selectparam2=driver.findElement(By.xpath("//*[@id=\"Frequency\"]"));
		selectparam2.click();

		WebElement selectparam3=driver.findElement(By.xpath("//*[@id=\"kVAH\"]"));
		selectparam3.click();

		WebElement btncomFilter=driver.findElement(By.xpath("//*[@id=\"kt_toolbar_primary_button\"]"));
		btncomFilter.click();
		logger=report2.createTest("Check -> The Compare Date Function Graph for Trends");
		logger.info("Graph Visibility Test");
		logger.pass("Visibility Test Success");

		WebElement svgGraph = driver.findElement(By.className("highcharts-root"));

		boolean isDisplayed = svgGraph.isDisplayed();
		if (isDisplayed)
		{
			System.out.println("The Compare Date Function Graph for Trends is visible.");
			logger.log(Status.PASS,"Compare Date Function Graph for Trends is Visible");
		} 
		else {
			System.out.println("The Compare Date Function Graph for Trends is not visible.");
			logger.log(Status.FAIL,"Compare Date Function Graph for Trends is not Visible");
		}


	}
	public void CheckParameters(ExtentReports report3) throws InterruptedException {

		System.out.println("Starting Check Parameter function");
		WebElement selectsite = driver.findElement(By.className("ng-select-container"));
		selectsite.click();
		WebElement selectKTL = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div[3]")); 
		selectKTL.click();
		System.out.println("Selected KTL ");

		WebElement selectequip = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[2]/ng-select"));
		selectequip.click();

		WebElement inputclick = driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[2]/ng-select/div/div/div[2]/input"));
		inputclick.click();

		inputclick.sendKeys("23-1");
		Thread.sleep(1000);

		WebElement select231 = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		select231.click();

		System.out.println("Selected Device ");



		List<WebElement> listElement = driver.findElements(By.className("game-item"));
		for(int i =0;i<listElement.size();i++)
		{
			String elementText = listElement.get(i).getText(); 
			System.out.println(elementText); 
		}

		logger=report3.createTest("Check -> The parameter list for Trends");
		logger.info("Paramter List Visibility Test");
		logger.pass("Visibility Test Success");

		WebElement parameterlist = driver.findElement(By.className("game-item"));

		boolean isDisplayed = parameterlist.isDisplayed();
		if (isDisplayed) {
			System.out.println("The parameter list is visible.");
			logger.log(Status.PASS,"Compare Date Function Graph for Trends is Visible");
		} else
		{
			System.out.println("The parameter list is not visible.");
			logger.log(Status.FAIL,"Compare Date Function Graph for Trends is not Visible");
		}

		// using size() method
		int size = listElement.size();

		// Printing the size of List
		System.out.println("Size of list = " + size);


		if(size!=33){
			System.out.println("Parameter size is not matching " + size);
			logger.log(Status.FAIL,"Parameter size is not matching for Trends");
		}
		else
		{
			System.out.println("Parameter size not matching " + size);
			logger.log(Status.PASS,"Parameter size is matching for Trends");
		}



	}
	public void CheckToday(ExtentReports report4) throws InterruptedException {

		System.out.println("Starting Check Today Week Month function");
		WebElement selectsite = driver.findElement(By.className("ng-select-container"));
		selectsite.click();
		WebElement selectKTL = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div[3]")); 
		selectKTL.click();
		System.out.println("Selected KTL ");

		WebElement selectequip = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[2]/ng-select"));
		selectequip.click();

		WebElement inputclick = driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[2]/ng-select/div/div/div[2]/input"));
		inputclick.click();

		inputclick.sendKeys("23-1");
		Thread.sleep(1000);

		WebElement select231 = driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div"));
		select231.click();

		System.out.println("Selected Device ");	

		//Selecting Consumption,Frequency ,KVAH
		WebElement selectparam1=driver.findElement(By.xpath("//*[@id=\"Consumption\"]"));
		selectparam1.click();

		WebElement selectparam2=driver.findElement(By.xpath("//*[@id=\"Frequency\"]"));
		selectparam2.click();

		WebElement selectparam3=driver.findElement(By.xpath("//*[@id=\"kVAH\"]"));
		selectparam3.click();
		Thread.sleep(2000);

		WebElement selectToday = driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[3]/app-custom-date-time-range/div[2]/div[1]/div[1]/a"));
		selectToday.click();


		WebElement btnFilter=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[5]/button"));
		btnFilter.click();

		System.out.println("Selecting Consumption ,Frequency ,RPhase Voltage");

		logger=report4.createTest("Check -> The Today function for Trends");
		logger.info("Today function Visibility Test");
		logger.pass("Visibility Test Success");

		WebElement svgGraph = driver.findElement(By.className("highcharts-root"));

		boolean isDisplayed = svgGraph.isDisplayed();
		if (isDisplayed) 
		{
			System.out.println("The SVG graph for Today function for Trends is visible.");
			logger.log(Status.PASS,"The SVG graph for Today function for Trends is visible");

		} else {
			System.out.println("The SVG graph for Today function for Trends is not visible");
			logger.log(Status.FAIL,"The SVG graph for Today function for Trends is not visible");
		}



	}


	public void CheckWeek(ExtentReports report5) throws InterruptedException 
	{
		Thread.sleep(3000);
		WebElement selectWeek = driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[3]/app-custom-date-time-range/div[2]/div[1]/div[2]/a"));
		selectWeek.click();


		WebElement btnFilter=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[5]/button"));
		btnFilter.click();

		System.out.println("Selecting Consumption ,Frequency ,RPhase Voltage");

		logger=report5.createTest("Check -> The Week function for Trends");
		logger.info("Week function Visibility Test");
		logger.pass("Visibility Test Success");

		WebElement svgGraph = driver.findElement(By.className("highcharts-root"));

		boolean isDisplayed = svgGraph.isDisplayed();
		if (isDisplayed) {
			System.out.println("The SVG graph for Week is visible.");
			logger.log(Status.PASS,"The SVG graph for Week function for Trends is visible");
		} else {
			System.out.println("The SVG graph for Week is not visible.");
			logger.log(Status.FAIL,"The SVG graph for Week function for Trends is visible");
		}


	}

	public void CheckMonth(ExtentReports report6) throws InterruptedException {
		Thread.sleep(3000);
		WebElement selectMonth = driver.findElement(By.xpath("//*[@id=\"#kt_header_menu\"]/div/form/div/div[3]/app-custom-date-time-range/div[2]/div[1]/div[3]/a"));
		selectMonth.click();


		WebElement btnFilter=driver.findElement(By.xpath("/html/body/app-layout/div/div/div/div/div/app-content/app-reports/app-trends/div/div[1]/div/app-filter/div/div[2]/div/div/div/form/div/div[5]/button"));
		btnFilter.click();

		System.out.println("Selecting Consumption ,Frequency ,RPhase Voltage");

		logger=report6.createTest("Check -> The Month function for Trends");
		logger.info("Month function Visibility Test");
		logger.pass("Visibility Test Success");

		WebElement svgGraph = driver.findElement(By.className("highcharts-root"));

		boolean isDisplayed = svgGraph.isDisplayed();
		if (isDisplayed) {
			System.out.println("The SVG graph for Week is visible.");
			logger.log(Status.PASS,"The SVG graph for Month function for Trends is visible");
		} else {
			System.out.println("The SVG graph for Week is not visible.");
			logger.log(Status.FAIL,"The SVG graph for Month function for Trends is visible");
		}

//		driver.get(dir);
//	}
//
//	public void teardown() {
//		report.flush();
	}
}



