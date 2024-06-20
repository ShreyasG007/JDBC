package com.tka.preparedStatement.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeByName {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task3", "root", "Shreyas21");
		PreparedStatement ps = connection.prepareStatement("SELECT Name FROM employee GROUP BY Name HAVING COUNT(*) > 1");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String name = rs.getString(1);
			System.out.println(name);
		}

	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeByName totalEmployee = new EmployeeByName();
		totalEmployee.work();
	}
}
