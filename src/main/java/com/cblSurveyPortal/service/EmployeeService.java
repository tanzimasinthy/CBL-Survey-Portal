package com.cblSurveyPortal.service;

import com.cblSurveyPortal.dto.EmployeeUpdateDTO;
import com.cblSurveyPortal.dto.ResponseDTO;
import com.cblSurveyPortal.enums.Authority;
import com.cblSurveyPortal.model.Employee;
import com.cblSurveyPortal.dto.EmployeeCreateDTO;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.repository.EmployeeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class EmployeeService {
    private ResponseDTO output = new ResponseDTO();
    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseDTO create(EmployeeCreateDTO input, User requester) {
        Employee employee = new Employee();
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            employee = employeeRepository.findByEmailAndStatus(input.getEmail(), "V");
            if (employee == null) {
                employee = new Employee();
                employee.setFirstName(input.getFirstName());
                employee.setLastName(input.getLastName());
                employee.setAddress(input.getAddress());
                employee.setPassword(encodePassword(input.getPassword()));
                employee.setEmail(input.getEmail());
                employee.setGrade(input.getGrade());
                employee.setDivision(input.getDivision());
                employee.setDepartment(input.getDepartment());
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

    public ResponseDTO getList() {
        List<Employee> employees = employeeRepository.findAllByStatus("V");
        if (employees == null || employees.size() == 0) {
            return output.generateErrorResponse("No data found");
        } else {
            for(int i=0; i < employees.size(); i++){
                employees.get(i).setPassword(decodePassword(employees.get(i).getPassword()));
            }
            return output.generateSuccessResponse(employees, "Success!");
        }
    }

    public ResponseDTO get(ObjectId id) {
        Employee employee = employeeRepository.findByIdAndStatus(id, "V");
        if (employee == null) {
            return output.generateErrorResponse("Data not found");
        } else {
            employee.setPassword(decodePassword(employee.getPassword()));
            return output.generateSuccessResponse(employee, "Success");
        }
    }

    public ResponseDTO update(EmployeeUpdateDTO input, User requester)
    {
        Employee employee;
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            employee = employeeRepository.findByEmailAndStatus(input.getEmail(), "V");
            if (employee != null) {
                employee.setFirstName(input.getFirstName());
                employee.setLastName(input.getLastName());
                employee.setAddress(input.getAddress());
                employee.setEmail(input.getEmail());
                employee.setGrade(input.getGrade());
                employee.setDivision(input.getDivision());
                employee.setDepartment(input.getDepartment());
                employee.setGender(input.getGender());
                employee.setAge(input.getAge());
                employee.setAuthority(input.getAuthority());
                employeeRepository.save(employee);
                return output.generateSuccessResponse(employee, "successfully updated");
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
            Employee employee = employeeRepository.findByIdAndStatus(id, "V");
            if (employee == null) {
                return output.generateErrorResponse("You have entered a wrong id");
            } else {
                employee.setStatus("D");
                employeeRepository.save(employee);
                return output.generateSuccessResponse(employee, "success");
            }

        }else
        {
            return output.generateErrorResponse("Permission Denied!!");
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
