package ss32114t2;

public class FixedSalaryEmployee extends Employee{
	private int fixedMonthlyPayment;
	
	public FixedSalaryEmployee() {
		fixedMonthlyPayment = -1; // ) unless specified
		averageMonthlySalary = -1;
	}
	
	public FixedSalaryEmployee(String name, int ID, int fixedMonthlyPayment) {
		super(name, ID);
		this.fixedMonthlyPayment = fixedMonthlyPayment;
		calcAverageMonthlySalary();
	}
	
	@Override
	protected int calcAverageMonthlySalary() {
		averageMonthlySalary = fixedMonthlyPayment;
		return averageMonthlySalary;
	}

	public int getMonthlyPayment() {
		return fixedMonthlyPayment;
	}
}
