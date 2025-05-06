package com.project.codemic.Codemic.model.enums;

public enum YearLevel {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4);

    private final int value;

    YearLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static YearLevel fromValue(int value) {
        for (YearLevel level : YearLevel.values()) {
            if (level.getValue() == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid Year Value: " + value);
    }
}
