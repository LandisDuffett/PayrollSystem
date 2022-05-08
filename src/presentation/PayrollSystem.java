package presentation;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.EmployeePojo;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class PayrollSystem {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		char proceed = 'y';
		
		while(proceed == 'y') {
			System.out.println("*****************************");
			System.out.println("PAYROLL SYSTEM");
			System.out.println("*****************************");
			System.out.println("1. List all Employees");
			System.out.println("2. Add a new Employee");
			System.out.println("3. Delete an Employee");
			System.out.println("4. Update an Employee");
			System.out.println("5. Exit");
			System.out.println("*****************************");
			System.out.println("Please enter an option:");
			int option = scan.nextInt();
			System.out.println("*****************************");
			switch(option) {
				case 1:
					List<EmployeePojo> everyEmployee = employeeService.getAllEmployees();
					System.out.println("***************************************************************************************");
					System.out.println("ID\tNAME\tSALARY\tHIRE_DAY");
					System.out.println("***************************************************************************************");
					everyEmployee.forEach((item)-> System.out.println(item.getEmployeeId() + "\t" + item.getName() + "\t" + item.getSalary() + "\t" + item.getHireDay()));
					System.out.println("***************************************************************************************");
					System.out.println("Do you want to continue?(y/n)");
					proceed = scan.next().charAt(0);
					break;
				case 2:
					EmployeePojo Emp = new EmployeePojo();
					System.out.println("***************************************************************************************");
					System.out.println("Enter employee name:");
					scan.nextLine();
					String Name = scan.nextLine();
					Emp.setName(Name);
					System.out.println("Enter employee salary: ");
					double Salary = scan.nextDouble();
					Emp.setSalary(Salary);
					System.out.println("Enter year in which employee was hired:");
					int yr = scan.nextInt();
					System.out.println("Enter month in which employee was hired as number(1-12):");
					int mn = scan.nextInt();
					System.out.println("Enter day of month on which employee was hired:");
					int dy = scan.nextInt();
					LocalDate HireDay = LocalDate.of(yr, mn, dy);
					Emp.setHireDay(HireDay);
					employeeService.addEmployee(Emp);
					System.out.println("***************************************************************************************");
					System.out.println("Do you want to continue?(y/n)");
					proceed = scan.next().charAt(0);
					break;
				case 3:
					List<EmployeePojo> allEmployees = employeeService.getAllEmployees();
					System.out.println("***************************************************************************************");
					System.out.println("ID\tNAME");
					System.out.println("***************************************************************************************");
					allEmployees.forEach((item)-> System.out.println(item.getEmployeeId() + "\t" + item.getName()));
					System.out.println("***************************************************************************************");
					System.out.println("Enter the ID of the employee you would like to delete: ");
					int delItem = scan.nextInt();
					employeeService.deleteEmployee(delItem);
					System.out.println("***************************************************************************************");
					System.out.println("Do you want to continue?(y/n)");
					proceed = scan.next().charAt(0);
					break;
				case 4:
					char cont = 'y';
					while(cont == 'y') {
					List<EmployeePojo> omniEmployees = employeeService.getAllEmployees();
					System.out.println("***************************************************************************************");
					System.out.println("ID\tNAME");
					System.out.println("***************************************************************************************");
					omniEmployees.forEach((item)-> System.out.println(item.getEmployeeId() + "\t" + item.getName()));
					System.out.println("***************************************************************************************");
					System.out.println("Enter the ID of the employee you would like to edit: ");
					int edItem = scan.nextInt();
					EmployeePojo edEmp = employeeService.getAnEmployee(edItem);
					char keep = 'y';
					while(keep == 'y') {
					System.out.println("*****************************");
					System.out.println("1. Edit employee name");
					System.out.println("2. Edit employee salary");
					System.out.println("3. Edit employee hire day");
					System.out.println("*****************************");
					System.out.println("Please enter an option:");
					int choice = scan.nextInt();
					switch(choice) {
						case 1:
							System.out.println("current name is: " + edEmp.getName() );
							System.out.println("enter new name: ");
							scan.nextLine();
							String newName = scan.nextLine();
							edEmp.setName(newName);
							employeeService.updateEmployee(edEmp);
							break;
						case 2:
							System.out.println("current description is: " + edEmp.getSalary() );
							System.out.println("enter new description:");
							scan.nextLine();
							double newDescr = scan.nextDouble();
							edEmp.setSalary(newDescr);
							employeeService.updateEmployee(edEmp);
							break;
						case 3:
							System.out.println("current hire day is: " + edEmp.getHireDay() );
							System.out.println("enter new year:");
							int hireYear = scan.nextInt();
							System.out.println("enter new month as number(1-12):");
							int hireMonth = scan.nextInt();
							System.out.println("enter new day of month:");
							int hireDay = scan.nextInt();
							LocalDate newHire = LocalDate.of(hireYear, hireMonth, hireDay);
							edEmp.setHireDay(newHire);
							employeeService.updateEmployee(edEmp);
							break;
					}
					System.out.println("****************************************************************************************");
					System.out.println("Do you want to continue editing this employee's records? (y/n)");
					keep = scan.next().charAt(0);
					}
					System.out.println("****************************************************************************************");
					System.out.println("Do you want to continue editing employee records? (y/n)");
					cont = scan.next().charAt(0);
					}
					System.out.println("***************************************************************************************");
					System.out.println("Do you want to continue?(y/n)");
					proceed = scan.next().charAt(0);
					break;
				case 5:
					System.out.println("***************************************************************************************");
					System.out.println("Thank you for using Payroll System!!");
					System.out.println("***************************************************************************************");
					System.exit(0);
				default:
					
			}
			
		}
		System.out.println("***************************************************************************************");
		System.out.println("Thank you for using Payroll System!!");
		System.out.println("***************************************************************************************");
		System.exit(0);
	}

}