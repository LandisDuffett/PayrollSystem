package service;

import java.util.List;

import dao.EmployeeDao;
import dao.EmployeeDaoCollectionImpl;
import exception.EmptyPayrollException;
import model.EmployeePojo;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDao employeeDao;

	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoCollectionImpl();
	}

	@Override
	public EmployeePojo addEmployee(EmployeePojo employeePojo) {
		return employeeDao.addEmployee(employeePojo);
	}

	@Override
	public EmployeePojo updateEmployee(EmployeePojo employeePojo) {
		return employeeDao.updateEmployee(employeePojo);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}

	@Override
	public List<EmployeePojo> getAllEmployees()throws EmptyPayrollException {
		return employeeDao.getAllEmployees();
	}

	@Override
	public EmployeePojo getAnEmployee(int employeeId) {
		return employeeDao.getAnEmployee(employeeId);
	}
	
	

}
