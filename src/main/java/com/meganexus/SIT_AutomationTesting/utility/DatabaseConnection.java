package com.meganexus.SIT_AutomationTesting.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private static final String dbusername = ConfigFile.readProperty("/config.propeties", "dbUsername");
	private static final String dbpassword = ConfigFile.readProperty("/config.propeties", "dbPassword");
	private static final String connectionUrl = ConfigFile.readProperty("/config.propeties", "connectionUrl");
	private static Connection connection;
	
	//Method to create a database connection
	private static Connection createConnection() {
		//creating connection and authentication
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl, dbusername, dbpassword);
			
			if (connection != null) {
				System.out.println("Connected to the database...");
			} else {
				System.out.println("Database connection failed");
				return null;
			}
			
		} // end of try 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver is not loaded.");
		}
		catch (SQLException sqlEx) {
			System.out.println("SQL Exception:" + sqlEx.getStackTrace());
		}
		return connection;
	}

	public static String executeSQLQuery(String sqlQuery) {
		//creating connection and authentication
		connection = createConnection();
		String resultValue = "";
		ResultSet rs;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlQuery);

			try {
				while (rs.next()) {
					resultValue = rs.getString(1).toString();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException err) {
				System.out.println("No Records obtained for this specific query");
				err.printStackTrace();
			} finally {
				connection.close();
			}
		} catch (SQLException sqlEx) {
			System.out.println("SQL Exception:" + sqlEx.getStackTrace());
		}
		return resultValue;
	}

	// verifying specific record
	public static void main(String[] args) {
		String sqlQuery = "select building_name from tr_offender_address_spg where offender_address_id='"
				+ executeSQLQuery("select offender_address_id from tr_offender_address_spg where profile_id='451';")
				+ "'";
		String building_name = executeSQLQuery(sqlQuery);
		System.out.println("building_name retrieved from database : " + building_name);
	}
}
