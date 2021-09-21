package edu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DButil {
	public static Connection connect() {
		Properties p = new Properties();
		try {
			p.load(DButil.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
			Class.forName(p.getProperty("driver"));
			String url = p.getProperty("url");
			Connection con = DriverManager.getConnection(url, p);
			return con;
		} catch (Exception e) {
			System.out.println("DButil-connect : " + e);
		}
		return null;
	}

	public static void close(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println("DButil-close : " + e);
		}
	}
}