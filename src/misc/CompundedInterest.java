package misc;

public class CompundedInterest {
	public static void main(String[] args) {
		double principal = 15000.0;
		double monthlyAddition = 1000.0;
		double monthlyAdditionIncrease = 1.025; // Moderate raises
		int duration = 12*35; //month
		double rate = 0.022; // % per month
		
		double result = principal;
		
		for(int i=0; i<duration; i++) {
			if(i%12==0) monthlyAddition*=monthlyAdditionIncrease;
			principal += monthlyAddition;
			result = (result+monthlyAddition)*(1+rate);
			
		}
		
		System.out.println("Disposable income: " + monthlyAddition);
		System.out.println("Principal: "+principal);
		System.out.println("Accrued interest: "+(long)(result-principal));
		System.out.println("Result: "+(long)result);
	}
}
