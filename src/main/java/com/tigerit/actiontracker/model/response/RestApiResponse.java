package com.tigerit.actiontracker.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tigerit.actiontracker.model.response.ajax.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestApiResponse<T> implements Serializable {
    private String message;

    private String status;

    private StatusCode statusCode;

    private SuccessDetails<T> success;

    private ErrorDetails error;

    private WarningDetails warning;

    private PendingResult pending;
}
