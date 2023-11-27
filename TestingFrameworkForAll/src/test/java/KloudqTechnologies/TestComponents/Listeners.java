package KloudqTechnologies.TestComponents;
//import java.io.IOException;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//
//import KloudqTechnologies.resources.ExtentReporterNG;
//
//public class Listeners extends BaseTest implements ITestListener{
//	public WebDriver driver;
//	ExtentTest test;
//	ExtentReports extent;
//	ExtentReports extent=ExtentReporterNG.getReportObject();
//	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
//	@Override
//	Here we are setting the every testcase name dynamically and setting up the entry of the same 
//	
//	public void onTestStart(ITestResult result) {
//		 //TODO Auto-generated method stub
//		test=extent.createTest(result.getMethod().getMethodName());
//		extentTest.set(test); unique thread id is given (error Validation Test)
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		 //TODO Auto-generated method stub
//		extentTest.get().log(Status.PASS,"Test is Passed");
//		
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result){
//		String testName=result.getTestName();
//		
//		try {
//			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			getScreenshot(testName,driver);
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//	extentTest.get().fail(result.getThrowable());
//		Screenshot and attaching to the report
//		
//		String filePath=null;
//try {
//		try {
//		driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//	} catch (IllegalArgumentException e) {
//			 //TODO Auto-generated catch block
//			e.printStackTrace();
//	} catch (IllegalAccessException e) {
//			 //TODO Auto-generated catch block
//				e.printStackTrace();
//		} catch (NoSuchFieldException e) {
//			 //TODO Auto-generated catch block
//			e.printStackTrace();
//	} catch (SecurityException e) {
//	 //TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	filePath = getScreenshot(result.getMethod().getMethodName(),driver);
//	
//} catch (IOException e) {
//	 //TODO Auto-generated catch block
//	e.printStackTrace();
//		}
//		extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
//		
//		
//		
//	
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		 //TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		 //TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		 //TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//		 //TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		 //TODO Auto-generated method stub
//		
//		extent.flush();
//	}
//
//