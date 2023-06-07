package com.tigerit.actiontracker.controller;

import com.tigerit.actiontracker.model.ServiceResponseExtended;
import com.tigerit.actiontracker.model.request.decisionlog.DecisionLogCreateRequest;
import com.tigerit.actiontracker.model.request.decisionlog.DecisionLogListRequest;
import com.tigerit.actiontracker.model.response.ajax.ResponseMessages;
import com.tigerit.actiontracker.model.response.decisionlog.DecisionLogResponse;
import com.tigerit.actiontracker.service.decisionlog.DecisionLogService;
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
@RequestMapping("/decision-log")
public class DecisionLogController {

    private final DecisionLogService decisionLogService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView view(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("decisionlog/view");
        return modelAndView;
    }

    @RequestMapping(value = "/create-decision-log", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessages createMilestone(HttpServletRequest req, @ModelAttribute("decisionLogCreateRequest") DecisionLogCreateRequest decisionLogCreateRequest) {
        ResponseMessages responseMessages = new ResponseMessages();
        ServiceResponseExtended<DecisionLogResponse> response = decisionLogService.addDecisionLog(req, decisionLogCreateRequest);
        return responseMessages;
    }

    @RequestMapping(value = "/get-data", method = RequestMethod.GET)
    @ResponseBody
    public List<DecisionLogResponse> getNoteHistoryData(HttpServletRequest request) {
        DecisionLogListRequest decisionLogListRequest = new DecisionLogListRequest();
        decisionLogListRequest.setProjectId("1");
        decisionLogListRequest.setPageNo(0);
        decisionLogListRequest.setTotalItemPerPage(5);
        ServiceResponseExtended<ArrayList> responseList= decisionLogService.getDecisionLogList(request,decisionLogListRequest);
//        responseList.add(new NotesHistoryDataResponse("hello how r u", "bob"));
//        responseList.add(new NotesHistoryDataResponse("I am fine", "alice"));
        return responseList.getBody();
    }
}
