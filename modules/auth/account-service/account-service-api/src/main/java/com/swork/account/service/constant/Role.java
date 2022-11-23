package com.swork.account.service.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public enum Role {

    USER("user"), ADMIN("admin"), SUPER_ADMIN("superAdmin");

    @JsonCreator
    public static Role create(String value) {
        if ((value == null) || value.equals("")) {
            return null;
        }

        for (Role role : values()) {
            if (Objects.equals(role.getValue(), value)) {
                return role;
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

    private Role(String value) {
        _value = value;
    }

    private final String _value;

}
