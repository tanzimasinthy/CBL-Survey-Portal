package com.cblSurveyPortal.controller;

import com.cblSurveyPortal.constant.HttpHeader;
import com.cblSurveyPortal.dto.AdminLoginDTO;
import com.cblSurveyPortal.dto.EmployeeLoginDTO;
import com.cblSurveyPortal.dto.RegistrationDTO;
import com.cblSurveyPortal.dto.ResponseDTO;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.service.AuthService;
import com.cblSurveyPortal.utills.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @RequestMapping(value = "/api/registration", method = RequestMethod.POST)
    public ResponseDTO registration(@RequestBody RegistrationDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = authService.registration(input,requester);
        return result;
    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseDTO login(@RequestBody EmployeeLoginDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = authService.login(input,requester);
        return result;
    }

    @RequestMapping(value = "/api/login/admin", method = RequestMethod.POST)
    public ResponseDTO loginAdmin(@RequestBody AdminLoginDTO input, @RequestHeader(value = HttpHeader.REQUESTER) String requesterStr)
    {
        User requester = Utils.generateUserFromJsonStr(requesterStr);
        ResponseDTO result = authService.loginAdmin(input,requester);
        return result;
    }
}
