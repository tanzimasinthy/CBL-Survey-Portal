package com.cblSurveyPortal.controller;

import com.cblSurveyPortal.constant.HttpHeader;
import com.cblSurveyPortal.dto.EmployeeCreateDTO;
import com.cblSurveyPortal.dto.EmployeeUpdateDTO;
import com.cblSurveyPortal.dto.ResponseDTO;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.service.EmployeeService;
import com.cblSurveyPortal.utills.Utils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/api/employee/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody EmployeeCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = employeeService.create(input,requester);
        return result;
    }

    @RequestMapping(value = "/api/employee/get-list",method = RequestMethod.GET)
    public ResponseDTO getList(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = employeeService.getList();
        return result;
    }

    @RequestMapping(value = "/api/employee/get/{id}",method = RequestMethod.GET)
    public ResponseDTO get(@PathVariable("id") ObjectId id, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = employeeService.get(id);
        return result;
    }

    @RequestMapping(value = "/api/employee/update",method = RequestMethod.PUT)
    public ResponseDTO update(@RequestBody EmployeeUpdateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = employeeService.update(input,requester);
        return result;
    }

    @RequestMapping(value = "/api/employee/delete/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId id,@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = employeeService.delete(id,requester);
        return result;
    }
}
