package hamiltonianPathTest;

import static org.junit.Assert.*;

import org.junit.Test;
import hamiltonianPath.*;

public class testCases {

	@Test
	public void I() {
		Main main = new Main();
		
		String[] inputArray = {"aba", 
				 "bbb", 
				 "bab"};
		
		assertFalse(main.stringRearrangement(inputArray));
	}
	
	@Test
	public void II() {
		Main main = new Main();
		
		String[] inputArray = {"ab", 
				 "bb", 
				 "aa"};
		
		assertTrue(main.stringRearrangement(inputArray));
	}
	
	@Test
	public void III() {
		Main main = new Main();
		
		String[] inputArray = {"q", "q"};
		
		assertFalse(main.stringRearrangement(inputArray));
	}
	
	@Test
	public void IV() {
		Main main = new Main();
		
		String[] inputArray = {"zzzzab", 
				 "zzzzbb", 
				 "zzzzaa"};
		
		assertTrue(main.stringRearrangement(inputArray));
	}
	
	@Test
	public void V() {
		Main main = new Main();
		
		String[] inputArray = {"ab", 
				 "ad", 
				 "ef", 
				 "eg"};
		
		assertFalse(main.stringRearrangement(inputArray));
	}
	
	@Test
	public void VI() {
		Main main = new Main();
		
		String[] inputArray = {"abc", 
				 "bef", 
				 "bcc", 
				 "bec", 
				 "bbc", 
				 "bdc"};
		
		assertTrue(main.stringRearrangement(inputArray));
	}
	
	@Test
	public void VII() {
		Main main = new Main();
		
		String[] inputArray = {"abc", 
				 "abx", 
				 "axx", 
				 "abc"};
		
		assertFalse(main.stringRearrangement(inputArray));
	}
	
	@Test
	public void VIII() {
		Main main = new Main();
		
		String[] inputArray = {"abc", 
				 "abx", 
				 "axx", 
				 "abx", 
				 "abc"};
		
		assertTrue(main.stringRearrangement(inputArray));
	}
	
	@Test
	public void IX() {
		Main main = new Main();
		
		String[] inputArray = {"f", 
				 "g", 
				 "a", 
				 "h"};
		
		assertTrue(main.stringRearrangement(inputArray));
	}

}
