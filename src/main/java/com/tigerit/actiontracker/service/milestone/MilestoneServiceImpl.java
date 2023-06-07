package com.tigerit.actiontracker.service.milestone;

import com.tigerit.actiontracker.model.ServiceResponseExtended;
import com.tigerit.actiontracker.model.request.milestone.MilestoneCreateRequest;
import com.tigerit.actiontracker.model.request.milestone.MilestoneListRequest;
import com.tigerit.actiontracker.model.response.milestone.MilestoneResponse;
import com.tigerit.actiontracker.utils.ServiceUtil;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

import static com.tigerit.actiontracker.utils.ServiceUtil.MILESTONE_CREATE_API;
import static com.tigerit.actiontracker.utils.ServiceUtil.MILESTONE_LIST_API;

@Service
public class MilestoneServiceImpl implements MilestoneService {
    @Override
    public ServiceResponseExtended<ArrayList> getMilestoneList(HttpServletRequest request, MilestoneListRequest milestoneListRequest) {
        return ServiceUtil.sendRequest(HttpMethod.POST, request, MILESTONE_LIST_API, milestoneListRequest, ArrayList.class);
    }

    @Override
    public ServiceResponseExtended<MilestoneResponse> createMileStone(HttpServletRequest req, MilestoneCreateRequest request) {
        return ServiceUtil.sendRequest(HttpMethod.POST, req, MILESTONE_CREATE_API, request, MilestoneResponse.class);
    }
}
