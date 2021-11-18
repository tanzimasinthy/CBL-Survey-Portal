package com.cblSurveyPortal.controller;

import com.cblSurveyPortal.constant.HttpHeader;
import com.cblSurveyPortal.dto.*;
import com.cblSurveyPortal.enums.SurveyType;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.service.AnswerService;
import com.cblSurveyPortal.utills.Utils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @RequestMapping(value = "/api/answer/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody AnswerDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = answerService.create(input,requester);
        return result;
    }

    @RequestMapping(value = "/api/answer/get-list",method = RequestMethod.GET)
    public ResponseDTO getList(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = answerService.getList();
        return result;
    }

    @RequestMapping(value = "/api/answer/get/{id}",method = RequestMethod.GET)
    public ResponseDTO get(@PathVariable("id") ObjectId id, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = answerService.get(id);
        return result;
    }
    @RequestMapping(value = "/api/answer/get-report",method = RequestMethod.GET)
    public ResponseDTO get(@RequestParam SurveyType surveyType, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = answerService.getReport(surveyType);
        return result;
    }


    @RequestMapping(value = "/api/answer/delete/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId id,@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = answerService.delete(id,requester);
        return result;
    }
}
