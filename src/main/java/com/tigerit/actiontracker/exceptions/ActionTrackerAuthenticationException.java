package com.tigerit.actiontracker.exceptions;

import com.tigerit.actiontracker.model.response.ajax.ErrorDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.authentication.AuthenticationServiceException;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActionTrackerAuthenticationException extends AuthenticationServiceException {
    private ErrorDetails errorDetails;

    public ActionTrackerAuthenticationException(String msg, ErrorDetails errorDetails){
        super(msg);
        this.errorDetails = errorDetails;
    }
}
