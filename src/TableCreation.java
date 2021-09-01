package skill4;

import java.sql.*;
public class TableCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4","root","root");
			Statement st = con.createStatement();
			/*String sql = "CREATE TABLE superAdmin(username varchar(155), password varchar(155))";
			
			String sql1 = "CREATE TABLE admin(email varchar(155), password varchar(155),name varchar(155),theatreName varchar(155),phnum varchar(155))";
			
			String sql2 = "CREATE TABLE customers(name varchar(155),email varchar(155),password varchar(155),address varchar(155))";*/
			
			String sql3 = "CREATE TABLE tickets(tid integer(5) AUTO_INCREMENT PRIMARY KEY,bookedBy varchar(155),theatreName varchar(155),numberOfTickets integer(10),"
					+ "totalAmount integer(10),bookedDate varchar(155),movieName varchar(155))";
			
			//String sql4 = "CREATE TABLE movies(mid integer(10) AUTO_INCREMENT PRIMARY KEY,movieName varchar(155),dateOfRelease varchar(155),ticketPrice varchar(155))";
			//st.execute(sql);
			//st.execute(sql1);
			//st.execute(sql2);
			st.execute(sql3);
			//st.execute(sql4);
			
			System.out.println("Tables Created");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
