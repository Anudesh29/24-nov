package KloudqTechnologies.JDBCConnection;

 

 

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

 


public class ConnectJDBC {

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