package model;

import java.time.LocalDate;

public class EmployeePojo {

	private int employeeId;
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public EmployeePojo() {
		
	}
	
	public EmployeePojo(int employeeId, String n, double s, int year, int month, int day)
	{
		this.employeeId = employeeId;
		this.name = n;
		this.salary = s;
		this.hireDay = LocalDate.of(year,  month,  day);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}

	public void setHireDay(LocalDate hireDay) {
		this.hireDay = hireDay;
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		this.salary += raise;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "EmployeePojo [employeeId=" + employeeId + ", employeeName=" + name + ", employeeSalary="
				+ salary + ", employeeHireDay=" + hireDay + "]";
	}
}
