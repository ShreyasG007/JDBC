package com.tka.database.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountEmployees {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capgemini", "root",
				"Shreyas21");
		String query = "select count(*) from employee";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);

		while (rs.next()) {
			String count = rs.getString(1);
			
			System.out.println("Total Emloyees : "+count);

		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		CountEmployees updateSalary = new CountEmployees();
		updateSalary.work();
	}
}
