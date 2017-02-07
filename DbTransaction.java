package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbTransaction {
private String url=" 1521:ORCLILP";
private String tableName;
private Connection connection=null;
private String user="aja185core";
private String password="aja185core";
public String getUrl(){
	return password;
	
}
public DbTransaction(String url, String user, String password, String tableName) {
	//super();
	this.url = url;
	this.tableName = tableName;
	this.user = user;
	this.password = password;
}
public String getTableName() {
	return tableName;
}
public void setTableName(String tableName) {
	this.tableName = tableName;
}
public Connection getConnection() {
	try {
		closeConnection();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		return connection;
}

public String getUser() {
	return user;
}
public void closeConnection(){
	try
	{
	if(connection != null && connection.isClosed() == false)
	connection.close();
	connection = null;
	}
	catch(SQLException e)
	{
	e.printStackTrace();
	}
}
public void setUser(String user) {
	this.user = user;
}
public void setUrl(String url) {
	this.url = url;
}

}
