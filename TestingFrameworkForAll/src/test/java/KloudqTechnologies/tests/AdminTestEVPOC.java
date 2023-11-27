package KloudqTechnologies.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import KloudqTechnologies.PageObjects.AdministratorTab;


public class AdminTestEVPOC {
	public  static WebDriver driver;
	@Test(groups= {"Admin"},priority = 1)  
	 public void Login() throws IOException, InterruptedException  
	 {  
		System.out.println("Execute Login Component");
		// LoginTestExcel.getAdminUserDataEVPOC();
	     Thread.sleep(5000);
		// AdministratorTab.CheckAdmin();
		 
	 }  
	
	
	@Test(groups= {"Admin"},priority = 2)  
	 public void LiveMap()  
	 {  
	     System.out.println("Execute Dashboard Component");  
	 }  
	
	
	 @Test  (groups= {"Admin"},priority = 3)  
	 public void Replay()  
	 {  
	     System.out.println("Execute Replay Component");  
	 }  
	 @Test  (groups= {"Admin"},priority = 4)  
	 public void Trends()  
	 {  
	     System.out.println("Execute Trends Component");  
	 }  
	 @Test  (groups= {"Admin"},priority = 5)  
	 public void Administrator()  
	 {  
	     System.out.println("Execute Administrator Component");  
	 }  
	 @Test  (groups= {"Admin"},priority = 6)  
	 public void Reports()  
	 {  
	     System.out.println("Execute Reports Component");  
	 }  
	
}
