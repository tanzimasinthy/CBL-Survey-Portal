package com.cblSurveyPortal.repository;

import com.cblSurveyPortal.model.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String > {

    public Employee findByIdAndStatus(ObjectId id, String status);
    public Employee findByEmailAndStatus(String email, String status);
    public Employee findByEmployeeIdAndStatus(String employeeId, String status);
    public List<Employee> findAllByStatus(String status);
    public Employee findById(ObjectId id);
}
