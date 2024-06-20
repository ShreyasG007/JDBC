package com.tka.database.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoveAllElements {
	public void work() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root",
				"Shreyas21");
		String query = "delete from studentdata";
		Statement statement = connection.createStatement();
		int executeUpdate = statement.executeUpdate(query);
		System.out.println(executeUpdate);

		

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		RemoveAllElements updateSalary = new RemoveAllElements();
		updateSalary.work();
	}
}
