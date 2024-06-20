 package com.tka.preparedStatement.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountEmployeeYearWise {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task3", "root", "Shreyas21");
		PreparedStatement ps = connection.prepareStatement("Select count(*) from employee where hired_year='2023'");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String count = rs.getString(1);
			System.out.println("Count : "+count);
		}

	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		CountEmployeeYearWise totalEmployee = new CountEmployeeYearWise();
		totalEmployee.work();
	}
}
