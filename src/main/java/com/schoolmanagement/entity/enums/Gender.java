package com.schoolmanagement.entity.enums;

public enum Gender {
    GENDER_MALE("male"),
    GENDER_FEMALE("female");


    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
