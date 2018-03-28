package clusterMergingTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import clusterMerging.Main;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class SplitSentenceTest {

	@Test
	@Parameters(method="data")
	public void test(String[] requests) {
		Main m = new Main();
		String[][] wordsOfRequests = m.splitRequests(requests);
		m.print(wordsOfRequests);
		assertTrue(true);
	}
	
	private Object[] data() {
		return new Object[]{
				new Object[]{
						new String[]{
								"   Test   of    spaces   ",
								"test-of-minus-as-punctuation-marks",
								"test,./of all;other`marks;I#could!imagine",
								"!every@other#punct$mark%on^key&board*must(work)))no__matter+how++many====of]them[are...",
								"''''''''''",
								"it's"
						}
					
				}
		};
	}
}
