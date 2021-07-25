package ru.training.at.hw8.propertyloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyLoader {
    private static final String PATH = "src/test/resources/environment.properties";
    private static Properties propertiesInstance;

    public static Properties getProperties() {
        if (propertiesInstance != null) {
            return propertiesInstance;
        }
        try (FileInputStream input = new FileInputStream(PATH)) {
            propertiesInstance = new Properties();
            propertiesInstance.load(new InputStreamReader(input, StandardCharsets.UTF_8));
            return propertiesInstance;
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(PropertyLoader.class);
            logger.error("File with properties is not found");
        }
        return null;
    }
}
