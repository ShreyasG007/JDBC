package com.tka.database.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateProfile {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capgemini", "root", "Shreyas21");
		String query = "select * from employee";
		
		String updateQuery = "update employee set profile='support' where name='radha'";
		
		Statement statement = connection.createStatement();
		
		int executeUpdate = statement.executeUpdate(updateQuery);
		
		System.out.println(executeUpdate);
		
		ResultSet rs = statement.executeQuery(query);

		while (rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String profile = rs.getString(3);
			String email = rs.getString(4);
			String salary = rs.getString(5);
			String age = rs.getString(6);
			String experience = rs.getString(7);
			String branch_location = rs.getString(8);
			
			System.out.println(id+"  "+name+"  "+profile+"  "+email+"  "+salary+"  "+age+"  "+experience+"  "+branch_location);

		}
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UpdateProfile updateSalary = new UpdateProfile();
		updateSalary.work();
	}
}
