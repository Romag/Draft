package enumPract;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import junit.framework.Test;

public class Main {

	public static void main(String[] args) {
		doSomth(5);
	}
	
	static void doSomth(Byte b) {
		System.out.println("Byte");
	}
	
//	static void doSomth(Integer i) {
//		System.out.println("Integer");
//	}
	
	static void doSomth(Long l) {
		System.out.println("Long");
	}
	
	static void doSomth(Double d) {
		System.out.println("Double");
	}
	
	static void doSomth(Float f) {
		System.out.println("Float");
	}
	
	static void doSomth(Number n) {
		System.out.println("Number");
	}
	
	static void doSomth(Object o) {
		System.out.println("Object");
	}
	
	static void doSomth(String str) {
		System.out.println("String");
	}

	static void doSomth(A a) {
		System.out.println("doSmth A");
		a.check();
		((B)a).check();
	}
	
	static void doSomth(B b) {
		System.out.println("doSmth B");
		b.check();
	}
}


class A {
	public static void check() {System.out.println("inside class A");}
}

class B extends A { 
	public static void check() {System.out.println("inside class B");}
}





