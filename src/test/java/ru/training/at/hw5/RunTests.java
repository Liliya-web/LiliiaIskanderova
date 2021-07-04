package ru.training.at.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/ru.training.at.hw5.feature")
public class RunTests extends AbstractTestNGCucumberTests {
}
