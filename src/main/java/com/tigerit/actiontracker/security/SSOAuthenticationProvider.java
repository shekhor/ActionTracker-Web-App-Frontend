package com.tigerit.actiontracker.security;

import com.tigerit.actiontracker.exceptions.ActionTrackerException;
import com.tigerit.actiontracker.model.request.AuthRequest;
import com.tigerit.actiontracker.model.response.auth.AuthResponse;
import com.tigerit.actiontracker.model.request.signup.UserType;
import com.tigerit.actiontracker.service.auth.AuthService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class SSOAuthenticationProvider extends AuthProvider {

    private AuthService authService;

    public SSOAuthenticationProvider(AuthService authService) {
        super(authService);
    }


    public Authentication authenticate(OAuth2AuthenticationToken authentication) throws AuthenticationException {
        String username = (String)authentication.getPrincipal().getAttributes().get("email");
        String password = (String)authentication.getPrincipal().getAttributes().get("id");

        return login(username, password, UserType.SSO);
    }

}
