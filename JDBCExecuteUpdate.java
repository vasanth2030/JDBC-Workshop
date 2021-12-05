package com.vasanth.jdbcworkshop;

import java.sql.*;

public class JDBCExecuteUpdate {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/jdbc_workshop";
		String uname = "hbstudent";
		String pass = "hbstudent";

		Connection con = DriverManager.getConnection(url, uname, pass);

		Statement st = con.createStatement();

		int n = st.executeUpdate("delete from student where id=5");

		System.out.println(n + " row/s affected!");

		ResultSet rs = st.executeQuery("select * from student;");

		while (rs.next()) {
			System.out.print(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
			System.out.println();
		}

		st.close();
		con.close();

	}

}
