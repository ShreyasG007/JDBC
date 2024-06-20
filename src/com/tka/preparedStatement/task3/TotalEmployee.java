package com.tka.preparedStatement.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalEmployee {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task3", "root", "Shreyas21");
		PreparedStatement ps = connection.prepareStatement("Select count(*) from employee");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String totalEmployee = rs.getString(1);
			System.out.println("Total Employee : "+totalEmployee);
		}

	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TotalEmployee totalEmployee = new TotalEmployee();
		totalEmployee.work();
	}
}
