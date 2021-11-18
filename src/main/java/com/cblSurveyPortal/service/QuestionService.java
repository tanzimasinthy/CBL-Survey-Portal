package com.cblSurveyPortal.service;

import com.cblSurveyPortal.dto.*;
import com.cblSurveyPortal.enums.Authority;
import com.cblSurveyPortal.model.Employee;
import com.cblSurveyPortal.model.Question;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.repository.QuestionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private QuestionRepository questionRepository;

    public ResponseDTO create(QuestionCreateDTO input, User requester) {
        Question question = new Question();
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            question = questionRepository.findByTitleAndStatus(input.getTitle(), "V");
            if (question == null) {
                question = new Question();
                question.setTitle(input.getTitle());
                question.setSurveyType(input.getSurveyType());
                question.setOption(input.getOptions());

                //  officer.setAuthority(input.getAuthority());
                question.setStatus("V");
                questionRepository.save(question);

            } else {
                return output.generateErrorResponse (" Already exist !!");

            }
        }
        return output.generateSuccessResponse(question, "Successfully created");
    }

    public ResponseDTO getList() {
        List<Question> questions = questionRepository.findAllByStatus("V");
        if (questions == null || questions.size() == 0) {
            return output.generateErrorResponse("No data found");
        } else {
            return output.generateSuccessResponse(questions, "Success!");
        }
    }

    public ResponseDTO get(ObjectId id) {
        Question question = questionRepository.findByIdAndStatus(id, "V");
        if (question == null) {
            return output.generateErrorResponse("Data not found");
        } else {
            return output.generateSuccessResponse(question, "Success");
        }
    }

    public ResponseDTO update(QuestionUpdateDTO input, User requester)
    {
        Question question;
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            question = questionRepository.findByTitleAndStatus(input.getTitle(), "V");
            if (question != null) {
                question.setTitle(input.getTitle());
                question.setSurveyType(input.getSurveyType());
                question.setOption(input.getOptions());
                questionRepository.save(question);
                return output.generateSuccessResponse(question, "successfully updated");
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
            Question question = questionRepository.findByIdAndStatus(id, "V");
            if (question == null) {
                return output.generateErrorResponse("You have entered a wrong id");
            } else {
                question.setStatus("D");
                questionRepository.save(question);
                return output.generateSuccessResponse(question, "success");
            }

        }else
        {
            return output.generateErrorResponse("Permission Denied!!");
        }

    }
}
