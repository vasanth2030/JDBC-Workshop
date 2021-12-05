package com.vasanth.jdbcworkshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCPreparedStatementExecuteQuery {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbc_workshop";
		String uname = "hbstudent";
		String pass = "hbstudent";
		Connection con=DriverManager.getConnection(url,uname,pass);

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter ID: ");
		int id=sc.nextInt();
		
		PreparedStatement pst=con.prepareStatement("select * from student where id =?");
		pst.setInt(1, id);
		
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		
		pst.close();
		con.close();
		
		
	}

}
