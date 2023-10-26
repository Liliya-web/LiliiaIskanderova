package ru.training.at.hw8.constants;

import com.github.javafaker.Faker;

public class RandomValueParameter {
    private static Faker faker = new Faker();
    public static String DEFAULT_BOARD_NAME = faker.company().name();
    public static String NEW_BOARD_NAME = faker.company().name();
    public static String BOARD_DESCRIPTION = faker.lorem().sentence(7);
    public static String NEW_BOARD_DESCRIPTION = faker.lorem().sentence(7);
    public static String LABEL_NAME = faker.lorem().word();
}
