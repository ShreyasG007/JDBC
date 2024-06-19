package com.tka.database.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LowestPaidEmployee {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capgemini", "root",
				"Shreyas21");
		String query = "select name,experience from employee where salary=(select min(salary) from employee)";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);

		while (rs.next()) {
			String name = rs.getString(1);
			String experience = rs.getString(2);

			System.out.println(name+"  "+experience);

		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		LowestPaidEmployee updateSalary = new LowestPaidEmployee();
		updateSalary.work();
	}
}
