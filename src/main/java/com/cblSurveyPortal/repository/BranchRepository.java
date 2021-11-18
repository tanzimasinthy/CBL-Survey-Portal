package com.cblSurveyPortal.repository;

import com.cblSurveyPortal.model.Branch;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends MongoRepository<Branch, String>
{
    Branch findByNameAndStatus(String name, String status);
    List<Branch> findAllByStatus(String status);
    Branch findByIdAndStatus(ObjectId id, String status);
    Branch findByAddress(String address);
}
