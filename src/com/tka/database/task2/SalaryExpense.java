package com.tka.database.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalaryExpense {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capgemini", "root",
				"Shreyas21");
		String query = "select AVG(Experience) as AvgExperience from employee";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);

		while (rs.next()) {
			String avgExperience = rs.getString(1);

			System.out.println("Average Experience : "+avgExperience);

		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SalaryExpense updateSalary = new SalaryExpense();
		updateSalary.work();
	}
}
