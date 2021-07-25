package ru.training.at.hw8.constants;

import static ru.training.at.hw8.propertyloader.PropertyLoader.getProperties;

import java.util.Properties;

public class SingleValueParameter {
    private static final Properties envProperties = getProperties();
    public static final String KEY;
    public static final String TOKEN;

    static {
        assert envProperties != null;
        KEY = envProperties.getProperty("KEY");
        TOKEN = envProperties.getProperty("TOKEN");
    }
}
