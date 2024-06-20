package com.tka.preparedStatement.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopFiveHighestPaid {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task3", "root", "Shreyas21");
		PreparedStatement ps = connection.prepareStatement("select * from employee order by salary desc limit 5;");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String salary = rs.getString(3);
			String department = rs.getString(4);
			String location = rs.getString(5);
			
			System.out.println(id + "  "+ name+"  "+salary+"  "+department+"  "+location);
			
		}

	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TopFiveHighestPaid highestPaid = new TopFiveHighestPaid();
		highestPaid.work();
	}
}
