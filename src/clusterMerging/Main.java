package clusterMerging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Map<Double, List<Integer>> map = new HashMap<>();
		List<Integer> values = new LinkedList<Integer>();
		values.add(1);
		values.add(2);
		map.put(new Double(1.0d), values);
		System.out.println(map.toString());

		for(List<Integer> list : map.values())
			list.add(3);
		System.out.println(map.toString());
		
	}

	public int[][] spamClusterization(String[] requests, int[] ids, double threshold) {
	    int[][] clusters;
	    
	    String[][] words = splitRequests(requests);
	    
	    double[][] jaccardIndexTable = indexForEachPair(words);
	    
	    clusters = divideIntoClusters(jaccardIndexTable, ids, threshold);
	    clusters = sortBySize(clusters);
	    //sortEveryRow(clusters);
	    
	    return clusters;
	}
	
	public String[][] splitRequests(String[] requests) {
	    String[][] result = new String[requests.length][];
	    for(int i=0; i<requests.length; i++) {
	        result[i] = requests[i].split("[^A-Za-z]+");
	    }
	    
	    toLowerCase(result);
	    return result;
	}

	void toLowerCase(String[][] words) {
	    for(int i=0; i<words.length; i++) {
	        for(int j=0; j<words[i].length; j++) {
	            words[i][j] = words[i][j].toLowerCase();
	        }
	    }
	}

	double[][] indexForEachPair(String[][] words) {
	    double[][] jaccardIndexTable = new double[words.length][words.length];
	    
	    for(int i=0; i<words.length; i++) {
	        for(int j=0; j<words.length; j++) {
	            if(i==j) {
	                jaccardIndexTable[i][j] = -1.0f;
	            } else {
	                double index = jaccardIndex(words[i], words[j]);
	                jaccardIndexTable[i][j] = index;
	                jaccardIndexTable[j][i] = index;
	            }
	        }
	    }
	    
	    return jaccardIndexTable;
	}

	double jaccardIndex(String[] fSet, String[] sSet) {
	    Set<String> allElements = new HashSet<>();
	    
	    for(String word : fSet)
	        allElements.add(word);
	    
	    for(String word : sSet)
	        allElements.add(word);
	    
	    double sharedWords = 0.0d;
	    for(String word : allElements) {
	        if(contains(fSet, word) &&
	          contains(sSet, word)) sharedWords++;
	    }
	    
	    return sharedWords/allElements.size();
	}

	boolean contains(String[] set, String target) {
	    for(String word : set) {
	        if(target.equals(word)) return true;
	    }
	    
	    return false;
	}

	int[][] divideIntoClusters(double[][] jaccardIndexTable, int[] ids, double threshold) {
	    Map<Double, Set<Integer>> clusters = new HashMap<>();
	    
	    for(int i=0; i<jaccardIndexTable.length; i++) {
	        for(int j=0; j<jaccardIndexTable[i].length; j++) {
	            if(jaccardIndexTable[i][j]<threshold) continue;
	            Set<Integer> cluster = clusters.containsKey(jaccardIndexTable[i][j]) ? clusters.get(jaccardIndexTable[i][j]) : 
	                                                                                        new HashSet<Integer>();
	            cluster.add(ids[i]);
	            cluster.add(ids[j]);
	            clusters.put(jaccardIndexTable[i][j], cluster);
	        }
	    }
	    
	    mergeClusters(clusters);
	        
	    return clustersLargerThanOne(clusters);
	}

	void mergeClusters(Map<Double, Set<Integer>> clusters) {
	    for(Set<Integer> clusterFir : clusters.values()){
	        for(Set<Integer> clusterSec : clusters.values()) {
	            if(!clusterFir.equals(clusterSec) &&
	              haveSharedElements(clusterFir, clusterSec) &&
	              !clusterFir.isEmpty() && !clusterSec.isEmpty()) {
	                mergeClusters(clusterFir, clusterSec);
	            }
	        }
	    }
	    
	}

	boolean haveSharedElements(Set<Integer> clusterFir, Set<Integer> clusterSec) {
	    for(Integer id : clusterFir) {
	        if(clusterSec.contains(id)) return true;
	    }
	    return false;
	}

	//merge and clear second cluster
	void mergeClusters(Set<Integer> clusterFir, Set<Integer> clusterSec) {
	    for(Integer id : clusterSec)
	        clusterFir.add(id);
	    
	    clusterSec.clear();
	}

	int[][] clustersLargerThanOne(Map<Double, Set<Integer>> clusters) {
	    List<List<Integer>> clustersLTO = new LinkedList<List<Integer>>();
	    for(Map.Entry<Double, Set<Integer>> entry : clusters.entrySet()) {
	        Set<Integer> cluster = entry.getValue();
	        if(cluster.size()>1) clustersLTO.add(new ArrayList<Integer>(cluster));
	    }
	    
	    int[][] clustersArray = convert(clustersLTO);
	    
	    return clustersArray;
	}

	int[][] convert(List<List<Integer>> clustersLTO) {
	    int[][] clustersArray = new int[clustersLTO.size()][];
	    
	    int iter = 0;
	    for(List<Integer> cluster : clustersLTO) {
	        clustersArray[iter] = convert(cluster, new int[0]);
	        iter++;
	    }
	    
	    return clustersArray;
	}

	int[] convert(List<Integer> cluster, int[] arrayType) {
	    arrayType = new int[cluster.size()];
	    int iter = 0;
	    for(Integer id : cluster) {
	        arrayType[iter] = id;
	        iter++;
	    }
	    
	    return arrayType;
	}

	public void print(String[][] strArray) {
	    for(int i=0; i<strArray.length; i++) {
	        System.out.println(Arrays.toString(strArray[i]));
	    }       
	}

	void print(int[][] array) {
	    for(int[] row : array)
	        for(int col : row)
	            System.out.print(col);
	}

	void print(double[][] array) {
	    for(double[] row : array){
	        for(double elem : row) 
	            System.out.printf("%.2f ", elem);
	        System.out.println();
	    }
	        
	}

	public int[][] sortBySize(int[][] clusters) {
	    int min;
	    int minIndex=0;
	    for(int i=0; i<clusters.length; i++) {
	        min = Integer.MAX_VALUE;
	        minIndex = i;
	        for(int j=i; j<clusters.length; j++) {
	            if(min>clusters[j].length) {
	                min = clusters[j].length;
	                minIndex = j;
	            }
	        }
	        swap(clusters, i, minIndex);
	        Arrays.sort(clusters[i]);
	    }
	    
	    return clusters;
	}
	
	void sortEveryRow(int[][] clusters) {
		for(int[] row : clusters) {
			Arrays.sort(row);
		}
	}
	
	void swap(int[][] clusters, int indexF, int indexS) {
	    int[] temp = clusters[indexF];
	    clusters[indexF] = clusters[indexS];
	    clusters[indexS] = temp;
	}
}