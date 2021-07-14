package ru.training.at.hw7.tests;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.training.at.hw7.BaseTest;

public class SubmitMetalsAndColorsFormTest extends BaseTest {
    @DataProvider(name = "jsonData")
    public Object[][] getJsonData(ITestContext context) throws FileNotFoundException {
        String dataFile = "src/test/resources/ru.training.at.hw7/JDI_ex8_metalsColorsDataSet.json";
        JsonArray array = JsonParser.parseReader(new FileReader(dataFile)).getAsJsonArray();
        Gson gson = new Gson();
        List<Map> list = gson.fromJson(array, List.class);
        Object[][] objects = list.stream()
                .map(testData ->
                        testData.values().stream().map(obj ->
                                obj).toArray()).toArray(Object[][]::new);
        return objects;
    }

    @Test(dataProvider = "jsonData")
    public void submitMetalsAndColorsFormTest(List<Double> summary, List<String> elements,
            String color, String metal, List<String> vegetables) {
        mainSteps.openMetalsAndColorsPage();
        mainSteps.submitMetalsAndColorsForm(summary, elements, color, metal, vegetables);
        mainSteps.checkMetalsAndColorsResults(summary, elements, color, metal, vegetables);
    }

}
