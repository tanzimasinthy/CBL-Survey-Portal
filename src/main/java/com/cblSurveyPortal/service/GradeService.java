package com.cblSurveyPortal.service;

import com.cblSurveyPortal.dto.*;
import com.cblSurveyPortal.enums.Authority;
import com.cblSurveyPortal.model.Division;
import com.cblSurveyPortal.model.Grade;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.repository.DivisionRepository;
import com.cblSurveyPortal.repository.GradeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private GradeRepository gradeRepository;

    public ResponseDTO create(GradeCreateDTO input, User requester) {
        Grade grade = new Grade();
        if (requester.isEnabled()) {
            grade = gradeRepository.findByNameAndStatus(input.getName(),"V");
            if (grade == null) {
                grade = new Grade();
                grade.setName(input.getName());
                grade.setValue(input.getValue());

                //officer.setAuthority(input.getAuthority());
                grade.setStatus("V");
                gradeRepository.save(grade);
            } else {
                return output.generateErrorResponse(" Already exist !!");

            }
        }

        return output.generateSuccessResponse(grade, "Successfully created");
    }
    public ResponseDTO getList(User requester) {
        List<Grade> grades = gradeRepository.findAllByStatus("V");
        if (grades == null) {
            return output.generateErrorResponse("NO data found");
        }else {
            return output.generateSuccessResponse(grades,"Success");
        }
    }
    public ResponseDTO getID(ObjectId id , User requester) {
        Grade grade = gradeRepository.findByIdAndStatus(id,"V");
        if (grade == null){
            return output.generateErrorResponse("No data found");
        }else {
            return  output.generateSuccessResponse(grade,"Success");
        }
    }
    public ResponseDTO update(GradeUpdateDTO input, ObjectId id, User requester)
    {
        Grade grade = gradeRepository.findByIdAndStatus(id,"V");
        if (grade!=null){
            grade.setName(input.getName());
            gradeRepository.save(grade);
            return output.generateSuccessResponse(grade, "Success");
        }else{
            return output.generateErrorResponse("Data not found");
        }
    }

    public ResponseDTO delete(ObjectId id,User requester)
    {
        if (requester.hasAuthority(Authority.ROLE_ADMIN))
        {
            Grade grade = gradeRepository.findByIdAndStatus(id, "V");
            if (grade == null) {
                return output.generateErrorResponse("You have entered a wrong id");
            } else {
                grade.setStatus("D");
                gradeRepository.save(grade);
                return output.generateSuccessResponse(grade, "success");
            }

        }else
        {
            return output.generateErrorResponse("Permission Denied!!");
        }
    }
}
