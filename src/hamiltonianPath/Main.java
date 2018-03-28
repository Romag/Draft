package hamiltonianPath;

public class Main {

	public static void main(String[] args) {
		String[] inputArray = {"abc", 
				 "abx", 
				 "axx", 
				 "abc"};
		
		Main main = new Main();
		System.out.println(main.stringRearrangement(inputArray));
	}
	
	public boolean stringRearrangement(String[] inputArray) {
		String[] path;
		int position = 0;
		boolean[] visited;
		
		for(int i=0; i<inputArray.length; i++) {
			path = new String[inputArray.length];
			visited = new boolean[inputArray.length];
			path[position] = inputArray[i];
			visited[i] = true;
			if(hasHamPath(inputArray, path, position+1, visited)) return true;
		}
		
		return false;
	}
	
	boolean hasHamPath(String[] inputArray, String[] path, int position, boolean[] visited) {
		if(position == inputArray.length) return true;
		
		for(int i=0; i<inputArray.length; i++) {
			if( visited[i] == false && 
					differsByOne(path[position-1], inputArray[i]) ) {
				path[position] = inputArray[i];
				visited[i] = true;
				if(hasHamPath(inputArray, path, position+1, visited)) return true;
				else visited[i] = false;	
			}
		}
		return false;
	}

	
	
	boolean differsByOne(String first, String second) {
	    int difference = 0;
	    //Assuming both strings have same length
	    for(int i=0; i<first.length(); i++) { 
	        if(first.charAt(i) != second.charAt(i)) difference++;
	    }
	    //System.out.println(first + " " + second + " " + difference);
	    return difference==1;
	}
	
}
