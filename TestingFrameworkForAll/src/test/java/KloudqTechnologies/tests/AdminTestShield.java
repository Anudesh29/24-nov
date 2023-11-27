package KloudqTechnologies.tests;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import KloudqTechnologies.JDBCConnection.ConnectJDBC;
import KloudqTechnologies.PageObjects.DashboardShield;
import KloudqTechnologies.PageObjects.Investigate;
import KloudqTechnologies.PageObjects.SLD;
import KloudqTechnologies.PageObjects.Trends;
import KloudqTechnologies.TestComponents.BaseTest;
import KloudqTechnologies.PageObjects.SECReportMaster;
import KloudqTechnologies.PageObjects.EquipmentDailykwh;
import KloudqTechnologies.PageObjects.EquipmentDailyConsp;
import KloudqTechnologies.PageObjects.EquipmentMonthlyConsp;
import KloudqTechnologies.PageObjects.DivisionDailyConsumption;
import KloudqTechnologies.PageObjects.DivisionMonthlyConsumption;
import KloudqTechnologies.PageObjects.CostDailyConsp;




public class AdminTestShield 
{

	ExtentTest logger;
	ExtentReports report;



	AdminTestShield()
	{
		ExtentHtmlReporter extent =new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ShieldTest1.html"));
		this.report=new ExtentReports();
		this.report.attachReporter(extent);

	}

	@Test(groups= {"Admin"},priority = 0)  
	public void Login() throws IOException, InterruptedException  
	{  

		System.out.println("Execute Login Component");

		LoginTestExcel lte=new LoginTestExcel();

		lte.getAdminUserDataShield(this.report);

		Thread.sleep(5000);

	}  

	@Test(groups= {"Admin"},priority = 1)  
	public void Dashboard() throws SQLException, FileNotFoundException, IOException, InterruptedException  
	{  

		ConnectJDBC sqlconnect=new ConnectJDBC();

		sqlconnect.Connect();

		DashboardShield DS=new DashboardShield(BaseTest.driver);
		DS.HeaderCheck(this.report);
		DS.CheckActualConsumptionToday(this.report);
		//DS.CheckCostOFActualPredToday(this.report);//-->this needs to be put id
		DS.CheckPowerFactor(this.report);
		DS.CheckAvgKwhToday(this.report);
		//		DS.CheckEnergyTreeToday(this.report);-->this needs to be put id

		DS.CheckEcActualPrYesterday(this.report);
		DS.CheckCostActualPrYesterday(this.report);
		DS.CheckAvgKwhYesterday(this.report);
		//		DS.CheckEnergyTreeYesterday(this.report);-->this needs to be put id	

		DS.CheckEcActualMonthly(this.report); 
		DS.CheckCostActualPredMonthly(this.report);
		DS.CheckAvgKwhMonthly(this.report);
		//		DS.CheckEnergyTreeMonthly(this.report);-->this needs to be put id

		//		DS.CheckEnegryConsumptionTrendGraph(this.report);-->this needs to be put id


		DS.CheckEnergyUsageDaywise(this.report);
		DS.CheckEnergyUsageMonthwise(this.report);
		DS.CheckEnergyUsageDivisionWise(this.report);
		DS.CheckEnergyUsageSiteWise(this.report);	

		//		DS.EnergyUsageCostDaywiseGraph(this.report);-->this needs to be put id
		DS.EnergyUsageCostMonthWiseGraph(this.report);
		DS.EnergyUsageCostDivisionWiseGraph(this.report);
		DS.EnergyUsageCostSiteWiseGraph(this.report);

		DS.MaximumDemandIND(this.report);
		DS.MaximumDemandMain(this.report);



		System.out.println("Executed Dashboard Component of Shield");

	}  

	@Test  (groups= {"Admin"},priority = 2)  
	public void SLD()  throws SQLException, FileNotFoundException, IOException, InterruptedException  {



		SLD SD =new SLD(BaseTest.driver);
		SD.SLDParentNodesCount(this.report);
		SD.SLDChildNodesCount(this.report);

		SD.SLDOnineStatus(this.report);
		SD.SLDOfflineStatus(this.report);

		SD.MachineSpecificationfrequency(this.report);
		SD.MachineSpecificationPowerFactor(this.report);
		SD.MachineSpecificationPower(this.report);
		SD.MachineSpecificationVoltage(this.report);
		SD.MachineSpecificationCurrent(this.report);
		//SD.MachineSpecificationVTHD(this.report);
		SD.MachineSpecificationCTHD(this.report);
		SD.MachineSpecificationStatus(this.report);


		System.out.println("Execute SLD Component");  

	}  

