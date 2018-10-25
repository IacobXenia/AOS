package connection;

import java.sql.*;

public class ConnectionProvider{
	
	static Connection connection=null;
	static String  username="postgres";
	static String password="1q2w3e";
	static String connectionURL="jdbc:postgresql://localhost:5432/SubmitDB";
	
	public static Connection getConnection()
	{
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection(connectionURL, username, password);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
	
}
