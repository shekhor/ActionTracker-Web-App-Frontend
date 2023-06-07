package com.tigerit.actiontracker.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * custom model need for during authentication session
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WebAuthDetails extends WebAuthenticationDetails {

    private String username="user1@gmail.com";

    private String password = "12345678";

    public WebAuthDetails(HttpServletRequest request) {
        super(request);
        this.username = request.getParameter("username").trim().toLowerCase();
        this.password = request.getParameter("password");
    }

    public WebAuthDetails(HttpServletRequest request , String username, String password) {
        super(request);
        this.username = username;
        this.password = password;
    }
}
