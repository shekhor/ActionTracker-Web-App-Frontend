package com.tigerit.actiontracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/team")
public class TeamController {

    @RequestMapping(value = "/members/{projectId}", method = RequestMethod.GET)
    public ModelAndView teamMemberUpdate(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("team/team-member");
        return modelAndView;
    }
}
