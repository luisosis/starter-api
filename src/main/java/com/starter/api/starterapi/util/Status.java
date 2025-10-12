package com.starter.api.starterapi.util;

public enum Status {

    CREATE("Create"),
    IN_PROGRESS("In Progress"),
    COMPLETE("Complete"),
    CANCELLED("Deleted");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public static Status fromString(String value) {
        if (value == null) return null;
        try {
            return Status.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Invalid status: " + value);
        }
    }
}
