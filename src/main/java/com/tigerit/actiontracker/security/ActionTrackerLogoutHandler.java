package com.tigerit.actiontracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.tigerit.actiontracker.utils.CookieConstants.ACCESS_TOKEN;
import static com.tigerit.actiontracker.utils.CookieConstants.REFRESH_TOKEN;

public class ActionTrackerLogoutHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {



    @Override
    public void onLogoutSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication)
            throws IOException, ServletException {

        String refererUrl = request.getHeader("Referer");
        Cookie accessTokenCookie = new Cookie(ACCESS_TOKEN, null);
        Cookie refreshTokenCookie = new Cookie(REFRESH_TOKEN, null);

        accessTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setHttpOnly(true);

        accessTokenCookie.setPath(request.getContextPath());
        refreshTokenCookie.setPath(request.getContextPath());

        accessTokenCookie.setMaxAge(0);
        refreshTokenCookie.setMaxAge(0);

        response.addCookie(accessTokenCookie);
        response.addCookie(refreshTokenCookie);
        response.setStatus(HttpServletResponse.SC_OK);
        super.onLogoutSuccess(request, response, authentication);
    }
}
