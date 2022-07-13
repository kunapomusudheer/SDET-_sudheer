package JDBCPractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ExecuteUpdateTest {
	@Test
	public void executeUpdateTest() throws Exception {
		//step=2 Connect to Database
		Connection con=null;
		try {
			//Register driver
			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			//step =3 Cteate Statement
			Statement stmt = con.createStatement();
			//Step=4 Execute update
			int result=stmt.executeUpdate("insert into students_info(regno,firstname,middlename,lastname)values('7','nga','di','jlast');");
			if(result==1) {
				System.out.println("data is added");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//step=5 close the connection
			con.close();
		}
		
	}
		
	}
