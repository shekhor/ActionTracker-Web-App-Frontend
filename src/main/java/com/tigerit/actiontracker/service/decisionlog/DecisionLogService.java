package com.tigerit.actiontracker.service.decisionlog;

import com.tigerit.actiontracker.model.ServiceResponseExtended;
import com.tigerit.actiontracker.model.request.decisionlog.DecisionLogCreateRequest;
import com.tigerit.actiontracker.model.request.decisionlog.DecisionLogListRequest;
import com.tigerit.actiontracker.model.response.decisionlog.DecisionLogResponse;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@EnableAsync
public interface DecisionLogService {
    ServiceResponseExtended<DecisionLogResponse> addDecisionLog(HttpServletRequest req, DecisionLogCreateRequest request);

    ServiceResponseExtended<ArrayList> getDecisionLogList(HttpServletRequest req, DecisionLogListRequest request);

}
