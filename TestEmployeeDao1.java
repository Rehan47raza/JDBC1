package com;
import java.util.ArrayList;

import com.EmployeeDao1;
import com.Employee;
public class TestEmployeeDao1 {

	public static void main(String[] args) {
		EmployeeDao1 ed=new EmployeeDao1();
		ArrayList<Employee> el=ed.getAllEmployees();
		for(Employee e:el){
			System.out.println("ID:"+e.getEmployeeId());
			//System.out.println("\t");
			System.out.println("Name:"+e.getEmployeeName());
			System.out.println("Gender:"+e.getGender());
			System.out.println("Designation:"+e.getDesignation());
			System.out.println("Email:"+e.getEmail());
			
		}
	}

}
