package com.tigerit.actiontracker.service.milestone;

import com.tigerit.actiontracker.model.ServiceResponseExtended;
import com.tigerit.actiontracker.model.request.milestone.MilestoneCreateRequest;
import com.tigerit.actiontracker.model.request.milestone.MilestoneListRequest;
import com.tigerit.actiontracker.model.response.milestone.MilestoneResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public interface MilestoneService {

    ServiceResponseExtended<ArrayList> getMilestoneList(HttpServletRequest request, MilestoneListRequest milestoneListRequest);

    ServiceResponseExtended<MilestoneResponse> createMileStone(HttpServletRequest req, MilestoneCreateRequest request);
}
