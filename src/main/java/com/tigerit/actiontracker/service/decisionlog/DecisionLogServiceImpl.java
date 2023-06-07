package com.tigerit.actiontracker.service.decisionlog;

import com.tigerit.actiontracker.model.ServiceResponseExtended;
import com.tigerit.actiontracker.model.request.decisionlog.DecisionLogCreateRequest;
import com.tigerit.actiontracker.model.request.decisionlog.DecisionLogListRequest;
import com.tigerit.actiontracker.model.response.decisionlog.DecisionLogResponse;
import com.tigerit.actiontracker.utils.ServiceUtil;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

import static com.tigerit.actiontracker.utils.ServiceUtil.DECISION_LOG_CREATE_API;
import static com.tigerit.actiontracker.utils.ServiceUtil.DECISION_LOG_LIST_API;

@Service
public class DecisionLogServiceImpl implements DecisionLogService {
    @Override
    public ServiceResponseExtended<DecisionLogResponse> addDecisionLog(HttpServletRequest req, DecisionLogCreateRequest request) {
        return ServiceUtil.sendRequest(HttpMethod.POST, req, DECISION_LOG_CREATE_API, request, DecisionLogResponse.class);

    }

    @Override
    public ServiceResponseExtended<ArrayList> getDecisionLogList(HttpServletRequest req, DecisionLogListRequest request) {
        return ServiceUtil.sendRequest(HttpMethod.POST, req, DECISION_LOG_LIST_API, request, ArrayList.class);
    }

}
