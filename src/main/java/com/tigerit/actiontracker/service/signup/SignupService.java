package com.tigerit.actiontracker.service.signup;

import com.tigerit.actiontracker.exceptions.ActionTrackerException;
import com.tigerit.actiontracker.model.request.signup.SignupRequest;
import com.tigerit.actiontracker.model.request.signup.UserVerifyRequest;
import com.tigerit.actiontracker.model.response.RestApiResponse;
import com.tigerit.actiontracker.model.response.signup.SignupResponse;

public interface SignupService {

    RestApiResponse<SignupResponse> signup(SignupRequest signupRequest);

    RestApiResponse<SignupResponse> verifyUser(String UserId, UserVerifyRequest request);


}
