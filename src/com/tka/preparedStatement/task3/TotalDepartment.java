package com.tka.preparedStatement.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalDepartment {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task3", "root", "Shreyas21");
		PreparedStatement ps = connection.prepareStatement("select department from employee");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String department = rs.getString(1);
			
			System.out.println(department);
		}

	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TotalDepartment employeeDept = new TotalDepartment();
		employeeDept.work();
	}
}
