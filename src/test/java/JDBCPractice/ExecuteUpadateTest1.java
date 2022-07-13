package JDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpadateTest1 {
@Test
public void execute() throws SQLException {
	Connection c = null;
	try {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		 Statement s = c.createStatement();
		 int e=s.executeUpdate("insert into students_info(regno,firstname,middlename,lastname)values('10','e','f','g');");
		if(e==1) {
			System.out.println("data is added");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		c.close(); 
	}
   
}
}
