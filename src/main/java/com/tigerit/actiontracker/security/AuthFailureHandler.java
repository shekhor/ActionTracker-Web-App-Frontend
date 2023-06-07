package com.tigerit.actiontracker.security;

import com.tigerit.actiontracker.model.response.ajax.ErrorDetails;
import com.tigerit.actiontracker.exceptions.ActionTrackerAuthenticationException;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

import static com.tigerit.actiontracker.utils.UrlHelper.LOGIN_FAILURE;

/**
 * custom authentication failure handler impl
 * this class is responsible for deciding where
 * should user goes when authentication is fails based on login type
 */
@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private MessageSource messageSource;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public AuthFailureHandler(RedirectStrategy redirectStrategy, MessageSource messageSource) {
        this.messageSource = messageSource;
        setDefaultFailureUrl(LOGIN_FAILURE);
        setRedirectStrategy(redirectStrategy);
    }

    @Override
    public void setDefaultFailureUrl(String defaultFailureUrl) {
        super.setDefaultFailureUrl(defaultFailureUrl);
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        super.setRedirectStrategy(redirectStrategy);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        ErrorDetails errorDetails;

        if (exception instanceof AuthenticationCredentialsNotFoundException) {
            errorDetails = buildErrorDetails(request, exception);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            request.getSession().setAttribute("error", errorDetails.getMessage());
            redirectStrategy.sendRedirect(request, response, LOGIN_FAILURE);
        } else if (exception instanceof ActionTrackerAuthenticationException) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            errorDetails = ((ActionTrackerAuthenticationException) exception).getErrorDetails();
            request.getSession().setAttribute("error", errorDetails.getMessage());
            redirectStrategy.sendRedirect(request, response, LOGIN_FAILURE);
        }
        else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            request.getSession().setAttribute("error", "Incorrect username or password.");
            redirectStrategy.sendRedirect(request, response, LOGIN_FAILURE);
        }

    }

    private ErrorDetails buildErrorDetails(HttpServletRequest request, AuthenticationException ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        switch (ex.getMessage()) {
            case "error.username_is_empty":
            case "error.wrong_credentials":
            case "error.inactive_account":
                errorDetails.setField("username");
                break;
            case "error.password_is_empty":
                errorDetails.setField("password");
                break;
            default:
                errorDetails.setField("");
        }
        errorDetails.setMessage(messageSource.getMessage(ex.getMessage(), null, Locale.getDefault()));
        return errorDetails;
    }

}
