package collectionsBenchmarking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Benchmark {
	static final int TESTING_BOUND = 1000000;
	static final String TEST_STRING = "TEST_STRING";

	   public static void main(String args[]) {
		   Benchmark bnch = new Benchmark();
		   
		   List<Integer> list1 = new LinkedList<>();	
		   List<Integer> list2 = new ArrayList<>(TESTING_BOUND);
		   bnch.test(list1);
		   bnch.test(list2);
		   System.out.println();
		   
		   Set<Integer> set1 = new HashSet<Integer>(TESTING_BOUND);
		   Set<Integer> set2 = new LinkedHashSet<Integer>();
		   Set<Integer> set3 = new TreeSet<Integer>();
		   bnch.test(set1);
		   bnch.test(set2);
		   bnch.test(set3);
		   System.out.println();
		   
		   Map<Integer, String> map1 = new HashMap<>();
		   Map<Integer, String> map2 = new TreeMap<>();
		   bnch.test(map1);
		   bnch.test(map2);
	   }

	   private void test(List<Integer> list) {
		   long start = System.currentTimeMillis();	
		   for(int i=0; i<TESTING_BOUND; i++) {
			   list.add(i);
		   }
		   
		   long end = System.currentTimeMillis();
		   System.out.println(list.getClass()+" "+(end-start));
	   }
	   
	   private void test(Set<Integer> set) {
		   long start = System.currentTimeMillis();	
		   for(int i=0; i<TESTING_BOUND; i++) {
			   set.add(i);
		   }
		   
		   long end = System.currentTimeMillis();
		   System.out.println(set.getClass()+" "+(end-start));
	   }
	   
	   private void test(Map<Integer, String> list) {
		   long start = System.currentTimeMillis();	
		   for(int i=0; i<TESTING_BOUND; i++) {
			   list.put(i, TEST_STRING);
		   }
		   
		   long end = System.currentTimeMillis();
		   System.out.println(list.getClass()+" "+(end-start));
	   }

	   private void printList(List<?> list) {
		   for(Object elem : list)
			   System.out.println(elem + " ");
		   System.out.println();
	   }

}
