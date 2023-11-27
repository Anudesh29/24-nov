package KloudqTechnologies.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import KloudqTechnologies.AbstractComponents.AbstractComponent;


public class LiveMap  extends AbstractComponent {
	public static WebDriver driver;
	 public LiveMap(WebDriver driver)
	 {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
		  
	 }
	
		
	 public void Headerdisplayed() {}
	 public void ElementsSelected() {}
	 public void ElementsEnabled() {}

}
