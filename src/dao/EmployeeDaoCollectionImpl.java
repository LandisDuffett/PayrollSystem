package dao;
import java.util.ArrayList;
import model.EmployeePojo;
import exception.EmptyPayrollException;

import java.util.Iterator;
import java.util.List;

import model.EmployeePojo;

public class EmployeeDaoCollectionImpl implements EmployeeDao{
	
	// this is the data store
	List<EmployeePojo> allEmployees = new ArrayList<EmployeePojo>(); 

	public EmployeeDaoCollectionImpl() {
		EmployeePojo employee1 = new EmployeePojo(101, "Carl Cracker", 75000, 1987, 12, 15);
		EmployeePojo employee2 = new EmployeePojo(102, "Harry Hacker", 50000, 1989, 10, 1);
		EmployeePojo employee3 = new EmployeePojo(103, "Tony Tester", 40000, 1990, 3, 15);

		allEmployees.add(employee1);
		allEmployees.add(employee2);
		allEmployees.add(employee3);
	}

	@Override
	public EmployeePojo addEmployee(EmployeePojo employeePojo) {
		int newEmployeeId = allEmployees.get(allEmployees.size()-1).getEmployeeId() + 1;
		employeePojo.setEmployeeId(newEmployeeId);
		// all the product to the data store
		allEmployees.add(employeePojo);
		
		return employeePojo;
		
	}

	@Override
	public EmployeePojo updateEmployee(EmployeePojo employeePojo) {
		for(int i=0;i<allEmployees.size();i++) {
			if(allEmployees.get(i).getEmployeeId() == employeePojo.getEmployeeId()) {
				allEmployees.set(i, employeePojo); 
				break;
			}
		}
		return employeePojo;
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Iterator<EmployeePojo> allEmployeesItr = allEmployees.iterator();
		while(allEmployeesItr.hasNext()) {
			EmployeePojo getEmployee = allEmployeesItr.next();
			if(getEmployee.getEmployeeId() == employeeId) {
				allEmployees.remove(getEmployee);
				break;
			}
		}
		
	}

	@Override
	public List<EmployeePojo> getAllEmployees()throws EmptyPayrollException {
		if(allEmployees.isEmpty()) {
			EmptyPayrollException epe = new EmptyPayrollException();
			throw epe;
		}
		return allEmployees;
	}

	@Override
	public EmployeePojo getAnEmployee(int employeeId) {
		EmployeePojo foundEmployee = null;
		for(int i=0;i<allEmployees.size();i++) {
			if(allEmployees.get(i).getEmployeeId() == employeeId) {
				foundEmployee = allEmployees.get(i); // when match found , assign the found reference variable to foundProduct
				break;
			}
		}
		return foundEmployee;
	}

}

