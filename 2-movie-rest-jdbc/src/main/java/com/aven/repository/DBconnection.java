package com.aven.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class DBconnection {
	private Connection connection;
	@Value("${mydb.driver}")
	private String driverName;
	@Value("${mydb.url}")
	private String url;
	@Value("${mydb.uname}")
	private String uname;
	@Value("${mydb.pwd}")
	private String pwd;
	
	
	public Connection getConnection() {
		return  connection;
	}

	@PostConstruct
	public void init() {

		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, uname, pwd);
			// connection = DriverManager.getConnection(url,uname,pwd);
			System.out.println("Connected Successfully with DB");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@PreDestroy
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
