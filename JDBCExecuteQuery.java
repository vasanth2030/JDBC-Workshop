package com.vasanth.jdbcworkshop;
import java.sql.*;
//	1) Import the package.
public class JDBCExecuteQuery {

	public static void main(String[] args) throws Exception {

//	2) Register the drivers.

		Class.forName("com.mysql.cj.jdbc.Driver");
		
//	3) Establish a connection.
		
		String url,uname,pass;
		url="jdbc:mysql://localhost:3306/jdbc_workshop";
		uname="hbstudent";
		pass="hbstudent";
		Connection con=DriverManager.getConnection(url,uname,pass);
		
		System.out.println("Connection Successful!");

//	4) Create a statement.
		
		Statement st=con.createStatement();

//	5) Execute the query.
		
		ResultSet rs= st.executeQuery("select * from student;");

//	6) Process the results.
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
			System.out.println();
		}
		
//	7) Close the connection.
		
		st.close();
		con.close();


	}

}
