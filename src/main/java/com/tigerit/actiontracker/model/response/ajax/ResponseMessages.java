package com.tigerit.actiontracker.model.response.ajax;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessages implements Serializable {

    private String message;

    private StatusCode status;

    private String errorCode;
}
