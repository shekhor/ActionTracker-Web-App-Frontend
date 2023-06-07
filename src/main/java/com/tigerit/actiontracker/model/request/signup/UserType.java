package com.tigerit.actiontracker.model.request.signup;

import java.io.Serializable;
import java.util.Arrays;

public enum UserType implements Serializable {
    SSO,
    COMMON;

    public static Status getStatus(String status) {
        return Arrays.stream(Status.values())
                .filter(v -> v.name().equals(status))
                .findFirst()
                .orElse(null);
    }
}
