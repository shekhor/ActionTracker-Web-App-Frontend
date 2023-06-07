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
public class SuccessDetails<T> implements Serializable {
    private T data;

    private String message;

    private String template;

    private String redirect;
}
