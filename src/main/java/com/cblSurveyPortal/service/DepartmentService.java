package com.cblSurveyPortal.service;

import com.cblSurveyPortal.dto.DepartmentCreateDTO;
import com.cblSurveyPortal.dto.ResponseDTO;
import com.cblSurveyPortal.enums.Authority;
import com.cblSurveyPortal.model.Department;
import com.cblSurveyPortal.model.Division;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.repository.DepartmentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private ResponseDTO output = new ResponseDTO();

    @Autowired
    private DepartmentRepository departmentRepository;

    public ResponseDTO create(DepartmentCreateDTO input, User requester) {
        Department department = new Department();
        if (requester.isEnabled()) {
            department = departmentRepository.findByNameAndStatus(input.getName(), "V");
            if (department == null) {
                department = new Department();
                department.setName(input.getName());

                //department.setAuthority(input.getAuthority());
                department.setStatus("V");
                departmentRepository.save(department);
            } else {
                return output.generateErrorResponse(" Already exist !!");

            }

        }
        return output.generateSuccessResponse(department, "success");
    }
    public ResponseDTO getList(User requester) {
        List<Department> departments = departmentRepository.findAllByStatus("V");
        if (departments == null) {
            return output.generateErrorResponse("NO data found");
        } else {
            return output.generateSuccessResponse(departments, "Success");
        }
    }
    public ResponseDTO getId(ObjectId id, User requester){
        Department department = departmentRepository.findByIdAndStatus(id, "V");
        if (department == null) {
            return output.generateErrorResponse("No data found");
        }else {
            return output.generateSuccessResponse(department,"Success");
        }
    }
    public ResponseDTO update(DepartmentCreateDTO input,ObjectId id,User requester){
        Department department = departmentRepository.findByIdAndStatus(id,"V");
        if (department !=null){
            department.setName(input.getName());
            departmentRepository.save(department);

            return output.generateSuccessResponse(department,"Success");
        }else {
            return output.generateErrorResponse("NO data found");
        }
    }
    public ResponseDTO delete(ObjectId id,User requester)
    {
        if (requester.hasAuthority(Authority.ROLE_ADMIN))
        {
            Department department = departmentRepository.findByIdAndStatus(id, "V");
            if (department == null) {
                return output.generateErrorResponse("You have entered a wrong id");
            } else {
                department.setStatus("D");
                departmentRepository.save(department);
                return output.generateSuccessResponse(department, "success");
            }

        }else
        {
            return output.generateErrorResponse("Permission Denied!!");
        }
    }
}

