package com.ts.housejoy.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	static Connection con = null;

	public static Connection openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/housejoy", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	public static void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
