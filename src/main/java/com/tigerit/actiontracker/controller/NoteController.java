package com.tigerit.actiontracker.controller;

import com.tigerit.actiontracker.model.response.notes.NotesHistoryDataResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView notes(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("notes/notes-page");
        return modelAndView;
    }

    @RequestMapping(value = "/get-data", method = RequestMethod.GET)
    @ResponseBody
    public List<NotesHistoryDataResponse> getNoteHistoryData(HttpServletRequest request) {
        ArrayList<NotesHistoryDataResponse> responseList= new ArrayList<NotesHistoryDataResponse>();
        responseList.add(new NotesHistoryDataResponse("hello how r u", "bob"));
        responseList.add(new NotesHistoryDataResponse("I am fine", "alice"));
        return responseList;
    }
}
