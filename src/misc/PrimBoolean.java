package misc;

public class PrimBoolean {

	public static void main(String[] args) {
		operatorPrecedence();

	}
	
	static void doubleComparison() {
		System.out.println(3*3 + 4*4 == 5*5);
		System.out.println(3.0*3.0 + 4.0*4.0 == 5.0*5.0);
		System.out.println(Math.pow(3.0, 2)+Math.pow(4.0, 2)==Math.pow(5.0, 2));
		
		
		System.out.println(0.03*0.03 + 0.04*0.04 == 0.05*0.05);
		System.out.println(0.03*0.03 + 0.04*0.04 == 0.05*0.05);
		System.out.println(Math.pow(0.03, 2)+Math.pow(0.04, 2)==Math.pow(0.05, 2));
	}
	
	static void operatorPrecedence() {
		System.out.println(- -2 - 6 * 12 / 8 - 1);
		
        int x = 2;            
        //int y = ++x + x++ + +x;            
        System.out.println(x++ + ++x);
        //System.out.println(y);        
        
        int i = 10;
        int n = ++i%5;
        System.out.println(n);
        
        int a = 10, b = 5, c = 1, result;
    	result = a-(c++ + b++);
    	System.out.println(result);
    	
    	int h=5;
    	System.out.println(h++ + h++ + h);
	}
}
