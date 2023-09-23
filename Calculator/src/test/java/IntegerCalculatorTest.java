
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.IntegerCalculator;



public class IntegerCalculatorTest {

    private final IntegerCalculator IntegerCalculator = new IntegerCalculator();


    @Test
    @DisplayName("#add > When both numbers are positive > Return a positive number")
    void addWhenBothNumbersArePositiveReturnAPositiveNumber() {
        int result = (int) IntegerCalculator.add(3,4);
        assertEquals(7, result);
    }

    @Test
    void addWhenBothNumbersAreNegativeReturnANegativeNumber() {
        int result = (int) IntegerCalculator.add(-3, -4);
        assertEquals(-7, result);
    }

    @Test
    void addWhenOneNumberIsPositiveAndTheAnotherIsNegativeReturnAPositiveNumber() {
        int result = (int) IntegerCalculator.add(-3, 4);
        assertEquals(1, result);
    }

    @Test
    void addWhenOneNumberIsPositiveAndTheAnotherIsNegativeReturnANegativeNumber() {
        int result = (int) IntegerCalculator.add(3, -4);
        assertEquals(-1, result);
    }

    @Test
    void addWhenOneNumberIsZeroReturnTheGivenNumber() {
        int result = (int) IntegerCalculator.add(3, 0);
        int secondResult = (int) IntegerCalculator.add(0, 4);
        assertAll(
                () -> assertEquals(3, result),
                () -> assertEquals(4, secondResult)
        );
    }

    @Test
    void addWhenOneNumberIsNegativeAndTheAnotherIsZeroReturnTheGivenNumber() {
        int result = (int) IntegerCalculator.add(-3, 0);
        int secondResult = (int) IntegerCalculator.add(0, -4);
        assertAll(
                () -> assertEquals(-3, result),
                () -> assertEquals(-4, secondResult)
        );
    }

    @Test
    @DisplayName("#divide > When the divider is zero > Throw an exception")
    void divideWhenTheDividerIsZeroThrowAnException() {
        assertThrows(ArithmeticException.class,

                () -> {IntegerCalculator.divide(5, 0); }
        );

    }

    @Test
    @DisplayName("#divide> When one number is negative > Return a negative number")
    void divideWhenOneNumberIsNegativeAndTheAnotherIsPositiveReturnANegativeNumber() {
        assertEquals(-5.0, IntegerCalculator.divide(15,-3));
        assertEquals(-2.5, IntegerCalculator.divide(-10,4));
    }


    @Test
    @DisplayName("#divide> When both numbers are negative > Return a positive number")
    void divideWhenBothNumbersAreNegativeReturnAPositiveNumber() {
        assertEquals(5.0, IntegerCalculator.divide(-15,-3));
        assertEquals(2.5, IntegerCalculator.divide(-10,-4));
    }


    @Test
    @DisplayName("#divide> When one both numbers are positive > Return a positive number")
    void divideWhenBothNumbersArePositiveReturnAPositiveNumber() {
        assertEquals(5.0, IntegerCalculator.divide(15,3));
        assertEquals(2.5, IntegerCalculator.divide(10,4));
    }


    @Test
    @DisplayName("#divide> When the divider is one > Return the dividend")
    void divideWhenTheDividerIsOneReturnTheGivenNumber() {
        assertEquals(15.0, IntegerCalculator.divide(15,1));
        assertEquals(10.0, IntegerCalculator.divide(10,1));
    }


    @Test
    @DisplayName("#multiply > When the both numbers are positive > Return a positive number")
    void multiplyWhenTheBothNumbersArePositive () {
        assertEquals(10, IntegerCalculator.multiply(5,2));
    }


    @Test
    @DisplayName("#multiply > When the one of the numbers is negative > Return a negative number")
    void multiplyWhenOneNumberIsNegativeReturnANegativeNumber () {
        assertEquals(-10, IntegerCalculator.multiply(5,-2));
    }


    @Test
    @DisplayName("#multiply > When the both numbers is negative > Return a positive number")
    void multiplyWhenBothNumbersAreNegativeReturnAPositiveNumber () {
        assertEquals(10, IntegerCalculator.multiply(-5,-2));
    }


    @Test
    @DisplayName("#multiply > When the one of the numbers is zero > Return zero")
    void multiplyWhenOneNumberIsZeroReturnZero() {
        assertEquals(0, IntegerCalculator.multiply(5,0));
        assertEquals(0, IntegerCalculator.multiply(0,67));
    }

    @Test
    @DisplayName("#multiply > When the one of the numbers is one > Return the given number")
    void multiplyWhenOneOfTheNumbersIsOneReturnTheGivenNumber() {
        assertEquals(5, IntegerCalculator.multiply(5,1));
        assertEquals(12, IntegerCalculator.multiply(1, 12));
    }

    @Test
    @DisplayName("#subtraction > When the both numbers are positive and the first is greater than the second > Return a positive number")
    void subtractWhenBothNumbersArePositiveAndTheFirstIsGreaterThanTheSecondReturnAPositiveNumber() {
        assertEquals(1, IntegerCalculator.subtract(10,9));
        assertEquals(5, IntegerCalculator.subtract(8, 3));
    }

    @Test
    @DisplayName("#subtraction > When the both numbers are positive and the first is smaller than the second > Return a negative number")
    void subtractWhenBothNumbersArePositiveAndTheFirstIsSmallerThanTheSecondReturnAPositiveNumber() {
        assertEquals(-5, IntegerCalculator.subtract(5,10));
        assertEquals(-6, IntegerCalculator.subtract(6, 12));
    }

    @Test
    @DisplayName("#subtraction > When the one the first number is positive and the second is negative > Return a positive number")
    void subtractWhenTheFirstNumberIsPositiveAndTheSecondIsNegativeReturnAPositiveNumber() {
        assertEquals(19, IntegerCalculator.subtract(10,-9));
        assertEquals(11, IntegerCalculator.subtract(8, -3));
    }
    @Test
    @DisplayName("#subtraction > When the both numbers are negative and the first number is greater than the second > Return a negative number")
    void subtractWhenTheBothNumbersAreNegativeAndTheFirstNumberIsGreaterThanTheSecondReturnANegativeNumber() {
        assertEquals(-1, IntegerCalculator.subtract(-10,-9));
        assertEquals(-5, IntegerCalculator.subtract(-8, -3));
    }

    @Test
    @DisplayName("#subtraction > When the both numbers are negative and the first number is smaller than the second > Return a positive number")
    void subtractWhenTheBothNumbersAreNegativeAndTheFirstNumberIsSmallerThanTheSecondReturnAPositiveNumber() {
        assertEquals(4, IntegerCalculator.subtract(-8,-12));
        assertEquals(5, IntegerCalculator.subtract(-5, -10));

    }

    @Test
    @DisplayName("#subtraction > When the first number is negative and the second is positive > Return a negative number")
    void subtractWhenTheFirstNumberIsNegativeAndTheSecondIsPositiveReturnANegativeNumber() {
        assertEquals(-15, IntegerCalculator.subtract(-10,5));
        assertEquals(-12, IntegerCalculator.subtract(-8, 4));
    }



















}
