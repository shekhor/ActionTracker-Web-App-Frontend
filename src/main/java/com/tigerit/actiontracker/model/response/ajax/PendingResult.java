package com.tigerit.actiontracker.model.response.ajax;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PendingResult implements Serializable {
    private static final int FACTOR = 1000;

    private String url;

    private int interval;
}
