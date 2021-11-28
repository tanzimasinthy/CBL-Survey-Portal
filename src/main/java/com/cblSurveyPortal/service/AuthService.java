package com.cblSurveyPortal.service;

import  com.cblSurveyPortal.dto.AdminLoginDTO;
import com.cblSurveyPortal.dto.EmployeeLoginDTO;
import com.cblSurveyPortal.dto.RegistrationDTO;
import com.cblSurveyPortal.dto.ResponseDTO;
import com.cblSurveyPortal.enums.Authority;
import com.cblSurveyPortal.model.*;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.repository.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class AuthService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private SurveyRepository surveyRepository;

    public ResponseDTO registration(RegistrationDTO input, User requester) {
        Employee employee = new Employee();
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            employee = employeeRepository.findByEmailAndStatus(input.getEmail(), "V");
            Grade grade = new Grade();
            grade = gradeRepository.findByIdAndStatus(input.getGradeId(), "V");
            if (grade == null){
                return output.generateErrorResponse(" Invalid Grade Id !!");
            }
            Division division = new Division();
            division = divisionRepository.findByIdAndStatus(input.getDivisionId(), "V");
            if (division == null){
                return output.generateErrorResponse(" Invalid Division Id !!");
            }

            Department department = new Department();
            department = departmentRepository.findByIdAndStatus(input.getDepartmentId(), "V");
            if (department == null){
                return output.generateErrorResponse(" Invalid Department Id !!");
            }

            if (employee == null) {
                employee = new Employee();
                employee.setFirstName(input.getFirstName());
                employee.setLastName(input.getLastName());
                employee.setAddress(input.getAddress());
                employee.setPassword(encodePassword(input.getPassword()));
                employee.setEmail(input.getEmail());
                employee.setGrade(grade);
                employee.setDivision(division);
                employee.setDepartment(department);
                employee.setEmployeeId(input.getEmployeeId());
                employee.setGender(input.getGender());
                employee.setAge(input.getAge());
                employee.setJoiningDate(input.getJoiningDate());
                //  officer.setAuthority(input.getAuthority());
                employee.setStatus("V");
                employeeRepository.save(employee);
            } else {
                return output.generateErrorResponse(" Already exist !!");

            }
        }
        return output.generateSuccessResponse(employee, "Successfully created");
    }


    public ResponseDTO login(EmployeeLoginDTO input, User requester) {
        Employee employee = new Employee();
        SurveyType surveyType = new SurveyType();
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            return output.generateErrorResponse(" Invalid User Request !!");
        } else  {
            employee = employeeRepository.findByEmployeeIdAndStatus(input.getEmployeeId(), "V");
            if (employee == null){
                return output.generateErrorResponse("User Not Found, Please Register First!!");
            }
            surveyType = surveyRepository.findByIdAndStatus(new ObjectId(input.getSurveyTypeId()), "V");
            if (surveyType == null){
                return output.generateErrorResponse("Survey Type Not Found !!");
            } else {
                if (!surveyType.getActive()) {
                    return output.generateErrorResponse("Invalid Survey Type !!");
                }
            }

        }
        return output.generateSuccessResponse(employee, "Successfully created");
    }

    public ResponseDTO loginAdmin(AdminLoginDTO input, User requester) {
        Employee employee = new Employee();
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            employee = employeeRepository.findByEmailAndStatus(input.getUsername(), "V");
            String password = employee.getPassword();
            if ( decodePassword(password).equals(input.getPassword())) {
                return output.generateSuccessResponse(employee, "Successfully Login");
            } else {
                return output.generateErrorResponse(" Wrong Password !!");
            }
        } else  {
            return output.generateErrorResponse(" Invalid User Request !!");
        }
    }



    public String encodePassword(String password)
    {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return encodedPassword;
    }
    public String decodePassword(String input)
    {
        byte[] decodedPassword = Base64.getDecoder().decode(input);
        return  new String(decodedPassword);
    }
}
