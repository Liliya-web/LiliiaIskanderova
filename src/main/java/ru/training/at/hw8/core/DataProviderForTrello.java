package ru.training.at.hw8.core;

import static ru.training.at.hw8.constants.PermissionLevel.ORG;
import static ru.training.at.hw8.constants.PermissionLevel.PRIVATE;
import static ru.training.at.hw8.constants.PermissionLevel.PUBLIC;
import static ru.training.at.hw8.constants.RandomValueParameter.BOARD_DESCRIPTION;
import static ru.training.at.hw8.constants.RandomValueParameter.DEFAULT_BOARD_NAME;
import static ru.training.at.hw8.constants.RandomValueParameter.LABEL_NAME;
import static ru.training.at.hw8.constants.RandomValueParameter.NEW_BOARD_DESCRIPTION;
import static ru.training.at.hw8.constants.RandomValueParameter.NEW_BOARD_NAME;

import org.testng.annotations.DataProvider;

public class DataProviderForTrello {
    @DataProvider
    public static Object[][] createDefaultBoardDataProvider() {
        return new Object[][]{
                {DEFAULT_BOARD_NAME, PRIVATE}
        };
    }

    @DataProvider
    public static Object[][] createBoardWithCustomParametersDataProvider() {
        return new Object[][]{
                {DEFAULT_BOARD_NAME, BOARD_DESCRIPTION, ORG}
        };
    }

    @DataProvider
    public static Object[][] updateBoardDataProvider() {
        return new Object[][]{
                {DEFAULT_BOARD_NAME, NEW_BOARD_NAME, BOARD_DESCRIPTION, PUBLIC, LABEL_NAME}
        };
    }

    @DataProvider
    public static Object[][] updateBoardWithCustomParametersDataProvider() {
        return new Object[][]{
                {DEFAULT_BOARD_NAME, NEW_BOARD_NAME, BOARD_DESCRIPTION, NEW_BOARD_DESCRIPTION, PUBLIC, LABEL_NAME}
        };
    }

    @DataProvider
    public static Object[][] createBoardsWithDifferentPermissionsDataProvider() {
        return new Object[][]{
                {DEFAULT_BOARD_NAME, PRIVATE},
                {DEFAULT_BOARD_NAME, PUBLIC},
                {DEFAULT_BOARD_NAME, ORG}
        };
    }
}
