package com.tigerit.actiontracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView projects(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("projects/default-project-page");
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView projectsUpdate(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("projects/update-project");
        return modelAndView;
    }

    @RequestMapping(value = "/milestone", method = RequestMethod.GET)
    public ModelAndView projectsMilestone(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("projects/dates-milestone-page");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createProject(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("projects/create-project");
        return modelAndView;
    }
}
