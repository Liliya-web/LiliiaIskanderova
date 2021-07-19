package ru.training.at.hw8.constants;

import com.github.javafaker.Faker;

public class RandomValueParameter {
    public static final String DEFAULT_BOARD_NAME = new Faker().company().name();
    public static final String NEW_BOARD_NAME = new Faker().company().name();
    public static final String BOARD_DESCRIPTION = new Faker().lorem().sentence(7);
    public static final String NEW_BOARD_DESCRIPTION = new Faker().lorem().sentence(7);
    public static final String LABEL_NAME = new Faker().lorem().word();
}
