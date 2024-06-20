package com.tka.preparedStatement.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AverageSalary {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task3", "root", "Shreyas21");
		PreparedStatement ps = connection.prepareStatement("Select avg(salary) as avg_sal from employee");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		String avgSal=rs.getString(1);
			System.out.println("Average Salary : "+avgSal);

		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AverageSalary avgSal = new AverageSalary();
		avgSal.work();
	}
}
