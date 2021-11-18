package com.cblSurveyPortal.controller;

import com.cblSurveyPortal.constant.HttpHeader;
import com.cblSurveyPortal.dto.DivisionCreateDTO;
import com.cblSurveyPortal.dto.DivisionUpdateDTO;
import com.cblSurveyPortal.dto.ResponseDTO;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.service.DivisionService;
import com.cblSurveyPortal.utills.Utils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DivisionController {
    @Autowired
    private DivisionService divisionService;
    @RequestMapping(value = "/api/division/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody DivisionCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = divisionService.create(input,requester);
        return result;
    }
    @RequestMapping(value ="/api/division/get" , method = RequestMethod.GET )
    public ResponseDTO getList(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = divisionService.getList(requester);
        return result;
    }

    @RequestMapping(value = "/api/division/{id}", method = RequestMethod.GET )
    public ResponseDTO getID(@PathVariable("id") ObjectId divisionID, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = divisionService.getID(divisionID, requester);
        return result;
    }
    @RequestMapping(value = "/api/division/{id}",method = RequestMethod.PUT)
    public ResponseDTO update(@PathVariable("id") ObjectId divisionId, @RequestBody DivisionUpdateDTO input, @RequestHeader(value = HttpHeader.REQUESTER ) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = divisionService.update(input,divisionId, requester);
        return result;
    }
    @RequestMapping(value = "/api/division/{id}", method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId divisionId, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = divisionService.delete(divisionId, requester);
        return result;
    }
}