	@Test  (groups= {"Admin"},priority = 3)  
	public void Trends() throws InterruptedException  
	{  


		Trends TR=new Trends(BaseTest.driver);
		TR.ClickTrendsTab();
		TR.Search(this.report);
		//TR.DateFunction(this.report);//TODO-> Time Setting is giving issue over here also Graph hover value has to be fetched
    	//DONE->It is giving the data of 3mins of 18 date
		TR.OpenShieldHistory();

		//TR.CompareDate(this.report); //TODO->Bug- not able to set the Compare date
		TR.CheckParameters(this.report);
		//TR.CheckToday(this.report);//TODO->Not able to get the Value of ToolTip of Graph
		//TR.CheckWeek(this.report);//TODO->Not able to get the Value of ToolTip of Graph
		//TR.CheckMonth(this.report);//TODO->Not able to get the Value of ToolTip of Graph

		System.out.println("Executed Trends Component");

	}  
	@Test  (groups= {"Admin"},priority = 4)  
	public void Investigate() throws InterruptedException  
	{  
		Investigate IT=new Investigate(BaseTest.driver);
		//	IT.ClickInvestigateTab();
		//		IT.DeviceIDVerification(this.report);//TODO->To check the voltage and Current with exact match
		//		IT.Date(this.report);AlertsDisplay
		IT.TodayFunction(this.report);
    	IT.WeekFunction(this.report);
		IT.MonthFunction(this.report);
		IT.AlertsDisplay(this.report);
		//IT.twohours();

		System.out.println("Executed Investigate Component"); 


	}  
	@Test  (groups= {"Admin"},priority = 5)  
	public void SECReportMaster() throws InterruptedException  
	{  
		SECReportMaster report1 =new SECReportMaster(BaseTest.driver);

		//report1.SECReortandProductMaster(this.report); //ToDo= date picker is not inspect need to verify after diployment 
		//report1.SECReortexport(this.report);  //ToDo= need to verify 1 method 1st

		System.out.println("Executed Reports Component");  
	}

	@Test  (groups= {"Admin"},priority = 6)  
	public void EquipmentDailykwh() throws InterruptedException, FileNotFoundException, SQLException, IOException  
	{  
		EquipmentDailykwh report2 =new EquipmentDailykwh(BaseTest.driver);

		report2.EqipmentDailykwhExport(this.report);

		System.out.println("Executed Reports Component");  


	}
	@Test  (groups= {"Admin"},priority = 7)  
	public void EquipmentDailyConsp() throws FileNotFoundException, SQLException, IOException, InterruptedException
	{  
		EquipmentDailyConsp report3 =new EquipmentDailyConsp(BaseTest.driver);

		report3.EquipmentDailyConspExport(this.report);

		System.out.println("Executed Reports Component");  

	}
	@Test  (groups= {"Admin"},priority = 8)  
	public void EquipmentMonthlyConsp() throws FileNotFoundException, SQLException, IOException, InterruptedException
	{  


		EquipmentMonthlyConsp report4 =new EquipmentMonthlyConsp(BaseTest.driver);

		report4.EquipmentMonthlyConspExport(this.report);



		System.out.println("Executed Reports Component");  

	}
	@Test  (groups= {"Admin"},priority = 8)  
	public void DivisionDailyConsumption() throws FileNotFoundException, SQLException, IOException, InterruptedException 
	{  
		
		DivisionDailyConsumption report5 =new DivisionDailyConsumption(BaseTest.driver);

		report5.DivisionDailyConsumptionExport(this.report);

		
		System.out.println("Executed Reports Component");  

	}

	@Test  (groups= {"Admin"},priority = 9)  
	public void DivisionMonthlyConsumption() throws FileNotFoundException, SQLException, IOException, InterruptedException 
   {  

		DivisionMonthlyConsumption report6 =new DivisionMonthlyConsumption(BaseTest.driver);

		report6.DivisionMonthlyConsumptionExport(this.report);


		System.out.println("Executed Reports Component");  

	}
	@Test  (groups= {"Admin"},priority = 10)  
	public void CostDailyConsp() throws FileNotFoundException, SQLException, IOException, InterruptedException 
	{  


		CostDailyConsp report7 =new CostDailyConsp(BaseTest.driver);

		report7.CostDailyConspExport(this.report);
		

		System.out.println("Executed Reports Component");  




	}

	@Test  (groups= {"Admin"},priority = 11)  
	public void Administarator() 
	{  


		System.out.println("Executed Administrator Component");  



		report.flush();

	}

}  



