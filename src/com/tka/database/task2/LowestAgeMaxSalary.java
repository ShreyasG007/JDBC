package com.tka.database.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LowestAgeMaxSalary {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capgemini", "root",
				"Shreyas21");
		String query = "SELECT name FROM employee WHERE age = (SELECT MIN(age) FROM employee)  AND salary = (SELECT MAX(salary) FROM employee)";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);

		while (rs.next()) {
			String name = rs.getString("name");

			System.out.println(name);

		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		LowestAgeMaxSalary updateSalary = new LowestAgeMaxSalary();
		updateSalary.work();
	}
}
