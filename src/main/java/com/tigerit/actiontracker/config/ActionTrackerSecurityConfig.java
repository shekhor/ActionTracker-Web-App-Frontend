package com.tigerit.actiontracker.config;

import com.tigerit.actiontracker.security.*;
import com.tigerit.actiontracker.service.auth.AuthService;
import com.tigerit.actiontracker.utils.CookieConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.tigerit.actiontracker.utils.CookieConstants.*;
import static com.tigerit.actiontracker.utils.UrlHelper.*;

@Configuration
public class ActionTrackerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProvider authProvider;

    private AuthService authService;

    private RedirectStrategy redirectStrategy;

    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private MessageSource messageSource;

    public void ActionTrackerSecurityConfig(AuthProvider authProvider,
                                  MessageSource messageSource,
                                  AuthService authService,
                                  RedirectStrategy redirectStrategy,
                                  AccessDeniedHandler accessDeniedHandler){
        this.authProvider = authProvider;
        this.messageSource = messageSource;
        this.authService = authService;
        this.redirectStrategy = redirectStrategy;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }


   // @formatter:off
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
                //.addFilterBefore(new MyCustomFilter(myCloudPath), OAuth2AuthorizationRequestRedirectFilter.class)
                .authorizeRequests()
                .antMatchers("/oauth_login", "/loginSuccess", allParam(LOGIN), allParam(SIGNUP_VERIFICATION), all(LOGIN),all(SIGNUP),all(RESOURCES), all(LOGIN_FAILURE),all(SSO_AUTH_URL),all("/g-login"),all("/g-reg")).permitAll() // #4 Later we need to remove "dashboard,projects,action,team,notes,decision", this is just for now page navigation
                .antMatchers(all("")).hasAnyAuthority(AUTHENTICATED,GOOGLE_SSO_USER_ROLE)
            .and()
                .exceptionHandling()
                .authenticationEntryPoint(new AuthEntryPoint())
                .accessDeniedHandler(accessDeniedHandler)
            .and()
                .formLogin()
                .authenticationDetailsSource(new AuthDetailsSource())
                .loginPage(LOGIN)
                .loginProcessingUrl(process(LOGIN))
                .failureUrl(LOGIN)
                .successHandler(new AuthSuccessHandler(authService))
                .failureHandler(new AuthFailureHandler(redirectStrategy, messageSource))
            .and()
                .logout()
                .logoutUrl(LOGOUT)
                .logoutSuccessHandler(logoutSuccessHandler())
                .invalidateHttpSession(true)
                .deleteCookies(CookieConstants.ACCESS_TOKEN, CookieConstants.REFRESH_TOKEN)//need to add cookies name
            .and()
                .oauth2Login()
                .loginPage("/login")
                .authorizationEndpoint()
                .baseUri("/oauth2/authorize-client")
                .authorizationRequestRepository(authorizationRequestRepository())
                .and()
                .tokenEndpoint()
                .accessTokenResponseClient(accessTokenResponseClient())
                .and()
                .defaultSuccessUrl("/loginSuccess")
            /*.and()
                .headers().and().oauth2Client().and().authenticationProvider(new GoogleAuthenticationProvider())
                .frameOptions()
                .sameOrigin()*/;
    }
    // @formatter:on

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new ActionTrackerLogoutHandler();
    }

    @Bean
    public AuthorizationRequestRepository<OAuth2AuthorizationRequest> authorizationRequestRepository() {
        return new HttpSessionOAuth2AuthorizationRequestRepository();
    }

    @Bean
    public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient() {
        DefaultAuthorizationCodeTokenResponseClient accessTokenResponseClient = new DefaultAuthorizationCodeTokenResponseClient();
        return accessTokenResponseClient;
    }


    // additional configuration for non-Spring Boot projects
    private static List<String> clients = Arrays.asList("google", "facebook");

    //@Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        List<ClientRegistration> registrations = clients.stream()
                .map(c -> getRegistration(c))
                .filter(registration -> registration != null)
                .collect(Collectors.toList());

        return new InMemoryClientRegistrationRepository(registrations);
    }

    private static String CLIENT_PROPERTY_KEY = "spring.security.oauth2.client.registration.";

    @Autowired
    private Environment env;

    private ClientRegistration getRegistration(String client) {
        String clientId = env.getProperty(CLIENT_PROPERTY_KEY + client + ".client-id");

        if (clientId == null) {
            return null;
        }

        String clientSecret = env.getProperty(CLIENT_PROPERTY_KEY + client + ".client-secret");
        if (client.equals("google")) {
            return CommonOAuth2Provider.GOOGLE.getBuilder(client)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .build();
        }
        if (client.equals("facebook")) {
            return CommonOAuth2Provider.FACEBOOK.getBuilder(client)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .build();
        }
        return null;
    }
}
