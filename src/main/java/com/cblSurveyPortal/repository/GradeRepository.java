package com.cblSurveyPortal.repository;

import com.cblSurveyPortal.model.Division;
import com.cblSurveyPortal.model.Grade;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends MongoRepository<Grade, String > {

    Grade findByIdAndStatus(ObjectId id, String status);
    List<Grade> findAllByStatus(String status);
    Grade findByNameAndStatus(String name, String status);
    Grade findByIdAndStatus(String id, String status);
    //Division deleteDivisionById(ObjectId id);
}
