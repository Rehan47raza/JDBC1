package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao1 {

	private String driver="oracle.jdbc.OracleDriver";
	private String dbURL="jdbc:oracle:thin:@INGNRGPILPHP01:1521:ORCLILP";
	private String dbUserName="aja185core";
	private String dbpassword="aja185core";
	private Connection con=null;
	
	public ArrayList<Employee>getAllEmployees(){
		ArrayList<Employee> el=new ArrayList<Employee>();
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(dbURL,dbUserName,dbpassword);
			PreparedStatement pst=con.prepareStatement("select * from TBL_1190848_EMPLOYEE");
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Employee e=new Employee();
				int eid=rs.getInt("EMPLOYEE_ID");
				String ename=rs.getString("EMPLOYEE_NAME");
				String gender=rs.getString("GENDER");
				String desig=rs.getString("DESIGNATION");
				String email=rs.getString("email");
				e.setEmployeeId(eid);
				e.setEmployeeName(ename);
				e.setGender(gender);
				e.setDesignation(desig);
				e.setEmail(email);
				el.add(e);
				
			}
		}
		catch(Exception e){
			System.out.println("Exception occured"+e);
		}
		finally{
			if(con!=null){
				try{
					con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		
		
		
		return el;
		
		
		
	}
}
