package ru.training.at.hw8.constants;

public enum PermissionLevel {
    PRIVATE("private"),
    PUBLIC("public"),
    ORG("org");

    public String permissionLevel;

    PermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }
}
