import math.MathOperations;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMathOperations {

    @Test
    public void mathTest() {
        Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
        assertThat(MathOperations.add(2,8)).isEqualTo(10);
        assertThat(MathOperations.multiply(2,5)).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource({"1,2", "5,8", "50,100"})
    public void mathTestAddition(int a, int b) {
        Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
        assertEquals(a + b, MathOperations.add(a,b));
    }

}
