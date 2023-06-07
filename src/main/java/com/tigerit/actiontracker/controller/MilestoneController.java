package com.tigerit.actiontracker.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tigerit.actiontracker.model.ServiceResponseExtended;
import com.tigerit.actiontracker.model.request.milestone.MilestoneCreateRequest;
import com.tigerit.actiontracker.model.response.ajax.ResponseMessages;
import com.tigerit.actiontracker.model.response.ajax.StatusCode;
import com.tigerit.actiontracker.model.response.milestone.MilestoneResponse;
import com.tigerit.actiontracker.model.request.milestone.MilestoneListRequest;
import com.tigerit.actiontracker.service.milestone.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/milestone")
public class MilestoneController {

    private final MilestoneService milestoneService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView milestoneView() {
        ModelAndView modelAndView = new ModelAndView("milestone/view");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView milestoneCreate(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("milestone/create");
        return modelAndView;
    }

    @RequestMapping(value = "/create-milestone", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessages createMilestone(HttpServletRequest req, @ModelAttribute("milestoneCreateRequest") MilestoneCreateRequest milestoneCreateRequest) {
        ResponseMessages responseMessages = new ResponseMessages();
        milestoneCreateRequest.setProjectId("1");
        milestoneCreateRequest.setProjectName("action tracker");

        ServiceResponseExtended<MilestoneResponse> milestoneResponse = milestoneService.createMileStone(req , milestoneCreateRequest);

        if(milestoneResponse != null && milestoneResponse.getBody() !=  null) {
            responseMessages.setMessage("Milestone created with project id " + milestoneCreateRequest.getProjectId());
            responseMessages.setStatus(StatusCode.SUCCESS);
        } else {
            responseMessages.setMessage("Error occured during Milestone creation with project id " + milestoneCreateRequest.getProjectId());
            responseMessages.setStatus(StatusCode.ERROR);
        }
        return responseMessages;
    }


    @RequestMapping(value = "/get-data", method = RequestMethod.GET)
    @ResponseBody
    public List<MilestoneResponse> milestoneList(HttpServletRequest request) {
        MilestoneListRequest milestoneListRequest = new MilestoneListRequest();
        milestoneListRequest.setPageNo(1);
        milestoneListRequest.setProjectId("1");
        milestoneListRequest.setTotalItemPerPage(100);

        ServiceResponseExtended<ArrayList> milestoneResponse = milestoneService.getMilestoneList(request, milestoneListRequest);

        if(milestoneResponse != null && milestoneResponse.getBody() !=  null) {
            return milestoneResponse.getBody();
        }
        return new ArrayList<>();
    }

}
