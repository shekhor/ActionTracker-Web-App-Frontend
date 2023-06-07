package com.tigerit.actiontracker.service.user;

import com.tigerit.actiontracker.exceptions.ActionTrackerException;
import com.tigerit.actiontracker.model.request.user.CheckUserExistServiceRequest;
import com.tigerit.actiontracker.model.response.RestApiResponse;
import com.tigerit.actiontracker.model.response.user.CheckUserExistServiceResponse;

public interface UserService {

    RestApiResponse<CheckUserExistServiceResponse> checkUserByEmail(CheckUserExistServiceRequest request);

}
