package matrix;

import java.util.Arrays;

public class Matrix {
	private int[][] matrix;
	private int width;
	private int height;

	public static void main(String[] args) {
		Matrix matrix = new Matrix(new int[][]{ {1, 2, 3},
												{4, 5, 6},
												{7, 8, 9} });
		
		int[][] newMat = matrix.delete(1, 1);
		System.out.println(Arrays.toString(newMat));
	}
	
	public Matrix(int height, int width) {
		this.height = height;
		this.width = width;
		matrix = new int[this.height][this.width];
	}
	
	public Matrix(int[][] matrix) {
		height = matrix.length;
		width = matrix[0].length;
		this.matrix = matrix;
	}

	public int[][] delete(int row, int col) {
		int[][] newMatrix = new int[height-1][width-1];
		
		for(int i=0; i<matrix.length; i++) {
			if(i==row) continue;
			int rowIndex = i>row ? i-1 : i;
			for(int j=0; j<matrix[i].length; j++) {
				if(j==col) continue;
				int colIndex = j>col ? j-1 : j;
				newMatrix[rowIndex][colIndex] = matrix[i][j];
			}
		}
		
		return newMatrix;
	}
	
	public int[][] constructSubmatrix(int[] rowsToDelete, int[] columnsToDelete) {
	    int[][] newMatrix = new int[matrix.length-rowsToDelete.length][matrix[0].length-columnsToDelete.length];
	    int rowIndex=0;
	    int colIndex=0;
	    int rowsPassed=0;
	    int colsPassed=0;
	    
	    for(int i=0; i<matrix.length; i++) {
	        if(contains(rowsToDelete, i)) continue;
	        rowIndex = i-indexMoreThanNElems(rowsToDelete, i);
	        
	        for(int j=0; j<matrix[i].length; j++) {
	            if(contains(columnsToDelete, j)) continue;
	            colIndex = j-indexMoreThanNElems(columnsToDelete, j);
	            
	            System.out.println(rowIndex+" "+colIndex+" "+i+" "+j);
	            newMatrix[rowIndex][colIndex] = matrix[i][j];
	            
	        }
	    }
	    
	    return newMatrix;
	}

	private boolean contains(int[] linesToDelete, int index) {
	    for(int i : linesToDelete) {
	        if(i==index) return true;
	    }
	    
	    return false;
	}

	private int indexMoreThanNElems(int[] linesToDelete, int index) {
	    int result = 0;
	    for(int i : linesToDelete) {
	        if(index > i) result++; //change may be needed
	    }
	    
	    return result;
	}
}
