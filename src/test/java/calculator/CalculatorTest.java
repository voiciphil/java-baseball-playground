package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void calculateSuccessfully() {
        Calculator calculator = new Calculator("2 + 3 * 4 / 2");
        assertThat(calculator.calculate()).isEqualTo(10);
    }

    @Test
    void divideZero() {
        Calculator calculator = new Calculator("2 + 3 * 4 / 0");
        assertThatThrownBy(calculator::calculate).isInstanceOf(ArithmeticException.class);
    }

    @Test
    void invalidInput1() {
        assertThatThrownBy(() -> new Calculator("1 +")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalidInput2() {
        assertThatThrownBy(() -> new Calculator("x + y")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalidInput3() {
        assertThatThrownBy(() -> new Calculator("1 & 2")).isInstanceOf(IllegalArgumentException.class);
    }
}
