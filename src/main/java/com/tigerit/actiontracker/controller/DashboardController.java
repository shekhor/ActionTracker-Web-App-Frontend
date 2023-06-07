package com.tigerit.actiontracker.controller;

import com.tigerit.actiontracker.component.logger.Loggable;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Loggable
    private Logger logger;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView dashboard(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("dashboard/dashboard");
        logger.debug("login successfull");
        return modelAndView;
    }
}
