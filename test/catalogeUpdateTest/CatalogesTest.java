package catalogeUpdateTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import catalogeUpdate.Cataloges;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class CatalogesTest {

	@Test
	@Parameters(method="data")
	public void test(String[][] cataloge, String[][] updates, String[][] expectedResult) {
		String[][] result = Cataloges.update(cataloge, updates); 
		assertArrayEquals(result, expectedResult);
	}
	
	public Object[] data() {
		return new Object[]{
				new Object[] {
						new String[][] {{"Books","Classics","Fiction"}, 
						                {"Electronics","Cell Phones","Computers","Ultimate item"}, 
						                {"Grocery","Beverages","Snacks"}, 
						                {"Snacks","Chocolate","Sweets"}, 
						                {"root","Books","Electronics","Grocery"}},
						new String[][] {{"Snacks","Marmalade"}, 
						                {"Fiction","Harry Potter"}, 
						                {"root","T-shirts"}, 
						                {"T-shirts","CodeFights"}},
						new String[][] {{"Books","Classics","Fiction"}, 
						                {"Electronics","Cell Phones","Computers","Ultimate item"}, 
						                {"Fiction","Harry Potter"}, 
						                {"Grocery","Beverages","Snacks"}, 
						                {"Snacks","Chocolate","Marmalade","Sweets"}, 
						                {"T-shirts","CodeFights"}, 
						                {"root","Books","Electronics","Grocery","T-shirts"}}
				},
				new Object[] {
						new String[][] {{"Books","Classics","Fiction "}, 
						                {"Electronics","Cell Phones","Computers","Ultimate item"}, 
						                {"Grocery","Beverages","Snacks"}, 
						                {"Snacks","Chocolate","Sweets"}, 
						                {"root","Books","Electronics","Grocery"}},
						new String[][] {{"Snacks","Marmalade"}, 
						                {"Fiction ","The Chronicles of Narnia"}, 
						                {"Fiction ","Fiction stories"}, 
						                {"Snacks","Tuc"}, 
						                {"root","T-shirts-men"}, 
						                {"T-shirts-men","My little pony t-shirt"}, 
						                {"Fiction ","Harry Potter"}, 
						                {"root","T-shirts"}, 
						                {"T-shirts","CodeFights"}, 
						                {"Fiction stories","Frozen heart"}, 
						                {"Fiction stories","Marvel films"}, 
						                {"Marvel films","Ant-man"}, 
						                {"Marvel films","Avengers"}},
						new String[][] {{"Books","Classics","Fiction "}, 
						                {"Electronics","Cell Phones","Computers","Ultimate item"}, 
						                {"Fiction ","Fiction stories","Harry Potter","The Chronicles of Narnia"}, 
						                {"Fiction stories","Frozen heart","Marvel films"}, 
						                {"Grocery","Beverages","Snacks"}, 
						                {"Marvel films","Ant-man","Avengers"}, 
						                {"Snacks","Chocolate","Marmalade","Sweets","Tuc"}, 
						                {"T-shirts","CodeFights"}, 
						                {"T-shirts-men","My little pony t-shirt"}, 
						                {"root","Books","Electronics","Grocery","T-shirts","T-shirts-men"}}
				},
				new Object[] {
						new String[][] {{"root","All","Fiction","here","topics"}},
						new String[][] {{"root","and"}, 
						                {"root","Fiction stories"}, 
						                {"Fiction stories","The Chronicles of Narnia"}, 
						                {"root","T-shirts-men"}, 
						                {"root","words"}, 
						                {"T-shirts-men","My little pony t-shirt"}, 
						                {"T-shirts-men","T-shirts"}, 
						                {"Fiction","Harry Potter"}, 
						                {"root","and good T-shirts"}, 
						                {"T-shirts","CodeFights"}},
						new String[][] {{"Fiction","Harry Potter"}, 
										{"Fiction stories","The Chronicles of Narnia"}, 
										{"T-shirts","CodeFights"}, 
										{"T-shirts-men","My little pony t-shirt","T-shirts"}, 
						                {"root","All","Fiction","Fiction stories","T-shirts-men","and","and good T-shirts","here","topics","words"}}
						
				},
				new Object[] {
						new String[][] {{"root","All"}},
						new String[][] {},
						new String[][] {{"root","All"}}
				}
				
		};
	}

}
