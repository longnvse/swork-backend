package com.swork.core.project.service.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public enum Type {
    MANAGE("manage"),
    HANDLE("handle"),
    PARTICIPATE("participate");

    @JsonCreator
    public static Type create(String value) {
        if ((value == null) || value.equals("")) {
            return null;
        }

        for (Type memberType : values()) {
            if (Objects.equals(memberType.getValue(), value)) {
                return memberType;
            }
        }

        throw new IllegalArgumentException("Invalid enum value: " + value);
    }

    @JsonValue
    public String getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return _value;
    }

    private Type(String value) {
        _value = value;
    }

    private final String _value;
}
