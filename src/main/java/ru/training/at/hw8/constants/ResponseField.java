package ru.training.at.hw8.constants;

public enum ResponseField {
    ID("id"),
    NAME("name"),
    DESC("desc"),
    PERMISSION("permissionLevel"),
    PURPLE("purple");

    public String name;

    ResponseField(String name) {
        this.name = name;
    }
}
