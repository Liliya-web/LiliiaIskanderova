package ru.training.at.hw1;

import static org.testng.Assert.assertEquals;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyLongValTest {

    @DataProvider
    public static Object[][] testData() {
        return new Object[][]{{3L, 3L, 9L}, {-10L, -5L, 50L}, {5L, -7L, -35L}, {-30L, 5L, -150L}, {0L, 0L, 0L}};
    }

    @Test (dataProvider = "testData")
    public void multiplyLongValTest(long a, long b, long expectedRes) {
        Calculator calc = new Calculator();
        long actualRes = calc.mult(a, b);
        assertEquals(actualRes, expectedRes);
    }
}
