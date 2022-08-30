package com.sjoedwards.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJbdc {

	public static void main(String[] args) {
		String jbdcUrl = "jdbc:mysql://0.0.0.0:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String user = "root";
		String password = "hbstudent";
		
		try {
			System.out.println("connecting to database" + jbdcUrl);
			Connection myConn = DriverManager.getConnection(jbdcUrl, user, password);
			System.out.println("connected");
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
