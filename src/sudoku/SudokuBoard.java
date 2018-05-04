package sudoku;

import java.util.ArrayList;
import java.util.List;

public abstract class SudokuBoard {
	private static final String COLS = "123456789";
	private static final String ROWS = "ABCDEFGH";
	protected static final List<String> ALL_POSITIONS;

	static {
		ALL_POSITIONS = initAllPositions();
	}
	
	private static List<String> initAllPositions() {
		List<String> allPos = new ArrayList(COLS.length()*ROWS.length());
		
		for(int i=0; i<ROWS.length(); i++)
			for(int j=0; j<COLS.length(); j++)
				allPos.add(""+ROWS.charAt(i)+COLS.charAt(j));
		
		return allPos;
	}
}
