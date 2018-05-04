package sudokuTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class SudokuTest {
	
	@Test
	@Parameters(method="generateAllPuzzles")
	public void testPuzzle(int[][] puzzle) {
		
	}
	
	public Object[] generateAllPuzzles() {
		
		
		return null;
	}
}
