package com.tigerit.actiontracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/action")
public class ActionController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView action(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("action/create-project-action");
        return modelAndView;
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ModelAndView actionDetail(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("action/detailed-action-page");
        return modelAndView;
    }
}
