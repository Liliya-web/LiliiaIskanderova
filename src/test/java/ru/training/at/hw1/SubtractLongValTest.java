package ru.training.at.hw1;

import static org.testng.Assert.assertEquals;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractLongValTest {

    @DataProvider
    public static Object[][] testData() {
        return new Object[][]{{1L, 3L, -2L}, {0L, 0L, 0L}, {-101L, -26L, -75L}};
    }

    @Test(dataProvider = "testData")
    public void subtractLongValTest(long a, long b, long expectedRes) {
        Calculator calc = new Calculator();
        long actualRes = calc.sub(a, b);
        assertEquals(actualRes, expectedRes);
    }
}
