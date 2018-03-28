package treeFromInorderPreorder;

import java.util.HashMap;
import java.util.Map;


public class RestoreBinaryTree {

	public static void main(String[] args) {
		int[] inorder = {4, 2, 1, 5, 3, 6};
		int[] preorder = {1, 2, 4, 3, 5, 6};
		System.out.println(restoreBinaryTree(inorder, preorder));

	}
	
	static Tree<Integer> restoreBinaryTree(int[] inorder, int[] preorder) {
	    if(inorder.length == 1) return new Tree<Integer>(inorder[0]);
	    
	    Tree<Integer> root = new Tree<Integer>(inorder[0]);
	    
	    // number in inOrder to position of number in preOrder
	    Map<Integer, Integer> dictionary = new HashMap<>(inorder.length); 
	    fillMap(dictionary, inorder, preorder);
	    
	    root = restoreTree(inorder, preorder, dictionary);
	    
	    return root;
	}

	static Tree<Integer> restoreTree(int[] inorder, int[] preorder, Map<Integer, Integer> dictionary) {
	    return restoreTree(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1, dictionary);
	}

	static Tree<Integer> restoreTree(int[] inorder, int[] preorder, int iStart, int iEnd, int pStart, int pEnd, Map<Integer, Integer> dictionary) {
	    if(iStart > iEnd) return null;
	    Tree<Integer> root = new Tree<>(preorder[pStart]);
	    
	    int leftLength = dictionary.get(preorder[pStart]) - iStart;
	    
	    root.left = restoreTree(inorder, preorder,
	                           iStart, iStart+leftLength-1,
	                           pStart+1, pStart+leftLength,
	                           dictionary);
	    
	    root.right = restoreTree(inorder, preorder,
	                            iStart+leftLength+1, iEnd,
	                            pStart+leftLength+1, pEnd,
	                            dictionary);
	    
	    return root;
	}

	static void fillMap(Map<Integer, Integer> map, int[] inorder, int[] preorder) {
	    for(int i=0; i<preorder.length; i++) {
	        map.put(preorder[i], findPosition(preorder[i], inorder));
	    }
	}

	static int findPosition(int number, int[] array) {
	    for(int i=0; i<array.length; i++) {
	        if(array[i] == number) {
	            return i;
	        }
	    }
	    
	    return -1;
	}




}
