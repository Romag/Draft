package clusterMerging;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestUsingConstructor {

    private int m1;
    private int m2;
    private Double[] arr3;
    private String[] str4;

    public ParameterizedTestUsingConstructor(int p1, int p2, Double[] pArr, String[] str) {
        m1 = p1;
        m2 = p2;
        arr3 = pArr;
        str4 = str;
    }

    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 1 , 2 , new Double[]{5.0d, 5.9d}, new String[]{"Test", "Test1", "Test2"}}, 
        									{ 5, 3, new Double[]{5.0d, 5.9d}, new String[]{"Test", "Test1", "Test2"} }, 
        									{ 121, 4, new Double[]{5.0d, 5.9d}, new String[]{"Test", "Test1", "Test2"}} };
        return Arrays.asList(data);
    }


    @Test
    public void testMultiplyException() {
        MyClass tester = new MyClass();
        assertEquals("Result", m1 * m2, tester.multiply(m1, m2));
    }


    // class to be tested
    class MyClass {
        public int multiply(int i, int j) {
            return i *j;
        }
    }

}