package com.tigerit.actiontracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public final class SecurityContextAccessorImpl implements SecurityContextAccessor{

    @Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;

    @Override
    public boolean isCurrentAuthenticationAnonymous() {
        SecurityContext securityContext =  SecurityContextHolder.getContext();
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
}
