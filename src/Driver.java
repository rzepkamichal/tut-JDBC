
import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		
		
		try {
			
			//get a connection to database
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "manager","manager");
			
			//create a statement
			Statement statement = connection.createStatement();
			
			//execute SQL query
			ResultSet resultSet = statement.executeQuery("select * from titles");
			
			//process the result set
			
			while(resultSet.next()) {
				
				System.out.println(resultSet.getString(1)+", "+resultSet.getString(2));
			}
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
