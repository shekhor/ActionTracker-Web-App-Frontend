package com.tigerit.actiontracker.service.auth;

import com.tigerit.actiontracker.exceptions.ActionTrackerException;
import com.tigerit.actiontracker.model.request.AuthRequest;
import com.tigerit.actiontracker.model.response.RestApiResponse;
import com.tigerit.actiontracker.model.response.auth.AuthResponse;

public interface AuthService {
    RestApiResponse<AuthResponse> login(AuthRequest authRequest);
}
