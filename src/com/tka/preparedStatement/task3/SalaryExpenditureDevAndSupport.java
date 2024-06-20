package com.tka.preparedStatement.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryExpenditureDevAndSupport {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task3", "root", "Shreyas21");
		PreparedStatement ps = connection.prepareStatement("select department,sum(salary) as sumSalary from employee where department IN('dev','support') group by department");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String department = rs.getString(1);
			String deptSum = rs.getString(2);
			

			System.out.println(department + "  " +deptSum);

		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SalaryExpenditureDevAndSupport salaryBetween = new SalaryExpenditureDevAndSupport();
		salaryBetween.work();
	}
}
