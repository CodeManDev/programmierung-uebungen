package calculator;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        this.calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        this.calculator = null;
    }

    @Test
    public void calculateInvalidOperator() {
        assertEquals(0, this.calculator.calculate(2, 3, "invalid"), 0);
    }

    @Test
    public void add() {
        assertEquals(5, this.calculator.add(2, 3), 0);
    }

    @Test
    public void subtract() {
        assertEquals(-1, this.calculator.subtract(2, 3), 0);
    }

    @Test
    public void multiply() {
        assertEquals(6, this.calculator.multiply(2, 3), 0);
    }

    @Test
    public void divide() {
        assertEquals(2D / 3D, this.calculator.divide(2, 3), 0);
    }

    @Test
    public void divideByZero() {
        assertEquals(0, this.calculator.divide(2, 0), 0);
    }
}