package lab0;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestVariant1 {

    // Boolean17 Test
    @Test(dataProvider = "boolean17Provider")
    public void booleanTask17Test(int number, boolean expected) {
        assertEquals(new Variant17().booleanTask17(number), expected);
    }

    @DataProvider
    public Object[][] boolean17Provider() {
        return new Object[][] { { 123, true }, { 456, false }, { 999, true }, { 100, false }, { 99, false } }; 
    }

    // For17 Test
    @Test(dataProvider = "for17Provider")
    public void forTask17Test(double A, int N, double expected) {
        assertEquals(new Variant17().forTask17(A, N), expected, 0.0001);
    }
    
    @DataProvider
    public Object[][] for17Provider() {
    return new Object[][] {
        { 2.0, 3, 15.0 },  
        { 1.5, 2, 4.75 },  
        { 3.0, 4, 121.0 }, 
        { 0.5, 3, 1.875 }, 
    };
}

    

    // Matrix17 Test
    @Test(dataProvider = "matrix17Provider")
    public void matrixTask17Test(double[][] matrix, int K, double[] expected) {
        assertEquals(new Variant17().matrixTask17(matrix, K), expected, 0.00001);
    }

    @DataProvider
    public Object[][] matrix17Provider() {
        return new Object[][] {
            { new double[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} }, 1, new double[] { 6, 6 } } 
        };
    }

    // Array17 Test
    @Test(dataProvider = "array17Provider")
    public void arrayTask17Test(int[] array, int[] expected) {
        assertEquals(new Variant17().arrayTask17(array), expected);
    }

    @DataProvider
    public Object[][] array17Provider() { 
        return new Object[][] { { new int[] { 1, 2, 3, 4, 5}, new int[] { 1, 5, 2, 4, 3 } } };
    }

    // Case17 Test
    @Test(dataProvider = "case17Provider")
    public void caseTask17Test(int number, String expected) {
        assertEquals(new Variant17().caseTask17(number), expected);
    }

    @DataProvider
    public Object[][] case17Provider() {
        return new Object[][] { 
            { 18, "вісімнадцять" }, 
            { 31, "тридцять один" } 
        };
    }

    // If17 Test
    @Test(dataProvider = "if17Provider")
    public void ifTask17Test(double A, double B, double C, double[] expected) {
        assertEquals(new Variant17().ifTask17(A, B, C), expected, 0.00001);
    }

    @DataProvider
    public Object[][] if17Provider() {
        return new Object[][] {
            { 1.0, 2.0, 3.0, new double[] { 2.0, 4.0, 6.0 } },  
            { 3.0, 2.0, 1.0, new double[] { 6.0, 4.0, 2.0 } },  
            { 1.0, 3.0, 2.0, new double[] { -1.0, -3.0, -2.0 } }, 
            { 2.0, 2.0, 2.0, new double[] { -2.0, -2.0, -2.0 } }, 
        };
    }

    // Integer17 Test
    @Test(dataProvider = "integer17Provider")
    public void integerTask17Test(int number, int expected) {
        assertEquals(new Variant17().integerTask17(number), expected);
    }

    @DataProvider
    public Object[][] integer17Provider() {
        return new Object[][] { { 1234, 2 }, { 56789, 7 } };
    }

    // While17 Test
    @Test(dataProvider = "while17Provider")
    public void whileTask17Test(int number, int[] expected) {
        assertEquals(new Variant17().whileTask17(number), expected);
    }

    @DataProvider
    public Object[][] while17Provider() {
    return new Object[][] {
        { 1234, new int[] { 1, 2, 3, 4 } }, 
        { 98765, new int[] { 9, 8, 7, 6, 5 } }
    };
}

}
