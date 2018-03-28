package incredibleTasks;

class A
{
 
 static int method1(int i)
 {
	 System.out.println(i*=11);
  return method2(i *= 11);
 }
 
 static int method2(int i)
 {
  return method3(i /= 11);
 }
 
 static int method3(int i)
 {
 return method4(i -= 11);
 }
 
 static int method4(int i)
 {
  return i += 11;
 }   
 
 public static void main(String [] args)
 {
  System.out.println(method1(11));
 }
}
