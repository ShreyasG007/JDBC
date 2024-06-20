package com.tka.preparedStatement.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalSalaryExpenditurePuneLocation {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task3", "root", "Shreyas21");
		PreparedStatement ps = connection.prepareStatement("select sum(salary) as sum_salary from employee where location='pune' ");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String salary = rs.getString(1);
			

			System.out.println("Pune Location Salary : "+salary);

		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TotalSalaryExpenditurePuneLocation salaryBetween = new TotalSalaryExpenditurePuneLocation();
		salaryBetween.work();
	}
}
