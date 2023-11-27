package KloudqTechnologies.tests;



import KloudqTechnologies.PageObjects.AdministratorTab;
import KloudqTechnologies.TestComponents.BaseTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;


public class AdministratorTest extends BaseTest  {
	@FindBy(xpath="//*[@id=\"#kt_header_menu\"]/div[1]/div/div/div/img")
	static
	WebElement admintab;
	
	@Test
	
	public void Adminuser() throws IOException, InterruptedException {
		 
	
		// AdministratorTab.CheckAdmin();
		 System.out.println("Am under AdminUSer");
		
        
	}
	
	
	
}
