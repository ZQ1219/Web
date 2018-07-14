package com.BBS;
import java.sql.*;
public class DB {
	public static Connection getCon() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/web?serverTimezone=GMT", "root", "mysql");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	public static Statement createStmt(Connection conn) {
		Statement stmt =null;
		try {
			stmt=(Statement) conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	public static ResultSet executeQuery(Statement stmt,String sql) {
		ResultSet rs=null;
		try {
			rs=((java.sql.Statement) stmt).executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		conn=null;
	}
	public static void close(Statement stmt) {
		if(stmt!=null) {
			try {
				((java.sql.Statement) stmt).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		stmt=null;
	}
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		rs=null;
	}
}

