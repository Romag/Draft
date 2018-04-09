package longestZigzagSequence;

public class NumberSequence {
	private final int[] sequence;
	
	public static void main(String[] args) {
		NumberSequence numSeq = new NumberSequence(new int[]{9, 8, 8, 5, 3, 5, 3, 2, 8, 6}); // == 4
		System.out.println(numSeq.longestZigzagSequence()+" "+4);
		
		numSeq = new NumberSequence(new int[]{4, 4});//4, 4 == 1
		System.out.println(numSeq.longestZigzagSequence()+" "+1);
		
		numSeq = new NumberSequence(new int[]{2, 1, 4, 4, 1, 4, 4, 1, 2, 0, 1, 0, 0, 3, 1, 3, 4, 1, 3, 4});
		System.out.println(numSeq.longestZigzagSequence()+" "+6);
		//2, 1, 4, 4, 1, 4, 4, 1, 2, 0, 1, 0, 0, 3, 1, 3, 4, 1, 3, 4 == 6

	}
	
	public NumberSequence(int[] sequence) {
		this.sequence = sequence;
	}
	
	public int longestZigzagSequence() {
		if(sequence.length < 3) return 1;
		int maxLength = 0;
		int length = 0;
		
		for(int i=1; i<sequence.length-1; i++) {
			int prev = sequence[i-1],
					curr = sequence[i],
					next = sequence[i+1];
			if( (curr>prev && curr>next) || 
					(curr<prev && curr<next) ) {
				length++;
			} else {
				if(maxLength<length) maxLength=length;
				length=0;
			}
		}
		
		
		return maxLength+2;
	}

}
