import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LabExampleTest {

    private List<Double> createList(Double... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void everyStatementTest() {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class,
                () -> LabExample.sumOfPricesGreaterThan(null,5d));
        assertTrue(ex.getMessage().contains("List of prices is not ok"));

        ex = assertThrows(RuntimeException.class,
                () -> LabExample.sumOfPricesGreaterThan(
                        createList(1d,3d,-2d),2d));
        assertTrue(ex.getMessage().contains("Negative prices not allowed"));

        assertEquals(9d,
                LabExample.sumOfPricesGreaterThan(
                        createList(1d,4d,5d),2d));
    }

    @Test
    void testEveryPath(){
        RuntimeException ex;

        // 1,2,3,12
        ex = assertThrows(RuntimeException.class,
                () -> LabExample.sumOfPricesGreaterThan(null,5d));
        assertTrue(ex.getMessage().contains("List of prices is not ok"));

        // 1,2,4,5.1,5.2,6,7,12
        ex = assertThrows(RuntimeException.class,
                () -> LabExample.sumOfPricesGreaterThan(
                        createList(-3d,5d),2d));
        // ...

        // 1,2,4,5.1,5.2,11,12
        // ...

        // 1,2,4,5.1,(5.2,6,8,9,10,5.3,5.2),11,12
        // ...

        // mixed
        // ...
    }

    @Test
    void multipleConditionsTest(){
        //(prices==null || prices.isEmpty())
        //T || X
        //F || T
        //F || F

        RuntimeException ex;
        ex = assertThrows(RuntimeException.class,
                () -> LabExample.sumOfPricesGreaterThan(null,5d));
        assertTrue(ex.getMessage().contains("List of prices is not ok"));

        // ...
    }
}