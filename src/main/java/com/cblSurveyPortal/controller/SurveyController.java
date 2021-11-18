package com.cblSurveyPortal.controller;

import com.cblSurveyPortal.constant.HttpHeader;
import com.cblSurveyPortal.dto.SurveyCreateDTO;
import com.cblSurveyPortal.dto.SurveyUpdateDTO;
import com.cblSurveyPortal.dto.ResponseDTO;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.service.SurveyService;
import com.cblSurveyPortal.utills.Utils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SurveyController {

    @Autowired
    private SurveyService surveyService;
    @RequestMapping(value = "/api/survey/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody SurveyCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = surveyService.create(input,requester);
        return result;
    }

    @RequestMapping(value = "/api/survey/get-list",method = RequestMethod.GET)
    public ResponseDTO getList(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = surveyService.getList();
        return result;
    }

    @RequestMapping(value = "/api/survey/get/{id}",method = RequestMethod.GET)
    public ResponseDTO get(@PathVariable("id") ObjectId id, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = surveyService.get(id);
        return result;
    }

    @RequestMapping(value = "/api/survey/update",method = RequestMethod.PUT)
    public ResponseDTO update(@RequestBody SurveyUpdateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = surveyService.update(input,requester);
        return result;
    }

    @RequestMapping(value = "/api/survey/delete/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId id,@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = surveyService.delete(id,requester);
        return result;
    }
}
