package JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;



public class ExecuteQueryTest {
	

	private static final Connection Con = null;

	@Test
	public void executequery() throws Throwable {
		Connection con=null;
    try {
		//step1 Register the driver
		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
		//step=2 Connect to Database
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		//step =3 Create Statement
		Statement stmt = con1.createStatement();
		//Step=4 Execute Quiery
		ResultSet result=stmt.executeQuery("select * from students_info");
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2));
		}
	} 
    catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally {
		//step=5 close the connection
		Con.close();
      	
	
	}
}
}
