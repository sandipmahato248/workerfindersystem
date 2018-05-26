package com.sandip.wf.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DBUtil {
	private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3307/worker_finder_system";
	private static final String USERNAME="root";
	private static final String PASSWORD="";

	public static Connection getConnection() throws ClassNotFoundException, SQLException{;
	Class.forName(DRIVER_NAME);
	return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}

	public static void closeAll(PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
