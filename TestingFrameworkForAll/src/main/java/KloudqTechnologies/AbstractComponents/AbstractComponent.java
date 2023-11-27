package KloudqTechnologies.AbstractComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import KloudqTechnologies.JDBCConnection.ConnectJDBC;




public class AbstractComponent {
	
	protected static WebDriver driver;
	
	//Here the super class is communicating with parent class ie Abstract class from child class 

	public AbstractComponent(WebDriver driver) {
	AbstractComponent.driver=driver;
	 PageFactory.initElements(driver,this);
}
	


	//Re usability of code
	public void waitForElementToAppear(By findBy) {
	//Waiting for the WebElement to appear
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	public void waitForWebElementToAppear(WebElement findBy) {
		//Waiting for the WebElement to appear
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
		}
	
	

	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		//Waiting for the WebElement to appear
		Thread.sleep(2000);
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//wait.until(ExpectedConditions.invisibilityOf(ele));
		
		}
	
	
	
	
	public static void ConnecttoDB()throws SQLException {


        ConnectJDBC sqlconnect=new ConnectJDBC();

        sqlconnect.Connect();

    }
	
	
    public static String url="jdbc:postgresql://pgdb-001.postgres.database.azure.com:5432/tor-platform";

    public static String user="pgsrvadmin";

    public static String password="sGhBG_>H_<*J";

    

    public void Connect() throws SQLException {

        try (Connection connection =DriverManager.getConnection(url,user,password);)

        {

            if (connection!=null) {

                

                System.out.println("Connection Sucessful");

            }

            else {

                

                System.out.println("Connection not Sucessful");

            }

        }

        catch(SQLException e){

            

            e.printStackTrace();

        }

        
    }


 }

    
