package com.tigerit.actiontracker.controller;

import com.tigerit.actiontracker.component.logger.Loggable;
import com.tigerit.actiontracker.model.request.signup.SignupRequest;
import com.tigerit.actiontracker.model.request.signup.Status;
import com.tigerit.actiontracker.model.request.signup.UserType;
import com.tigerit.actiontracker.model.request.user.CheckUserExistServiceRequest;
import com.tigerit.actiontracker.model.response.RestApiResponse;
import com.tigerit.actiontracker.model.response.ajax.StatusCode;
import com.tigerit.actiontracker.model.response.user.CheckUserExistServiceResponse;
import com.tigerit.actiontracker.security.*;
import com.tigerit.actiontracker.exceptions.ActionTrackerException;
import com.tigerit.actiontracker.model.response.signup.SignupResponse;
import com.tigerit.actiontracker.service.signup.SignupService;
import com.tigerit.actiontracker.service.user.UserService;
import com.tigerit.actiontracker.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.WebUtils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import static com.tigerit.actiontracker.utils.CookieConstants.ACCESS_TOKEN;
import static com.tigerit.actiontracker.utils.CookieConstants.REFRESH_TOKEN;
import static com.tigerit.actiontracker.utils.UrlHelper.LOGIN;


@Controller
@RequiredArgsConstructor
public class LoginController {

    @Loggable
    private Logger logger;

    @Autowired
    private SSOAuthenticationProvider ssoAuthProvider;

    @Autowired
    SecurityContextAccessor securityContextAccessor;

    @Autowired
    AuthSuccessHandler authSuccessHandler;

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    private static final String authorizationRequestBaseUri = "oauth2/authorize-client";
    Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

    private final SignupService signupService;

    private final UserService userService;


