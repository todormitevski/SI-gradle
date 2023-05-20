import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @BeforeAll
    static void init(){
        System.out.println("This method will be invoked BEFORE all other methods!");
    }

    @AfterAll
    static void destroy(){
        System.out.println("This method will be invoked AFTER all other methods!");
    }

    @BeforeEach
    void beforeEachTest(){
        System.out.println("This method will be invoked BEFORE each test!");
    }

    @AfterEach
    void afterEachTest(){
        System.out.println("This method will be invoked AFTER each test!");
    }

    @Test
    void divideNormalNumbers() {
        System.out.println("Test divideNormalNumbers");
        assertEquals(3, calculator.divide(9,3));
        assertEquals(2, calculator.divide(4,2));
        assertEquals(0, calculator.divide(0,2));
    }

    @Test
    void divideDecimalNumbers(){
        System.out.println("Test divideDecimalNumbers");
        assertEquals(2.25,calculator.divide(9,4));
        //assertEquals(1,calculator.divide(0,4.5));
        assertEquals(0.5,calculator.divide(1,2));
    }

    @Test
    void assertionTypes(){
        assertEquals(3,calculator.divide(9,3));
        assertEquals(3,calculator.divide(9,3),"Optional failure message");
        assertTrue(3 > calculator.divide(4,2), "OFM");
        assertNotEquals(3,calculator.divide(10,3));
    }

    @Test
    void testGroupedAssertions(){
        assertAll("AssertionHeading",
                () -> assertEquals(3, calculator.divide(6,2)),
                () -> assertEquals(3, calculator.divide(4,2)),
                () -> assertEquals(3, calculator.divide(2,2)),
                () -> assertEquals(3, calculator.divide(0,2))
        );
    }

    @Test
    void timeoutNotExceeded(){
        assertTimeout(Duration.ofMillis(3), () ->{
            calculator.calculateTotalInterval(0,50000);
        });
    }

    @Test
    void exceptionTest(){
        assertThrows(RuntimeException.class, () -> calculator.divide(5,0));
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> calculator.divide(5,0));
        assertTrue(ex.getMessage().contains("Cannot divide by zero!"));
    }

    @Test
    void exceptionTestSecondary(){
        RuntimeException ex = null;
        try{
            calculator.divide(5,0);
        } catch(RuntimeException e){
            ex = e;
        }
        assertNotNull(ex);
    }
}