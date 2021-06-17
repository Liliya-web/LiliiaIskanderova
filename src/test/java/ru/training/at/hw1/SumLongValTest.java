package ru.training.at.hw1;

import static org.testng.Assert.assertEquals;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumLongValTest {

    @DataProvider
    public static Object[][] testData() {
        return new Object[][]{{1L, 3L, 4L}, {0L, 0L, 0L}, {-101L, -24L, -125L}};
    }

    @Test (dataProvider = "testData")
    public void sumTest(long a, long b, long expectedRes) {
        Calculator calc = new Calculator();
        long actualRes = calc.sum(a, b);
        assertEquals(actualRes, expectedRes);
    }
}
