
import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3306/employees?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "manager";
		String password = "manager";
		
		try {
			
			//get a connection to database
			Connection connection = DriverManager.getConnection(url, user, password);
			
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
