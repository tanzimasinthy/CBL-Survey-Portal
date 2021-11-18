package com.cblSurveyPortal.controller;

import com.cblSurveyPortal.constant.HttpHeader;
import com.cblSurveyPortal.dto.*;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.service.EmployeeService;
import com.cblSurveyPortal.service.QuestionService;
import com.cblSurveyPortal.utills.Utils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @RequestMapping(value = "/api/question/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody QuestionCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = questionService.create(input,requester);
        return result;
    }

    @RequestMapping(value = "/api/question/get-list",method = RequestMethod.GET)
    public ResponseDTO getList(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = questionService.getList();
        return result;
    }

    @RequestMapping(value = "/api/question/get/{id}",method = RequestMethod.GET)
    public ResponseDTO get(@PathVariable("id") ObjectId id, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = questionService.get(id);
        return result;
    }

    @RequestMapping(value = "/api/question/update",method = RequestMethod.PUT)
    public ResponseDTO update(@RequestBody QuestionUpdateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = questionService.update(input,requester);
        return result;
    }

    @RequestMapping(value = "/api/question/delete/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId id,@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = questionService.delete(id,requester);
        return result;
    }
}
