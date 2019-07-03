
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
			ResultSet resultSet = statement.executeQuery("select * from departments");
			
			//process the result set
			
			/**
			while(resultSet.next()) {
				
				System.out.println(resultSet.getString(1)+", "+resultSet.getString(2));
			}*/
			
			
			/**insertion
			String insertionStmt = "insert into departments "
					+ "values ('d011', 'Administration')";
			statement.executeUpdate(insertionStmt);
			*/
			
			/**update
			String updateStmt = "update departments"
					+ " set dept_name = 'Administration Management'"
					+ " where dept_no = 'd010' ";
			
			statement.executeUpdate(updateStmt);
			resultSet = statement.executeQuery("select * from departments");
			resultSet.first();
			System.out.println("\nAfter update:");
			System.out.println(resultSet.getString(1)+", "+resultSet.getString(2));
			*/
			
			/**Deletion
			 
			String deleteStmt = "delete from departments"
					+" where dept_no = 'd010'";
			int rowsAffected = statement.executeUpdate(deleteStmt);
			
			System.out.println("\nRows deleted:" + rowsAffected);
			System.out.println("Delete Complete");
			
			resultSet = statement.executeQuery("select * from departments");
			while(resultSet.next()) {
				
				System.out.println(resultSet.getString(1)+", "+resultSet.getString(2));
			}
			*/
			
			/**Prepared Statements
			 * 
			 */
			
			PreparedStatement prepStmt = connection.prepareStatement("select e.last_name, s.salary "
											+ " from salaries s"
											+ " join employees e on e.emp_no = s.emp_no"
											+ " where s.salary > ?"
											+ " and e.last_name like ?");
			
			prepStmt.setInt(1,50000);
			prepStmt.setString(2, "K%");
			
			ResultSet prepResultSet = prepStmt.executeQuery();
			
			while(prepResultSet.next()) {
				
				System.out.println(prepResultSet.getString(1)+", "+prepResultSet.getString(2));
			}
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
