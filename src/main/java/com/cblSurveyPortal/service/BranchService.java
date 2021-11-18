package com.cblSurveyPortal.service;

import com.cblSurveyPortal.dto.BranchCreateDTO;
import com.cblSurveyPortal.dto.ResponseDTO;
import com.cblSurveyPortal.enums.Authority;
import com.cblSurveyPortal.model.Branch;
import com.cblSurveyPortal.model.dummy.User;
import com.cblSurveyPortal.repository.BranchRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    private ResponseDTO output = new ResponseDTO();

    @Autowired
    private BranchRepository branchRepository;
    public ResponseDTO create (BranchCreateDTO input, User requester)
    {
        Branch branch = new Branch();
        if (requester.hasAuthority(Authority.ROLE_ADMIN))
        {
            branch = branchRepository.findByNameAndStatus(input.getName(),"V");
            if (branch == null){
                branch = new Branch();
                branch.setId(new ObjectId());
                branch.setName(input.getName());
                branch.setAddress(input.getAddress());
                branch.setStatus("V");
                branchRepository.save(branch);
            }else {
                return output.generateErrorResponse("Already exist");
            }

        }
        return output.generateSuccessResponse(branch,"Success");
    }
    public ResponseDTO getList(User requester)
    {
        List<Branch> branches = branchRepository.findAllByStatus("V");
        if (branches == null){
            return output.generateErrorResponse("No data found");
        }else {
            return output.generateSuccessResponse(branches,"Success");
        }

    }
    public ResponseDTO getId(ObjectId id, User requester)
    {
        Branch branch = branchRepository.findByIdAndStatus(id,"V");
        if (branch == null){
            return output.generateErrorResponse("data not found");
        }else {
            return output.generateSuccessResponse(branch,"Success");
        }
    }
    public ResponseDTO update(BranchCreateDTO input, ObjectId id, User requester) {
        Branch branch;
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            branch = branchRepository.findByIdAndStatus(id, "V");
            if (branch != null) {
                branch.setName(input.getName());
                branch.setAddress(input.getAddress());
                branchRepository.save(branch);

                return output.generateSuccessResponse(branch, "Success");
            } else {
                return output.generateErrorResponse("Already Exist");
            }
        } else {
            return output.generateErrorResponse("Permission denied");
        }
    }
    public ResponseDTO delete(ObjectId id,User requester) {
        if (requester.hasAuthority(Authority.ROLE_ADMIN)) {
            Branch branch = branchRepository.findByIdAndStatus(id, "V");
            if (branch == null) {
                return output.generateErrorResponse("You have entered a wrong id");
            } else {
                branch.setStatus("D");
                branchRepository.save(branch);
                return output.generateSuccessResponse(branch, "success");
            }

        } else {
            return output.generateErrorResponse("Permission Denied!!");
        }
    }

}
