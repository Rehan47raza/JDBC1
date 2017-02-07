package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.DbTransaction;
public class TestProcedure {
public static void main(String args[]) throws SQLException{
	
	//TestProcedure tp=new TestProcedure();
	DbTransaction db=new DbTransaction("jdbc:oracle:thin:@INGNRGPILPHP01:1521:ORCLILP","aja185core" ,"aja185core", "tbl_test_1190848");
	
		System.out.println(getTestsCount(db));


	for(Test t:getTests(db,2)){
		System.out.println(t.id+" "+t.title);
	}
	
	
}
public static  int getTestsCount(DbTransaction db) throws SQLException{
	Connection con=db.getConnection();
	Statement stmt=con.createStatement();  
	int count=0;
	ResultSet rs=stmt.executeQuery("select * from tbl_test_1190848");  
	while(rs.next()) {
		count++;
	}
	db.closeConnection();

	return count;
}
public static ArrayList<Test> getTests(DbTransaction db,int a){
	ArrayList <Test> test=new ArrayList<Test>();
	Connection con=db.getConnection();
	Statement stmt = null;
	try {
		stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from tbl_test_1190848");
		while(rs.next()) {
		if(rs.getInt(1)>a){
		
			Test t=new Test();
			t.id=rs.getInt(1);
			t.title=rs.getString(2);
			test.add(t);
			
		}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}  
	

	db.closeConnection();
	return test;
	}
}
