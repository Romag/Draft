package ss32114t2;

public abstract class Employee implements Comparable<Employee> {
	private String name;
	private int ID;
	protected int averageMonthlySalary; 
		
	public Employee() {
		name = "Default Name";
		ID = -1;
	}
	
	public Employee(String name, int ID) {
		this.name = name;
		this.ID = ID;
	}
	
	protected abstract int calcAverageMonthlySalary();
	
	@Override
	public String toString() {
		return "Name:"+name+" ID:"+ID+" Monthly Salary:"+averageMonthlySalary;
	}
	
	/**
	 * Compares this Employee with another one by difference in monthly salary. 
	 * If both salaries are equal returns result of standard comparison of names of employees.
	 * @param e another Employee
	 * @return a negative integer, zero, or a positive integer as this object averageMonthlySalary
     *          is less than, equal to, or greater than the averageMonthlySalary  object.
	 */
	public final int compareTo(Employee e) {
		int thisAMS = this.getAverageMonthlySalary();
		int thatAMS = e.getAverageMonthlySalary();
		String thatName = e.name;
		
		if(thisAMS > thatAMS) return 1;
		else if(thisAMS < thatAMS) return -1;
		else return this.name.compareTo(thatName); // If monthly salaries are equal objects are compared by name
	}
	

	public boolean equalsBySalary(Object thatE) {
		if(thatE == null) return false;
		else if(!(thatE instanceof Employee)) return false;
		else return this.averageMonthlySalary == ((Employee)thatE).averageMonthlySalary; 
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getAverageMonthlySalary() {
		return averageMonthlySalary;
	}
}
