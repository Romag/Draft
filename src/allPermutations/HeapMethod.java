package allPermutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HeapMethod {

	public static void main(String[] args) {
		HeapMethod allPermutationsHeap = new HeapMethod();
		int[] A = new int[]{1, 2, 3};
		
	    List<List<Integer>> allPermutations = allPermutationsHeap.generate(A);
	    
	    for(List<Integer> permutation : allPermutations) {
	    	for(Integer i : permutation)
	    		System.out.print(i);
	    	System.out.println();
	    }
		
		//System.out.println(allPermutationsHeap.generate(A).toString());
		
	}

	public List<List<Integer>> generate (int[] A) {
		int n = A.length;
	    int[] c = new int[n];
	    List<List<Integer>> allPermutations = new LinkedList<List<Integer>>();
	    
		for(int i=0; i<c.length; i++) {
			c[i]=0;
		}
	    
		//System.out.println(Arrays.toString(A));
		allPermutations.add( new ArrayList(Arrays.stream(A).boxed().collect(Collectors.toList()) ) );
	    int i=0;
	    while(i<n) {
	    	if(c[i] < i) {
	    		if(i%2==0) {
	    			swap(A, 0, i);
	    		} else {
	    			swap(A, c[i], i);
	    		}
	    		//System.out.println(Arrays.toString(A));
	    		allPermutations.add( new ArrayList(Arrays.stream(A).boxed().collect(Collectors.toList()) ) );
	    		c[i]++;
	    		i = 0;
	    	} else {
	    		c[i] = 0;
	    		i++;
	    	}
	    }
	    
	    return allPermutations;
	}
	    
    public void swap(int[] A, int index1, int index2) {
    	int temp = A[index1];
    	A[index1] = A[index2];
    	A[index2] = temp;
    }
}
