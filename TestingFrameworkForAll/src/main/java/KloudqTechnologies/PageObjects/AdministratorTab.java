package KloudqTechnologies.PageObjects;



// import java.util.Iterator;
// import java.util.List;


// import org.openqa.selenium.By;
// import org.openqa.selenium.JavascriptExecutor;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.FindBy;
// import org.openqa.selenium.support.PageFactory;

// import KloudqTechnologies.AbstractComponents.AbstractComponent;



 public class AdministratorTab {
	
	
// 	public AdministratorTab(WebDriver driver) {
// 		super(driver);
// 		 AbstractComponent.driver=driver;
// 		 PageFactory.initElements(driver,this);
		  
// 	}
// 	@FindBy(xpath="//*[@id=\"#kt_header_menu\"]/div[1]/div/div/div/img")
// 	static
// 	WebElement admintab;
// 	//Admin -Parameter 
// 	public static LiveMap CheckAdmin() 
// 	{
		
// 		// get the current URL
// 	      String strUrl = driver.getCurrentUrl();
// 	      //Print the URL
// 	      System.out.println("Current Url is: "+ strUrl);
	     
// 	      AdminTabHeaderisDisplayed();
// 	      clickAdminTab();
// 	      AllModules();
// 	      AllModuleHeader();
// 	      ModuleImage();
// 	      LogoProfile();
// 	      LogoKloudq();
	      
// 		System.out.println("Am under CheckAdmin");
// 		Placeholder();
// 		CheckMaxlength();
// 		return null;
		
		
		
// 	}
// 	 public static void AdminTabHeaderisDisplayed() {
// 		 WebElement i = driver.findElement
// 			      (By.xpath("//*[@id=\"#kt_header_menu\"]/div[4]/div"));
// 		// Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

// 	      //verify if status is true
	      
// 	         System.out.println("Admin Tab is visible");
	     
// 	 }
// 	 public static void clickAdminTab() {
// 		 WebElement admintab = driver.findElement
// 			      (By.xpath("//*[@id=\"#kt_header_menu\"]/div[4]/div"));
// 		// Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

// 	      //verify if status is true
// 		 admintab.click();
// 	         System.out.println("Admin Tab is clickable");
	     
// 	 }
	
// 	 public static void AllModules() {
		
         
// 		 List<WebElement> allmodules = driver.findElements(By.className("admincards"));

// 		 Iterator<WebElement> itr = allmodules.iterator();
// 		 System.out.println("Checking all the Modules");
// 		 while(itr.hasNext()) {
// 		     System.out.println(itr.next().getText());
// 		     System.out.println("Modules are present");}
// 		 }
// 		 public static void AllModuleHeader() {
				
	         
// 			 List<WebElement> moduleheader = driver.findElements(By.className("card-header"));

// 			 Iterator<WebElement> itr = moduleheader.iterator();
// 			 System.out.println("Checking the header of Modules");
// 			 while(itr.hasNext()) {
// 			     System.out.println(itr.next().getText());
// 			     System.out.println("Header of Modules are present");}
// 			 } 
		 
// 		 public static void ModuleImage() {
			 

// 			 WebElement i = driver.findElement
// 				      (By.xpath("//*[@id=\"kt_content\"]/div[1]/div/div/div/div/div[1]/a[1]/div/span[1]/img"));
// 			 Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

// 		//verify if status is true
// 		if (p) {
// 		   System.out.println("Module Icon is present");
// 		} else {
// 		   System.out.println("Module Icon is not present");
// 		}
			 
			 
// 		 }
		 
// public static void LogoProfile() {
			 
// 			 WebElement i = driver.findElement
// 				      (By.xpath("//*[@id=\"kt_header_user_menu_toggle\"]/div/img"));
// 			 Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

// 		//verify if status is true
// 		if (p) {
// 		   System.out.println("Profile Image is present");
// 		} else {
// 		   System.out.println("Profile Image not present");
// 		}
			 
// 		 }
		 
// public static void LogoKloudq() {
	 
// 	 WebElement i = driver.findElement
// 		      (By.xpath("//*[@id=\"kt_header\"]/div/div[2]/a/img"));
// 	 Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

// //verify if status is true
// if (p) {
//   System.out.println("Kloudq Logo image is present");
// } else {
//   System.out.println("Kloudq Logo image is not present");
// }
	 
// }



// public static  void Placeholder() {
	
// 	driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div[1]/div/div/div/div/div[3]/a[2]/div")).click();
// 	driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div[1]/div/div/div[1]/div[2]/div/a")).click();
//     WebElement ph = driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[1]/div[1]/input"));

//     String placeText = ph.getAttribute("placeholder");

//     if (placeText.equals("Parameter Name"))
//         System.out.println("Correct placeText is shown");
//     else
//         System.out.println("Correct placeText is not shown");

    
	
//     WebElement ph2 = driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[1]/div[2]/input"));

//     String placeText2 = ph2.getAttribute("placeholder");
    
//     if (placeText2.equals("UOM"))
//         System.out.println("Correct placeText is shown");
//     else
//         System.out.println("Correct placeText is not shown");

   
    
//     WebElement ph3 = driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[2]/div/textarea"));

//     String placeText3 = ph3.getAttribute("placeholder");
    
//     if (placeText3.equals("Parameter Description"))
//         System.out.println("Correct placeText is shown");
//     else
//         System.out.println("Correct placeText is not shown");

	
// }
// public static  void CheckMaxlength() 
// {
// 	String flength = driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[1]/div[1]/input")).getAttribute("maxlength");
//     System.out.println("Parameter Name's max length is - " +flength);
  
    
//     String flength2 = driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[1]/div[2]/input")).getAttribute("maxlength");
//     System.out.println("UOM's max length is - " +flength2);
    
//     String flength3 = driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/div/div[2]/div/div/form/div[2]/div/textarea")).getAttribute("maxlength");
//     System.out.println("Description's max length is - " +flength3);
    
// }


	 }
	 
	 
