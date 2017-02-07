package com;
import com.Employee;
import com.EmployeeDao;
public class TestEmployeeDao {

	public static void main(String[] args) {
		EmployeeDao ed=new EmployeeDao();
		Employee e=new Employee();
		e.setEmployeeId(20);
		e.setEmployeeName("Nikhil");
		e.setGender("Male");
		e.setDesignation("ASE");
		e.setEmail("rehanraza260@gmail.com");
		ed.addEmployee(e);
		System.out.println("");
		System.out.println("Records Inserted");
		System.out.println(ed.updateEmployee(e));
		int employeeId=10;
		System.out.println(ed.deleteEmployee(employeeId));
		

	}

}
