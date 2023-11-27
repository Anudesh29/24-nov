package KloudqTechnologies.tests;

import java.io.IOException;

import org.testng.annotations.Test;

public class CustomerTestEVPOC {

	@Test(groups= {"Customer"},priority = 1)  
	 public void Login() throws IOException, InterruptedException  
	 {  
		System.out.println("Execute Login Component");
		 LoginTestExcel.getCustomerUserDataEVPOC();
		 
	     
	 }  
	
	
	@Test(groups= {"Customer"},priority = 2)  
	 public void LiveMap()  
	 {  
	     System.out.println("Execute Dashboard Component");  
	 }  
	 @Test  (groups= {"Customer"},priority = 3)  
	 public void Replay()  
	 {  
	     System.out.println("Execute Replay Component");  
	 }  
	 @Test  (groups= {"Customer"},priority = 4)  
	 public void Trends()  
	 {  
	     System.out.println("Execute Trends Component");  
	 }  
	 
	 @Test  (groups= {"Customer"},priority = 5)  
	 public void Reports()  
	 {  
	     System.out.println("Execute Reports Component");  
	 }  
	
}
