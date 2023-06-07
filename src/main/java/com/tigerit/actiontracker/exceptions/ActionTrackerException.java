package com.tigerit.actiontracker.exceptions;

import com.tigerit.actiontracker.model.response.ajax.ErrorDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActionTrackerException extends Exception {

    private String code;

    private String description;

    private ErrorDetails errorDetails;

    public ActionTrackerException(String message) {
        super(message);
    }

    public ActionTrackerException(String message,ErrorDetails e) {
        super(message);
        this.errorDetails = e;
    }

    public ActionTrackerException(String code, String message, String description) {
        super(message);
    }

    public ActionTrackerException(String code, String message, String description, Throwable throwable) {
        super(message, throwable);
    }

    public ActionTrackerException(Throwable throwable) {
        super(throwable);
    }

    public ActionTrackerException(String message, Throwable cause) {
        super(message, cause);
    }
}
