package com.cblSurveyPortal.service;

import com.cblSurveyPortal.dto.*;
import com.cblSurveyPortal.enums.Authority;
import com.cblSurveyPortal.model.SurveyType;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.repository.SurveyRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private SurveyRepository surveyRepository;

    public ResponseDTO create(SurveyCreateDTO input, User requester) {
        SurveyType surveyType = new SurveyType();
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            surveyType = surveyRepository.findByNameAndStatus(input.getName(), "V");
            if (surveyType == null) {
                surveyType = new SurveyType();
                surveyType.setName(input.getName());
                surveyType.setActive(true);
                surveyType.setStatus("V");
                surveyRepository.save(surveyType);

            } else {
                return output.generateErrorResponse (" Already exist !!");

            }
        }
        return output.generateSuccessResponse(surveyType, "Successfully created");
    }

    public ResponseDTO getList() {
        List<SurveyType> surveyTypes = surveyRepository.findAllByStatus("V");
        if (surveyTypes == null || surveyTypes.size() == 0) {
            return output.generateErrorResponse("No data found");
        } else {
            return output.generateSuccessResponse(surveyTypes, "Success!");
        }
    }

    public ResponseDTO get(ObjectId id) {
        SurveyType surveyType = surveyRepository.findByIdAndStatus(id, "V");
        if (surveyType == null) {
            return output.generateErrorResponse("Data not found");
        } else {
            return output.generateSuccessResponse(surveyType, "Success");
        }
    }

    public ResponseDTO update(SurveyUpdateDTO input, User requester)
    {
        SurveyType surveyType;
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            surveyType = surveyRepository.findByNameAndStatus(input.getName(), "V");
            if (surveyType != null) {
                surveyType.setName(input.getName());
                surveyType.setActive(input.getActive());
                surveyRepository.save(surveyType);
                return output.generateSuccessResponse(surveyType, "successfully updated");
            } else {
                return output.generateErrorResponse("Data Not Found!!");
            }
        }

        else {
            return output.generateErrorResponse("Permission Denied!!");
        }
    }


    public ResponseDTO delete(ObjectId id,User requester)
    {
        if (requester.hasAuthority(Authority.ROLE_ADMIN))
        {
            SurveyType surveyType = surveyRepository.findByIdAndStatus(id, "V");
            if (surveyType == null) {
                return output.generateErrorResponse("You have entered a wrong id");
            } else {
                surveyType.setStatus("D");
                surveyRepository.save(surveyType);
                return output.generateSuccessResponse(surveyType, "success");
            }

        }else
        {
            return output.generateErrorResponse("Permission Denied!!");
        }

    }
}
