package com.tka.database.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MaxSalaryTestProfile {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capgemini", "root",
				"Shreyas21");
		String query = "select MAX(salary) as MaxSalary from employee where profile='test'";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);

		while (rs.next()) {
			String maxSalary = rs.getString(1);

			System.out.println("Max salary from test profile : " + maxSalary);

		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MaxSalaryTestProfile updateSalary = new MaxSalaryTestProfile();
		updateSalary.work();
	}
}
