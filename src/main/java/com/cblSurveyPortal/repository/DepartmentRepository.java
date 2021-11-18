package com.cblSurveyPortal.repository;

import com.cblSurveyPortal.model.Department;
import com.cblSurveyPortal.service.DepartmentService;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String>
{
    Department findByNameAndStatus(String name, String status);
    List<Department> findAllByStatus(String status);
    Department findByIdAndStatus( ObjectId id, String status);
    Department findByIdAndStatus( String id, String status);

}
