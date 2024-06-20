package com.tka.preparedStatement.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDepatment {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task3", "root", "Shreyas21");
		PreparedStatement ps = connection.prepareStatement("select department,count(*) as deptCount from employee group by department");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String department = rs.getString(1);
			String  deptCount= rs.getString(2);
			System.out.println(department + "  "+deptCount);
		}

	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeDepatment employeeDept = new EmployeeDepatment();
		employeeDept.work();
	}
}
