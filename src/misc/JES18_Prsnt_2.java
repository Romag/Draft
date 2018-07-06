package misc;

import java.util.Arrays;

public class JES18_Prsnt_2 {
	public static void main(String[] args) {
		int[] array = {5, 1, 3, 4, 0, 8, 9, 7, 6, 2};
		
//		System.out.println(Arrays.toString(array));
//		invertArray(array);
//		System.out.println(Arrays.toString(array));
		
		System.out.println(Arrays.toString(array));
		slide26BubbleSortAmendment(array);
		
		
		
	}
	
	//eternal cycle
	private static void slide20() {
		int[] arr = {1, 2, 3};
		for(int i=0; i<10; i++) {
			System.out.println(arr[i]);
			i-=2;
			//i--d
		}
	}
	
	private static void slide21() {
		int[] arr = {0, 1, 2, 3, 4};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-i; j++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
	
	private static void slide22() {
		int[] arr = {0, 1, 2, 3, 4};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-i; j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void slide23() {
		int[] arr = {0, 1, 2, 3, 4};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
		}
	}
	
	//Bubble sort apparently
	private static void slide2425(int[] array) {
		for(int i=0; i<array.length-1; i++) {
			swap(array, i, i+1);
		}
		
		System.out.println(Arrays.toString(array));
		
	}
	
	//bubble sort with reversed barrier
	private static void slide26BubbleSort(int[] array) {
		for(int barrier = array.length-1; barrier>=0; barrier--) {
			for(int i=0; i<barrier; i++) {
				swap(array, i, i+1);
			}
			System.out.println(Arrays.toString(array));
		}
		System.out.println(Arrays.toString(array));
	}
	
	//Bubble sort in my way
	private static void slide26BubbleSortAmendment(int[] array) {
		for(int i=0; i<array.length-1; i++) {
			for(int j=0; j<array.length-i-1; j++) {
				swap(array, j, j+1);
			}
			System.out.println(Arrays.toString(array));
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	private static void selectionSort(int[] array) {
		for(int leftCursor=0; leftCursor<array.length-1; leftCursor++) {
			for(int rightCursor=leftCursor+1; rightCursor<array.length; rightCursor++) {
				swap(array, leftCursor, rightCursor);
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	private static void selectionSortLessSwaps(int[] array) {
		int minIndex;
		for(int i=0; i<array.length-1; i++) {
			minIndex = i;
			for(int j=i+1; j<array.length; j++) {
				if(array[minIndex] > array[j]) minIndex = j;
			}
			swapNoCond(array, i, minIndex);
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	private static void insertionSort(int[] array) {
		for(int i=1; i<array.length; i++) {
			int elemToInsert = array[i];
			int locationToInsert = i-1;
			
			while(locationToInsert>=0 && array[locationToInsert]>elemToInsert) {
				array[locationToInsert+1] = array[locationToInsert]; 
				locationToInsert--;
			}
			array[locationToInsert+1] = elemToInsert;
		}
	}
	
	private static void swap(int[] array, int first, int second) {
		if(array[first] > array[second]) {
			int temp = array[first];
			array[first] = array[second];
			array[second] = temp;
		}
	}
	
	private static void invertArray(int[] arr) {
		int temp;
		for(int i=0; i<arr.length/2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}
	}
	
	private static void swapNoCond(int[] array, int f, int s) {
		int temp = array[f];
		array[f] = array[s];
		array[s] = temp;
	}
}