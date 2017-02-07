package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.Employee;
public class EmployeeDao {

	private String driver="oracle.jdbc.OracleDriver";
	private String dbURL="jdbc:oracle:thin:@INGNRGPILPHP01:1521:ORCLILP";
	private String dbUserName="aja185core";
	private String dbpassword="aja185core";
	private Connection con=null;
	
	public int addEmployee(Employee employee){
		int noe=0;
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(dbURL,dbUserName,dbpassword);
			PreparedStatement pst=con.prepareStatement("insert into TBL_1190848_EMPLOYEE values (?,?,?,?,?)");
			pst.setInt(1,employee.getEmployeeId());
			pst.setString(2,employee.getEmployeeName());
			pst.setString(3,employee.getGender());
			pst.setString(4,employee.getDesignation());
			pst.setString(5,employee.getDesignation());
			noe=pst.executeUpdate();
			System.out.println(noe);
			con.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				try{
					con.close();
				}
				catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		
		
		
		return noe;
		}
	public int updateEmployee(Employee employee){
		int noe=0;
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(dbURL,dbUserName,dbpassword);
			PreparedStatement pst=con.prepareStatement("update  TBL_1190848_EMPLOYEE set EMPLOYEE_NAME=?,GENDER=?,DESIGNATION=?,EMAIL=? where EMPLOYEE_ID=?");
			
			
			pst.setString(1,employee.getEmployeeName());
			pst.setString(2,employee.getGender());
			pst.setString(3,employee.getDesignation());
			pst.setString(4,employee.getEmail());
			pst.setInt(5,employee.getEmployeeId());
			noe=pst.executeUpdate();
			System.out.println(noe);
			con.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				try{
					con.close();
				}
				catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		
		
		
		return noe;
	
		
	}
	public int deleteEmployee(int employeeId){
		int noe=0;
		try{
		Class.forName(driver);
		con=DriverManager.getConnection(dbURL,dbUserName,dbpassword);
		PreparedStatement pst=con.prepareStatement("delete from TBL_1190848_EMPLOYEE where EMPLOYEE_ID=?");
		pst.setInt(1,employeeId);
		noe=pst.executeUpdate();
		con.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				try{
					con.close();
				}
				catch (SQLException e){
					e.printStackTrace();
				}
			}
			
			
		}
		
		return noe;
	}
}





