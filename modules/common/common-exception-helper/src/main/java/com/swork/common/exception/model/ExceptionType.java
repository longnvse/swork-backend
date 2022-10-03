package com.swork.common.exception.model;

import java.util.Objects;

public class ExceptionType {

    public enum Status {

        BAD_REQUEST("BadRequest"), AUTH("Auth"), RESOURCE("Resource"), CONFLICT("Conflict"), COMMON ("Common");

        public static Status create(String value) {
            if ((value == null) || value.equals("")) {
                return null;
            }

            for (Status status : values()) {
                if (Objects.equals(status.getValue(), value)) {
                    return status;
                }
            }

            throw new IllegalArgumentException("Invalid enum value: " + value);
        }

        public String getValue() {
            return _value;
        }

        @Override
        public String toString() {
            return _value;
        }

        Status(String value) {
            _value = value;
        }

        private final String _value;

    }


}
