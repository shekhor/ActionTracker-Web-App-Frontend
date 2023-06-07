package com.tigerit.actiontracker.service.auth;

import com.tigerit.actiontracker.exceptions.ActionTrackerException;
import com.tigerit.actiontracker.model.request.AuthRequest;
import com.tigerit.actiontracker.model.response.RestApiResponse;
import com.tigerit.actiontracker.model.response.auth.AuthResponse;
import com.tigerit.actiontracker.utils.ServiceUtil;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import static com.tigerit.actiontracker.utils.ServiceUtil.USER_LOGIN_API;

@Service
public class AuthServiceImpl implements AuthService{
    @Override
    public RestApiResponse<AuthResponse> login(AuthRequest authRequest) {
        return ServiceUtil.sendRequest(HttpMethod.POST, USER_LOGIN_API, authRequest, AuthResponse.class);
    }
}
