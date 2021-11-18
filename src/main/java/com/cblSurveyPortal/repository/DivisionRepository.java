package com.cblSurveyPortal.repository;

import com.cblSurveyPortal.model.Division;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DivisionRepository extends MongoRepository<Division, String > {

     Division findByIdAndStatus(ObjectId id, String status);
     List<Division> findAllByStatus(String status);
     Division findByNameAndStatus(String name, String status);
     Division findByIdAndStatus(String id, String status);
     //Division deleteDivisionById(ObjectId id);
}
