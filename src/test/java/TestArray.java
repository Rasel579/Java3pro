import lesson6.TestArrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;


public class TestArray {
    private TestArrays testArray;

    @BeforeEach
    public void init(){
        testArray = new TestArrays();
    }



    @Test
    public void testCheck(){
        Assertions.assertEquals(Arrays.toString(new int[]{5, 6, 6}), Arrays.toString(testArray.checkElements(new int[]{54, 23, 433, 3, 4, 5, 6, 6})));
        Assertions.assertEquals(Arrays.toString(new int[]{1, 7}), Arrays.toString(testArray.checkElements(new int[]{4, 23, 433, 3, 4, 1, 7})));
        Assertions.assertEquals(Arrays.toString(new int[]{5, 1, 7}), Arrays.toString(testArray.checkElements(new int[]{4, 5, 1, 7})));
        Assertions.assertTrue(testArray.isContain(new int[]{1,3,4,1}));
    }
    @Test
    public void testCheckException(){
        Assertions.assertThrows(RuntimeException.class,() -> testArray.checkElements(new int[]{1,1,1}));
    }

    @CsvSource({
            "1, 3, 4, 56, 5",
            "2, 4, 6, 5, 4",
            "1, 3, 6, 5, 1",
            "0, 3, 6, 5, 0",
    })
    @ParameterizedTest
    public void isBooleanTest(int a, int b, int c, int d, int f){
        Assertions.assertTrue(testArray.isContain(new int[]{a, b, c, d, f}));
    }

}
