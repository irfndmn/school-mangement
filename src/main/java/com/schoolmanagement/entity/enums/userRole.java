package com.schoolmanagement.entity.enums;

public enum userRole {

    ROLE_ADMIN("admin"),
    ROLE_TEACHER("teacher"),
    ROLE_STUDENT("student"),
    ROLE_DEAN("dean");

    private final String name;

    userRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
