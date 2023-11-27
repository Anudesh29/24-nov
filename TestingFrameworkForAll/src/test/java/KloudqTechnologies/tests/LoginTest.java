package KloudqTechnologies.tests;



import KloudqTechnologies.TestComponents.BaseTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;


public class LoginTest extends BaseTest  {
	@FindBy(xpath="//*[@id=\"kt_login_signin_form\"]/div[2]")
	WebElement errorMessage;
	
	@Test(dataProvider="loginData",dataProviderClass=LoginTestExcel.class)
	
	public void Loginuser() throws IOException, InterruptedException {
		
		
	    LoginTestExcel.getData();
	   
        
	}

	
}
