package ru.training.at.hw8.constants;

public enum ResponseField {
    ID("id"),
    NAME("name"),
    DESC("desc"),
    PERMISSION("prefs.permissionLevel"),
    LABEL_NAMES("labelNames.purple");

    public String name;

    ResponseField(String name) {
        this.name = name;
    };
}
