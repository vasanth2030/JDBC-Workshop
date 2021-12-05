package com.vasanth.jdbcworkshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCPreparedStatementExecuteUpdate {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbc_workshop";
		String uname = "hbstudent";
		String pass = "hbstudent";
		Connection con=DriverManager.getConnection(url,uname,pass);

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter ID: ");
		int id=sc.nextInt();
		System.out.println("Enter First Name: ");
		String fname=sc.next();
		System.out.println("Enter Last Name: ");
		String lname=sc.next();
		
		PreparedStatement pst=con.prepareStatement("insert into student values (?,?,?)");
		pst.setInt(1, id);
		pst.setString(2, fname);
		pst.setString(3, lname);
		
		int n=pst.executeUpdate();
		System.out.println(n+" rows affected!");
		
		pst.close();
		con.close();
		
		
	}

}
