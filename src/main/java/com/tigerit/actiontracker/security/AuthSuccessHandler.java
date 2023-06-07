package com.tigerit.actiontracker.security;
import com.tigerit.actiontracker.model.response.auth.AuthResponse;
import com.tigerit.actiontracker.service.auth.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.tigerit.actiontracker.utils.CookieConstants.*;
import static com.tigerit.actiontracker.utils.UrlHelper.HOME;

/**
 * custom authentication success handler impl
 * this class is responsible for deciding where
 * should user goes when authentication is successful
 */
@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private final AuthService authService;

    public AuthSuccessHandler(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        AuthResponse authResponse = (AuthResponse) authentication.getDetails();

        Cookie accessTokenCookie = new Cookie(ACCESS_TOKEN, authResponse.getAccessToken());
        Cookie refreshTokenCookie = new Cookie(REFRESH_TOKEN, authResponse.getRefreshToken());

        accessTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setHttpOnly(true);

        accessTokenCookie.setPath(request.getContextPath());
        refreshTokenCookie.setPath(request.getContextPath());

        accessTokenCookie.setMaxAge(TOKEN_VALIDITY_IN_SECONDS);
        refreshTokenCookie.setMaxAge(TOKEN_VALIDITY_IN_SECONDS);

        response.addCookie(accessTokenCookie);
        response.addCookie(refreshTokenCookie);

        //later will call service to get userdetails by access token and set it to session


        response.setStatus(HttpServletResponse.SC_OK);
        redirectStrategy.sendRedirect(request, response, HOME);
    }
}
