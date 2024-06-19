package com.tka.database.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayNameAndEmail {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capgemini", "root",
				"Shreyas21");
		String query = "select name,email from employee where salary != 51000";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);

		while (rs.next()) {
			
			String name = rs.getString(1);
			
			String experience = rs.getString(2);
			
			System.out.println(name+"  "+experience);

		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DisplayNameAndEmail databaseExample = new DisplayNameAndEmail();
		databaseExample.work();
	}
}
