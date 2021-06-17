package ru.training.at.hw1;

import static org.testng.Assert.assertEquals;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivideLongValTest {

    @DataProvider
    public static Object[][] testData() {
        return new Object[][]{{3L, 3L, 1L}, {-10L, -5L, 2L}, {35L, -7L, -5L}, {-30L, 5L, -6L}};
    }

    @Test (dataProvider = "testData")
    public void divideLongValTest(long a, long b, long expectedRes) {
        Calculator calc = new Calculator();
        long actualRes = calc.div(a, b);
        assertEquals(actualRes, expectedRes);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void divideLongByZero() {
        Calculator calc = new Calculator();
        calc.div(3, 0);
    }
}
