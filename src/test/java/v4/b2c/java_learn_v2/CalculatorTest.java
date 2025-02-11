package v4.b2c.java_learn_v2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;
    private List<String> logs;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(); // Inisialisasi sebelum setiap pengujian
        logs = new ArrayList<>();
    }

    @Test
    void testAdd() {
        int result = calculator.add(2, 3);
        logs.add("Add method executed");
        assertEquals(5, result, "Addition should return the correct result");
    }

    @Test
    void testSubtract() {
        int result = calculator.subtract(5, 3);
        logs.add("Subtract method executed");
        assertEquals(2, result, "Subtraction should return the correct result");
    }

    @Test
    void testMultiply() {
        int result = calculator.multiply(4, 3);
        logs.add("Multiply method executed");
        assertEquals(12, result, "Multiplication should return the correct result");
    }

    @Test
    void testDivide() {
        int result = calculator.divide(10, 2);
        logs.add("Divide method executed");
        assertEquals(5, result, "Division should return the correct result");
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0), "Division by zero should throw an exception");
    }

    @AfterEach
    void tearDown() {
        System.out.println(logs);
        logs.clear(); // Bersihkan log setelah setiap pengujian
        System.out.println("Logs cleared after test execution.");
    }


}
