package com.competition.model;

import lombok.Getter;

@Getter
public enum Role {
    SUPER_ADMINISTRATOR("SA", "Super Adminstrator"),
    ADMINISTRATOR("A", "Administrator"),
    USER("U", "User");

    private final String abbrevation;
    private final String name;

    Role(final String abbrevation, final String name) {
        this.abbrevation = abbrevation;
        this.name = name;
    }
}
