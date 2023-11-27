package KloudqTechnologies.PageObjects;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.jdbc.ResultSetMetaData;

import java.sql.ResultSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import java.sql.Statement;

public class DashboardAConsumption {

	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {

		 
        final String url="jdbc:postgresql://pgdb-001.postgres.database.azure.com:5432/tor-platform";



        final String user="pgsrvadmin";

        final String password="sGhBG_>H_<*J";
        
        
        
        Properties prop = new Properties();
        prop.load(new FileInputStream("./src/main/java/KloudqTechnologies/config/config.properties"));
        String Q1=prop.getProperty("ECActualPredictive");
       // String QUERY = "SELECT \"AlertDataID\", \"CompanyID\", \"EquipmentID\", \"Status\"\r\n" + "FROM public.\"AlertData\";";


              // Open a connection

              Connection conn = DriverManager.getConnection(url,user,password);
              Statement stmt = conn.createStatement();
              ResultSet rs = stmt.executeQuery(Q1);
             
              
              java.sql.ResultSetMetaData rsMetaData = rs.getMetaData();
              int numberOfColumns = rsMetaData.getColumnCount();

              // get the column names; column indexes start from 1
              for (int i = 1; i < numberOfColumns + 1; i++) {
                //String columnName = rsMetaData.getColumnName(i);
                //String tableName = rsMetaData.getTableName(i);
                //System.out.println(columnName);
               // System.out.println(tableName);
                while(rs.next())
                {
                    int col1 = rs.getInt(1);
                    String col2 = rs.getString(2);
                   
                    System.out.println("Actual Consumption kWh: "+col1);
                    System.out.println("Predictive Consumption kWh: "+col2);
                }
                
              }

              rs.close();
              stmt.close();
              
            	}
            	  
            	  
            	  
           }

    
	
	
	

