package com.tigerit.actiontracker.model.request.signup;

import java.io.Serializable;

public enum Status implements Serializable {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
