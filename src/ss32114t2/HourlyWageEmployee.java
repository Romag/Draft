package ss32114t2;

public class HourlyWageEmployee extends Employee{
	private int hourlyRate;
	
	public HourlyWageEmployee() {
		hourlyRate = -1;
		averageMonthlySalary = -1;
	}
	
	public HourlyWageEmployee(String name, int ID, int hourlyRate) {
		super(name, ID);
		this.hourlyRate = hourlyRate;
		calcAverageMonthlySalary();
	}
	
	@Override
	protected int calcAverageMonthlySalary() {
		if(averageMonthlySalary != -1) return averageMonthlySalary;
		
		averageMonthlySalary = new Double(20.8*8*hourlyRate).intValue();
		return averageMonthlySalary;
	}

}
