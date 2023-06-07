package com.tigerit.actiontracker.service.signup;

import com.tigerit.actiontracker.exceptions.ActionTrackerException;
import com.tigerit.actiontracker.model.request.signup.SignupRequest;
import com.tigerit.actiontracker.model.request.signup.UserVerifyRequest;
import com.tigerit.actiontracker.model.response.RestApiResponse;
import com.tigerit.actiontracker.model.response.signup.SignupResponse;
import com.tigerit.actiontracker.utils.ServiceUtil;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import static com.tigerit.actiontracker.utils.ServiceUtil.USER_SIGNUP_API;
import static com.tigerit.actiontracker.utils.ServiceUtil.USER_VERIFY_API;

@Service
public class SignupServiceImpl implements SignupService {

    @Override
    public RestApiResponse<SignupResponse> signup(SignupRequest signupRequest) {
        return ServiceUtil.sendRequest(HttpMethod.POST, USER_SIGNUP_API, signupRequest, SignupResponse.class);
    }

    @Override
    public RestApiResponse<SignupResponse> verifyUser(String userId, UserVerifyRequest request) {
        String url = USER_VERIFY_API + "/" + userId;
        return ServiceUtil.sendRequest(HttpMethod.PUT, url, request, SignupResponse.class);
    }

}
