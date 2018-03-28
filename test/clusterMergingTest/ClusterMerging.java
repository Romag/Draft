package clusterMergingTest;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;

import clusterMerging.Main;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class ClusterMerging {
	@Test
	@Parameters(method="dataI")
	public void testClusterMerging(
	  String[] requests, int[] ids, double threshold, int[][] expectedValue) {
		Main m = new Main();
		
		assertTrue(Arrays.deepEquals(m.spamClusterization(requests, ids, threshold), expectedValue));
	}
	 
	private Object[] dataI() {
	    return new Object[] { 
	        new Object[] { new String[]{"I need a new window.", 
	        		 "I really, really want to replace my window!", 
	        		 "Replace my window.", 
	        		 "I want a new window.", 
	        		 "I want a new carpet, I want a new carpet, I want a new carpet.", 
	        		 "Replace my carpet"}, 
	        		new int[]{374, 2845, 83, 1848, 1837, 1500},
	        		0.5d,
	        		new int[][]{{83,1500}, {374,1837,1848}} },
	        
	        new Object[] { new String[]{"A", 
	        		 "C", 
	        		 "A C"}, 
	        		new int[]{374, 2845, 83},
	        		0.5d,
	        		new int[][]{ {83,374,2845}} },
	        
	        new Object[] { new String[]{"I need a new window", 
	        		 "I really, really want to replace my window", 
	        		 "Replace mY !!.windoW........", 
	        		 "I want a new window?", 
	        		 "I want a new carpet, i want a new carpet, I WANT A NEW CARPET", 
	        		 "RePlAcE!!! !!!My!!! !!!CaRpEt!!!!"}, 
	        		new int[]{374, 2845, 83, 1848, 1837, 1500},
	        		0.5d,
	        		new int[][]{{83,1500}, {374,1837,1848}} },
	        
	        new Object[] { new String[]{"I need a new window"}, 
	        		new int[]{239},
	        		0.5d,
	        		new int[][]{} },
	        
	        new Object[] { new String[]{"Wow So Cute!! wow wow", 
	        		 "So cute, wow! Cute cute cute"}, 
	        		new int[]{239, 999},
	        		1d,
	        		new int[][]{{239, 999}} }
	    };
	}
	
	@Test
	@Parameters(method="dataII")
	public void mdArraySortBySize(int[][] array, int[][] result) {
		Main m = new Main();
		assertTrue(Arrays.deepEquals(m.sortBySize(array), result));
	}
	
	private Object[] dataII() {
		return new Object[]{
				new Object[] {
					new int[][]{ {1, 2, 3}, {2}, {15, 2}, {} },
					new int[][]{ {}, {2}, {2, 15}, {1, 2, 3} },
					new int[][]{  }
				}
		};
		
	}

}
