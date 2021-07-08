package ru.training.at.hw5.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class TestContext {

    private static TestContext instance;

    private Map<String, Object> context = new HashMap<>();

    private TestContext() {
    }

    public void addTestObject(String key, Object value) {
        context.put(key, value);
    }

    public <T> T getTestObject(String key) {
        return (T) context.get(key);
    }

    public void clean() {
        context.clear();
        instance = null;
    }

    public static TestContext getInstance() {
        if (Objects.isNull(instance)) {
            instance = new TestContext();
        }
        return instance;
    }
}
