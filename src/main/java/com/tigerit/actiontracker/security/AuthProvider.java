package com.tigerit.actiontracker.security;

import com.tigerit.actiontracker.component.logger.Loggable;
import com.tigerit.actiontracker.exceptions.ActionTrackerAuthenticationException;
import com.tigerit.actiontracker.exceptions.ActionTrackerException;
import com.tigerit.actiontracker.model.request.AuthRequest;
import com.tigerit.actiontracker.model.response.RestApiResponse;
import com.tigerit.actiontracker.model.response.ajax.ErrorDetails;
import com.tigerit.actiontracker.model.response.auth.AuthResponse;
import com.tigerit.actiontracker.model.request.signup.UserType;
import com.tigerit.actiontracker.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthProvider implements AuthenticationProvider {

    private final AuthService authService;

    @Loggable
    private Logger logger;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        WebAuthDetails details = (WebAuthDetails) authentication.getDetails();
        String username = details.getUsername();
        String password = details.getPassword();
        return login(username, password, UserType.COMMON);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public Authentication login(String username, String password, UserType userType) {
        if (StringUtils.isEmpty(username)) {
            throw new AuthenticationCredentialsNotFoundException("error.username_is_empty");
        } else if (StringUtils.isEmpty(password)) {
            throw new AuthenticationCredentialsNotFoundException("error.password_is_empty");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        String encodedPassword = DigestUtils.md5Hex(password);

        RestApiResponse<AuthResponse> restApiResponse = null;
        restApiResponse = authService.login(new AuthRequest(username, password, userType));
        AuthResponse authResponse;
        if (restApiResponse == null) {
            logger.debug("RestApiResponse is NULL");
            throw new InternalAuthenticationServiceException("Service Unavailable");
        } else if (restApiResponse.getSuccess() != null
                && restApiResponse.getSuccess().getData() != null) {
            logger.debug("Auth Response has Success Details");
            authResponse = restApiResponse.getSuccess().getData();
            logger.debug("Auth Response form Service Call: {}", authResponse.toString());
        } else if (restApiResponse.getError() != null) {
            logger.debug("Auth Response has Error Details");
            ErrorDetails errorDetails = restApiResponse.getError();
            throw new ActionTrackerAuthenticationException("Auth Service don't have proper auth response", errorDetails);
        } else {
            throw new InternalAuthenticationServiceException("Service Unavailable");
        }
        grantedAuthorities.add(new SimpleGrantedAuthority("AUTHENTICATED"));
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(username, encodedPassword, grantedAuthorities);
        usernamePasswordAuthenticationToken.setDetails(authResponse);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        return usernamePasswordAuthenticationToken;
    }
}
