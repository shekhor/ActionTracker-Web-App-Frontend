package com.tigerit.actiontracker.controller;

import com.tigerit.actiontracker.component.logger.Loggable;
import com.tigerit.actiontracker.exceptions.ActionTrackerException;
import com.tigerit.actiontracker.model.request.signup.SignupRequest;
import com.tigerit.actiontracker.model.request.signup.UserVerifyRequest;
import com.tigerit.actiontracker.model.request.user.CheckUserExistServiceRequest;
import com.tigerit.actiontracker.model.response.RestApiResponse;
import com.tigerit.actiontracker.model.response.signup.SignupResponse;
import com.tigerit.actiontracker.model.request.signup.UserType;
import com.tigerit.actiontracker.model.response.user.CheckUserExistServiceResponse;
import com.tigerit.actiontracker.service.signup.SignupService;
import com.tigerit.actiontracker.service.user.UserService;
import com.tigerit.actiontracker.utils.Converter;
import com.tigerit.actiontracker.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import static com.tigerit.actiontracker.utils.Defs.*;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    @Loggable
    private Logger logger;

    private final SignupService signupService;

    private final UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("signupRequest") SignupRequest signupRequest, RedirectAttributes redirectAttributes) throws ActionTrackerException {

        signupRequest.setUserType(UserType.COMMON);
        CheckUserExistServiceRequest userExistServiceRequest = new CheckUserExistServiceRequest();
        userExistServiceRequest.setEmail(signupRequest.getEmail());
        RestApiResponse<CheckUserExistServiceResponse> restApiResponse = userService.checkUserByEmail(userExistServiceRequest);

        if(restApiResponse.getSuccess() != null && restApiResponse.getSuccess().getData() != null){
            return Utils.redirectUrlwithError("registration", USER_EXIST_MESSAGE, redirectAttributes);
        } else {
            RestApiResponse<SignupResponse> response = signupService.signup(signupRequest);

            if(response.getSuccess() != null && response.getSuccess().getData() != null){
                return Utils.redirectUrlwithSuccess("login", SIGNUP_SUCCESS_MESSAGE, redirectAttributes);
            } else if(response.getError() != null && response.getError().getMessage() != null){
                return Utils.redirectUrlwithError("registration", response.getError().getMessage(), redirectAttributes);
            }

            return Utils.redirectUrlwithError("registration", SIGNUP_ERROR_MESSAGE, redirectAttributes);
        }

    }

    @RequestMapping(value = "/verifyUser", method = RequestMethod.GET)
    public String verifyUser(@RequestParam String id, @RequestParam String token, RedirectAttributes redirectAttributes) throws ActionTrackerException {
        id = Converter.decodeBase64(id);
        token = Converter.decodeBase64(token);
        UserVerifyRequest verifyRequest = new UserVerifyRequest(token);
        RestApiResponse<SignupResponse> response = signupService.verifyUser(id, verifyRequest);

        if(response.getSuccess() != null && response.getSuccess().getData() != null){
            return Utils.redirectUrlwithSuccess("login", USER_VERIFICATION_MESSAGE, redirectAttributes);
        } else if(response.getError() != null && response.getError().getMessage() != null){
            return Utils.redirectUrlwithError("login", response.getError().getMessage(), redirectAttributes);
        }

        return Utils.redirectUrlwithError("login", USER_VERIFICATION_ERROR_MESSAGE, redirectAttributes);

    }

}
