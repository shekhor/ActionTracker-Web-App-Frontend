package com.tigerit.actiontracker.service.user;

import com.tigerit.actiontracker.exceptions.ActionTrackerException;
import com.tigerit.actiontracker.model.request.user.CheckUserExistServiceRequest;
import com.tigerit.actiontracker.model.response.RestApiResponse;
import com.tigerit.actiontracker.model.response.user.CheckUserExistServiceResponse;
import com.tigerit.actiontracker.utils.ServiceUtil;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import static com.tigerit.actiontracker.utils.ServiceUtil.USER_CHECK_API;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public RestApiResponse<CheckUserExistServiceResponse> checkUserByEmail(CheckUserExistServiceRequest request) {
        return ServiceUtil.sendRequest(HttpMethod.POST, USER_CHECK_API, request, CheckUserExistServiceResponse.class);
    }
}
