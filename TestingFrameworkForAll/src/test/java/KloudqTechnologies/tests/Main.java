package KloudqTechnologies.tests;



import KloudqTechnologies.JDBCConnection.ConnectJDBC;
import KloudqTechnologies.TestComponents.BaseTest;



import java.io.IOException;
import java.sql.SQLException;

public class Main extends BaseTest{
	public static void main(String[] args) throws IOException, InterruptedException, SQLException {
	System.out.println("In main class");
	LoginTest a1 = new LoginTest();
 a1.Loginuser();//Login Test
  driver. quit();
	
 
  AdministratorTest at=new AdministratorTest();
  at.Adminuser();
  
  ConnectJDBC sqlconnect=new ConnectJDBC();

  sqlconnect.Connect();
  
	//LiveMapTest a2=new LiveMapTest();
	//a2.CheckAllImages();
	
	
	
	}}

	


