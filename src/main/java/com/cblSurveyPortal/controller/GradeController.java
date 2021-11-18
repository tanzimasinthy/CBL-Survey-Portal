package com.cblSurveyPortal.controller;

import com.cblSurveyPortal.constant.HttpHeader;
import com.cblSurveyPortal.dto.*;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.service.GradeService;
import com.cblSurveyPortal.utills.Utils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @RequestMapping(value = "/api/grade/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody GradeCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = gradeService.create(input,requester);
        return result;
    }
    @RequestMapping(value ="/api/grade/get" , method = RequestMethod.GET )
    public ResponseDTO getList(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = gradeService.getList(requester);
        return result;
    }

    @RequestMapping(value = "/api/grade/{id}", method = RequestMethod.GET )
    public ResponseDTO getID(@PathVariable("id") ObjectId gradeId, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = gradeService.getID(gradeId, requester);
        return result;
    }
    @RequestMapping(value = "/api/grade/{id}",method = RequestMethod.PUT)
    public ResponseDTO update(@PathVariable("id") ObjectId gradeId, @RequestBody GradeUpdateDTO input, @RequestHeader(value = HttpHeader.REQUESTER ) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = gradeService.update(input, gradeId, requester);
        return result;
    }
    @RequestMapping(value = "/api/grade/{id}", method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId gradeId, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = gradeService.delete(gradeId, requester);
        return result;
    }
}
