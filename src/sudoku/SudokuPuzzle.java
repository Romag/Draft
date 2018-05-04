package sudoku;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SudokuPuzzle extends SudokuBoard {
	private Map<String, List<Short>> puzzle;
	
	public SudokuPuzzle() {
		
	}
	
	public SudokuPuzzle(String line) {
		puzzle = parsePuzzleFromLine(line); 
	}
	
	
	
	private Map<String, List<Short>> parsePuzzleFromLine(String line) {
		Map<String, List<Short>> puzzle = new HashMap<>();
		List<Short> allPossibleValues = new LinkedList<>();
		for(short i=1; i<=9; i++) allPossibleValues.add(i);
		
		Iterator<String> posIter = ALL_POSITIONS.iterator();
		for(char c : line.toCharArray()) {
			boolean validDigit = Character.isDigit(c);
			int num = validDigit ? Character.digit(c, 10) : -1;
			
			List<Short> values = new LinkedList<Short>();
			if(num>=1 &&
				num<=9) values.add(new Integer(num).shortValue());
			else values = new LinkedList<>(allPossibleValues);
			
			
		}
		
		return null;
	}

	/**
	 * Returns array of possible numbers for a given pistion based on position which looks like A1, A2, C3.
	 * @param positionKey
	 * @return acceptableValues
	 */
	public short[] getAcceptableValuesForPosition(String positionKey) {
		List<Short> valuesList = puzzle.get(positionKey);
		
		short[] acceptableValues = unboxWrapperArray(valuesList.toArray(new Short[0]));
		
		return acceptableValues;
	}
	
	private short[] unboxWrapperArray(Short[] wrapperArray) {
		short[] primitiveArray = new short[wrapperArray.length];
		
		int iterator = 0;
		for(Short sh : wrapperArray) primitiveArray[iterator++] = sh;
		
		return primitiveArray;
	}
	
	
}
