package exception;

public class EmptyPayrollException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Payroll is Empty!";
	}
	
}
