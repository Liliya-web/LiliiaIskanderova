package ru.training.at.hw8.constants;

import java.util.Properties;

import static ru.training.at.hw8.propertyloader.PropertyLoader.getProperties;

public class SingleValueParameter {
    private static final Properties envProperties = getProperties();
    public static final String KEY = envProperties.getProperty("KEY");
    public static final String TOKEN = envProperties.getProperty("TOKEN");
}
