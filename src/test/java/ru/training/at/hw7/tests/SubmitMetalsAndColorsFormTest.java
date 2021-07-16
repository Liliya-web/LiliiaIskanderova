package ru.training.at.hw7.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw7.BaseTest;

public class SubmitMetalsAndColorsFormTest extends BaseTest {
    @DataProvider(name = "jsonData")
    public Object[][] getJsonData(ITestContext context) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String dataFile = "src/test/resources/ru.training.at.hw7/JDI_ex8_metalsColorsDataSet.json";
        Map<String, Map<String, Object>> map = mapper.readValue(Paths.get(dataFile).toFile(), Map.class);
        Object[][] objects = map.values().stream()
                .map(testData ->
                        testData.values().stream().map(obj ->
                                obj).toArray()).toArray(Object[][]::new);
        return objects;
    }

    @Test(dataProvider = "jsonData")
    public void submitMetalsAndColorsFormTest(List<Integer> summary, List<String> elements,
            String color, String metal, List<String> vegetables) {
        mainSteps.openMetalsAndColorsPage();
        mainSteps.submitMetalsAndColorsForm(summary, elements, color, metal, vegetables);
        mainSteps.checkMetalsAndColorsResults(summary, elements, color, metal, vegetables);
    }

}
