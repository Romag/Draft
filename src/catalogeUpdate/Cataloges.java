package catalogeUpdate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Cataloges {
	public static void main(String[] args) {
		
	}
	
	public static String[][] update(String[][] cataloge, String[][] updates) {
		String[][] result = new String[0][];
		
		Map<String, Set<String>> catalogeMap = putCatalogeIntoMap(cataloge);
		Map<String, List<String>> updatesMap = putUpdateCatalogeIntoMap(updates);
		
		catalogeMap = updateCataloge(catalogeMap, updatesMap);
		
		result = convert(catalogeMap, new String[0][0]);
		
		return result;
	}
	
	private static Map<String, Set<String>> putCatalogeIntoMap(String[][] cataloge) {
		Map<String, Set<String>> resultMap = new TreeMap<>();
		
		for(int i=0; i<cataloge.length; i++) {
			Set<String> goodsInCataloge = new TreeSet<>();
			resultMap.put(cataloge[i][0], goodsInCataloge);
			for(int j=1; j<cataloge[i].length; j++) {
				goodsInCataloge.add(cataloge[i][j]);
			}
		}
			
		return resultMap;
	}

	private static Map<String, List<String>> putUpdateCatalogeIntoMap(String[][] updates) {
		Map<String, List<String>> resultMap = new HashMap<>();
		
		for(int i=0; i<updates.length; i++) {
			List<String> goodsToUpdate = resultMap.containsKey(updates[i][0]) ? resultMap.get(updates[i][0]) : new LinkedList<String>();
			for(int j=1; j<updates[i].length; j++) {
				goodsToUpdate.add(updates[i][j]);
			}
			resultMap.put(updates[i][0], goodsToUpdate);
		}
			
		return resultMap;
	}
	
	private static Map<String, Set<String>> updateCataloge(Map<String, Set<String>> catalogeMap, Map<String, List<String>> updatesMap) {
		//Set<String> catalogeRootRow = catalogeMap.get("root");
		for(Map.Entry<String, List<String>> updateEntry : updatesMap.entrySet()) {
			String updateCategory = updateEntry.getKey(); 
			Set<String> targetOfUpdate = catalogeMap.containsKey(updateCategory) ? catalogeMap.get(updateCategory) : 
																					new TreeSet<String>();
			
			//Update TreeSet in catalogeMap specific row or create new key-value pair
			List<String> sourceOfUpdate = updateEntry.getValue();
			for(String itemForUpd : sourceOfUpdate) {
				targetOfUpdate.add(itemForUpd);
			}
			catalogeMap.put(updateCategory, targetOfUpdate);
			
			//Update root
			//catalogeRootRow.add(updateCategory);
		}
		
		
		return catalogeMap;
	}
	
	private static String[][] convert(Map<String, Set<String>> catalogeMap, String[][] typeArray) {
		String[][] result = new String[catalogeMap.size()][];
		
		int i=0,
				j=1;
		for(Map.Entry<String, Set<String>> entry : catalogeMap.entrySet()) {
			j=1;
			result[i] = new String[entry.getValue().size()+1];
			result[i][0] = entry.getKey();
			for(String word : entry.getValue()) {
				result[i][j] = word;
				j++;
			}
			i++;
		}
		
		return result;
	}
}