    private HttpSession httpSession;


    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Model model) {

        logger.debug("login controller called");
        ModelAndView modelAndView = new ModelAndView("login");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if(inputFlashMap != null){
            String error = (String)inputFlashMap.get("gerror");
            modelAndView.addObject("gerror",error);
        }

        if(request.getParameter("gsso") != null && request.getParameter("gsso").equalsIgnoreCase("true")){
            SecurityContextHolder.getContext().setAuthentication(null);
            SecurityContextHolder.clearContext();
            Utils.deleteCookie(request,response,ACCESS_TOKEN);
            Utils.deleteCookie(request,response,REFRESH_TOKEN);
        }

//        if(securityContextAccessor.isCurrentAuthenticationAnonymous()){
//            return modelAndView;
//        }else{
//            Cookie accessCookie = WebUtils.getCookie(request, ACCESS_TOKEN);
//            if(accessCookie!= null && accessCookie.getValue() != null) {
//                modelAndView = new ModelAndView(new RedirectView("dashboard"));
//            }
//            return modelAndView;
//        }

        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);
        if (type != ResolvableType.NONE && ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }

        clientRegistrations.forEach(registration -> oauth2AuthenticationUrls.put(registration.getClientName(), authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
        model.addAttribute("urls", oauth2AuthenticationUrls);
        return modelAndView;

    }

    @RequestMapping(value = "/login-failure", method = RequestMethod.GET)
    public String loginFailure(HttpServletRequest request,
                               RedirectAttributes redirectAttributes) {
        String error = (String) request.getSession().getAttribute("error");
        redirectAttributes.addFlashAttribute("error", error);
        request.getSession().setAttribute("error", null);
        logger.debug("Error Msg: {}" +error);
        return "redirect:login";
    }

    @RequestMapping(value = "/g-login")
    public String glogin(HttpServletResponse response, HttpServletRequest request,RedirectAttributes redirectAttributes) {
        //httpSession.setAttribute("ACTION","LOGIN");
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("ACTION","LOGIN");
        return "redirect:/oauth2/authorization/google";
    }

    @RequestMapping(value = "/g-reg")
    public String greg(HttpServletResponse response, HttpServletRequest request,RedirectAttributes redirectAttributes) {
        //httpSession.setAttribute("ACTION","LOGIN");
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("ACTION","REG");
        return "redirect:/oauth2/authorization/google";
    }

    private SignupRequest setSignUpRequestAttributes(OAuth2AuthenticationToken authentication) {
        SignupRequest signupRequest = new SignupRequest();
        SignupResponse signupResponse = null;
        signupRequest.setUserType(UserType.SSO);
        signupRequest.setStatus(Status.ACTIVE);
        signupRequest.setEncryptedPassword(authentication.getPrincipal().getAttributes().get("id").toString());
        signupRequest.setConfirmEncryptedPassword(authentication.getPrincipal().getAttributes().get("id").toString());

        String email = authentication.getPrincipal().getAttributes().get("email").toString();
        signupRequest.setEmail(email);
        String emailDomain = email.substring(email.indexOf("@") + 1);

        signupRequest.setFirstName(authentication.getPrincipal().getAttributes().get("given_name").toString());
        signupRequest.setLastName(authentication.getPrincipal().getAttributes().get("family_name").toString());
        return signupRequest;
    }

    private void checkSignup(HttpServletRequest request, HttpServletResponse response, OAuth2AuthenticationToken authentication, SignupRequest signupRequest) throws IOException {
        RestApiResponse<SignupResponse> signupResponse = signupService.signup(signupRequest);

        if(signupResponse.getSuccess() != null && signupResponse.getSuccess().getData() != null) {
            googleSsoLogin(authentication,request,response);
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
            SecurityContextHolder.clearContext();
            response.sendRedirect(request.getContextPath()+LOGIN);
        }
    }

    @RequestMapping(value = "/gsso-login")
    public String user(OAuth2AuthenticationToken authentication, HttpServletResponse response, HttpServletRequest request,RedirectAttributes redirectAttributes) throws IOException {
        System.out.println(authentication.getName());
        System.out.println("Google ID : " + authentication.getPrincipal().getAttributes().get("id"));
        System.out.println("Google EMAIL : " + authentication.getPrincipal().getAttributes().get("email"));
        CheckUserExistServiceRequest userExistServiceRequest = new CheckUserExistServiceRequest();
        HttpSession httpSession = request.getSession(false);
        String action = httpSession.getAttribute("ACTION").toString();
        userExistServiceRequest.setEmail(authentication.getPrincipal().getAttributes().get("email").toString());
        RestApiResponse<CheckUserExistServiceResponse> restApiResponse = null;

        restApiResponse = userService.checkUserByEmail(userExistServiceRequest);
        if(restApiResponse.getStatusCode().equals(StatusCode.ERROR)  || restApiResponse.getError() != null) {

            if(action != null && action.equalsIgnoreCase("REG")){
                SignupRequest signupRequest = setSignUpRequestAttributes(authentication);
                checkSignup(request, response, authentication, signupRequest);
            } else {
                redirectAttributes.addFlashAttribute("gerror", "User not exist, Please SignUp first");
                return "redirect:login?gsso=true";
            }
        }

        if(action != null && action.equalsIgnoreCase("REG")){

            if(restApiResponse.getSuccess() != null && restApiResponse.getSuccess().getData() != null){
                redirectAttributes.addFlashAttribute("gerror", "You are already registered, Please SignIn With Google");
                return "redirect:login?gsso=true";
            }
            SignupRequest signupRequest = setSignUpRequestAttributes(authentication);
            checkSignup(request, response, authentication, signupRequest);

        }else if(action != null && action.equalsIgnoreCase("LOGIN")){
            googleSsoLogin(authentication,request,response);
        }
        return null;
    }


    private void googleSsoLogin(OAuth2AuthenticationToken authentication,HttpServletRequest request, HttpServletResponse response) throws IOException{
        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();
        final Authentication commonAuthentication = ssoAuthProvider.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(commonAuthentication);
        authSuccessHandler.onAuthenticationSuccess(request,response,commonAuthentication);
    }

    @GetMapping("/oauth_login")
    public ModelAndView getLoginPage(Model model) {

        ModelAndView modelAndView = new ModelAndView("oauth_login");
        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);
        if (type != ResolvableType.NONE && ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }

        clientRegistrations.forEach(registration -> oauth2AuthenticationUrls.put(registration.getClientName(), authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
        model.addAttribute("urls", oauth2AuthenticationUrls);

        return modelAndView;
    }

    @GetMapping("/loginSuccess")
    public String getLoginInfo(Model model, OAuth2AuthenticationToken authentication) {

        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());

        String userInfoEndpointUri = client.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUri();

        if (!StringUtils.isEmpty(userInfoEndpointUri)) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken()
                    .getTokenValue());

            HttpEntity<String> entity = new HttpEntity<String>("", headers);

            ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
            Map userAttributes = response.getBody();
            model.addAttribute("name", userAttributes.get("name"));
        }

        return "loginSuccess";
    }
}
