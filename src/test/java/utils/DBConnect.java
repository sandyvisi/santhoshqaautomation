package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	public static Connection con;

	public static Connection connectDB() {

		try {
			String url = "jdbc:mysql://localhost:3306/qadb";
			String userName = "root";
			String password = "Saibaba1@3";
			System.out.println("DB is connected");

			con = DriverManager.getConnection(url, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return con;
	}

	public static ResultSet getDataByStringCondition(String table, String column, String value) throws SQLException {

		ResultSet resultset = null;
		PreparedStatement statement = null;
		String query = null;

		try {

			query = "select * from " + table + " where " + column + "=?";

			statement = con.prepareStatement(query);

			statement.setString(1, value);

			resultset = statement.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultset;
	}

	public static void closeDB() {

		try {

			con.close();

			System.out.println("DB Closed");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
