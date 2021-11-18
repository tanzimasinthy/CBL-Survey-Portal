package com.cblSurveyPortal.controller;
import com.cblSurveyPortal.constant.HttpHeader;
import com.cblSurveyPortal.dto.BranchCreateDTO;
import com.cblSurveyPortal.dto.ResponseDTO;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.service.BranchService;
import com.cblSurveyPortal.utills.Utils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BranchController {
    @Autowired
    private BranchService branchService;
    @RequestMapping(value = "/api/branch/create", method = RequestMethod.POST)
    public ResponseDTO create(@RequestBody BranchCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = branchService.create(input,requester);
        return result;
    }
    @RequestMapping(value = "/api/branch/getList", method = RequestMethod.GET)
    public ResponseDTO getList(@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = branchService.getList(requester);
        return result;
    }
    @RequestMapping(value = "/api/branch/{id}", method = RequestMethod.GET)
    public ResponseDTO getId(@PathVariable("id")ObjectId brnId, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = branchService.getId(brnId,requester);
        return result;
    }
    @RequestMapping(value = "/api/branch/{id}", method = RequestMethod.PUT)
    public ResponseDTO update(@PathVariable("id") ObjectId brnId , @RequestBody BranchCreateDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = branchService.update(input,brnId, requester);

        return result;
    }
    @RequestMapping(value = "api/branch/{id}",method = RequestMethod.DELETE)
    public ResponseDTO delete(@PathVariable("id") ObjectId id,@RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = branchService.delete(id,requester);
        return result;
    }
}

