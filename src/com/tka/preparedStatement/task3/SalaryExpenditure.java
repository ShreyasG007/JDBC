package com.tka.preparedStatement.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryExpenditure {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task3", "root", "Shreyas21");
		PreparedStatement ps = connection.prepareStatement("select Sum(salary) as totalSalry from employee");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String totalSalary = rs.getString(1);
			

			System.out.println("Total Salary : "+totalSalary);

		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SalaryExpenditure salaryBetween = new SalaryExpenditure();
		salaryBetween.work();
	}
}
