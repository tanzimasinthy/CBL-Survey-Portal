package com.cblSurveyPortal.service;

import com.cblSurveyPortal.dto.DivisionCreateDTO;
import com.cblSurveyPortal.dto.DivisionUpdateDTO;
import com.cblSurveyPortal.dto.ResponseDTO;
import com.cblSurveyPortal.enums.Authority;
import com.cblSurveyPortal.model.Division;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.repository.DivisionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {

    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private DivisionRepository divisionRepository;

    public ResponseDTO create(DivisionCreateDTO input, User requester) {
        Division division = new Division();
        if (requester.isEnabled()) {
            division = divisionRepository.findByNameAndStatus(input.getName(), "V");
            if (division == null) {
                division = new Division();
                division.setName(input.getName());

                //officer.setAuthority(input.getAuthority());
                division.setStatus("V");
                divisionRepository.save(division);
            } else {
                return output.generateErrorResponse(" Already exist !!");

            }
        }

        return output.generateSuccessResponse(division, "Successfully created");
    }
    public ResponseDTO getList(User requester) {
        List<Division> divisions = divisionRepository.findAllByStatus("V");
        if (divisions == null) {
            return output.generateErrorResponse("NO data found");
        }else {
            return output.generateSuccessResponse(divisions,"Success");
        }
    }
    public ResponseDTO getID(ObjectId id , User requester) {
        Division division = divisionRepository.findByIdAndStatus(id,"V");
        if (division == null){
            return output.generateErrorResponse("No data found");
        }else {
            return  output.generateSuccessResponse(division,"Success");
        }
    }
    public ResponseDTO update(DivisionUpdateDTO input,ObjectId id, User requester)
    {
        Division division = divisionRepository.findByIdAndStatus(id,"V");
        if (division!=null){
            division.setName(input.getName());
            divisionRepository.save(division);
            return output.generateSuccessResponse(division, "Success");
        }else{
            return output.generateErrorResponse("Data not found");
        }
    }

    public ResponseDTO delete(ObjectId id,User requester)
    {
        if (requester.hasAuthority(Authority.ROLE_ADMIN))
        {
            Division division = divisionRepository.findByIdAndStatus(id, "V");
            if (division == null) {
                return output.generateErrorResponse("You have entered a wrong id");
            } else {
                division.setStatus("D");
                divisionRepository.save(division);
                return output.generateSuccessResponse(division, "success");
            }

        }else
        {
            return output.generateErrorResponse("Permission Denied!!");
        }
    }

}
