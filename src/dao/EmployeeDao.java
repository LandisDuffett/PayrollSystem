package dao;

import java.util.List;

import exception.EmptyPayrollException;
import model.EmployeePojo;

public interface EmployeeDao {

	EmployeePojo addEmployee(EmployeePojo employeePojo); // Create
	
	EmployeePojo updateEmployee(EmployeePojo employeePojo); // Update
	
	void deleteEmployee(int employeeId); // Delete
	
	List<EmployeePojo> getAllEmployees()throws EmptyPayrollException; // Read
	
	EmployeePojo getAnEmployee(int employeeId); // Read
	
}
