package com.cblSurveyPortal.controller;

import com.cblSurveyPortal.constant.HttpHeader;
import com.cblSurveyPortal.dto.DepartmentCreateDTO;
import com.cblSurveyPortal.dto.DivisionCreateDTO;
import com.cblSurveyPortal.dto.ResponseDTO;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.service.DepartmentService;
import com.cblSurveyPortal.utills.Utils;
import com.mongodb.util.Util;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping(value = "/api/department/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody DepartmentCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = departmentService.create(input,requester);
        return result;
    }
    @RequestMapping(value ="/api/department/get" , method = RequestMethod.GET )
    public ResponseDTO getList(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = departmentService.getList(requester);
        return result;
    }
    @RequestMapping(value = "/api/department/{id}", method = RequestMethod.GET)
    public ResponseDTO getId(@PathVariable("id") ObjectId dptId , @RequestHeader (value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = departmentService.getId(dptId, requester);
        return result;
    }
    @RequestMapping(value = "/api/department/{id}", method = RequestMethod.PUT)
    public ResponseDTO update(@PathVariable("id") ObjectId dptId, @RequestBody DepartmentCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = departmentService.update(input,dptId, requester);
        return result;
    }
    @RequestMapping(value = "/api/department/{id}", method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId dptId, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = departmentService.delete(dptId,requester);
        return result;
    }
}
