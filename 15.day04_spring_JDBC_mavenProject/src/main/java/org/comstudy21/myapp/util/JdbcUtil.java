package org.comstudy21.myapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil implements JdbcProperties {

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		
		try {
			Class.forName(CLASSDRIVER);
			
			return DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	public static void close(Connection obj){
		if(obj != null){
			try {
				obj.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement obj){
		if(obj != null){
			try {
				obj.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet obj){
		if(obj != null){
			try {
				obj.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// close 메소드를 override 한다.
	public static void close(ResultSet rs, Statement stmt, Connection conn){
		close(rs);
		close(stmt);
		close(conn);
	}
		
	
	public static void main(String[] args){
		System.out.println(getConnection());
	}

}
