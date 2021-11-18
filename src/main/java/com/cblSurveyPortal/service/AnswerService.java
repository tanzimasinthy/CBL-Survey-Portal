package com.cblSurveyPortal.service;

import com.cblSurveyPortal.dto.AnsPercentageReportDTO;
import com.cblSurveyPortal.dto.AnswerDTO;
import com.cblSurveyPortal.dto.OptionPercentageDTO;
import com.cblSurveyPortal.dto.ResponseDTO;
import com.cblSurveyPortal.enums.Authority;
import com.cblSurveyPortal.enums.SurveyType;
import com.cblSurveyPortal.model.Answer;
import com.cblSurveyPortal.model.Employee;
import com.cblSurveyPortal.model.Question;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.repository.AnswerRepository;
import com.cblSurveyPortal.repository.EmployeeRepository;
import com.cblSurveyPortal.repository.QuestionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseDTO create(AnswerDTO input, User requester) {
        Answer answer = new Answer();
        Employee employee = employeeRepository.findByEmailAndStatus(requester.getUsername(), "V");
        if (employee == null) {
            return output.generateErrorResponse("No data found");
        } else {
            Answer answer1 = answerRepository.findBySurveyTypeAndEmployeeIdInAndStatus(input.getSurveyType(), employee.getId(), "V");
            if (answer1 != null){
                return output.generateErrorResponse("Duplicate Data.");
            }
            answer.setEmployee(employee);
            answer.setAnsList(input.getAnsList());
            answer.setSurveyType(input.getSurveyType());
            answer.setDate(input.getDate());
            answer.setStatus("V");
            answerRepository.save(answer);
        }

        return output.generateSuccessResponse(answer, "Successfully created");
    }

    public ResponseDTO getList() {
        List<Answer> answers = answerRepository.findAllByStatus("V");
        if (answers == null || answers.size() == 0) {
            return output.generateErrorResponse("No data found");
        } else {
            return output.generateSuccessResponse(answers, "Success!");
        }
    }

    public ResponseDTO get(ObjectId id) {
        Answer answer = answerRepository.findByIdAndStatus(id, "V");
        if (answer == null) {
            return output.generateErrorResponse("Data not found");
        } else {
            return output.generateSuccessResponse(answer, "Success");
        }
    }

    public ResponseDTO delete(ObjectId id,User requester)
    {
        if (requester.hasAuthority(Authority.ROLE_ADMIN))
        {
            Answer answer = answerRepository.findByIdAndStatus(id, "V");
            if (answer == null) {
                return output.generateErrorResponse("You have entered a wrong id");
            } else {
                answer.setStatus("D");
                answerRepository.save(answer);
                return output.generateSuccessResponse(answer, "success");
            }

        }else
        {
            return output.generateErrorResponse("Permission Denied!!");
        }

    }

    public ResponseDTO getReport(SurveyType type) {
        List<Employee> employeeList = employeeRepository.findAllByStatus("V");
        List<Answer> answerList = answerRepository.findBySurveyTypeAndStatus(type, "V");
        List<AnsPercentageReportDTO> perAns = new ArrayList<>();
        if (answerList.size() == 0) {
            return output.generateErrorResponse("Data not found");
        } else {
            for (int i = 0; i < answerList.size(); i++) {
                AnsPercentageReportDTO ansPercentageReport = new AnsPercentageReportDTO();
                for (int j = 0; j < answerList.get(i).getAnsList().size(); j++) {
                    Question question = questionRepository.findByIdAndStatus(answerList.get(i).getAnsList().get(j).getQuestionId(), "V");
                    ansPercentageReport.setQuestionId(question.getId());
                    ansPercentageReport.setQuestionTitle(question.getTitle());
                    List<OptionPercentageDTO> optionPercentageList = new ArrayList<>();
                   for (int k = 0; k < question.getOption().size(); k++){
                       OptionPercentageDTO perOption = new OptionPercentageDTO();
                       if(answerList.get(i).getAnsList().get(j).getQuestionOption().equals(question.getOption().get(k))){
                           for (int m = 0; m < optionPercentageList.size(); m++){
                               if (answerList.get(i).getAnsList().get(j).getQuestionOption().equals(optionPercentageList.get(m).getOptionTag())){
                                   optionPercentageList.get(m).setOptionValue(optionPercentageList.get(m).getOptionValue() + 1);
                               }
                           }
                          perOption.setOptionTag(question.getOption().get(k));
                          perOption.setOptionValue(1);
                          optionPercentageList.add(perOption);
                       }
                   }
                    ansPercentageReport.setOptionList(optionPercentageList);
                }
                perAns.add(ansPercentageReport);
            }

            for (int r = 0; r < perAns.size(); r++) {
                for (int y = 0; y < perAns.get(r).getOptionList().size(); y++) {
                    perAns.get(r).getOptionList().get(y).setOptionValueInPercent((perAns.get(r).getOptionList().get(y).getOptionValue() * 100) / employeeList.size() );
                }
            }
            return output.generateSuccessResponse(perAns, "Success");
        }
    }
}
