package com.tigerit.actiontracker.utils;

final public class UrlHelper {
    public static final String LOGIN = "/login";

    public static final String GOOGLE_SSO_LOGIN_URL = "/gsso-login";

    public static final String SIGNUP = "/registration";

    public static final String HOME = "/dashboard";

    public static final String LOGIN_FAILURE = "/login-failure";

    public static final String RESOURCES = "/resources";

    public static final String AUTHENTICATED = "AUTHENTICATED";

    public static final String GOOGLE_SSO_USER_ROLE = "ROLE_USER";

    public static final String LOGOUT = "/logout";

    public static final String SIGNUP_VERIFICATION = "/verifyUser";

    public static String all(String url) {
        return url + "/**";
    }

    public static String process(String url) {
        return url + "/process";
    }

    public static final String SSO_AUTH_URL = "/oauth2/authorization";

    public static String allParam(String url) {
        return url + "**";
    }
}
