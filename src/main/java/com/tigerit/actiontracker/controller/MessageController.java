package com.tigerit.actiontracker.controller;

import com.tigerit.actiontracker.model.MessageModel;
import com.tigerit.actiontracker.model.ServiceResponseExtended;
import com.tigerit.actiontracker.model.request.decisionlog.DecisionLogCreateRequest;
import com.tigerit.actiontracker.model.response.decisionlog.DecisionLogResponse;
import com.tigerit.actiontracker.service.decisionlog.DecisionLogService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private final DecisionLogService decisionLogService;


    @MessageMapping("/chat/{to}")
    public String sendMessage(@DestinationVariable String to, MessageModel message, Principal principal ) {
        System.out.println("handling send message: " + message + " to: " + to);
        boolean isExists = "1".equalsIgnoreCase(to);
        if (isExists) {
            simpMessagingTemplate.convertAndSend("/topic/"+ message.getTopicName() + "/" + to, message);
        }

        HttpServletRequest request1 =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
        if(message.getMessage() == "decision-log") {
            DecisionLogCreateRequest decisionLogCreateRequest = new DecisionLogCreateRequest();
            decisionLogCreateRequest.setDecision(message.getMessage());
            decisionLogCreateRequest.setProjectId(to);

            //ServiceResponseExtended<DecisionLogResponse> response = decisionLogService.addDecisionLog(req, decisionLogCreateRequest);

        }
        return "redirect:login";
    }
}
