package recurringTaskTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import recurringTask.*;

@RunWith(JUnitParamsRunner.class)
public class RecurringTaskTest {

	@Test
	@Parameters(method="data")
	public void test(String firstDate, int k, String[] daysOfTheWeek, int n, String[] expectedResult) {
		RecurringTask rTask = new RecurringTask();
		String[] result = rTask.recurringTask(firstDate, k, daysOfTheWeek, n);
		
		assertArrayEquals(expectedResult, result);
	}
	
	public Object[] data() {
		return new Object[]{
				new Object[]{
						"01/01/2015",
						2,
						new String[]{"Monday", "Thursday"},
						4,
						new String[]{"01/01/2015", 
									 "05/01/2015", 
									 "15/01/2015", 
									 "19/01/2015"}
				},
				
				new Object[]{
						"30/05/1995",
						4,
						new String[]{"Tuesday"},
						1,
						new String[]{"30/05/1995"}
				},
				
				new Object[]{
						"22/02/2020",
						1,
						new String[]{"Saturday"},
						2,
						new String[]{"22/02/2020", 
								 	"29/02/2020"}
				},
				
				new Object[]{
						"01/02/2100",
						4,
						new String[]{"Sunday", "Monday"},
						4,
						new String[]{"01/02/2100", 
									 "07/02/2100", 
									 "01/03/2100", 
									 "07/03/2100"}
				},
				
				new Object[]{
						"23/02/2000",
						2,
						new String[]{"Wednesday", "Friday"},
						4,
						new String[]{"23/02/2000", 
									 "25/02/2000", 
									 "08/03/2000", 
									 "10/03/2000"}
				},
				
				new Object[]{
						"31/12/2999",
						1,
						new String[]{"Tuesday"},
						2,
						new String[]{"31/12/2999", 
								 	"07/01/3000"}
				}
		};
	}

}
